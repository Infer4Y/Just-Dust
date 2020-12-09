package xavier.just_dust.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.creative_tabs.DustTabs;

public class BaseBlocks extends Block {
    protected String name;

    public BaseBlocks(Material material, String name) {
        super(material);

        this.name = name;
        setHardness(3f);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DustTabs.BLOCKS_CREATIVE_TAB);
    }

    public void registerItemModel(Item itemBlock) {
        JustDust.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
