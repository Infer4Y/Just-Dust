package xavier.just_dust.common.items.tools;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.creative_tabs.DustTabs;
import xavier.just_dust.common.items.energy.BaseEnergyItem;
import xavier.just_dust.common.items.energy.EnergyCellItem;

import java.util.Set;

public class ItemSaw extends EnergyCellItem {
    protected SawMaterials materials;
    private final float attackDamage;

    public ItemSaw(String name, CreativeTabs tab, SawMaterials materials) {
        super(name, tab, materials.storageSize, materials.energyInputRate, materials.energyOutputRate, materials.startingEnergy);
        attackDamage = materials.damage;
        maxStackSize = 1;
        setCreativeTab(DustTabs.TOOLS_CREATIVE_TAB);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        if(this.getEnergyStorage(stack).getEnergyStored()==0f)
            return 0f;
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? 1 : this.materials.speed;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if(this.getEnergyStorage(stack).getEnergyStored()==0)
            return false;
        this.getEnergyStorage(stack).extractEnergy(materials.energyUsagePerTick*2, false);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        EnumActionResult result = super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
        if (result.equals(EnumActionResult.SUCCESS))
            this.getEnergyStorage(player.getHeldItem(hand)).extractEnergy(materials.energyUsagePerTick, false);
        return result;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }

        return multimap;
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "tools/saws/"+name);
    }

    public enum SawMaterials{
        TIER_ONE(100000, 120, 1000, 0, 0, 4f, 2f),
        TIER_TWO(120000, 100, 1200, 0, 0, 5.5f, 3.5f),
        TIER_THREE(240000, 50, 2400, 0, 0, 7f, 7f);

        int storageSize, energyUsagePerTick, energyInputRate, energyOutputRate, startingEnergy;
        float damage, speed;

        SawMaterials(int storageSize, int energyUsagePerTick, int energyInputRate, int energyOutputRate, int startingEnergy, float damage, float speed) {
            this.storageSize = storageSize;
            this.energyUsagePerTick = energyUsagePerTick;
            this.energyInputRate = energyInputRate;
            this.energyOutputRate = energyOutputRate;
            this.startingEnergy = startingEnergy;
            this.damage = damage;
            this.speed = speed;
        }
    }
}
