package xavier.just_dust.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.MachineFuel;
import xavier.just_dust.blocks.BlockCompressor;
import xavier.just_dust.containers.ContainerCompressor;
import xavier.just_dust.api.recipes.CompressorRecipes;
import xavier.just_dust.slots.SlotCompressorFuel;

import javax.annotation.Nullable;

public class TileEntityCompressor extends TileEntityLockable implements ITickable, ISidedInventory {
    private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2,1};
    private static final int[] SLOTS_SIDES = new int[] {1};
    private ItemStack[] compressorItemStacks = new ItemStack[3];
    private int compressorRunTime;
    private int currentItemRunTime;
    private int compressingTime;
    private int totalRunTime;
    private String compressorCustomName;

    public int getSizeInventory() {
        return this.compressorItemStacks.length;
    }

    @Nullable
    public ItemStack getStackInSlot(int index) {
        return this.compressorItemStacks[index];
    }

    @Nullable
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.compressorItemStacks, index, count);
    }

    @Nullable
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.compressorItemStacks, index);
    }

    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        boolean flag = stack != null && stack.isItemEqual(this.compressorItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.compressorItemStacks[index]);
        this.compressorItemStacks[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }

        if (index == 0 && !flag) {
            this.totalRunTime = this.getCookTime(stack);
            this.compressingTime = 0;
            this.markDirty();
        }
    }

    public String getName() {
        return this.hasCustomName() ? this.compressorCustomName : "container.compressor";
    }

    public boolean hasCustomName() {
        return this.compressorCustomName != null && !this.compressorCustomName.isEmpty();
    }

    public void setCustomInventoryName(String name) {
        this.compressorCustomName = name;
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.compressorItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < this.compressorItemStacks.length) {
                this.compressorItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        this.compressorRunTime = compound.getInteger("RunTime");
        this.compressingTime = compound.getInteger("CompressingTime");
        this.totalRunTime = compound.getInteger("CompressingTimeTotal");
        this.currentItemRunTime = getItemRunTime(this.compressorItemStacks[1]);

        if (compound.hasKey("CustomName", 8)) {
            this.compressorCustomName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("RunTime", this.compressorRunTime);
        compound.setInteger("CompressingTime", this.compressingTime);
        compound.setInteger("CompressingTimeTotal", this.totalRunTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.compressorItemStacks.length; ++i) {
            if (this.compressorItemStacks[i] != null) {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.compressorItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.compressorCustomName);
        }

        return compound;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isRunning() {
        return this.compressorRunTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isRunning(IInventory inventory) {
        return inventory.getField(0) > 0;
    }

    public void update() {
        boolean flag = this.isRunning();
        boolean flag1 = false;

        if (!this.world.isRemote) {
            if (this.isRunning() || this.compressorItemStacks[1] != null && this.compressorItemStacks[0] != null) {
                if (!this.isRunning() && this.canCompressing()) {
                    this.currentItemRunTime = this.compressorRunTime = getItemRunTime(this.compressorItemStacks[1]);

                    if (this.isRunning()) {
                        flag1 = true;

                        if (this.compressorItemStacks[1] != null) {
                            --this.compressorItemStacks[1].stackSize;

                            if (this.compressorItemStacks[1].stackSize == 0) {
                                this.compressorItemStacks[1] = compressorItemStacks[1].getItem().getContainerItem(compressorItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isRunning() && this.canCompressing()) {
                    ++this.compressingTime;

                    if (this.compressingTime == this.totalRunTime) {
                        this.compressingTime = 0;
                        this.totalRunTime = this.getCookTime(this.compressorItemStacks[0]);
                        this.compressItem();
                        flag1 = true;
                    }

                    --this.compressorRunTime;
                } else {
                    this.compressingTime = 0;
                }
            } else if (!this.isRunning() && this.compressingTime > 0) {
                this.compressingTime = MathHelper.clamp(this.compressingTime - 2, 0, this.totalRunTime);
            }

            if (flag != this.isRunning()) {
                flag1 = true;
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public int getCookTime(@Nullable ItemStack stack) {
        return 200;
    }

    private boolean canCompressing() {
        if (this.compressorItemStacks[0] == null) {
            return false;
        } else {
            ItemStack itemstack = CompressorRecipes.instance().getCompressingResult(this.compressorItemStacks[0]);
            if (itemstack == null) return false;
            if (this.compressorItemStacks[2] == null) return true;
            if (!this.compressorItemStacks[2].isItemEqual(itemstack)) return false;
            int result = compressorItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.compressorItemStacks[2].getMaxStackSize();
        }
    }

    public void compressItem() {
        if (this.canCompressing()) {
            ItemStack itemstack = CompressorRecipes.instance().getCompressingResult(this.compressorItemStacks[0]);

            if (this.compressorItemStacks[2] == null) {
                this.compressorItemStacks[2] = itemstack.copy();
            } else if (this.compressorItemStacks[2].getItem() == itemstack.getItem()) {
                this.compressorItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.compressorItemStacks[0].stackSize;

            if (this.compressorItemStacks[0].stackSize <= 0) {
                this.compressorItemStacks[0] = null;
            }
        }
    }

    public static int getItemRunTime(ItemStack stack){
        if (stack == null) {
            return 0;
        } else {
            return new MachineFuel().getEnergyOutput(stack);
        }
    }

    public static boolean isItemFuel(ItemStack stack)
    {
        return getItemRunTime(stack) > 0;
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void openInventory(EntityPlayer player) {}

    public void closeInventory(EntityPlayer player) {}

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else if (index != 1) {
            return true;
        } else {
            ItemStack itemstack = this.compressorItemStacks[1];
            return isItemFuel(stack) || SlotCompressorFuel.isBucket(stack) && (itemstack == null || itemstack.getItem() != Items.BUCKET);
        }
    }

    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }

    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        if (direction == EnumFacing.DOWN && index == 1) {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
                return false;
            }
        }
        return true;
    }

    public String getGuiID() {
        return "just_dust:compressor";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerCompressor(playerInventory, this);
    }

    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.compressorRunTime;
            case 1:
                return this.currentItemRunTime;
            case 2:
                return this.compressingTime;
            case 3:
                return this.totalRunTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.compressorRunTime = value;
                break;
            case 1:
                this.currentItemRunTime = value;
                break;
            case 2:
                this.compressingTime = value;
                break;
            case 3:
                this.totalRunTime = value;
        }
    }

    public int getFieldCount() {
        return 4;
    }

    public void clear() {
        for (int i = 0; i < this.compressorItemStacks.length; ++i) {
            this.compressorItemStacks[i] = null;
        }
    }

    net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
    net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing) {
        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            if (facing == EnumFacing.DOWN)
                return (T) handlerBottom;
            else if (facing == EnumFacing.UP)
                return (T) handlerTop;
            else
                return (T) handlerSide;
        return super.getCapability(capability, facing);
    }
}
