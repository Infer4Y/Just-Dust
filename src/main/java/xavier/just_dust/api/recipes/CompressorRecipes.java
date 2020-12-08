package xavier.just_dust.api.recipes;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xavier.just_dust.items.ModItems;

import java.util.Map;

public class CompressorRecipes extends MachineRecipeManager {
    private static final CompressorRecipes COMPRESSING_BASE = new CompressorRecipes();
    private final Map<ItemStack, ItemStack> compressing_list = Maps.newHashMap();
    private final Map<ItemStack, Float> experience_list = Maps.newHashMap();

    public static CompressorRecipes instance()
    {
        return COMPRESSING_BASE;
    }

    private CompressorRecipes() {
        super("compressor_crafting");
        this.addCompressing(ModItems.death_dust, new ItemStack(ModItems.death_dust_compressed), 0.1F);
        this.addCompressing(ModItems.earth_dust, new ItemStack(ModItems.earth_dust_compressed), 0.1F);
        this.addCompressing(ModItems.energy_dust, new ItemStack(ModItems.energy_dust_compressed), 0.1F);
        this.addCompressing(ModItems.fire_dust, new ItemStack(ModItems.fire_dust_compressed), 0.1F);
        this.addCompressing(ModItems.life_dust, new ItemStack(ModItems.life_dust_compressed), 0.1F);
        this.addCompressing(ModItems.matter_dust, new ItemStack(ModItems.matter_dust_compressed), 0.1F);
        this.addCompressing(ModItems.water_dust, new ItemStack(ModItems.water_dust_compressed), 0.1F);

        this.addCompressingRecipeForBlock(Blocks.SAND, new ItemStack(Blocks.SANDSTONE), 0.1F);

        this.addCompressing(ModItems.gold_dust, new ItemStack(Items.GOLD_INGOT), 0.1F);
        this.addCompressing(ModItems.iron_dust, new ItemStack(Items.IRON_INGOT), 0.1F);
        this.addCompressing(ModItems.obsidian_dust, new ItemStack(Blocks.OBSIDIAN), 0.1F);
        this.addCompressing(ModItems.diamond_dust, new ItemStack(Items.DIAMOND), 0.1F);
        this.addCompressing(ModItems.emerald_dust, new ItemStack(Items.EMERALD), 0.1F);
        this.addCompressing(ModItems.lapis_dust, new ItemStack(Items.DYE, 1,4), 0.1F);

        this.addCompressingRecipeForBlock(Blocks.COAL_BLOCK, new ItemStack(Items.DIAMOND), 1.0F);
    }

    public void addCompressingRecipeForBlock(Block input, ItemStack stack, float experience) {
        this.addCompressing(Item.getItemFromBlock(input), stack, experience);
    }

    public void addCompressing(Item input, ItemStack stack, float experience) {
        this.addCompressingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addCompressingRecipe(ItemStack input, ItemStack stack, float experience) {
        if (getCompressingResult(input) != null) {
            return;
        }
        this.compressing_list.put(input, stack);
        this.experience_list.put(stack, experience);
    }

    public ItemStack getCompressingResult(ItemStack stack) {
        for (Map.Entry<ItemStack, ItemStack> entry : this.compressing_list.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getCompressingList() {
        return this.compressing_list;
    }

    public float getCompressingExperience(ItemStack stack) {
        for (Map.Entry<ItemStack, Float> entry : this.experience_list.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return stack.getItem().getSmeltingExperience(stack);
    }
}
