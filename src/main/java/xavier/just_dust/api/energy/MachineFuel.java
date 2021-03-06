package xavier.just_dust.api.energy;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import xavier.just_dust.common.blocks.ModBlocks;
import xavier.just_dust.common.items.ModItems;

public class MachineFuel {

    public static int getEnergyOutput(ItemStack stack){
        if (stack.isEmpty())
            return 0;
        Item item = stack.getItem();

        if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
        {
            Block block = Block.getBlockFromItem(item);

            if (block == Blocks.REDSTONE_TORCH) {
                return 1600;
            }

            if (block == Blocks.REDSTONE_LAMP) {
                return 1600;
            }

            if (block == Blocks.REDSTONE_BLOCK) {
                return 16000;
            }

            if (block == Blocks.REDSTONE_ORE) {
                return 20000;
            }

            if (block == ModBlocks.energy_dust_block) {
                return 32000;
            }
        }
        if (item == Items.REDSTONE) return 1600;
        if (item == ModItems.energy_dust) return 1600;
        if (item == ModItems.energy_dust_compressed) return 3200;
        return 0;
    }
}
