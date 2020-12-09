package xavier.just_dust.common.creative_tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.blocks.ModBlocks;

public class MachineCreativeTab extends CreativeTabs {

    public MachineCreativeTab() {
        super("machine_"+ JustDust.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.compressor_tier_one);
    }
}
