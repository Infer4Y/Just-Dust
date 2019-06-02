package xavier.just_dust;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MachineFuel {
    public MachineFuel() {
    }

    public int getEnergyOutput(ItemStack stack){
        Item item = stack.getItem();

        if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
        {
            Block block = Block.getBlockFromItem(item);

            if (block == Blocks.REDSTONE_TORCH) {
                return 150;
            }

            if (block == Blocks.REDSTONE_LAMP) {
                return 300;
            }

            if (block == Blocks.REDSTONE_BLOCK) {
                return 16000;
            }

            if (block == Blocks.REDSTONE_ORE) {
                return 20000;
            }
        }
        if (item == Items.REDSTONE) return 1600;
        return 0;
    }
}
