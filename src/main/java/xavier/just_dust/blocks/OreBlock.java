package xavier.just_dust.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xavier.just_dust.JustDust;

public class OreBlock extends BaseBlocks{
    public OreBlock(String name) {
        super(Material.ROCK, name);
        setHardness(3f);
        setResistance(5f);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }



    @Override
    public void registerItemModel(Item itemBlock) {
        JustDust.proxy.registerItemRenderer(itemBlock, 0, name);
    }
}
