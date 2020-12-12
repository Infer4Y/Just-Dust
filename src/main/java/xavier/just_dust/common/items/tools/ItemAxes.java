package xavier.just_dust.common.items.tools;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.creative_tabs.DustTabs;
import xavier.just_dust.common.items.ItemModelProvider;

public class ItemAxes extends ItemAxe implements ItemModelProvider {

    protected String name;

    public ItemAxes(ToolMaterial material, String name) {
        super(material, 8f, -3.1f);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(DustTabs.TOOLS_CREATIVE_TAB);
    }

    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "tools/axes/"+name);
    }
}
