package com.github.dragoni7.dreamland.common.world.feature.generation;
import com.github.dragoni7.dreamland.common.world.feature.configs.ConeConfig;
import com.github.dragoni7.dreamland.common.world.feature.util.FastNoiseLite;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureMath;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class Cone extends Feature<ConeConfig> {

	public Cone(Codec<ConeConfig> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<ConeConfig> context) {
		WorldGenLevel worldgenlevel = context.level();
		RandomSource rand = context.random();
		FeatureBuilder builder = new FeatureBuilder();
		BlockPos origin = context.origin();
		Boolean status = false;
		FastNoiseLite noise = createNoise(worldgenlevel.getSeed(), context.config().noiseFrequency().sample(rand));
		int height = context.config().height().sample(rand);
		int baseRadius = context.config().radius().sample(rand);
		
		for (int y = 0; y < height; y++) {
			for (int x = -baseRadius; x < baseRadius; x++) {
				for (int z = -baseRadius; z < baseRadius; z++) {
					int currentHeight = height - y;
					double coneRadius = FeatureMath.coneRadius(FeatureMath.coneSlantHeight(baseRadius, currentHeight), currentHeight);
					BlockPos pos = origin.offset(x, y, z);
					double distance = origin.offset(0, y, 0).distToCenterSqr(pos.getX(), pos.getY(), pos.getZ());
					float f = noise.GetNoise(x, y, z);
					if (distance < (coneRadius - ((rand.nextIntBetweenInclusive(1, 2) + baseRadius / 2) - f))) {
						if (f > 0) {
							status = builder.addInput(worldgenlevel, context.config().block1().getState(rand, pos), pos, true);
						}
						else {
							status = builder.addInput(worldgenlevel, context.config().block2().getState(rand, pos), pos, true);
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
