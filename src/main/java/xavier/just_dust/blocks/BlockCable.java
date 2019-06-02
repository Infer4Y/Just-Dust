package xavier.just_dust.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockCable extends BaseBlocks {
    public static final AxisAlignedBB CORE_AABB = new AxisAlignedBB(0.375D, 0.375D, 0.375D, 0.625D, 0.625D, 0.625D);

    public BlockCable(Material material, String name) {
        super(material, name);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return damageDropped(state);
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        entityIn.dismountRidingEntity();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return CORE_AABB;
    }

    @Override
    public boolean isFullCube(IBlockState blockState) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
        state = state.getActualState(worldIn, pos);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, CORE_AABB);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        IProperty [] listedProperties = new IProperty[0]; // no listed properties
        IUnlistedProperty [] unlistedProperties = new IUnlistedProperty[] {LINK_UP, LINK_DOWN, LINK_EAST, LINK_WEST, LINK_NORTH, LINK_SOUTH};
        return new ExtendedBlockState(this, listedProperties, unlistedProperties);
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
        if (state instanceof IExtendedBlockState) {  // avoid crash in case of mismatch
            IExtendedBlockState retval = (IExtendedBlockState)state;
            boolean linkup = canConnectTo(world, pos.up());
            retval = retval.withProperty(LINK_UP, linkup);

            boolean linkdown = canConnectTo(world, pos.down());
            retval = retval.withProperty(LINK_DOWN, linkdown);

            boolean linkeast = canConnectTo(world, pos.east());
            retval = retval.withProperty(LINK_EAST, linkeast);

            boolean linkwest = canConnectTo(world, pos.west());
            retval = retval.withProperty(LINK_WEST, linkwest);

            boolean linknorth = canConnectTo(world, pos.north());
            retval = retval.withProperty(LINK_NORTH, linknorth);

            boolean linksouth = canConnectTo(world, pos.south());
            retval = retval.withProperty(LINK_SOUTH, linksouth);

            return retval;
        }
        return state;
    }

    private boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        if (block == Blocks.BARRIER) return false;
        if (block == ModBlocks.block_cable) return true;
        if (block == ModBlocks.block_compressor) return true;
        if (block == ModBlocks.block_grinder) return true;
        if (block == Blocks.REDSTONE_BLOCK) return true;
        if (block == Blocks.REDSTONE_ORE) return true;
        if (block == Blocks.LIT_REDSTONE_ORE) return true;
        if (block.getMaterial(iblockstate).isOpaque() && block.isFullCube(iblockstate) && block.getMaterial(iblockstate) != Material.CIRCUITS) return false;
        if (block.getMaterial(iblockstate) == Material.CIRCUITS) return true;
        return false;
    }

    public static final IUnlistedProperty<Boolean> LINK_UP = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_up"));
    public static final IUnlistedProperty<Boolean> LINK_DOWN = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_down"));
    public static final IUnlistedProperty<Boolean> LINK_WEST = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_west"));
    public static final IUnlistedProperty<Boolean> LINK_EAST = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_east"));
    public static final IUnlistedProperty<Boolean> LINK_NORTH = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_north"));
    public static final IUnlistedProperty<Boolean> LINK_SOUTH = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_south"));
}

