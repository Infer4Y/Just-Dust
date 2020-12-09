package xavier.just_dust.common.slots;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import xavier.just_dust.common.tile_entities.TileEntityGrinderTierOne;

import javax.annotation.Nullable;

public class SlotGrinderFuel extends Slot {
    public SlotGrinderFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack) {
        return TileEntityGrinderTierOne.isItemFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() == Items.BUCKET;
    }
}
