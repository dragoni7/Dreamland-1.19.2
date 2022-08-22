package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.configs.HillConfig;
import com.github.dragoni7.dreamland.common.world.feature.util.FastNoiseLite;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class Hill extends Feature<HillConfig> {

	public Hill(Codec<HillConfig> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<HillConfig> context) {
		WorldGenLevel worldgenlevel = context.level();
		RandomSource rand = context.random();
		FastNoiseLite hillNoise = createNoise(worldgenlevel.getSeed(), context.config().noiseFrequency().sample(rand));
		FeatureBuilder builder = new FeatureBuilder();
		BlockPos origin = context.origin();
		Boolean status = false;
		Boolean hasLake = RollBoolean.roll(context.config().lakeFrequency().sample(rand), rand);
		int xRadius = context.config().xRadius().sample(rand);
		int yHeight = context.config().yHeight().sample(rand);
		int zRadius = context.config().zRadius().sample(rand);
		
		for (int x = -xRadius; x < xRadius; x++) {
			for (int y = 0; y < yHeight; y++) {
				for (int z = -zRadius; z < zRadius; z++) {
					double distance = Mth.square((double)x/(xRadius-3)) + Mth.square((double)y/(yHeight)) + Mth.square((double)z/(zRadius-3));
					float noise = hillNoise.GetNoise(x, y, z);
					BlockPos pos = origin.offset(x, y, z);
					
					if (hasLake && y == yHeight-1 && distance < 1.7 + noise) {
						status = builder.addInput(worldgenlevel, context.config().liquidBlock().getState(rand, origin), pos, true);
						if (RollBoolean.roll(5, rand)) {
							status = builder.addInput(worldgenlevel, context.config().liquidBlock().getState(rand, origin), pos.below(), true);
						}
					} else if (distance < 2 + noise) {
						status = builder.addInput(worldgenlevel, context.config().block().getState(rand, origin), pos, true);
					}
				}
			}
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
