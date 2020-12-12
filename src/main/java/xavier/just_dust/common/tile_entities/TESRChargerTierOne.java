package xavier.just_dust.common.tile_entities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

public class TESRChargerTierOne extends TileEntitySpecialRenderer<TileEntityChargerTierOne> {
    public void start(){
        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
        GlStateManager.enableBlend();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GlStateManager.pushMatrix();
    }

    public void end(){
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
    }

    public void drawStick(IBakedModel model, TileEntityChargerTierOne te, ItemStack rod, double x, double y, double z, float rotY){
        start();

        GlStateManager.translate(x, y , z);
        GlStateManager.rotate((float) Math.toRadians(45), 0, rotY, 0);

        model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(rod, te.getWorld(), null);
        model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

        Minecraft.getMinecraft().getRenderItem().renderItem(rod, model);
        end();
    }

    @Override
    public void render(TileEntityChargerTierOne te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        //super.render(te, x, y, z, partialTicks, destroyStage, alpha);
        ItemStack rod = new ItemStack(Items.STICK);
        ItemStack stack = te.getStackInSlot(0);
        float middleY = 9f/16f;
        if (!stack.isEmpty()) {
            start();
            IBlockState state = te.getWorld().getBlockState(te.getPos());
            float worldTime = te.getWorld().getTotalWorldTime();
            double offset = Math.sin((worldTime + partialTicks) / 8) / 8.0;
            GlStateManager.translate(x + 0.5, y + 8f/16f + offset, z + 0.5);
            GlStateManager.rotate((worldTime + partialTicks) * 4, 0, 1, 0);


            IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(stack, te.getWorld(), null);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack, model);

            end();
        }
    }
}
