package xavier.just_dust.blocks.model;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.blocks.BlockCable;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import java.util.LinkedList;
import java.util.List;

public class CompositeModel implements IPerspectiveAwareModel {

    public CompositeModel(IBakedModel i_modelCore, IBakedModel i_modelUp, IBakedModel i_modelDown,
                          IBakedModel i_modelWest, IBakedModel i_modelEast,
                          IBakedModel i_modelNorth, IBakedModel i_modelSouth) {
        modelCore = i_modelCore;
        modelUp = i_modelUp;
        modelDown = i_modelDown;
        modelWest = i_modelWest;
        modelEast = i_modelEast;
        modelNorth = i_modelNorth;
        modelSouth = i_modelSouth;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public List<BakedQuad> getQuads(@Nullable IBlockState blockState, @Nullable EnumFacing side, long rand) {
        List<BakedQuad> quadsList = new LinkedList<BakedQuad>();
        quadsList.addAll(modelCore.getQuads(blockState, side, rand));
        if (!(blockState instanceof IExtendedBlockState)) {
            return quadsList;
        }
        IExtendedBlockState extendedBlockState = (IExtendedBlockState) blockState;
        if (isLinkPresent(extendedBlockState, (IUnlistedProperty<Boolean>) BlockCable.LINK_UP)) {
            quadsList.addAll(modelUp.getQuads(extendedBlockState, side, rand));
        }
        if (isLinkPresent(extendedBlockState, (IUnlistedProperty<Boolean>) BlockCable.LINK_DOWN)) {
            quadsList.addAll(modelDown.getQuads(extendedBlockState, side, rand));
        }
        if (isLinkPresent(extendedBlockState, (IUnlistedProperty<Boolean>) BlockCable.LINK_WEST)) {
            quadsList.addAll(modelWest.getQuads(extendedBlockState, side, rand));
        }
        if (isLinkPresent(extendedBlockState, (IUnlistedProperty<Boolean>) BlockCable.LINK_EAST)) {
            quadsList.addAll(modelEast.getQuads(extendedBlockState, side, rand));
        }
        if (isLinkPresent(extendedBlockState, (IUnlistedProperty<Boolean>) BlockCable.LINK_NORTH)) {
            quadsList.addAll(modelNorth.getQuads(extendedBlockState, side, rand));
        }
        if (isLinkPresent(extendedBlockState, (IUnlistedProperty<Boolean>) BlockCable.LINK_SOUTH)) {
            quadsList.addAll(modelSouth.getQuads(extendedBlockState, side, rand));
        }
        return quadsList;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isAmbientOcclusion() {
        return modelCore.isAmbientOcclusion();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isGui3d() {
        return modelCore.isGui3d();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getParticleTexture() {
        TextureAtlasSprite textureAtlasSprite = Minecraft.getMinecraft().getTextureMapBlocks()
                .getAtlasSprite("just_dust:blocks/death_dust_block");

        return textureAtlasSprite;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return modelCore.getItemCameraTransforms();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
        if (modelCore instanceof IPerspectiveAwareModel) {
            Matrix4f matrix4f = ((IPerspectiveAwareModel) modelCore).handlePerspective(cameraTransformType).getRight();
            return Pair.of(this, matrix4f);
        } else {

            ItemCameraTransforms itemCameraTransforms = modelCore.getItemCameraTransforms();
            ItemTransformVec3f itemTransformVec3f = itemCameraTransforms.getTransform(cameraTransformType);
            TRSRTransformation tr = new TRSRTransformation(itemTransformVec3f);
            Matrix4f mat = null;
            if (tr != null) {
                mat = tr.getMatrix();
            }

            return Pair.of(this, mat);
        }
    }

    @Override
    public ItemOverrideList getOverrides() {
        return null;
    }

    private boolean isLinkPresent(IExtendedBlockState iExtendedBlockState, IUnlistedProperty<Boolean> whichLink) {
        Boolean link = iExtendedBlockState.getValue(whichLink);
        if (link == null) {
            return false;
        }
        return link;
    }

    private IBakedModel modelCore;
    private IBakedModel modelUp;
    private IBakedModel modelDown;
    private IBakedModel modelWest;
    private IBakedModel modelEast;
    private IBakedModel modelNorth;
    private IBakedModel modelSouth;
}
