package xavier.just_dust.blocks.model;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;

public class ModelLoaderCable implements ICustomModelLoader {
    public final String SMART_MODEL_RESOURCE_LOCATION = "models/block/smartmodel/";

    @Override
    public boolean accepts(ResourceLocation resourceLocation) {
        return resourceLocation.getResourceDomain().equals("just_dust")
                && resourceLocation.getResourcePath().startsWith(SMART_MODEL_RESOURCE_LOCATION);
    }

    @Override
    public IModel loadModel(ResourceLocation resourceLocation) {
        String resourcePath = resourceLocation.toString();
        if (!resourcePath.startsWith(SMART_MODEL_RESOURCE_LOCATION)) {
            assert false : "loadModel expected " + SMART_MODEL_RESOURCE_LOCATION + " but found " + resourcePath;
        }
        String modelName = resourcePath.substring(SMART_MODEL_RESOURCE_LOCATION.length());

        if (modelName.equals("cablemodel")) {
            return new ModelCable();
        } else {
            return ModelLoaderRegistry.getMissingModel();
        }
    }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    private IResourceManager resourceManager;
}
