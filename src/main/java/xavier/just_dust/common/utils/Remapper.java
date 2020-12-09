package xavier.just_dust.common.utils;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.MissingMappings;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xavier.just_dust.JustDust;

import java.util.List;
import java.util.Map;

public class Remapper<T extends IForgeRegistryEntry<T>> {
    private List<Predicate<MissingMappings.Mapping<T>>> remappingFunctions = ImmutableList.of(this::remapCustomName);

    private void remapAll(List<MissingMappings.Mapping<T>> missingMappings) {
        for (MissingMappings.Mapping<T> missingMapping : missingMappings) {
            boolean remapped = remappingFunctions.stream().anyMatch(mappingPredicate -> mappingPredicate.test(missingMapping));
        }
    }

    private boolean tryRemap(MissingMappings.Mapping<T> missingMapping, ResourceLocation registryName) {
        IForgeRegistry<T> registry = missingMapping.registry;
        T value = registry.getValue(registryName);
        if (registry.containsKey(registryName) && value != null) {
            missingMapping.remap(value);
            return true;
        }

        return false;
    }

    private static Map<String, String> customNames = ImmutableMap.<String, String>builder()
            .put("compressor", "compressor_tier_one")
            .put("grinder", "grinder_tier_one")
            .build();

    private boolean remapCustomName(MissingMappings.Mapping<T> missingMapping) {
        String missingPath = missingMapping.key.getResourcePath();

        if (!customNames.containsKey(missingPath)) return false;

        String newPath = customNames.get(missingPath);
        ResourceLocation newRegistryName = new ResourceLocation(missingMapping.key.getResourceDomain(), newPath);

        return tryRemap(missingMapping, newRegistryName);
    }

    @EventBusSubscriber(modid = JustDust.MODID)
    public static class EventHandler {
        private static final Remapper<Block> blockRemapper = new Remapper<>();
        private static final Remapper<Item> itemRemapper = new Remapper<>();

        @SubscribeEvent
        public static void missingBlockMappings(MissingMappings<Block> event) {
            blockRemapper.remapAll(event.getMappings());
        }

        @SubscribeEvent
        public static void missingItemMappings(MissingMappings<Item> event) {
            itemRemapper.remapAll(event.getMappings());
        }
    }
}
