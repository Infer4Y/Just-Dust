package xavier.just_dust.api.recipes;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xavier.just_dust.items.ModItems;

import javax.annotation.Nullable;
import java.util.Map;

public class GrinderRecipes {
    private static final GrinderRecipes COMPRESSING_BASE = new GrinderRecipes();
    private Map<ItemStack, ItemStack> grinding_list = Maps.<ItemStack, ItemStack>newHashMap();
    private Map<ItemStack, Float> experience_list = Maps.<ItemStack, Float>newHashMap();

    public static GrinderRecipes instance()
    {
        return COMPRESSING_BASE;
    }

    public GrinderRecipes() {
        this.addGrinding(ModItems.death_dust_compressed, new ItemStack(ModItems.death_dust), 0.1F);
        this.addGrinding(ModItems.earth_dust_compressed, new ItemStack(ModItems.earth_dust), 0.1F);
        this.addGrinding(ModItems.energy_dust_compressed, new ItemStack(ModItems.energy_dust), 0.1F);
        this.addGrinding(ModItems.fire_dust_compressed, new ItemStack(ModItems.fire_dust), 0.1F);
        this.addGrinding(ModItems.life_dust_compressed, new ItemStack(ModItems.life_dust), 0.1F);
        this.addGrinding(ModItems.matter_dust_compressed, new ItemStack(ModItems.matter_dust), 0.1F);
        this.addGrinding(ModItems.water_dust_compressed, new ItemStack(ModItems.water_dust), 0.1F);

        this.addGrinding(Items.GOLDEN_SWORD, new ItemStack(ModItems.gold_dust,2), 0.1F);
        this.addGrinding(Items.GOLDEN_HOE, new ItemStack(ModItems.gold_dust,2), 0.1F);
        this.addGrinding(Items.GOLDEN_SHOVEL, new ItemStack(ModItems.gold_dust,1), 0.1F);
        this.addGrinding(Items.GOLDEN_AXE, new ItemStack(ModItems.gold_dust,3), 0.1F);
        this.addGrinding(Items.GOLDEN_PICKAXE, new ItemStack(ModItems.gold_dust,3), 0.1F);
        this.addGrinding(Items.GOLDEN_BOOTS, new ItemStack(ModItems.gold_dust,4), 0.1F);
        this.addGrinding(Items.GOLDEN_LEGGINGS, new ItemStack(ModItems.gold_dust,7), 0.1F);
        this.addGrinding(Items.GOLDEN_CHESTPLATE, new ItemStack(ModItems.gold_dust,8), 0.1F);
        this.addGrinding(Items.GOLDEN_HELMET, new ItemStack(ModItems.gold_dust,5), 0.1F);
        this.addGrinding(new ItemStack(Items.GOLDEN_APPLE, 1, 0), new ItemStack(ModItems.gold_dust,8), 0.1F);
        this.addGrinding(new ItemStack(Items.GOLDEN_APPLE, 1, 1), new ItemStack(ModItems.gold_dust,72), 0.9F);
        this.addGrinding(Items.GOLD_INGOT, new ItemStack(ModItems.gold_dust), 0.1F);

        this.addGrinding(Items.EMERALD, new ItemStack(ModItems.emerald_dust), 0.1F);
        this.addGrinding(new ItemStack(Items.DYE, 1, 4), new ItemStack(ModItems.lapis_dust), 0.1F);

        this.addGrinding(Items.DIAMOND, new ItemStack(ModItems.diamond_dust), 0.1F);
        this.addGrinding(Items.DIAMOND_SWORD, new ItemStack(ModItems.diamond_dust,2), 0.1F);
        this.addGrinding(Items.DIAMOND_HOE, new ItemStack(ModItems.diamond_dust,2), 0.1F);
        this.addGrinding(Items.DIAMOND_SHOVEL, new ItemStack(ModItems.diamond_dust,1), 0.1F);
        this.addGrinding(Items.DIAMOND_AXE, new ItemStack(ModItems.diamond_dust,3), 0.1F);
        this.addGrinding(Items.DIAMOND_PICKAXE, new ItemStack(ModItems.diamond_dust,3), 0.1F);
        this.addGrinding(Items.DIAMOND_BOOTS, new ItemStack(ModItems.diamond_dust,4), 0.1F);
        this.addGrinding(Items.DIAMOND_LEGGINGS, new ItemStack(ModItems.diamond_dust,7), 0.1F);
        this.addGrinding(Items.DIAMOND_CHESTPLATE, new ItemStack(ModItems.diamond_dust,8), 0.1F);
        this.addGrinding(Items.DIAMOND_HELMET, new ItemStack(ModItems.diamond_dust,5), 0.1F);

        this.addGrinding(Items.IRON_INGOT, new ItemStack(ModItems.iron_dust), 0.1F);
        this.addGrinding(Items.IRON_SWORD, new ItemStack(ModItems.iron_dust,2), 0.1F);
        this.addGrinding(Items.IRON_HOE, new ItemStack(ModItems.iron_dust,2), 0.1F);
        this.addGrinding(Items.IRON_SHOVEL, new ItemStack(ModItems.iron_dust,1), 0.1F);
        this.addGrinding(Items.IRON_AXE, new ItemStack(ModItems.iron_dust,3), 0.1F);
        this.addGrinding(Items.IRON_PICKAXE, new ItemStack(ModItems.iron_dust,3), 0.1F);
        this.addGrinding(Items.IRON_BOOTS, new ItemStack(ModItems.iron_dust,4), 0.1F);
        this.addGrinding(Items.IRON_LEGGINGS, new ItemStack(ModItems.iron_dust,7), 0.1F);
        this.addGrinding(Items.IRON_CHESTPLATE, new ItemStack(ModItems.iron_dust,8), 0.1F);
        this.addGrinding(Items.IRON_HELMET, new ItemStack(ModItems.iron_dust,5), 0.1F);

        this.addGrindingRecipeForBlock(Blocks.OBSIDIAN, new ItemStack(ModItems.obsidian_dust, 1), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.LAPIS_ORE, new ItemStack(ModItems.lapis_dust, 16), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.GOLD_ORE, new ItemStack(ModItems.gold_dust, 3), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.DIAMOND_ORE, new ItemStack(ModItems.diamond_dust,3), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.EMERALD_ORE, new ItemStack(ModItems.emerald_dust, 3), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.IRON_ORE, new ItemStack(ModItems.iron_dust, 3), 0.1F);

        this.addGrindingRecipeForBlock(Blocks.LAPIS_BLOCK, new ItemStack(ModItems.lapis_dust, 9), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.GOLD_BLOCK, new ItemStack(ModItems.gold_dust, 9), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.DIAMOND_BLOCK, new ItemStack(ModItems.diamond_dust,9), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.EMERALD_BLOCK, new ItemStack(ModItems.emerald_dust, 9), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.IRON_BLOCK, new ItemStack(ModItems.iron_dust, 9), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.IRON_BARS, new ItemStack(ModItems.iron_dust, 6), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.IRON_TRAPDOOR, new ItemStack(ModItems.iron_dust, 4), 0.1F);
        this.addGrindingRecipeForBlock(Blocks.IRON_DOOR, new ItemStack(ModItems.iron_dust, 6), 0.1F);

        this.addGrinding(Items.BONE, new ItemStack(Items.DYE,9,15),0.1f);

        this.addGrinding(Items.BEETROOT, new ItemStack(Items.DYE,9,1),0.1f);

        this.addGrinding(new ItemStack(Blocks.YELLOW_FLOWER,1,0), new ItemStack(Items.DYE,3,11), 0.1f);

        this.addGrinding(new ItemStack(Blocks.DOUBLE_PLANT,1,0), new ItemStack(Items.DYE,3,11), 0.1f);
        this.addGrinding(new ItemStack(Blocks.DOUBLE_PLANT,1,1), new ItemStack(Items.DYE,3,13), 0.1f);
        this.addGrinding(new ItemStack(Blocks.DOUBLE_PLANT,1,4), new ItemStack(Items.DYE,3,1), 0.1f);
        this.addGrinding(new ItemStack(Blocks.DOUBLE_PLANT,1,5), new ItemStack(Items.DYE,3,9), 0.1f);

        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,0), new ItemStack(Items.DYE,3,1), 0.1f);
        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,1), new ItemStack(Items.DYE,3,12), 0.1f);
        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,2), new ItemStack(Items.DYE,3, 13), 0.1f);
        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,3), new ItemStack(Items.DYE,3,7), 0.1f);
        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,4), new ItemStack(Items.DYE,3,1), 0.1f);
        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,5), new ItemStack(Items.DYE,3,14), 0.1f);
        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,6), new ItemStack(Items.DYE,3,7), 0.1f);
        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,7), new ItemStack(Items.DYE,3,9), 0.1f);
        this.addGrinding(new ItemStack(Blocks.RED_FLOWER,1,8), new ItemStack(Items.DYE,3,7), 0.1f);
    }

    public void addGrindingRecipeForBlock(Block input, ItemStack stack, float experience) {
        this.addGrinding(Item.getItemFromBlock(input), stack, experience);
    }

    public void addGrinding(Item input, ItemStack stack, float experience) {
        this.addGrindingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addGrinding(ItemStack input, ItemStack stack, float experience) {
        this.addGrindingRecipe(input, stack, experience);
    }

    public void addGrindingRecipe(ItemStack input, ItemStack stack, float experience) {
        if (getGrindingResult(input) != null) {
            net.minecraftforge.fml.common.FMLLog.info("Ignored compressing recipe with conflicting input: " + input + " = " + stack);
            return;
        }
        this.grinding_list.put(input, stack);
        this.experience_list.put(stack, Float.valueOf(experience));
    }

    @Nullable
    public ItemStack getGrindingResult(ItemStack stack) {
        for (Map.Entry<ItemStack, ItemStack> entry : this.grinding_list.entrySet()) {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
                return (ItemStack)entry.getValue();
            }
        }

        return null;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getGrinding_list() {
        return this.grinding_list;
    }

    public float getGrindingExperience(ItemStack stack) {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1)
            return ret;

        for (Map.Entry<ItemStack, Float> entry : this.experience_list.entrySet()) {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
                return ((Float)entry.getValue()).floatValue();
            }
        }

        return 0.0F;
    }
}
