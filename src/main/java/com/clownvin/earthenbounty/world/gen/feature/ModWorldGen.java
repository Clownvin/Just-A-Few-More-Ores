package com.clownvin.earthenbounty.world.gen.feature;

import com.clownvin.earthenbounty.blocks.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {
    private WorldGenerator genBlackDiamond;
    private WorldGenerator genSalt;
    private WorldGenerator genMithril;
    private WorldGenerator genTin;
    private WorldGenerator genCopper;
    private WorldGenerator genPlatinum;
    private WorldGenerator genSulfur;

    public ModWorldGen() {
        genBlackDiamond = new WorldGenMinable(ModBlocks.black_diamond_ore_block.getDefaultState(), 3);
        genSalt = new WorldGenMinable(ModBlocks.salt_ore_block.getDefaultState(), 16);
        genMithril = new WorldGenMinable(ModBlocks.mithril_ore_block.getDefaultState(), 10);
        genTin = new WorldGenMinable(ModBlocks.tin_ore_block.getDefaultState(), 8);
        genCopper = new WorldGenMinable(ModBlocks.copper_ore_block.getDefaultState(), 8);
        genPlatinum = new WorldGenMinable(ModBlocks.platinum_ore_block.getDefaultState(), 2);
        genSulfur = new WorldGenMinable(ModBlocks.sulfur_ore_block.getDefaultState(), 12, BlockMatcher.forBlock(Blocks.NETHERRACK));
    }

    private void runGenerator(WorldGenerator generator, World world, Random random, int chunk_x, int chunk_z, float veinChance, int veinChances, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight || maxHeight < minHeight)
            throw new IllegalArgumentException("Illegal height arguments");
        int heightDiff = (maxHeight - minHeight + 1);
        for (int i = 0; i < veinChances; i++) {
            if (random.nextFloat() > veinChance)
                continue;
            int x = (chunk_x * 16) + random.nextInt(16);
            int z = (chunk_z * 16) + random.nextInt(16);
            int y = minHeight + random.nextInt(heightDiff);
            BlockPos pos = new BlockPos(x, y, z);
            generator.generate(world, random, pos);
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            // System.out.println("GENERATING");
            case -1: //Nether ores
                runGenerator(genSulfur, world, random, chunkX, chunkZ, .56f, 76, 0, 255);
                break;
            case 0: // Overworld ores
                runGenerator(genBlackDiamond, world, random, chunkX, chunkZ, .5f, 1, 1, 20);
                runGenerator(genSalt, world, random, chunkX, chunkZ, .85f, 5, 50, 150);
                runGenerator(genMithril, world, random, chunkX, chunkZ, .75f, 4, 0, 40);
                runGenerator(genTin, world, random, chunkX, chunkZ, 1f, 16, 60, 255);
                runGenerator(genCopper, world, random, chunkX, chunkZ, 1f, 16, 60, 255);
                runGenerator(genPlatinum, world, random, chunkX, chunkZ, .15f, 2, 0, 64);
                break;
        }
    }
}
