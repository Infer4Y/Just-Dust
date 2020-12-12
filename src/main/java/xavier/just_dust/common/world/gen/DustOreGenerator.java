package xavier.just_dust.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import xavier.just_dust.common.blocks.ModBlocks;

import java.util.Random;

public class DustOreGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()){
            case 0:
                generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
                break;
            case 1:
                generateHell(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
                break;
            case -1:
                generateEnd(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
                break;
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(ModBlocks.fire_dust_ore.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 32, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.earth_dust_ore.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.water_dust_ore.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 33, 64, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.death_dust_ore.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 5, 17, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.life_dust_ore.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 18, 64, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.matter_dust_ore.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6);
    }

    private void generateHell(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

    }

    private void generateEnd(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

    }

    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }

    private void generateHellOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator =new WorldGenMinable(ore, 14, BlockMatcher.forBlock(Blocks.NETHERRACK));
            generator.generate(world, random, pos);
        }
    }
}
