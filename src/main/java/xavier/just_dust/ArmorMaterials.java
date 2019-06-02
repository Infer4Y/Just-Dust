package xavier.just_dust;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import static xavier.just_dust.JustDust.MODID;


public class ArmorMaterials {
    public static final Item.ToolMaterial starToolMaterial = EnumHelper.addToolMaterial("Dust", 6, 5000, 10, 10, 14);
    public static final ItemArmor.ArmorMaterial cobbleArmorMaterial = EnumHelper.addArmorMaterial("COBBLE", MODID + ":cobble", 1250, new int[]{1, 3, 4, 2}, 15, SoundEvents.BLOCK_STONE_PLACE, 0);
}
