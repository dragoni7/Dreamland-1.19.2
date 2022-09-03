package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureMath;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class MoldPuffTree extends Feature<SimpleBlockConfiguration> {
	
	private static final int MAX_TRUNK_HEIGHT = 22;
	private static final int MIN_TRUNK_HEIGHT = 9;

	public MoldPuffTree(Codec<SimpleBlockConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		RandomSource rand = context.random();
		int height = rand.nextInt(MIN_TRUNK_HEIGHT, MAX_TRUNK_HEIGHT);
		BlockPos origin = context.origin();
		FeatureBuilder builder = new FeatureBuilder();
		BlockState state = context.config().toPlace().getState(rand, origin);
		
		BlockPos pos = origin;
		for (int h = 0; h < height; h++) {
			pos = origin.offset(0, h, 0);
			if (!builder.addInput(worldgenlevel, DreamlandWoodSets.MOLD_WOOD.log().block().get().defaultBlockState(), pos)) {
				return false;
			}
		}
		pos = pos.offset(0, 2, 0);
		
		for (int x = -2; x < 2; x++) {
			for (int y = -2; y < 2; y++) {
				for (int z = -2; z < 2; z++) {
					double distance = FeatureMath.distance(x, y, z, 2, 2, 2);
					if (distance < 1) {
						if (!builder.addInput(worldgenlevel, state, pos.offset(x, y, z))) {
							return false;
						}
					}
				}
			}
		}
		
		builder.build(worldgenlevel);
		return true;
	}

}
