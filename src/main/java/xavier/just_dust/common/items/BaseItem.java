package xavier.just_dust.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xavier.just_dust.JustDust;

public class BaseItem extends Item implements ItemModelProvider{

    protected String name;

    public BaseItem(String name, CreativeTabs tab) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, name);
    }

}
