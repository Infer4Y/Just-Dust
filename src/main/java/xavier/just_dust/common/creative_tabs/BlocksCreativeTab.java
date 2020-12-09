package xavier.just_dust.common.creative_tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.blocks.ModBlocks;

public class BlocksCreativeTab extends CreativeTabs {

    public BlocksCreativeTab() {
        super("blocks_"+ JustDust.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.death_dust_block);
    }
}
