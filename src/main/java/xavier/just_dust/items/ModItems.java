package xavier.just_dust.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static BaseItems fire_dust, earth_dust, life_dust, matter_dust, water_dust, death_dust, energy_dust,
                            fire_dust_compressed, earth_dust_compressed, life_dust_compressed,
                            matter_dust_compressed, water_dust_compressed, death_dust_compressed, energy_dust_compressed,
                            blade_wheel, iron_dust, gold_dust, diamond_dust, obsidian_dust, emerald_dust, lapis_dust;

    public static void init() {
        register(fire_dust = new BaseItems("fire_dust", CreativeTabs.MATERIALS));
        register(earth_dust = new BaseItems("earth_dust", CreativeTabs.MATERIALS));
        register(life_dust = new BaseItems("life_dust", CreativeTabs.MATERIALS));
        register(matter_dust = new BaseItems("matter_dust", CreativeTabs.MATERIALS));
        register(water_dust = new BaseItems("water_dust", CreativeTabs.MATERIALS));
        register(death_dust = new BaseItems("death_dust", CreativeTabs.MATERIALS));
        register(energy_dust = new BaseItems("energy_dust", CreativeTabs.MATERIALS));
        register(fire_dust_compressed = new BaseItems("fire_dust_compressed", CreativeTabs.MATERIALS));
        register(earth_dust_compressed = new BaseItems("earth_dust_compressed", CreativeTabs.MATERIALS));
        register(life_dust_compressed = new BaseItems("life_dust_compressed", CreativeTabs.MATERIALS));
        register(matter_dust_compressed = new BaseItems("matter_dust_compressed", CreativeTabs.MATERIALS));
        register(water_dust_compressed = new BaseItems("water_dust_compressed", CreativeTabs.MATERIALS));
        register(death_dust_compressed = new BaseItems("death_dust_compressed", CreativeTabs.MATERIALS));
        register(energy_dust_compressed = new BaseItems("energy_dust_compressed", CreativeTabs.MATERIALS));
        register(blade_wheel = new BaseItems("blade_wheel", CreativeTabs.MATERIALS));
        register(iron_dust = new BaseItems("iron_dust", CreativeTabs.MATERIALS));
        register(gold_dust = new BaseItems("gold_dust", CreativeTabs.MATERIALS));
        register(diamond_dust = new BaseItems("diamond_dust", CreativeTabs.MATERIALS));
        register(obsidian_dust = new BaseItems("obsidian_dust", CreativeTabs.MATERIALS));
        register(emerald_dust = new BaseItems("emerald_dust", CreativeTabs.MATERIALS));
        register(lapis_dust = new BaseItems("lapis_dust", CreativeTabs.MATERIALS));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);
        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }
        return item;
    }
}
