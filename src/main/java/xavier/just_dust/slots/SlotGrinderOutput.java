package xavier.just_dust.slots;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import xavier.just_dust.api.recipes.CompressorRecipes;

import javax.annotation.Nullable;

public class SlotGrinderOutput extends Slot {
    private EntityPlayer thePlayer;
    private int removeCount;

    public SlotGrinderOutput(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
        this.thePlayer = player;
    }

    public boolean isItemValid(@Nullable ItemStack stack) {
        return false;
    }

    public ItemStack decrStackSize(int amount) {
        if (this.getHasStack()) {
            this.removeCount += Math.min(amount, this.getStack().stackSize);
        }

        return super.decrStackSize(amount);
    }

    public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack) {
        this.onCrafting(stack);
        super.onPickupFromSlot(playerIn, stack);
    }

    protected void onCrafting(ItemStack stack, int amount) {
        this.removeCount += amount;
        this.onCrafting(stack);
    }

    protected void onCrafting(ItemStack stack) {
        stack.onCrafting(this.thePlayer.world, this.thePlayer, this.removeCount);

        if (!this.thePlayer.world.isRemote) {
            int i = this.removeCount;
            float f = CompressorRecipes.instance().getCompressingExperience(stack);

            if (f == 0.0F) {
                i = 0;
            } else if (f < 1.0F) {
                int j = MathHelper.floor((float)i * f);

                if (j < MathHelper.ceil((float)i * f) && Math.random() < (double)((float)i * f - (float)j)) {
                    ++j;
                }

                i = j;
            }

            while (i > 0) {
                int k = EntityXPOrb.getXPSplit(i);
                i -= k;
                this.thePlayer.world.spawnEntity(new EntityXPOrb(this.thePlayer.world, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, k));
            }
        }

        this.removeCount = 0;
    }
}
