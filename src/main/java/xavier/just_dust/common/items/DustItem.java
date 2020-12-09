package xavier.just_dust.common.items;

import net.minecraft.creativetab.CreativeTabs;
import xavier.just_dust.JustDust;

public class DustItem extends BaseItem {
    public DustItem(String name, CreativeTabs tab) {
        super(name, tab);
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "dusts/"+name);
    }
}
