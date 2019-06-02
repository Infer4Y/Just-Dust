package xavier.just_dust.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.containers.ContainerCompressor;
import xavier.just_dust.containers.ContainerGrinder;
import xavier.just_dust.tileentities.TileEntityCompressor;
import xavier.just_dust.tileentities.TileEntityGrinder;

public class GuiHandler implements IGuiHandler {
    private static final int COMPRESSOR_ID = 0;
    private static final int GRINDER_ID = 1;
    public static int getCompressorGuiID() {
        return COMPRESSOR_ID;
    }
    public static int getGrinderGuiID() {
        return GRINDER_ID;
    }


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te instanceof TileEntityCompressor){
            return new ContainerCompressor(player.inventory, (TileEntityCompressor) te);
        }

        if (te instanceof TileEntityGrinder){
            return new ContainerGrinder(player.inventory, (TileEntityGrinder) te);
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te instanceof TileEntityCompressor){
            TileEntityCompressor tileentitycompressor = (TileEntityCompressor) te;
            return new GUICompressor(player.inventory, tileentitycompressor);
        }

        if (te instanceof TileEntityGrinder){
            TileEntityGrinder tileentitygrinder = (TileEntityGrinder) te;
            return new GUIGrinder(player.inventory, tileentitygrinder);
        }

        return null;
    }
}
