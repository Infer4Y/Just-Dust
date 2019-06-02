package xavier.just_dust.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import xavier.just_dust.blocks.ModBlocks;
import xavier.just_dust.items.ModItems;


public class ModCrafting {
    public static void init() {
        //Normal Dust to Normal Dust Block
        GameRegistry.addRecipe(new ItemStack(ModBlocks.death_dust_block),"iii","iii","iii",'i', ModItems.death_dust);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.earth_dust_block),"iii","iii","iii",'i', ModItems.earth_dust);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.energy_dust_block),"iii","iii","iii",'i', ModItems.energy_dust);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.fire_dust_block),"iii","iii","iii",'i', ModItems.fire_dust);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.life_dust_block),"iii","iii","iii",'i', ModItems.life_dust);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.matter_dust_block),"iii","iii","iii",'i', ModItems.matter_dust);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.water_dust_block),"iii","iii","iii",'i', ModItems.water_dust);
        //Normal Dust Block to Normal Dust
        GameRegistry.addRecipe(new ItemStack(ModItems.death_dust),"iii","iii","iii",'i', ModBlocks.death_dust_block);
        GameRegistry.addRecipe(new ItemStack(ModItems.earth_dust),"iii","iii","iii",'i', ModBlocks.earth_dust_block);
        GameRegistry.addRecipe(new ItemStack(ModItems.energy_dust),"iii","iii","iii",'i', ModBlocks.energy_dust_block);
        GameRegistry.addRecipe(new ItemStack(ModItems.fire_dust),"iii","iii","iii",'i', ModBlocks.fire_dust_block);
        GameRegistry.addRecipe(new ItemStack(ModItems.life_dust),"iii","iii","iii",'i', ModBlocks.life_dust_block);
        GameRegistry.addRecipe(new ItemStack(ModItems.matter_dust),"iii","iii","iii",'i', ModBlocks.matter_dust_block);
        GameRegistry.addRecipe(new ItemStack(ModItems.water_dust),"iii","iii","iii",'i', ModBlocks.water_dust_block);
        //Crafting Ingredients
        GameRegistry.addRecipe(new ItemStack(ModItems.blade_wheel),"fif","ifi","fif",'f',Items.IRON_INGOT,'i',Items.FLINT);
        //Machines
        GameRegistry.addRecipe(new ItemStack(ModBlocks.block_compressor),"IRI","P P","IRI",'I',Items.IRON_INGOT,'P',Blocks.PISTON,'R',Items.REDSTONE);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.block_compressor),"IRI","RBR","IRI",'I',Items.IRON_INGOT,'R',Items.REDSTONE,'B',ModItems.blade_wheel);
    }
}
