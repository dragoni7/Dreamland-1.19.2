package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.util.FastNoiseLite;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureMath;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class MoldWoodTree extends Feature<NoneFeatureConfiguration> {

	public MoldWoodTree(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		RandomSource rand = context.random();
		FastNoiseLite trunkNoise = createNoise(worldgenlevel.getSeed() + rand.nextLong(), 0.1F);
		FeatureBuilder builder = new FeatureBuilder();
		BlockPos origin = context.origin();
		BlockPos pos = origin;
		Boolean status = false;
		int radius = 6;
		int yHeight = rand.nextIntBetweenInclusive(26, 46);
		int foliageHeight = 6;
		int foliageRadius = 16;
		WeightedStateProvider trunkBlockProvider = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandWoodSets.MOLD_WOOD.wood().block().get().defaultBlockState(), 75).add(DreamlandBlocks.GLOWING_MOLD_WOOD.block().get().defaultBlockState(), 25));
		WeightedStateProvider foliageBlockProvider = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.BLACK_MOLD.block().get().defaultBlockState(), 50).add(DreamlandBlocks.WHITE_MOLD.block().get().defaultBlockState(), 50));
		BlockState foliageBlock = foliageBlockProvider.getState(rand, origin);
		BlockState trunkBlock = trunkBlockProvider.getState(rand, origin);
		
		for (int x = -radius; x < radius; x++) {
			for (int y = 0; y < yHeight; y++) {
				for (int z = -radius; z < radius; z++) {
					double distance = Mth.square((double)x/(radius-3)) + Mth.square((double)y/(yHeight)) + Mth.square((double)z/(radius-3));
					float noise = trunkNoise.GetNoise(x, y, z);
					pos = origin.offset(x, y, z);
					
					if (distance < 1.3 + noise) {
						status = builder.addInput(worldgenlevel, DreamlandWoodSets.MOLD_WOOD.strippedLog().block().get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y), pos, true);
					} else if (distance < 2 + noise) {
						trunkBlock = trunkBlockProvider.getState(rand, pos);
						status = builder.addInput(worldgenlevel, trunkBlock, pos, true);
					}
				}
			}
		}
		
		origin = pos.offset(-5, 0, -5);
		
		for (int x = -foliageRadius; x < foliageRadius; x++) {
			for (int y = 0; y < foliageHeight; y++) {
				for (int z = -foliageRadius; z < foliageRadius; z++) {
					pos = origin.offset(x, y, z);
					double distance = FeatureMath.distance(x, y, z, foliageRadius, foliageHeight, foliageRadius);
					if (distance > 0.8 && distance < 1 && y < 1) {
						int overhang = rand.nextIntBetweenInclusive(1, 9);
						for (int i = 0; i < overhang; i++) {
							status = builder.addInput(worldgenlevel, foliageBlock, pos.offset(0, -i, 0), true);
						}
					}
					else if (distance < 1) {
						status = builder.addInput(worldgenlevel, foliageBlock, pos, true);
					}
				}
			}
		}
		
		if (!status) {
			return false;
		}
		
		builder.build(worldgenlevel);
		return status;
	}
	
	private static FastNoiseLite createNoise(long seed, float frequency) {
		FastNoiseLite noise = new FastNoiseLite((int) seed);
		noise.SetNoiseType(FastNoiseLite.NoiseType.Cellular);
		noise.SetFrequency(frequency);
		return noise;
	}

}
