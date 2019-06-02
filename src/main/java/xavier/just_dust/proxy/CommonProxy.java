package xavier.just_dust.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xavier.just_dust.JustDust;
import xavier.just_dust.blocks.ModBlocks;
import xavier.just_dust.api.recipes.CompressorRecipes;
import xavier.just_dust.api.recipes.GrinderRecipes;
import xavier.just_dust.crafting.ModCrafting;
import xavier.just_dust.guis.GuiHandler;
import xavier.just_dust.items.ModItems;
import xavier.just_dust.ore.Ore;
import xavier.just_dust.tileentities.TileEntityCompressor;
import xavier.just_dust.tileentities.TileEntityGrinder;


public class CommonProxy {
    public static Configuration configuration;
    public void preInit(FMLPreInitializationEvent e) {
        ModBlocks.init();
        ModItems.init();
    }

    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new CompressorRecipes());
        MinecraftForge.EVENT_BUS.register(new GrinderRecipes());
        NetworkRegistry.INSTANCE.registerGuiHandler(JustDust.instance, new GuiHandler());
        GameRegistry.registerTileEntity(TileEntityCompressor.class , JustDust.MODID+":compressor");
        GameRegistry.registerTileEntity(TileEntityGrinder.class , JustDust.MODID+":grinder");
        ModCrafting.init();
        Ore.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }
}
