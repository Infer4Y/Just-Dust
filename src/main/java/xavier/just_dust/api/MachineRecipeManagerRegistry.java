package xavier.just_dust.api;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryInternal;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;
import xavier.just_dust.JustDust;
import xavier.just_dust.api.recipes.CompressorRecipes;
import xavier.just_dust.api.recipes.GrinderRecipes;
import xavier.just_dust.api.recipes.MachineRecipeManager;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber
public class MachineRecipeManagerRegistry {
    public static final MachineRecipeManager GRINDER = GrinderRecipes.instance();
    public static final MachineRecipeManager COMPRESSOR = CompressorRecipes.instance();

    public static List<MachineRecipeManager> MACHINE_RECIPES;

    public static void init() {
        MACHINE_RECIPES = new ArrayList();
        MACHINE_RECIPES.add(GRINDER);
        MACHINE_RECIPES.add(COMPRESSOR);
    }


    @SubscribeEvent
    public void createMaterialRegistry(RegistryEvent.NewRegistry newRegistry) {

        RegistryBuilder<MachineRecipeManager> registryBuilder = new RegistryBuilder<MachineRecipeManager>();

        registryBuilder.add((IForgeRegistry.CreateCallback<MachineRecipeManager>) (owner, stage) -> {})
                .allowModification()
                .setName(new ResourceLocation(JustDust.MODID, "recipe_manager_registry"))
                .create();
    }

    @SubscribeEvent
    public void registerMaterials(RegistryEvent.Register<MachineRecipeManager> recipeManagerRegister) {

        for(MachineRecipeManager machineRecipeManager : MACHINE_RECIPES)
            recipeManagerRegister.getRegistry().register(machineRecipeManager);

    }
}
