package xavier.just_dust.common.slots;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import xavier.just_dust.common.tile_entities.TileEntityChargerTierOne;

import javax.annotation.Nullable;

public class SlotChargerFuel extends Slot {
    public SlotChargerFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    public boolean isItemValid(@Nullable ItemStack stack) {
        return TileEntityChargerTierOne.isItemFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() == Items.BUCKET;
    }
}
