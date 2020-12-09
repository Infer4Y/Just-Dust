package xavier.just_dust.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import xavier.just_dust.common.creative_tabs.DustTabs;

public class ModItems {
    public static BaseItem fire_dust, earth_dust, life_dust, matter_dust, water_dust, death_dust, energy_dust,
                            fire_dust_compressed, earth_dust_compressed, life_dust_compressed, matter_dust_compressed, water_dust_compressed, death_dust_compressed, energy_dust_compressed,
                            blade_wheel,
                            iron_dust, coal_dust, steel_dust, gold_dust, diamond_dust, obsidian_dust, emerald_dust, lapis_dust;

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                (fire_dust = new DustItem("fire_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (earth_dust = new DustItem("earth_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (life_dust = new DustItem("life_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (matter_dust = new DustItem("matter_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (water_dust = new DustItem("water_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (death_dust = new DustItem("death_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (energy_dust = new DustItem("energy_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (fire_dust_compressed = new IngotItem("fire_dust_compressed", DustTabs.MATERIALS_CREATIVE_TAB)),
                (earth_dust_compressed = new IngotItem("earth_dust_compressed", DustTabs.MATERIALS_CREATIVE_TAB)),
                (life_dust_compressed = new IngotItem("life_dust_compressed", DustTabs.MATERIALS_CREATIVE_TAB)),
                (matter_dust_compressed = new IngotItem("matter_dust_compressed", DustTabs.MATERIALS_CREATIVE_TAB)),
                (water_dust_compressed = new IngotItem("water_dust_compressed", DustTabs.MATERIALS_CREATIVE_TAB)),
                (death_dust_compressed = new IngotItem("death_dust_compressed", DustTabs.MATERIALS_CREATIVE_TAB)),
                (energy_dust_compressed = new IngotItem("energy_dust_compressed", DustTabs.MATERIALS_CREATIVE_TAB)),
                (blade_wheel = new PartItem("blade_wheel", DustTabs.MATERIALS_CREATIVE_TAB)),
                (iron_dust = new DustItem("iron_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (coal_dust = new DustItem("coal_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (steel_dust = new DustItem("steel_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (gold_dust = new DustItem("gold_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (diamond_dust = new DustItem("diamond_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (obsidian_dust = new DustItem("obsidian_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (emerald_dust = new DustItem("emerald_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (lapis_dust = new DustItem("lapis_dust", DustTabs.MATERIALS_CREATIVE_TAB))
        );
    }

    public static void registerModels() {
        fire_dust.registerItemModel();
        earth_dust.registerItemModel();
        life_dust.registerItemModel();
        matter_dust.registerItemModel();
        water_dust.registerItemModel();
        death_dust.registerItemModel();
        energy_dust.registerItemModel();
        fire_dust_compressed.registerItemModel();
        earth_dust_compressed.registerItemModel();
        life_dust_compressed.registerItemModel();
        matter_dust_compressed.registerItemModel();
        water_dust_compressed.registerItemModel();
        death_dust_compressed.registerItemModel();
        energy_dust_compressed.registerItemModel();
        blade_wheel.registerItemModel();
        iron_dust.registerItemModel();
        coal_dust.registerItemModel();
        steel_dust.registerItemModel();
        gold_dust.registerItemModel();
        diamond_dust.registerItemModel();
        obsidian_dust.registerItemModel();
        emerald_dust.registerItemModel();
        lapis_dust.registerItemModel();
    }
}
