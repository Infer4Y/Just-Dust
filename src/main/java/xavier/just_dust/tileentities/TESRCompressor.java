package xavier.just_dust.tileentities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;
import xavier.just_dust.blocks.BlockCompressor;

public class TESRCompressor extends TileEntitySpecialRenderer<TileEntityCompressor> {


    @Override
    public void render(TileEntityCompressor te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(te, x, y, z, partialTicks, destroyStage, alpha);
        ItemStack stack = te.getStackInSlot(0);
        if (stack != null) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
            GlStateManager.enableBlend();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
            GlStateManager.pushMatrix();
            IBlockState state = te.getWorld().getBlockState(te.getPos());
            if (Block.getBlockFromItem(stack.getItem()) == null){
                GlStateManager.translate(x + 0.5, y + 0.325, z + 0.5);
                if (!(state.getValue( BlockHorizontal.FACING ) == EnumFacing.NORTH ||  state.getValue( BlockHorizontal.FACING ) == EnumFacing.SOUTH)) {
                    GlStateManager.rotate(90, 0, 0, 1);
                } else {
                    GlStateManager.rotate(90, 1, 0, 0);
                }
            } else {
                GlStateManager.translate(x + 0.5, y + 0.25, z + 0.5);
            }
            switch (state.getValue( BlockHorizontal.FACING )){
                case NORTH:
                    GlStateManager.rotate(0, 0, 1, 0);
                    break;
                case WEST:
                    GlStateManager.rotate(270, 0, 1, 0);
                    break;
                case EAST:
                    GlStateManager.rotate(90, 0, 1, 0);
                    break;
                case SOUTH:
                    GlStateManager.rotate(180, 0, 1, 0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + state.getValue(BlockHorizontal.FACING));
            }

            IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(stack, te.getWorld(), null);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack, model);

            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }
}
