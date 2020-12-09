package xavier.just_dust.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    public static BaseBlocks fire_dust_block, earth_dust_block, life_dust_block, matter_dust_block, water_dust_block, death_dust_block, energy_dust_block;
    public static BlockCompressorTierOne compressor_tier_one;
    public static BlockCompressorTierTwo compressor_tier_two;
    public static BlockGrinderTierOne grinder_tier_one;
    public static BlockGrinderTierTwo grinder_tier_two;
    public static BlockEnergyCable cable_energy_tier_one, cable_energy_tier_two;


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
                grinder_tier_two = new BlockGrinderTierTwo(),
                compressor_tier_two = new BlockCompressorTierTwo(),
                grinder_tier_one = new BlockGrinderTierOne(),
                cable_energy_tier_one = new BlockEnergyCable("cable_energy_tier_one"),
                cable_energy_tier_two = new BlockEnergyCable("cable_energy_tier_two")
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
                cable_energy_tier_two.createItemBlock()
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
    }
}
