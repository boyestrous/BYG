package corgiaoc.byg.common.world.surfacebuilder.nether;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class WarpedDesertSB extends SurfaceBuilder<TernarySurfaceConfig> {
    public static final BlockState SAND = Blocks.SAND.getDefaultState();

    public WarpedDesertSB(Codec<TernarySurfaceConfig> config) {
        super(config);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;

        if (noise > 1.5) {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.set(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.down());

                if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck == Blocks.AIR.getDefaultState())
                    chunkIn.setBlockState(block, BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), false);
                for (Direction direction : Direction.Type.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.offset(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck2 == Blocks.AIR.getDefaultState())
                        chunkIn.setBlockState(block, BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.WARPEDDESERT);
        } else {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.set(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.down());

                if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck == Blocks.AIR.getDefaultState())
                    chunkIn.setBlockState(block, BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), false);
                for (Direction direction : Direction.Type.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.offset(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck2 == Blocks.AIR.getDefaultState())
                        chunkIn.setBlockState(block, BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.WARPEDDESERT_SOIL);
        }

    }
}