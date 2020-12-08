package xavier.just_dust.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.LinkedList;
import java.util.List;

public class ModItems {
    public static BaseItems fire_dust, earth_dust, life_dust, matter_dust, water_dust, death_dust, energy_dust,
                            fire_dust_compressed, earth_dust_compressed, life_dust_compressed, matter_dust_compressed, water_dust_compressed, death_dust_compressed, energy_dust_compressed,
                            blade_wheel,
                            iron_dust, coal_dust, steel_dust, gold_dust, diamond_dust, obsidian_dust, emerald_dust, lapis_dust;

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                (fire_dust = new DustItem("fire_dust", CreativeTabs.MATERIALS)),
                (earth_dust = new DustItem("earth_dust", CreativeTabs.MATERIALS)),
                (life_dust = new DustItem("life_dust", CreativeTabs.MATERIALS)),
                (matter_dust = new DustItem("matter_dust", CreativeTabs.MATERIALS)),
                (water_dust = new DustItem("water_dust", CreativeTabs.MATERIALS)),
                (death_dust = new DustItem("death_dust", CreativeTabs.MATERIALS)),
                (energy_dust = new DustItem("energy_dust", CreativeTabs.MATERIALS)),
                (fire_dust_compressed = new IngotItem("fire_dust_compressed", CreativeTabs.MATERIALS)),
                (earth_dust_compressed = new IngotItem("earth_dust_compressed", CreativeTabs.MATERIALS)),
                (life_dust_compressed = new IngotItem("life_dust_compressed", CreativeTabs.MATERIALS)),
                (matter_dust_compressed = new IngotItem("matter_dust_compressed", CreativeTabs.MATERIALS)),
                (water_dust_compressed = new IngotItem("water_dust_compressed", CreativeTabs.MATERIALS)),
                (death_dust_compressed = new IngotItem("death_dust_compressed", CreativeTabs.MATERIALS)),
                (energy_dust_compressed = new IngotItem("energy_dust_compressed", CreativeTabs.MATERIALS)),
                (blade_wheel = new BaseItems("blade_wheel", CreativeTabs.MATERIALS)),
                (iron_dust = new DustItem("iron_dust", CreativeTabs.MATERIALS)),
                (coal_dust = new DustItem("coal_dust", CreativeTabs.MATERIALS)),
                (steel_dust = new DustItem("steel_dust", CreativeTabs.MATERIALS)),
                (gold_dust = new DustItem("gold_dust", CreativeTabs.MATERIALS)),
                (diamond_dust = new DustItem("diamond_dust", CreativeTabs.MATERIALS)),
                (obsidian_dust = new DustItem("obsidian_dust", CreativeTabs.MATERIALS)),
                (emerald_dust = new DustItem("emerald_dust", CreativeTabs.MATERIALS)),
                (lapis_dust = new DustItem("lapis_dust", CreativeTabs.MATERIALS))
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
