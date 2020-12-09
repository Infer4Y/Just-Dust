package xavier.just_dust.common.creative_tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.items.ModItems;

public class MaterialsCreativeTab extends CreativeTabs {

    public MaterialsCreativeTab() {
        super("parts_"+ JustDust.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.obsidian_dust);
    }
}
