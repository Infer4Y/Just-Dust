package xavier.just_dust.items.tools;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xavier.just_dust.JustDust;
import xavier.just_dust.items.ItemModelProvider;

import net.minecraft.item.Item.ToolMaterial;

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
