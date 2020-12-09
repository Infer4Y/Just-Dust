package xavier.just_dust.common.items;

import net.minecraft.creativetab.CreativeTabs;
import xavier.just_dust.JustDust;

public class PartItem extends BaseItem {
    public PartItem(String name, CreativeTabs tab) {
        super(name, tab);
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "parts/"+name);
    }
}
