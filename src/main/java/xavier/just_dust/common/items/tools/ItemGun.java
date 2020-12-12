package xavier.just_dust.common.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.items.BaseItem;

public class ItemGun extends BaseItem {
    public ItemGun(String name, CreativeTabs tab) {
        super(name, tab);
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "tools/guns/"+name);
    }
}
