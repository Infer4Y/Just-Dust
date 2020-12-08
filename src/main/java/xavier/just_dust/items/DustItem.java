package xavier.just_dust.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xavier.just_dust.JustDust;

public class DustItem extends BaseItems{
    public DustItem(String name, CreativeTabs tab) {
        super(name, tab);
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "dusts/"+name);
    }
}
