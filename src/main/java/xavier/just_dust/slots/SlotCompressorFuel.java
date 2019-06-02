package xavier.just_dust.slots;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import xavier.just_dust.tileentities.TileEntityCompressor;

import javax.annotation.Nullable;

public class SlotCompressorFuel extends Slot {
    public SlotCompressorFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    public boolean isItemValid(@Nullable ItemStack stack) {
        return TileEntityCompressor.isItemFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack != null && stack.getItem() != null && stack.getItem() == Items.BUCKET;
    }
}
