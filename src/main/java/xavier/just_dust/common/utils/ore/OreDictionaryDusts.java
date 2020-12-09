package xavier.just_dust.common.utils.ore;

import com.google.common.collect.ImmutableMap;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import xavier.just_dust.common.items.ModItems;

import java.util.Map;

public class OreDictionaryDusts{
    private static Map<String, Item> ores = ImmutableMap.<String, Item>builder()
            .put("emeraldDust", ModItems.emerald_dust)
            .put("dustEmerald", ModItems.emerald_dust)
            .put("lapisDust", ModItems.lapis_dust)
            .put("dustLapis", ModItems.lapis_dust)
            .put("dyeBlue", ModItems.lapis_dust)
            .put("blueDye", ModItems.lapis_dust)
            .put("steelDust", ModItems.steel_dust)
            .put("dustSteel", ModItems.steel_dust)
            .put("ironDust", ModItems.iron_dust)
            .put("dustIron", ModItems.iron_dust)
            .put("goldDust", ModItems.gold_dust)
            .put("dustGold", ModItems.gold_dust)
            .put("diamondDust", ModItems.diamond_dust)
            .put("dustDiamond", ModItems.diamond_dust)
            .put("obsidianDust", ModItems.obsidian_dust)
            .put("dustObsidian", ModItems.obsidian_dust)
            .build();

    public static void init(){
        ores.forEach(((oreName, item) -> {
            OreDictionary.registerOre(oreName,item);
        }));
        OreDictionary.rebakeMap();
    }

}
