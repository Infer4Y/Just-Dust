package xavier.just_dust.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.capabilities.Capability;
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
import xavier.just_dust.api.recipes.CompressorRecipes;
import xavier.just_dust.api.recipes.GrinderRecipes;
import xavier.just_dust.common.blocks.ModBlocks;
import xavier.just_dust.client.guis.GuiHandler;
import xavier.just_dust.common.items.ModItems;
import xavier.just_dust.common.tile_entities.*;
import xavier.just_dust.common.utils.ore.OreDictionaryDusts;


public class CommonProxy {
    public static Configuration configuration;
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(JustDust.instance, new GuiHandler());
        OreDictionaryDusts.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }

    public void registerRenderers() {
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
            GameRegistry.registerTileEntity(TileEntityCompressorTierOne.class , JustDust.MODID+":compressor_tier_one");
            GameRegistry.registerTileEntity(TileEntityGrinderTierOne.class , JustDust.MODID+":grinder_tier_one");
            GameRegistry.registerTileEntity(TileEntityCompressorTierTwo.class , JustDust.MODID+":compressor_tier_two");
            GameRegistry.registerTileEntity(TileEntityGrinderTierTwo.class , JustDust.MODID+":grinder_tier_two");
            GameRegistry.registerTileEntity(TileEntityChargerTierOne.class , JustDust.MODID+":charger_tier_one");
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
