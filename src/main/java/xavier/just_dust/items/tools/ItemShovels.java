package xavier.just_dust.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import xavier.just_dust.JustDust;
import xavier.just_dust.items.ItemModelProvider;


import net.minecraft.item.Item.ToolMaterial;

public class ItemShovels extends ItemSpade implements ItemModelProvider {

    private String name;

    public ItemShovels(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(CreativeTabs.TOOLS);
    }

    public void registerItemModel(Item item) {
        JustDust.proxy.registerItemRenderer(this, 0, name);
    }

}