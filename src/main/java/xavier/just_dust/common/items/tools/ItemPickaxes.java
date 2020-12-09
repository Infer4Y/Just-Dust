package xavier.just_dust.common.items.tools;


import net.minecraft.creativetab.CreativeTabs;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.items.ItemModelProvider;

public class ItemPickaxes extends net.minecraft.item.ItemPickaxe implements ItemModelProvider {

    private String name;

    public ItemPickaxes(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(CreativeTabs.TOOLS);
    }


    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, name);
    }
}
