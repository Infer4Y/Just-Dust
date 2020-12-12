package xavier.just_dust.common.items.energy;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import xavier.just_dust.JustDust;
import xavier.just_dust.api.energy.CapabilityProviderEnergy;
import xavier.just_dust.common.items.BaseItem;

import javax.annotation.Nullable;
import java.util.List;

public class EnergyCellItem extends BaseEnergyItem {
    public EnergyCellItem(String name, CreativeTabs tab, int capacity) {
        super(name, tab, capacity);
        maxStackSize = 1;
    }

    public EnergyCellItem(String name, CreativeTabs tab, int capacity, int maxTransfer) {
        super(name, tab, capacity, maxTransfer);
        maxStackSize = 1;
    }

    public EnergyCellItem(String name, CreativeTabs tab, int capacity, int maxReceive, int maxExtract) {
        super(name, tab, capacity, maxReceive, maxExtract);
        maxStackSize = 1;
    }

    public EnergyCellItem(String name, CreativeTabs tab, int capacity, int maxReceive, int maxExtract, int energy) {
        super(name, tab, capacity, maxReceive, maxExtract, energy);
        maxStackSize = 1;
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "cells/"+name);
    }
}
