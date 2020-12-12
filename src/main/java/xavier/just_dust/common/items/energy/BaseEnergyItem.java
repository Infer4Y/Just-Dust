package xavier.just_dust.common.items.energy;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import xavier.just_dust.api.energy.CapabilityProviderEnergy;
import xavier.just_dust.api.energy.EnergyStorageItem;
import xavier.just_dust.common.items.BaseItem;

import javax.annotation.Nullable;
import java.util.List;

public class BaseEnergyItem extends BaseItem {
    int capacity, maxReceive, maxExtract, energy;

    public BaseEnergyItem(String name, CreativeTabs tab, int capacity) {
        this(name, tab, capacity, capacity, capacity, 0);
    }

    public BaseEnergyItem(String name, CreativeTabs tab, int capacity, int maxTransfer) {
        this(name, tab, capacity, maxTransfer, maxTransfer, 0);
    }

    public BaseEnergyItem(String name, CreativeTabs tab, int capacity, int maxReceive, int maxExtract) {
        this(name, tab, capacity, maxReceive, maxExtract, 0);
    }

    public BaseEnergyItem(String name, CreativeTabs tab, int capacity, int maxReceive, int maxExtract, int energy) {
        super(name, tab);
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.energy = energy;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(getEnergyStorage(stack).getEnergyStored()+"/"+this.getEnergyStorage(stack).getMaxEnergyStored());
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new CapabilityProviderEnergy(new EnergyStorageItem(stack, this.capacity));
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        IEnergyStorage energy = getEnergyStorage(stack);
        double stored = energy.getMaxEnergyStored() - energy.getEnergyStored();
        return (double) stored / energy.getMaxEnergyStored();
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    public IEnergyStorage getEnergyStorage(ItemStack stack) {
        if (stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
            return stack.getCapability(CapabilityEnergy.ENERGY, null);
        }

        return null;
    }
}
