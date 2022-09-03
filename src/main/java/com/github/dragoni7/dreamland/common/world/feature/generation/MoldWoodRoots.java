package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class MoldWoodRoots extends Feature<NoneFeatureConfiguration> {

	public MoldWoodRoots(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos origin = context.origin();
		RandomSource rand = context.random();
		Direction direction = Direction.getRandom(rand);
		BlockState state = DreamlandWoodSets.MOLD_WOOD.log().block().get().defaultBlockState();
		
		if (direction == Direction.UP) {
			direction = Direction.NORTH;
			state = state.setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
		}
		
		if (direction == Direction.DOWN) {
			direction = Direction.WEST;
			state = state.setValue(BlockStateProperties.AXIS, Direction.Axis.X);
		}
		
		if (direction == Direction.NORTH || direction == Direction.SOUTH) {
			state = state.setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
		}
		
		if (direction == Direction.EAST || direction == Direction.WEST) {
			state = state.setValue(BlockStateProperties.AXIS, Direction.Axis.X);
		}
		
		int length = rand.nextIntBetweenInclusive(6, 10);
		int humpStart = rand.nextIntBetweenInclusive(1, length/2);
		int humpHeight = rand.nextIntBetweenInclusive(2, 4);
		int humpEnd = rand.nextIntBetweenInclusive(humpStart + 2, length);
		FeatureBuilder builder = new FeatureBuilder();
		
		BlockPos pos = origin;
		
		for (int i = 0, j = 0; i <= length; i++) {
			if (i == humpStart) {
				for (; j < humpHeight; j++) {
					pos = origin.relative(Direction.UP, j).relative(direction, i);
					if (!builder.addInput(worldgenlevel, state.setValue(BlockStateProperties.AXIS, Direction.Axis.Y), pos, true)) {
						return false;
					}
				}
				if (!builder.addInput(worldgenlevel, DreamlandWoodSets.MOLD_WOOD.wood().block().get().defaultBlockState(), pos, true)) {
					return false;
				}
				j--;
			}
			else if (i == humpEnd) {
				pos = origin.relative(Direction.UP, j).relative(direction, i);
				for (; j >= 0; j--) {
					pos = origin.relative(Direction.UP, j).relative(direction, i);
					if (j == humpHeight-1) {
						if (!builder.addInput(worldgenlevel, DreamlandWoodSets.MOLD_WOOD.wood().block().get().defaultBlockState(), pos, true)) {
							return false;
						}
					}
					else {
						if (!builder.addInput(worldgenlevel, state.setValue(BlockStateProperties.AXIS, Direction.Axis.Y), pos, true)) {
							return false;
						}
					}
				}
				j++;
			}
			else {
				pos = origin.relative(Direction.UP, j).relative(direction, i);
				if (!builder.addInput(worldgenlevel, state, pos, true)) {
					return false;
				}
			}
		}
		
		if (!worldgenlevel.getBlockState(pos.below()).is(Blocks.AIR) && !worldgenlevel.getBlockState(pos.below()).is(Blocks.WATER)) {
			builder.build(worldgenlevel);
			return true;
		}
		return false;
	}

}
