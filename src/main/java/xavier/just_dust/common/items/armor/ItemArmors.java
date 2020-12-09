package xavier.just_dust.common.items.armor;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.items.ItemModelProvider;

public class ItemArmors extends net.minecraft.item.ItemArmor implements ItemModelProvider {

    private String name;

    public ItemArmors(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
        super(material, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(CreativeTabs.COMBAT);
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, name);
    }
}
