package xavier.just_dust.common.items.tools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xavier.just_dust.JustDust;
import xavier.just_dust.common.creative_tabs.DustTabs;

public class ItemSaw extends ItemAxes {
    public ItemSaw(ToolMaterial material, String name) {
        super(material, name);
        setNoRepair();
        setMaxDamage(100000);//Example in redstone usage. Not not RF
        setCreativeTab(DustTabs.TOOLS_CREATIVE_TAB);
    }


    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void registerItemModel() {
        JustDust.proxy.registerItemRenderer(this, 0, "tools/saws/"+name);
    }
}
