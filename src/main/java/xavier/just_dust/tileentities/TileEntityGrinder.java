package xavier.just_dust.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.MachineFuel;
import xavier.just_dust.blocks.BlockGrinder;
import xavier.just_dust.containers.ContainerGrinder;
import xavier.just_dust.api.recipes.GrinderRecipes;
import xavier.just_dust.slots.SlotGrinderFuel;

import javax.annotation.Nullable;

public class TileEntityGrinder extends TileEntityLockable implements ITickable, ISidedInventory {
    private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2,1};
    private static final int[] SLOTS_SIDES = new int[] {1};
    private ItemStack[] grinderItemStacks = new ItemStack[3];
    private int grinderRunTime;
    public static int currentItemRunTime;
    private int grinderTime;
    private int totalGrindingTime;
    private String grinderCustomName;

    public int getSizeInventory() {
        return this.grinderItemStacks.length;
    }

    @Nullable
    public ItemStack getStackInSlot(int index) {
        return this.grinderItemStacks[index];
    }

    @Nullable
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.grinderItemStacks, index, count);
    }

    @Nullable
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.grinderItemStacks, index);
    }

    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        boolean flag = stack != null && stack.isItemEqual(this.grinderItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.grinderItemStacks[index]);
        this.grinderItemStacks[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }

        if (index == 0 && !flag) {
            this.totalGrindingTime = this.getGrindingTime(stack);
            this.grinderTime = 0;
            this.markDirty();
        }
    }

    public String getName() {
        return this.hasCustomName() ? this.grinderCustomName : "container.grinder";
    }

    public boolean hasCustomName() {
        return this.grinderCustomName != null && !this.grinderCustomName.isEmpty();
    }

    public void setCustomInventoryName(String name) {
        this.grinderCustomName = name;
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.grinderItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < this.grinderItemStacks.length) {
                this.grinderItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        this.grinderRunTime = compound.getInteger("RunTime");
        this.grinderTime = compound.getInteger("GrindingTime");
        this.totalGrindingTime = compound.getInteger("GrindingTimeTotal");
        this.currentItemRunTime = getItemRunTime(this.grinderItemStacks[1]);

        if (compound.hasKey("CustomName", 8)) {
            this.grinderCustomName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("RunTime", this.grinderRunTime);
        compound.setInteger("GrindingTime", this.grinderTime);
        compound.setInteger("GrinderTimeTotal", this.totalGrindingTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.grinderItemStacks.length; ++i) {
            if (this.grinderItemStacks[i] != null) {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.grinderItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.grinderCustomName);
        }

        return compound;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isRunning() {
        return this.grinderRunTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isRunning(IInventory inventory) {
        return inventory.getField(0) > 0;
    }

    public void update() {
        boolean flag = this.isRunning();
        boolean flag1 = false;

        if (!this.world.isRemote) {
            if (this.isRunning() || this.grinderItemStacks[1] != null && this.grinderItemStacks[0] != null) {
                if (!this.isRunning() && this.canCompressing()) {
                    this.currentItemRunTime = this.grinderRunTime = getItemRunTime(this.grinderItemStacks[1]);

                    if (this.isRunning()) {
                        flag1 = true;

                        if (this.grinderItemStacks[1] != null) {
                            --this.grinderItemStacks[1].stackSize;

                            if (this.grinderItemStacks[1].stackSize == 0) {
                                this.grinderItemStacks[1] = grinderItemStacks[1].getItem().getContainerItem(grinderItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isRunning() && this.canCompressing()) {
                    ++this.grinderTime;

                    if (this.grinderTime == this.totalGrindingTime) {
                        this.grinderTime = 0;
                        this.totalGrindingTime = this.getGrindingTime(this.grinderItemStacks[0]);
                        this.compressItem();
                        flag1 = true;
                    }

                    --this.grinderRunTime;
                } else {
                    this.grinderTime = 0;
                }
            } else if (!this.isRunning() && this.grinderTime > 0) {
                this.grinderTime = MathHelper.clamp(this.grinderTime - 2, 0, this.totalGrindingTime);
            }

            if (flag != this.isRunning()) {
                flag1 = true;
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public int getGrindingTime(@Nullable ItemStack stack) {
        return 200;
    }

    private boolean canCompressing() {
        if (this.grinderItemStacks[0] == null) {
            return false;
        } else {
            ItemStack itemstack = GrinderRecipes.instance().getGrindingResult(this.grinderItemStacks[0]);
            if (itemstack == null) return false;
            if (this.grinderItemStacks[2] == null) return true;
            if (!this.grinderItemStacks[2].isItemEqual(itemstack)) return false;
            int result = grinderItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.grinderItemStacks[2].getMaxStackSize();
        }
    }

    public void compressItem() {
        if (this.canCompressing()) {
            ItemStack itemstack = GrinderRecipes.instance().getGrindingResult(this.grinderItemStacks[0]);

            if (this.grinderItemStacks[2] == null) {
                this.grinderItemStacks[2] = itemstack.copy();
            } else if (this.grinderItemStacks[2].getItem() == itemstack.getItem()) {
                this.grinderItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.grinderItemStacks[0].stackSize;

            if (this.grinderItemStacks[0].stackSize <= 0) {
                this.grinderItemStacks[0] = null;
            }
        }
    }

    public static int getItemRunTime(ItemStack stack) {
        if (stack == null) {
            return 0;
        } else {
            return new MachineFuel().getEnergyOutput(stack);
        }
    }

    public static boolean isItemFuel(ItemStack stack) {
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
            ItemStack itemstack = this.grinderItemStacks[1];
            return isItemFuel(stack) || SlotGrinderFuel.isBucket(stack) && (itemstack == null || itemstack.getItem() != Items.BUCKET);
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
        return "just_dust:grinder";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerGrinder(playerInventory, this);
    }

    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.grinderRunTime;
            case 1:
                return this.currentItemRunTime;
            case 2:
                return this.grinderTime;
            case 3:
                return this.totalGrindingTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.grinderRunTime = value;
                break;
            case 1:
                this.currentItemRunTime = value;
                break;
            case 2:
                this.grinderTime = value;
                break;
            case 3:
                this.totalGrindingTime = value;
        }
    }

    public int getFieldCount() {
        return 4;
    }

    public void clear() {
        for (int i = 0; i < this.grinderItemStacks.length; ++i) {
            this.grinderItemStacks[i] = null;
        }
    }

    net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, EnumFacing.UP);
    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, EnumFacing.DOWN);
    net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, EnumFacing.WEST);

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, EnumFacing facing) {
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
