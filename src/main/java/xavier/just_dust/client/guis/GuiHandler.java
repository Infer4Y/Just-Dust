package xavier.just_dust.client.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.common.containers.ContainerCharger;
import xavier.just_dust.common.containers.ContainerCompressor;
import xavier.just_dust.common.containers.ContainerGrinder;
import xavier.just_dust.common.tile_entities.*;

public class GuiHandler implements IGuiHandler {
    private static final int COMPRESSOR_TIER_ONE_ID = 0;
    private static final int GRINDER_TIER_ONE_ID = 1;
    private static final int COMPRESSOR_TIER_TWO_ID = 2;
    private static final int GRINDER_TIER_TWO_ID = 3;
    private static final int COMPRESSOR_TIER_THREE_ID = 4;
    private static final int GRINDER_TIER_THREE_ID = 5;
    private static final int COMPRESSOR_TIER_FOUR_ID = 6;
    private static final int GRINDER_TIER_FOUR_ID = 7;
    private static final int CHARGER_TIER_ONE_ID = 8;
    public static int getCompressorTierOneGuiID() {
        return COMPRESSOR_TIER_ONE_ID;
    }
    public static int getGrinderTierOneGuiID() {
        return GRINDER_TIER_ONE_ID;
    }
    public static int getCompressorTierTwoGuiID() {
        return COMPRESSOR_TIER_TWO_ID;
    }
    public static int getGrinderTierTwoGuiID() {
        return GRINDER_TIER_TWO_ID;
    }
    public static int getCompressorTierThreeGuiID() {
        return COMPRESSOR_TIER_THREE_ID;
    }
    public static int getGrinderTierThreeGuiID() {
        return GRINDER_TIER_THREE_ID;
    }
    public static int getCompressorTierFourGuiID() {
        return COMPRESSOR_TIER_FOUR_ID;
    }
    public static int getGrinderTierFourGuiID() {
        return GRINDER_TIER_FOUR_ID;
    }
    public static int getChargerTierOneID() {
        return CHARGER_TIER_ONE_ID;
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

        if (te instanceof TileEntityCompressorTierTwo){
            TileEntityCompressorTierTwo tileEntityCompressorTierTwo = (TileEntityCompressorTierTwo) te;
            return new ContainerCompressor(player.inventory, tileEntityCompressorTierTwo);
        }

        if (te instanceof TileEntityGrinderTierTwo){
            TileEntityGrinderTierTwo tileEntityGrinderTierTwo = (TileEntityGrinderTierTwo) te;
            return new ContainerGrinder(player.inventory, tileEntityGrinderTierTwo);
        }

        if (te instanceof TileEntityChargerTierOne){
            TileEntityChargerTierOne tileEntityChargerTierOne = (TileEntityChargerTierOne) te;
            return new ContainerCharger(player.inventory, tileEntityChargerTierOne);
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

        if (te instanceof TileEntityCompressorTierTwo){
            TileEntityCompressorTierTwo tileEntityCompressorTierTwo = (TileEntityCompressorTierTwo) te;
            return new GUICompressorTierTwo(player.inventory, tileEntityCompressorTierTwo);
        }

        if (te instanceof TileEntityGrinderTierTwo){
            TileEntityGrinderTierTwo tileEntityGrinderTierTwo = (TileEntityGrinderTierTwo) te;
            return new GUIGrinderTierTwo(player.inventory, tileEntityGrinderTierTwo);
        }

        if (te instanceof TileEntityChargerTierOne){
            TileEntityChargerTierOne tileEntityChargerTierOne = (TileEntityChargerTierOne) te;
            return new GUIChargerTierOne(player.inventory, tileEntityChargerTierOne);
        }

        return null;
    }
}
