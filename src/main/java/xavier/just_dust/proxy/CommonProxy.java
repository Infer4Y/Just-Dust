package xavier.just_dust.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xavier.just_dust.JustDust;
import xavier.just_dust.api.recipes.MachineRecipeManager;
import xavier.just_dust.blocks.ModBlocks;
import xavier.just_dust.api.recipes.CompressorRecipes;
import xavier.just_dust.api.recipes.GrinderRecipes;
import xavier.just_dust.guis.GuiHandler;
import xavier.just_dust.items.ModItems;
import xavier.just_dust.ore.Ore;
import xavier.just_dust.tileentities.TileEntityCompressor;
import xavier.just_dust.tileentities.TileEntityGrinder;


public class CommonProxy {
    public static Configuration configuration;
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(JustDust.instance, new GuiHandler());
        GameRegistry.registerTileEntity(TileEntityCompressor.class , JustDust.MODID+":compressor");
        GameRegistry.registerTileEntity(TileEntityGrinder.class , JustDust.MODID+":grinder");
        Ore.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }

    public void registerRenderers() {
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        public static void registerCraftingApi(RegistryEvent.Register<MachineRecipeManager> event){
            event.getRegistry().registerAll(CompressorRecipes.instance(), GrinderRecipes.instance());

        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }



    }
}
