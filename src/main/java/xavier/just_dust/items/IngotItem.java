package xavier.just_dust.items;

import net.minecraft.creativetab.CreativeTabs;
import xavier.just_dust.JustDust;

public class IngotItem extends BaseItems{
    public IngotItem(String name, CreativeTabs tab) {
        super(name, tab);
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "ingots/"+name);
    }
}
