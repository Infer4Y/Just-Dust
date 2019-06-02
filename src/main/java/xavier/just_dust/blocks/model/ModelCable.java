package xavier.just_dust.blocks.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;

public class ModelCable implements IModel {

    public static final ResourceLocation TEXTURE_SHEET = new ResourceLocation("just_dust:blocks/death_dust_block");

    public static final ModelResourceLocation MODEL_CORE = new ModelResourceLocation("just_dust:cable_subblocks/block_cable_core_model");
    public static final ModelResourceLocation MODEL_UP = new ModelResourceLocation("just_dust:cable_subblocks/block_cable_up_model");
    public static final ModelResourceLocation MODEL_DOWN = new ModelResourceLocation("just_dust:cable_subblocks/block_cable_down_model");
    public static final ModelResourceLocation MODEL_NORTH = new ModelResourceLocation("just_dust:cable_subblocks/block_cable_north_model");
    public static final ModelResourceLocation MODEL_SOUTH = new ModelResourceLocation("just_dust:cable_subblocks/block_cable_south_model");
    public static final ModelResourceLocation MODEL_WEST = new ModelResourceLocation("just_dust:cable_subblocks/block_cable_west_model");
    public static final ModelResourceLocation MODEL_EAST = new ModelResourceLocation("just_dust:cable_subblocks/block_cable_east_model");

    public ModelCable() {
    }

    @Override
    public Collection<ResourceLocation> getDependencies() {
        return ImmutableList.copyOf(new ResourceLocation[]{MODEL_CORE, MODEL_UP, MODEL_DOWN, MODEL_WEST, MODEL_EAST, MODEL_NORTH, MODEL_SOUTH});
    }

    @Override
    public Collection<ResourceLocation> getTextures() {
        return ImmutableList.copyOf(new ResourceLocation[]{TEXTURE_SHEET});
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, com.google.common.base.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        try {
            IModel subComponent = ModelLoaderRegistry.getModel(MODEL_CORE);
            IBakedModel bakedModelCore = subComponent.bake(state, format, bakedTextureGetter);

            subComponent = ModelLoaderRegistry.getModel(MODEL_UP);
            IBakedModel bakedModelUp = subComponent.bake(state, format, bakedTextureGetter);

            subComponent = ModelLoaderRegistry.getModel(MODEL_DOWN);
            IBakedModel bakedModelDown = subComponent.bake(state, format, bakedTextureGetter);

            subComponent = ModelLoaderRegistry.getModel(MODEL_WEST);
            IBakedModel bakedModelWest = subComponent.bake(state, format, bakedTextureGetter);

            subComponent = ModelLoaderRegistry.getModel(MODEL_EAST);
            IBakedModel bakedModelEast = subComponent.bake(state, format, bakedTextureGetter);

            subComponent = ModelLoaderRegistry.getModel(MODEL_NORTH);
            IBakedModel bakedModelNorth = subComponent.bake(state, format, bakedTextureGetter);

            subComponent = ModelLoaderRegistry.getModel(MODEL_SOUTH);
            IBakedModel bakedModelSouth = subComponent.bake(state, format, bakedTextureGetter);

            return new CompositeModel(bakedModelCore, bakedModelUp, bakedModelDown,
                    bakedModelWest, bakedModelEast, bakedModelNorth, bakedModelSouth);
        } catch (Exception exception) {
            System.err.println("ModelCable.bake() failed due to exception:" + exception);
            return ModelLoaderRegistry.getMissingModel().bake(state, format, bakedTextureGetter);
        }
    }

    @Override
    public IModelState getDefaultState() {
        return null;
    }

}
