package xavier.just_dust.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xavier.just_dust.items.ItemModelProvider;

public class ModBlocks {
    public static BaseBlocks fire_dust_block, earth_dust_block, life_dust_block, matter_dust_block, water_dust_block, death_dust_block, energy_dust_block;
    public static BlockCompressor block_compressor;
    public static BlockGrinder block_grinder;
    public static BlockCable block_cable;


    public static void init() {
        register(fire_dust_block = new BaseBlocks(Material.SAND, "fire_dust_block"));
        register(earth_dust_block = new BaseBlocks(Material.SAND, "earth_dust_block"));
        register(life_dust_block = new BaseBlocks(Material.SAND, "life_dust_block"));
        register(matter_dust_block = new BaseBlocks(Material.SAND, "matter_dust_block"));
        register(water_dust_block = new BaseBlocks(Material.SAND, "water_dust_block"));
        register(death_dust_block = new BaseBlocks(Material.SAND, "death_dust_block"));
        register(energy_dust_block = new BaseBlocks(Material.SAND, "energy_dust_block"));
        register(block_compressor = (BlockCompressor) new BlockCompressor().setCreativeTab(CreativeTabs.REDSTONE));
        register(block_grinder = (BlockGrinder) new BlockGrinder().setCreativeTab(CreativeTabs.REDSTONE));
        register(block_cable = new BlockCable(Material.IRON,"block_cable"));
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if (block instanceof ItemModelProvider) {
            ((ItemModelProvider)block).registerItemModel(itemBlock);
        }

        if (block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
