package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.configs.SphereConfig;
import com.github.dragoni7.dreamland.common.world.feature.util.FastNoiseLite;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureMath;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class Sphere extends Feature<SphereConfig> {

	public Sphere(Codec<SphereConfig> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<SphereConfig> context) {
		WorldGenLevel worldgenlevel = context.level();
		RandomSource rand = context.random();
		FeatureBuilder builder = new FeatureBuilder();
		BlockPos origin = context.origin();
		Boolean status = false;
		FastNoiseLite noise = createNoise(worldgenlevel.getSeed() + rand.nextLong(), context.config().noiseFrequency().sample(rand));
		int height = context.config().height().sample(rand);
		int radius = context.config().radius().sample(rand);
		
		for (int x = -radius; x < radius; x++) {
			for (int y = 0; y < height; y++) {
				for (int z = -radius; z < radius; z++) {
					BlockPos pos = origin.offset(x, y, z);
					double distance = FeatureMath.distance(x, y, z, radius, height, radius);
					float f = noise.GetNoise(x, y, z);
					if (distance < 1) {
						if (f < 0) {
							status = builder.addInput(worldgenlevel, context.config().block1().getState(rand, origin), pos, true);
						}
						else {
							if (!context.config().block2().getState(rand, origin).is(Blocks.AIR)) {
								status = builder.addInput(worldgenlevel, context.config().block2().getState(rand, origin), pos, true);
							}
						}
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
		noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
		noise.SetFrequency(frequency);
		return noise;
	}
}
