package xavier.just_dust.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import xavier.just_dust.api.recipes.CompressorRecipes;
import xavier.just_dust.api.recipes.GrinderRecipes;

public class JustDustAPI {
    public static void addGrinding(Block input, ItemStack output, float xp) {
        GrinderRecipes.instance().addGrindingRecipeForBlock(input, output, xp);
    }

    public static void addGrinding(Item input, ItemStack output, float xp) {
        GrinderRecipes.instance().addGrinding(input, output, xp);
    }

    public static void addGrinding(ItemStack input, ItemStack output, float xp) {
        GrinderRecipes.instance().addGrindingRecipe(input, output, xp);
    }

    public static void addOreGrinding(String oreName, ItemStack output, float xp) {
        for (ItemStack stack : OreDictionary.getOres(oreName)) {
            GrinderRecipes.instance().addGrindingRecipe(stack, output, xp);
        }
    }

    public static void addOreGrinding(ItemStack input, String oreName, float xp) {
        for (ItemStack stack : OreDictionary.getOres(oreName)) {
            GrinderRecipes.instance().addGrindingRecipe(input, stack, xp);
        }
    }

    public static void addOreGrinding(String oreName, String oreName2, float xp) {
        for (ItemStack stack : OreDictionary.getOres(oreName)) {
            for (ItemStack stack2 : OreDictionary.getOres(oreName2)) {
                GrinderRecipes.instance().addGrindingRecipe(stack, stack2, xp);}
        }
    }

    public static void addCompressing(Block input, ItemStack output, float xp) {
        CompressorRecipes.instance().addCompressingRecipeForBlock(input, output, xp);
    }

    public static void addCompressing(Item input, ItemStack output, float xp) {
        CompressorRecipes.instance().addCompressing(input, output, xp);
    }

    public static void addCompressing(ItemStack input, ItemStack output, float xp) {
        CompressorRecipes.instance().addCompressingRecipe(input, output, xp);
    }

    public static void addOreCompressing(String oreName, ItemStack output, float xp) {
        for (ItemStack stack : OreDictionary.getOres(oreName)) {
            CompressorRecipes.instance().addCompressingRecipe(stack, output, xp);
        }
    }

    public static void addOreCompressing(ItemStack input, String oreName, float xp) {
        for (ItemStack stack : OreDictionary.getOres(oreName)) {
            CompressorRecipes.instance().addCompressingRecipe(input, stack, xp);
        }
    }

    public static void addOreCompressing(String oreName, String oreName2, float xp) {
        for (ItemStack stack : OreDictionary.getOres(oreName)) {
            for (ItemStack stack2 : OreDictionary.getOres(oreName2)) {
                CompressorRecipes.instance().addCompressingRecipe(stack, stack2, xp);}
        }
    }
}
