package xavier.just_dust.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import xavier.just_dust.common.creative_tabs.DustTabs;
import xavier.just_dust.common.items.energy.BaseEnergyItem;
import xavier.just_dust.common.items.energy.EnergyCellItem;
import xavier.just_dust.common.items.tools.ItemGun;
import xavier.just_dust.common.items.tools.ItemSaw;

public class ModItems {
    public static BaseItem fire_dust, earth_dust, life_dust, matter_dust, water_dust, death_dust, energy_dust,
                            fire_dust_compressed, earth_dust_compressed, life_dust_compressed, matter_dust_compressed, water_dust_compressed, death_dust_compressed, energy_dust_compressed,
                            blade_wheel,
                            iron_dust, coal_dust, steel_dust, gold_dust, diamond_dust, obsidian_dust, emerald_dust, lapis_dust,
                            energy_cell_tier_one, energy_cell_tier_two, energy_cell_tier_three, energy_cell_tier_four,
                            energy_cell_tier_five, energy_cell_tier_six, energy_cell_tier_seven, energy_cell_tier_eight,
                            saw_tier_one,
                            gun_dual_barrel;

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
                (lapis_dust = new DustItem("lapis_dust", DustTabs.MATERIALS_CREATIVE_TAB)),
                (energy_cell_tier_one = new EnergyCellItem("energy_cell_tier_one", DustTabs.TOOLS_CREATIVE_TAB, 1000000, 1000, 1000)),
                (energy_cell_tier_two = new EnergyCellItem("energy_cell_tier_two", DustTabs.TOOLS_CREATIVE_TAB, 2000000, 1200, 1200)),
                (energy_cell_tier_three = new EnergyCellItem("energy_cell_tier_three", DustTabs.TOOLS_CREATIVE_TAB, 4000000, 2400, 2400)),
                (energy_cell_tier_four = new EnergyCellItem("energy_cell_tier_four", DustTabs.TOOLS_CREATIVE_TAB, 8000000, 4800, 4800)),
                (energy_cell_tier_five = new EnergyCellItem("energy_cell_tier_five", DustTabs.TOOLS_CREATIVE_TAB, 16000000, 9600, 9600)),
                (energy_cell_tier_six = new EnergyCellItem("energy_cell_tier_six", DustTabs.TOOLS_CREATIVE_TAB, 32000000, 19200, 19200)),
                (energy_cell_tier_seven = new EnergyCellItem("energy_cell_tier_seven", DustTabs.TOOLS_CREATIVE_TAB, 64000000, 38400, 38400)),
                (energy_cell_tier_eight = new EnergyCellItem("energy_cell_tier_eight", DustTabs.TOOLS_CREATIVE_TAB, 128000000, 768000, 76800)),
                (saw_tier_one = new ItemSaw("saw_powered_tier_one", DustTabs.TOOLS_CREATIVE_TAB, ItemSaw.SawMaterials.TIER_ONE)),
                (gun_dual_barrel = new ItemGun("gun_dual_barrel", DustTabs.TOOLS_CREATIVE_TAB))
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
        lapis_dust.registerItemModel();
        gun_dual_barrel.registerItemModel();
        saw_tier_one.registerItemModel();
        energy_cell_tier_one.registerItemModel();
        energy_cell_tier_two.registerItemModel();
        energy_cell_tier_three.registerItemModel();
        energy_cell_tier_four.registerItemModel();
        energy_cell_tier_five.registerItemModel();
        energy_cell_tier_six.registerItemModel();
        energy_cell_tier_seven.registerItemModel();
        energy_cell_tier_eight.registerItemModel();
    }
}
