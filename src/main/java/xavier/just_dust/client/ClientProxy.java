package xavier.just_dust.client;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.JustDust;
import xavier.just_dust.client.guis.GuiHandler;
import xavier.just_dust.common.tile_entities.*;
import xavier.just_dust.common.CommonProxy;

import static xavier.just_dust.JustDust.MODID;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        NetworkRegistry.INSTANCE.registerGuiHandler(JustDust.instance, new GuiHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MODID + ":" + id, "inventory"));
    }

    @Override
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCompressorTierOne.class, new TESRCompressorTierOne());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrinderTierOne.class, new TESRGrinderTierOne());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChargerTierOne.class, new TESRChargerTierOne());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCompressorTierTwo.class, new TESRCompressorTierTwo());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrinderTierTwo.class, new TESRGrinderTierTwo());
    }
}
