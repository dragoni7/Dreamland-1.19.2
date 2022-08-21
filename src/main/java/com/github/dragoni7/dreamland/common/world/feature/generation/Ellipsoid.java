package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.configs.EllipsoidConfig;
import com.github.dragoni7.dreamland.common.world.feature.util.FastNoiseLite;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class Ellipsoid extends Feature<EllipsoidConfig> {

	private static final int ONE = 1;
	
	public Ellipsoid(Codec<EllipsoidConfig> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<EllipsoidConfig> context) {
		WorldGenLevel worldgenlevel = context.level();
		RandomSource rand = context.random();
		FastNoiseLite ellipsoidNoise = createNoise(worldgenlevel.getSeed());
		EllipsoidConfig config = context.config();
		boolean status = false;
		FeatureBuilder ellipsoidBuilder = new FeatureBuilder();
		BlockPos origin = context.origin();
		int xRadius = config.xRadius().sample(rand);
		int yRadius = config.yRadius().sample(rand);
		int zRadius = config.zRadius().sample(rand);
		
		for (int x = -xRadius; x < xRadius; x++) {
			for (int y = -yRadius; y < yRadius; y++) {
				for (int z = -zRadius; z < zRadius; z++) {
					
					BlockPos pos = origin.offset(x, y, z);
					double distance = Mth.square((double)x/xRadius) + Mth.square((double)y/yRadius) + Mth.square((double)z/zRadius);
					float noise = ellipsoidNoise.GetNoise(x, y, z);
					BlockState state;
					
					if (distance < ONE - 0.1 && noise < 0) {
						state = config.noiseBlock().getState(rand, origin);
					} 
					else if (distance < ONE + Mth.nextDouble(rand, 0.1, 0.3)) {
						state = config.block().getState(rand, origin);
					}
					else {
						continue;
					}
					
					if (!worldgenlevel.getBlockState(pos).is(BlockTags.FEATURES_CANNOT_REPLACE)) {
						status = ellipsoidBuilder.addInput(worldgenlevel, state, pos, true);
					}
				}
			}
		}
		
		ellipsoidBuilder.build(worldgenlevel);
		return status;
	}
	
	private static FastNoiseLite createNoise(long seed) {
		FastNoiseLite noise = new FastNoiseLite((int) seed);
		noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
		noise.SetFractalOctaves(6);
		noise.SetFrequency(0.001F);
		return noise;
	}
}
