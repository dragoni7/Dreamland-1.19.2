package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.ArrayList;
import java.util.List;

import com.github.dragoni7.dreamland.common.world.feature.configs.StarConfig;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FrostStar extends Feature<StarConfig> {

	public FrostStar(Codec<StarConfig> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<StarConfig> context) {
		WorldGenLevel worldgenlevel = context.level();
		FeatureBuilder builder = new FeatureBuilder();
		BlockPos origin = context.origin();
		Boolean status = false;
		RandomSource rand = context.random();
		BlockState state = context.config().block().getState(rand, origin);
		int height = context.config().height().sample(rand);
		int radius = context.config().radius().sample(rand);
		int xMax = radius * 2;
		
		for(int y = 0; y < height; y++) {
			int zMax = radius;
			if (y == 0 || y == height - 1) {
				zMax = radius + 1; // create lip at edge
			}
			for (int x = 0; x < xMax; x++) {
				for (int z = 0; z < zMax; z++) {
					
					List<BlockPos> positions = new ArrayList<BlockPos>();
					// mirror shape on each axis to create star
					positions.add(origin.offset(x, y, z));
					positions.add(origin.offset(z, y, x));
					
					positions.add(origin.offset(-x, y, z));
					positions.add(origin.offset(z, y, -x));
					
					positions.add(origin.offset(x, y, -z));
					positions.add(origin.offset(-z, y, x));
					
					positions.add(origin.offset(-x, y, -z));
					positions.add(origin.offset(-z, y, -x));
					
					// only build feature on solid ground
					for (BlockPos pos : positions) {
						if (y < 1 && (worldgenlevel.getBlockState(pos.below()).is(Blocks.AIR) || worldgenlevel.getBlockState(pos.below()).is(Blocks.WATER))) {
							return false;
						}
						else {
							status = builder.addInput(worldgenlevel, state, pos, true);
						}
					}
					
					
				}
				if (x%2 == 0) {
					zMax--; // stretch along z
				}
			}
		}
		
		if (status) {
			builder.build(worldgenlevel);
		}
		
		return status;
	}

}
