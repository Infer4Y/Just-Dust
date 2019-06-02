package xavier.just_dust.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockOre extends BaseBlocks {
    protected List<ItemStack> drop;
    public BlockOre(String name, int toolHarvestLevel, Item drop) {
        super(Material.ROCK, name);
        setHardness(0.3f);
        setHarvestLevel("pickaxe", toolHarvestLevel);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.drop.add(new ItemStack(drop));
    }

    public BlockOre(String name, int toolHarvestLevel, Block drop) {
        super(Material.ROCK, name);
        setHardness(0.3f);
        setHarvestLevel("pickaxe", toolHarvestLevel);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.drop.add(new ItemStack(drop));
    }

    @Override
    public void dropXpOnBlockBreak(World worldIn, BlockPos pos, int amount) {
        super.dropXpOnBlockBreak(worldIn, pos, amount);
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        return drop;
    }
}
