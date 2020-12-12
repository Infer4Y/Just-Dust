package xavier.just_dust.common.blocks.cables;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.common.blocks.machines.BlockCompressorTierOne;
import xavier.just_dust.common.blocks.machines.BlockGrinderTierOne;

public class BlockEnergyCable extends BlockCableBase {
    public BlockEnergyCable(String blockName) {
        super(Material.CIRCUITS, blockName);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, CONNECTED_PROPERTIES.toArray(new IProperty[CONNECTED_PROPERTIES.size()]));
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    protected boolean isValidConnection(IBlockState ownState, IBlockState neighbourState, IBlockAccess world, BlockPos ownPos, EnumFacing neighbourDirection) {
        if (super.isValidConnection(ownState, neighbourState, world, ownPos, neighbourDirection)) {
            return true;
        }
        final BlockPos neighbourPos = ownPos.offset(neighbourDirection);
        final Block neighbourBlock = neighbourState.getBlock();

        if (neighbourBlock.hasTileEntity(neighbourState)) {
            final TileEntity tileEntity = world.getTileEntity(neighbourPos);
            return tileEntity != null && tileEntity.hasCapability(CapabilityEnergy.ENERGY, neighbourDirection.getOpposite());
        }
        return neighbourBlock instanceof BlockGrinderTierOne || neighbourBlock instanceof BlockCompressorTierOne;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

}
