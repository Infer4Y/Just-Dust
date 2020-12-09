package xavier.just_dust.common.items.tools;


import net.minecraft.creativetab.CreativeTabs;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.creative_tabs.DustTabs;
import xavier.just_dust.common.items.ItemModelProvider;

public class ItemSwords extends net.minecraft.item.ItemSword implements ItemModelProvider {

    protected String name;

    public ItemSwords(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(DustTabs.TOOLS_CREATIVE_TAB);
    }

    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, name);
    }

}
