package xavier.just_dust.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import xavier.just_dust.items.ItemModelProvider;

public class ModBlocks {
    public static BaseBlocks fire_dust_block, earth_dust_block, life_dust_block, matter_dust_block, water_dust_block, death_dust_block, energy_dust_block;
    public static BlockCompressor block_compressor;
    public static BlockGrinder block_grinder;
    public static BlockEnergyCable block_cable;


    public static void register(IForgeRegistry<Block> registery) {
        registery.registerAll(
                fire_dust_block = new BaseBlocks(Material.SAND, "fire_dust_block"),
                earth_dust_block = new BaseBlocks(Material.SAND, "earth_dust_block"),
                life_dust_block = new BaseBlocks(Material.SAND, "life_dust_block"),
                matter_dust_block = new BaseBlocks(Material.SAND, "matter_dust_block"),
                water_dust_block = new BaseBlocks(Material.SAND, "water_dust_block"),
                death_dust_block = new BaseBlocks(Material.SAND, "death_dust_block"),
                energy_dust_block = new BaseBlocks(Material.SAND, "energy_dust_block"),
                block_compressor = (BlockCompressor) new BlockCompressor().setCreativeTab(CreativeTabs.REDSTONE),
                block_grinder = (BlockGrinder) new BlockGrinder().setCreativeTab(CreativeTabs.REDSTONE),
                block_cable = (BlockEnergyCable) new BlockEnergyCable("block_cable").setCreativeTab(CreativeTabs.REDSTONE)
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
                block_compressor.createItemBlock(),
                block_grinder.createItemBlock(),
                block_cable.createItemBlock()
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
        block_compressor.registerItemModel(Item.getItemFromBlock(block_compressor));
        block_grinder.registerItemModel(Item.getItemFromBlock(block_grinder));
        block_cable.registerItemModel(Item.getItemFromBlock(block_cable));;
    }
}
