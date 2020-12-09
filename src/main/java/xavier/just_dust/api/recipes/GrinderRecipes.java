package xavier.just_dust.api.recipes;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xavier.just_dust.common.items.ModItems;

import java.util.Map;

public class GrinderRecipes extends MachineRecipeManager {
    private static final GrinderRecipes COMPRESSING_BASE = new GrinderRecipes();
    private final Map<ItemStack, ItemStack> GRINDING_LIST = Maps.newHashMap();
    private final Map<ItemStack, Float> experience_list = Maps.newHashMap();
    private final Map<ItemStack, Integer> time_list = Maps.newHashMap();

    public static GrinderRecipes instance()
    {
        return COMPRESSING_BASE;
    }

    public GrinderRecipes() {
        super("grinder_crafting");
        this.addGrindingRecipe(ModItems.death_dust_compressed, new ItemStack(ModItems.death_dust), 0.1F);
        this.addGrindingRecipe(ModItems.earth_dust_compressed, new ItemStack(ModItems.earth_dust), 0.1F);
        this.addGrindingRecipe(ModItems.energy_dust_compressed, new ItemStack(ModItems.energy_dust), 0.1F);
        this.addGrindingRecipe(ModItems.fire_dust_compressed, new ItemStack(ModItems.fire_dust), 0.1F);
        this.addGrindingRecipe(ModItems.life_dust_compressed, new ItemStack(ModItems.life_dust), 0.1F);
        this.addGrindingRecipe(ModItems.matter_dust_compressed, new ItemStack(ModItems.matter_dust), 0.1F);
        this.addGrindingRecipe(ModItems.water_dust_compressed, new ItemStack(ModItems.water_dust), 0.1F);

        this.addGrindingRecipe(Items.GOLDEN_SWORD, new ItemStack(ModItems.gold_dust,2), 0.1F);
        this.addGrindingRecipe(Items.GOLDEN_HOE, new ItemStack(ModItems.gold_dust,2), 0.1F);
        this.addGrindingRecipe(Items.GOLDEN_SHOVEL, new ItemStack(ModItems.gold_dust,1), 0.1F);
        this.addGrindingRecipe(Items.GOLDEN_AXE, new ItemStack(ModItems.gold_dust,3), 0.1F);
        this.addGrindingRecipe(Items.GOLDEN_PICKAXE, new ItemStack(ModItems.gold_dust,3), 0.1F);
        this.addGrindingRecipe(Items.GOLDEN_BOOTS, new ItemStack(ModItems.gold_dust,4), 0.1F);
        this.addGrindingRecipe(Items.GOLDEN_LEGGINGS, new ItemStack(ModItems.gold_dust,7), 0.1F);
        this.addGrindingRecipe(Items.GOLDEN_CHESTPLATE, new ItemStack(ModItems.gold_dust,8), 0.1F);
        this.addGrindingRecipe(Items.GOLDEN_HELMET, new ItemStack(ModItems.gold_dust,5), 0.1F);
        this.addGrindingRecipe(new ItemStack(Items.GOLDEN_APPLE, 1, 0), new ItemStack(ModItems.gold_dust,8), 0.1F);
        this.addGrindingRecipe(new ItemStack(Items.GOLDEN_APPLE, 1, 1), new ItemStack(ModItems.gold_dust,72), 0.9F);
        this.addGrindingRecipe(Items.GOLD_INGOT, new ItemStack(ModItems.gold_dust), 0.1F);

        this.addGrindingRecipe(Items.EMERALD, new ItemStack(ModItems.emerald_dust), 0.1F);
        this.addGrindingRecipe(new ItemStack(Items.DYE, 1, 4), new ItemStack(ModItems.lapis_dust), 0.1F);

        this.addGrindingRecipe(Items.DIAMOND, new ItemStack(ModItems.diamond_dust), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_SWORD, new ItemStack(ModItems.diamond_dust,2), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_HOE, new ItemStack(ModItems.diamond_dust,2), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_SHOVEL, new ItemStack(ModItems.diamond_dust,1), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_AXE, new ItemStack(ModItems.diamond_dust,3), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_PICKAXE, new ItemStack(ModItems.diamond_dust,3), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_BOOTS, new ItemStack(ModItems.diamond_dust,4), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_LEGGINGS, new ItemStack(ModItems.diamond_dust,7), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_CHESTPLATE, new ItemStack(ModItems.diamond_dust,8), 0.1F);
        this.addGrindingRecipe(Items.DIAMOND_HELMET, new ItemStack(ModItems.diamond_dust,5), 0.1F);

        this.addGrindingRecipe(Items.IRON_INGOT, new ItemStack(ModItems.iron_dust), 0.1F);
        this.addGrindingRecipe(Items.IRON_SWORD, new ItemStack(ModItems.iron_dust,2), 0.1F);
        this.addGrindingRecipe(Items.IRON_HOE, new ItemStack(ModItems.iron_dust,2), 0.1F);
        this.addGrindingRecipe(Items.IRON_SHOVEL, new ItemStack(ModItems.iron_dust,1), 0.1F);
        this.addGrindingRecipe(Items.IRON_AXE, new ItemStack(ModItems.iron_dust,3), 0.1F);
        this.addGrindingRecipe(Items.IRON_PICKAXE, new ItemStack(ModItems.iron_dust,3), 0.1F);
        this.addGrindingRecipe(Items.IRON_BOOTS, new ItemStack(ModItems.iron_dust,4), 0.1F);
        this.addGrindingRecipe(Items.IRON_LEGGINGS, new ItemStack(ModItems.iron_dust,7), 0.1F);
        this.addGrindingRecipe(Items.IRON_CHESTPLATE, new ItemStack(ModItems.iron_dust,8), 0.1F);
        this.addGrindingRecipe(Items.IRON_HELMET, new ItemStack(ModItems.iron_dust,5), 0.1F);

        this.addGrindingRecipe(Blocks.OBSIDIAN, new ItemStack(ModItems.obsidian_dust, 1), 0.1F);
        this.addGrindingRecipe(Blocks.LAPIS_ORE, new ItemStack(ModItems.lapis_dust, 16), 0.1F);
        this.addGrindingRecipe(Blocks.GOLD_ORE, new ItemStack(ModItems.gold_dust, 3), 0.1F);
        this.addGrindingRecipe(Blocks.DIAMOND_ORE, new ItemStack(ModItems.diamond_dust,3), 0.1F);
        this.addGrindingRecipe(Blocks.EMERALD_ORE, new ItemStack(ModItems.emerald_dust, 3), 0.1F);
        this.addGrindingRecipe(Blocks.IRON_ORE, new ItemStack(ModItems.iron_dust, 3), 0.1F);

        this.addGrindingRecipe(Blocks.LAPIS_BLOCK, new ItemStack(ModItems.lapis_dust, 9), 0.1F);
        this.addGrindingRecipe(Blocks.GOLD_BLOCK, new ItemStack(ModItems.gold_dust, 9), 0.1F);
        this.addGrindingRecipe(Blocks.DIAMOND_BLOCK, new ItemStack(ModItems.diamond_dust,9), 0.1F);
        this.addGrindingRecipe(Blocks.EMERALD_BLOCK, new ItemStack(ModItems.emerald_dust, 9), 0.1F);
        this.addGrindingRecipe(Blocks.IRON_BLOCK, new ItemStack(ModItems.iron_dust, 9), 0.1F);
        this.addGrindingRecipe(Blocks.IRON_BARS, new ItemStack(ModItems.iron_dust, 6), 0.1F);
        this.addGrindingRecipe(Blocks.IRON_TRAPDOOR, new ItemStack(ModItems.iron_dust, 4), 0.1F);
        this.addGrindingRecipe(Blocks.IRON_DOOR, new ItemStack(ModItems.iron_dust, 6), 0.1F);

        this.addGrindingRecipe(Items.BONE, new ItemStack(Items.DYE,9,15),0.1f);

        this.addGrindingRecipe(Items.BEETROOT, new ItemStack(Items.DYE,9,1),0.1f);

        this.addGrindingRecipe(new ItemStack(Blocks.YELLOW_FLOWER,1,0), new ItemStack(Items.DYE,3,11), 0.1f);

        this.addGrindingRecipe(new ItemStack(Blocks.DOUBLE_PLANT,1,0), new ItemStack(Items.DYE,3,11), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.DOUBLE_PLANT,1,1), new ItemStack(Items.DYE,3,13), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.DOUBLE_PLANT,1,4), new ItemStack(Items.DYE,3,1), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.DOUBLE_PLANT,1,5), new ItemStack(Items.DYE,3,9), 0.1f);

        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,0), new ItemStack(Items.DYE,3,1), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,1), new ItemStack(Items.DYE,3,12), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,2), new ItemStack(Items.DYE,3, 13), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,3), new ItemStack(Items.DYE,3,7), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,4), new ItemStack(Items.DYE,3,1), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,5), new ItemStack(Items.DYE,3,14), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,6), new ItemStack(Items.DYE,3,7), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,7), new ItemStack(Items.DYE,3,9), 0.1f);
        this.addGrindingRecipe(new ItemStack(Blocks.RED_FLOWER,1,8), new ItemStack(Items.DYE,3,7), 0.1f);
    }

    public void addGrindingRecipe( Block input,  ItemStack stack, float experience) {
        this.addGrindingRecipe(Item.getItemFromBlock(input), stack, experience);
    }

    public void addGrindingRecipe( Item input,  ItemStack stack, float experience) {
        this.addGrindingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addGrindingRecipe( ItemStack input,  ItemStack stack, float experience) {
        if (getGrindingResult(input) != ItemStack.EMPTY) {
            return;
        }
        this.GRINDING_LIST.put(input, stack);
        this.experience_list.put(stack, experience);
    }

    public ItemStack getGrindingResult( ItemStack stack) {
        for (Map.Entry<ItemStack, ItemStack> entry : this.GRINDING_LIST.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getGrindingList() {
        return this.GRINDING_LIST;
    }

    public float getGrindingExperience(ItemStack stack) {
        for (Map.Entry<ItemStack, Float> entry : this.experience_list.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return stack.getItem().getSmeltingExperience(stack);
    }

    public int getGrindingTime(ItemStack stack) {
        for (Map.Entry<ItemStack, Integer> entry : this.time_list.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return 200;
    }
}
