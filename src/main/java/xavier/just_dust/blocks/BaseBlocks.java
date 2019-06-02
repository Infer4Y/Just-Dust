package xavier.just_dust.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xavier.just_dust.JustDust;
import xavier.just_dust.items.ItemModelProvider;

public class BaseBlocks extends Block implements ItemModelProvider {
    protected String name;

    public BaseBlocks(Material material, String name) {
        super(material);

        this.name = name;
        setHardness(3f);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public void registerItemModel(Item itemBlock) {
        JustDust.proxy.registerItemRenderer(itemBlock, 0, name);
    }
}
