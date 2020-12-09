package xavier.just_dust.common.tile_entities;

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
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xavier.just_dust.api.energy.MachineFuel;
import xavier.just_dust.api.recipes.CompressorRecipes;
import xavier.just_dust.common.blocks.BlockCompressorTierOne;
import xavier.just_dust.common.containers.ContainerCompressor;
import xavier.just_dust.common.slots.SlotCompressorFuel;

public class TileEntityChargerTierOne extends TileEntityLockable implements ITickable, ISidedInventory {
    private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2,1};
    private static final int[] SLOTS_SIDES = new int[] {1};
    private NonNullList<ItemStack> compressorItemStacks = NonNullList.withSize(3, ItemStack.EMPTY);;
    private int compressorRunTime;
    private int currentItemRunTime;
    private int compressingTime;
    private int totalRunTime;
    private String compressorCustomName;

    @Override
    public void onLoad() {
        if (world.isRemote) {
        }
    }

    public int getSizeInventory() {
        return this.compressorItemStacks.size();
    }

    public boolean isEmpty() {
        for (ItemStack itemstack : this.compressorItemStacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ItemStack getStackInSlot(int index) {
        return this.compressorItemStacks.get(index);
    }

    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.compressorItemStacks, index, count);
    }

    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.compressorItemStacks, index);
    }

    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.compressorItemStacks.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.compressorItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag)
        {
            this.totalRunTime = this.getCookTime(stack);
            this.compressingTime = 0;
            this.markDirty();
        }
    }

    public String getName() {
        return this.hasCustomName() ? this.compressorCustomName : "container.compressor_tier_one";
    }

    public boolean hasCustomName() {
        return this.compressorCustomName != null && !this.compressorCustomName.isEmpty();
    }

    public void setCustomInventoryName(String name) {
        this.compressorCustomName = name;
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.compressorItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.compressorItemStacks);
        this.compressorRunTime = compound.getInteger("RunTime");
        this.compressingTime = compound.getInteger("CompressingTime");
        this.totalRunTime = compound.getInteger("CompressingTimeTotal");
        this.currentItemRunTime = getItemRunTime(this.compressorItemStacks.get(1));

        if (compound.hasKey("CustomName", 8))
        {
            this.compressorCustomName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("RunTime", (short)this.compressorRunTime);
        compound.setInteger("CompressingTime", (short)this.compressingTime);
        compound.setInteger("CompressingTimeTotal", (short)this.totalRunTime);
        ItemStackHelper.saveAllItems(compound, this.compressorItemStacks);

        if (this.hasCustomName())
        {
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
            if (this.isRunning() || !this.compressorItemStacks.get(0).isEmpty()) {
                if (!this.isRunning() && this.canCompressing()) {
                    this.currentItemRunTime = this.compressorRunTime = getItemRunTime((ItemStack) this.compressorItemStacks.get(1));

                    if (this.isRunning()) {
                        flag1 = true;

                        if (this.compressorItemStacks.get(1) != null) {
                            ((ItemStack) this.compressorItemStacks.get(1)).shrink(1);

                            if (((ItemStack) this.compressorItemStacks.get(1)).getCount() == 0) {
                                this.compressorItemStacks.set(1, ((ItemStack) compressorItemStacks.get(1)).getItem().getContainerItem((ItemStack) compressorItemStacks.get(1)));
                            }
                        }
                    }
                }

                if (this.isRunning() && this.canCompressing()) {
                    ++this.compressingTime;

                    if (this.compressingTime == this.totalRunTime) {
                        this.compressingTime = 0;
                        this.totalRunTime = this.getCookTime((ItemStack) this.compressorItemStacks.get(0));
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
                BlockCompressorTierOne.setState(this.isRunning(), this.world, this.pos);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public int getCookTime(ItemStack stack) {
        return Math.round(CompressorRecipes.instance().getCompressingTime(stack) * 1.5f);
    }

    private boolean canCompressing() {
        if (((ItemStack)this.compressorItemStacks.get(0)).isEmpty()) {
            return false;
        } else {
            ItemStack itemstack = CompressorRecipes.instance().getCompressingResult(this.compressorItemStacks.get(0));

            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = this.compressorItemStacks.get(2);

                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!itemstack1.isItemEqual(itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= this.getInventoryStackLimit() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize())  // Forge fix: make furnace respect stack sizes in furnace recipes
                {
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        }
    }

    public void compressItem() {
        if (this.canCompressing()) {
            ItemStack itemstack = this.compressorItemStacks.get(0);
            ItemStack itemstack1 = CompressorRecipes.instance().getCompressingResult(itemstack);
            ItemStack itemstack2 = this.compressorItemStacks.get(2);

            if (itemstack2.isEmpty()) {
                this.compressorItemStacks.set(2, itemstack1.copy());
            } else if (itemstack2.getItem() == itemstack1.getItem()) {
                itemstack2.grow(itemstack1.getCount());
            }

            itemstack.shrink(1);
        }
    }

    public static int getItemRunTime(ItemStack stack){
        return MachineFuel.getEnergyOutput(stack);
    }

    public static boolean isItemFuel(ItemStack stack)
    {
        return getItemRunTime(stack) > 0;
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void openInventory(EntityPlayer player) {}

    public void closeInventory(EntityPlayer player) {
        this.markDirty();
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else if (index != 1) {
            return true;
        } else {
            ItemStack itemstack = ((ItemStack)this.compressorItemStacks.get(1));
            return isItemFuel(stack) || SlotCompressorFuel.isBucket(stack) && (itemstack.isEmpty() || itemstack.getItem() != Items.BUCKET);
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
        return "just_dust:compressor_tier_one";
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
        for (int i = 0; i < this.compressorItemStacks.size(); ++i) {
            this.compressorItemStacks.set(i, ItemStack.EMPTY);
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
