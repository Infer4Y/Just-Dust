package xavier.just_dust.api.recipes;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xavier.just_dust.JustDust;

public class MachineRecipeManager extends IForgeRegistryEntry.Impl<MachineRecipeManager>{
    public MachineRecipeManager(String name) {
        this.setRegistryName(new ResourceLocation(JustDust.MODID, name));
    }
}
