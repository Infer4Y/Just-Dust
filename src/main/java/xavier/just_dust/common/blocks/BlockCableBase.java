package xavier.just_dust.common.blocks;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.JustDust;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BlockCableBase extends  BaseBlocks {

    public static final float PIPE_MIN_POS = 0.4375f;
    public static final float PIPE_MAX_POS = 0.6875f;

    public static final ImmutableList<IProperty<Boolean>> CONNECTED_PROPERTIES = ImmutableList.copyOf(
            Stream.of(EnumFacing.VALUES)
                    .map(facing -> PropertyBool.create(facing.getName()))
                    .collect(Collectors.toList())
    );

    public static final ImmutableList<AxisAlignedBB> CONNECTED_BOUNDING_BOXES = ImmutableList.copyOf(
            Stream.of(EnumFacing.VALUES)
                    .map(facing -> {
                        Vec3i directionVec = facing.getDirectionVec();
                        return new AxisAlignedBB(
                                getMinBound(directionVec.getX()), getMinBound(directionVec.getY()), getMinBound(directionVec.getZ()),
                                getMaxBound(directionVec.getX()), getMaxBound(directionVec.getY()), getMaxBound(directionVec.getZ())
                        );
                    })
                    .collect(Collectors.toList())
    );

    private static float getMinBound(int dir) {
        return dir == -1 ? 0 : PIPE_MIN_POS;
    }

    private static float getMaxBound(int dir) {
        return dir == 1 ? 1 : PIPE_MAX_POS;
    }

    public BlockCableBase(Material material, String blockName) {
        super(material, blockName);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    protected boolean isValidConnection(IBlockState ownState, IBlockState neighbourState, IBlockAccess world, BlockPos ownPos, EnumFacing neighbourDirection) {
        return neighbourState.getBlock() instanceof BlockCableBase;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState bs, final IBlockAccess world, final BlockPos coord, final EnumFacing face) {
        return true;
    }

    private boolean canConnectTo(IBlockState ownState, IBlockAccess worldIn, BlockPos ownPos, EnumFacing neighbourDirection) {
        final BlockPos neighbourPos = ownPos.offset(neighbourDirection);
        final IBlockState neighbourState = worldIn.getBlockState(neighbourPos);
        final Block neighbourBlock = neighbourState.getBlock();

        final boolean neighbourIsValidForThis = isValidConnection(ownState, neighbourState, worldIn, ownPos, neighbourDirection);
        final boolean thisIsValidForNeighbour = !(neighbourBlock instanceof BlockCableBase) || ((BlockCableBase) neighbourBlock).isValidConnection(neighbourState, ownState, worldIn, neighbourPos, neighbourDirection.getOpposite());

        return neighbourIsValidForThis && thisIsValidForNeighbour;
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        for (final EnumFacing facing : EnumFacing.VALUES) {
            state = state.withProperty(CONNECTED_PROPERTIES.get(facing.getIndex()), canConnectTo(state, world, pos, facing));
        }

        return state;
    }

    public final boolean isConnected(IBlockState state, EnumFacing facing) {
        return state.getValue(CONNECTED_PROPERTIES.get(facing.getIndex()));
    }



    @SuppressWarnings("deprecation")
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        AxisAlignedBB bb = new AxisAlignedBB(PIPE_MIN_POS, PIPE_MIN_POS, PIPE_MIN_POS, PIPE_MAX_POS, PIPE_MAX_POS, PIPE_MAX_POS);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, bb);

        state = getActualState(state, worldIn, pos);

        for (final EnumFacing facing : EnumFacing.VALUES) {
            if (isConnected(state, facing)) {
                AxisAlignedBB axisAlignedBB = CONNECTED_BOUNDING_BOXES.get(facing.getIndex());
                addCollisionBoxToList(pos, entityBox, collidingBoxes, axisAlignedBB);
            }
        }
    }

    @Override
    public void registerItemModel(Item itemBlock) {
        JustDust.proxy.registerItemRenderer(itemBlock, 0, "cables/"+name);
    }
}