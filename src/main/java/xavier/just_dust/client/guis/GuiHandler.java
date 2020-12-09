package xavier.just_dust.client.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.common.containers.ContainerCompressor;
import xavier.just_dust.common.containers.ContainerGrinder;
import xavier.just_dust.common.tile_entities.TileEntityCompressorTierOne;
import xavier.just_dust.common.tile_entities.TileEntityGrinderTierOne;

public class GuiHandler implements IGuiHandler {
    private static final int COMPRESSOR_TIER_ONE_ID = 0;
    private static final int GRINDER_TIER_ONE_ID = 1;
    public static int getCompressorTierOneGuiID() {
        return COMPRESSOR_TIER_ONE_ID;
    }
    public static int getGrinderTierOneGuiID() {
        return GRINDER_TIER_ONE_ID;
    }


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te instanceof TileEntityCompressorTierOne){
            return new ContainerCompressor(player.inventory, (TileEntityCompressorTierOne) te);
        }

        if (te instanceof TileEntityGrinderTierOne){
            return new ContainerGrinder(player.inventory, (TileEntityGrinderTierOne) te);
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te instanceof TileEntityCompressorTierOne){
            TileEntityCompressorTierOne tileEntityCompressorTierOne = (TileEntityCompressorTierOne) te;
            return new GUICompressor(player.inventory, tileEntityCompressorTierOne);
        }

        if (te instanceof TileEntityGrinderTierOne){
            TileEntityGrinderTierOne tileEntityGrinderTierOne = (TileEntityGrinderTierOne) te;
            return new GUIGrinder(player.inventory, tileEntityGrinderTierOne);
        }

        return null;
    }
}
