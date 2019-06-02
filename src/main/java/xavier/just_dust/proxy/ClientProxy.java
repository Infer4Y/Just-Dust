package xavier.just_dust.proxy;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.JustDust;
import xavier.just_dust.blocks.ModBlocks;
import xavier.just_dust.blocks.model.ModelLoaderCable;
import xavier.just_dust.guis.GuiHandler;

import static xavier.just_dust.JustDust.MODID;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy{
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(this);
        StateMapperBase ignoreState = new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState iBlockState) {
                return new ModelResourceLocation("just_dust:block_cable_statemapper_name");
            }
        };
        ModelLoader.setCustomStateMapper(ModBlocks.block_cable, ignoreState);

        ModelLoaderRegistry.registerLoader(new ModelLoaderCable());

        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("just_dust:block_cable", "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.block_cable), DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
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
}
