package xavier.just_dust.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import xavier.just_dust.common.items.ModItems;

public class ModBlocks {
    public static BaseBlocks    fire_dust_block, earth_dust_block,
                                life_dust_block, matter_dust_block,
                                water_dust_block, death_dust_block,
                                energy_dust_block;
    public static BlockCompressorTierOne compressor_tier_one;
    public static BlockCompressorTierTwo compressor_tier_two;
    public static BlockGrinderTierOne grinder_tier_one;
    public static BlockGrinderTierTwo grinder_tier_two;
    public static BlockEnergyCable cable_energy_tier_one, cable_energy_tier_two;
    public static BlockOre  fire_dust_ore, earth_dust_ore,
                            life_dust_ore, matter_dust_ore,
                            water_dust_ore, death_dust_ore,
                            energy_dust_ore;
    public static BlockChargerTierOne charger_tier_one;


    public static void register(IForgeRegistry<Block> registery) {
        registery.registerAll(
                fire_dust_block = new BaseBlocks(Material.ROCK, "fire_dust_block"),
                earth_dust_block = new BaseBlocks(Material.ROCK, "earth_dust_block"),
                life_dust_block = new BaseBlocks(Material.ROCK, "life_dust_block"),
                matter_dust_block = new BaseBlocks(Material.ROCK, "matter_dust_block"),
                water_dust_block = new BaseBlocks(Material.ROCK, "water_dust_block"),
                death_dust_block = new BaseBlocks(Material.ROCK, "death_dust_block"),
                energy_dust_block = new BaseBlocks(Material.ROCK, "energy_dust_block"),
                compressor_tier_one = new BlockCompressorTierOne(),
                grinder_tier_one = new BlockGrinderTierOne(),
                compressor_tier_two = new BlockCompressorTierTwo(),
                grinder_tier_two = new BlockGrinderTierTwo(),
                cable_energy_tier_one = new BlockEnergyCable("cable_energy_tier_one"),
                cable_energy_tier_two = new BlockEnergyCable("cable_energy_tier_two"),
                fire_dust_ore = new BlockOre("fire_dust_ore", 2 ,ModItems.fire_dust).setExpDrop(2.3f),
                earth_dust_ore = new BlockOre("earth_dust_ore", 2, ModItems.earth_dust).setExpDrop(2.3f),
                life_dust_ore = new BlockOre("life_dust_ore", 2, ModItems.life_dust).setExpDrop(2.3f),
                matter_dust_ore = new BlockOre("matter_dust_ore",2, ModItems.matter_dust).setExpDrop(2.3f),
                water_dust_ore = new BlockOre("water_dust_ore",2, ModItems.water_dust).setExpDrop(2.3f),
                death_dust_ore = new BlockOre("death_dust_ore",2, ModItems.death_dust).setExpDrop(1.3f),
                energy_dust_ore = new BlockOre("energy_dust_ore",2, ModItems.energy_dust).setExpDrop(2.3f)
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                fire_dust_block.createItemBlock(),
                earth_dust_block.createItemBlock(),
                life_dust_block.createItemBlock(),
                matter_dust_block.createItemBlock(),
                water_dust_block.createItemBlock(),
                death_dust_block.createItemBlock(),
                energy_dust_block.createItemBlock(),
                compressor_tier_one.createItemBlock(),
                grinder_tier_one.createItemBlock(),
                compressor_tier_two.createItemBlock(),
                grinder_tier_two.createItemBlock(),
                cable_energy_tier_one.createItemBlock(),
                cable_energy_tier_two.createItemBlock(),
                fire_dust_ore.createItemBlock(),
                earth_dust_ore.createItemBlock(),
                life_dust_ore.createItemBlock(),
                matter_dust_ore.createItemBlock(),
                water_dust_ore.createItemBlock(),
                death_dust_ore.createItemBlock(),
                energy_dust_ore.createItemBlock()
        );
    }

    public static void registerModels() {
        fire_dust_block.registerItemModel(Item.getItemFromBlock(fire_dust_block));
        earth_dust_block.registerItemModel(Item.getItemFromBlock(earth_dust_block));
        life_dust_block.registerItemModel(Item.getItemFromBlock(life_dust_block));
        matter_dust_block.registerItemModel(Item.getItemFromBlock(matter_dust_block));
        water_dust_block.registerItemModel(Item.getItemFromBlock(water_dust_block));
        death_dust_block.registerItemModel(Item.getItemFromBlock(death_dust_block));
        energy_dust_block.registerItemModel(Item.getItemFromBlock(energy_dust_block));
        compressor_tier_one.registerItemModel(Item.getItemFromBlock(compressor_tier_one));
        grinder_tier_one.registerItemModel(Item.getItemFromBlock(grinder_tier_one));
        compressor_tier_two.registerItemModel(Item.getItemFromBlock(compressor_tier_two));
        grinder_tier_two.registerItemModel(Item.getItemFromBlock(grinder_tier_two));
        cable_energy_tier_one.registerItemModel(Item.getItemFromBlock(cable_energy_tier_one));
        cable_energy_tier_two.registerItemModel(Item.getItemFromBlock(cable_energy_tier_two));
        fire_dust_ore.registerItemModel(Item.getItemFromBlock(fire_dust_ore));
        earth_dust_ore.registerItemModel(Item.getItemFromBlock(earth_dust_ore));
        life_dust_ore.registerItemModel(Item.getItemFromBlock(life_dust_ore));
        matter_dust_ore.registerItemModel(Item.getItemFromBlock(matter_dust_ore));
        water_dust_ore.registerItemModel(Item.getItemFromBlock(water_dust_ore));
        death_dust_ore.registerItemModel(Item.getItemFromBlock(death_dust_ore));
        energy_dust_ore.registerItemModel(Item.getItemFromBlock(energy_dust_ore));
    }
}
