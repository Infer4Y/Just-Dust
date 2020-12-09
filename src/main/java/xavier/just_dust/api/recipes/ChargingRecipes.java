package xavier.just_dust.api.recipes;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class ChargingRecipes extends MachineRecipeManager {

    private static final ChargingRecipes COMPRESSING_BASE = new ChargingRecipes();
    private final Map<ItemStack, ItemStack> compressing_list = Maps.newHashMap();
    private final Map<ItemStack, Float> experience_list = Maps.newHashMap();
    private final Map<ItemStack, Integer> time_list = Maps.newHashMap();

    private ChargingRecipes() {
        super("charging_energizer");


    }

    public static ChargingRecipes instance() {
        return COMPRESSING_BASE;
    }

    public void addChargingRecipe(Block input, ItemStack stack, float experience) {
        this.addChargingRecipe(Item.getItemFromBlock(input), stack, experience);
    }

    public void addChargingRecipe(Item input, ItemStack stack, float experience) {
        this.addChargingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addChargingRecipe(ItemStack input, ItemStack stack, float experience) {
        if (getChargingResult(input) != ItemStack.EMPTY) {
            return;
        }
        this.compressing_list.put(input, stack);
        this.experience_list.put(stack, experience);
    }

    public ItemStack getChargingResult(ItemStack stack) {
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

    public float getChargingExperience(ItemStack stack) {
        for (Map.Entry<ItemStack, Float> entry : this.experience_list.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return stack.getItem().getSmeltingExperience(stack);
    }

    public int getChargingTime(ItemStack stack) {
        for (Map.Entry<ItemStack, Integer> entry : this.time_list.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return 200;
    }
}
