package xavier.just_dust.common.slots;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import xavier.just_dust.api.recipes.ChargingRecipes;

import javax.annotation.Nullable;

public class SlotChargerOutput extends Slot {
    private EntityPlayer thePlayer;
    private int removeCount;

    public SlotChargerOutput(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
        this.thePlayer = player;
    }

    public boolean isItemValid(@Nullable ItemStack stack) {
        return false;
    }

    public ItemStack decrStackSize(int amount) {
        if (this.getHasStack()) {
            this.removeCount += Math.min(amount, this.getStack().getCount());
        }

        return super.decrStackSize(amount);
    }

    @Override
    public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
        this.onCrafting(stack);
        return super.onTake(thePlayer, stack);
    }

    protected void onCrafting(ItemStack stack, int amount) {
        this.removeCount += amount;
        this.onCrafting(stack);
    }

    protected void onCrafting(ItemStack stack) {
        stack.onCrafting(this.thePlayer.world, this.thePlayer, this.removeCount);

        this.removeCount = 0;
    }
}
