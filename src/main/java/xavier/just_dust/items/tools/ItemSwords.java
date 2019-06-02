package xavier.just_dust.items.tools;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xavier.just_dust.JustDust;
import xavier.just_dust.items.ItemModelProvider;

import net.minecraft.item.Item.ToolMaterial;

public class ItemSwords extends net.minecraft.item.ItemSword implements ItemModelProvider {

    private String name;

    public ItemSwords(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(CreativeTabs.COMBAT);
    }

    public void registerItemModel(Item item) {
        JustDust.proxy.registerItemRenderer(this, 0, name);
    }

}
