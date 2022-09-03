package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class MoldGrowth extends Feature<SimpleBlockConfiguration> {
	
	private static final int MAX_TRUNK_HEIGHT = 6;
	private static final int MIN_TRUNK_HEIGHT = 2;

	public MoldGrowth(Codec<SimpleBlockConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos origin = context.origin();
		RandomSource rand = context.random();
		FeatureBuilder builder = new FeatureBuilder();
		BlockState state = context.config().toPlace().getState(rand, origin);
		int trunkBaseHeight = MIN_TRUNK_HEIGHT + rand.nextInt(2);
		boolean xzChange = rand.nextBoolean();
		
		if(!createTrunk(state, worldgenlevel, xzChange, trunkBaseHeight, builder, origin)) {
			return false;
		}
		
		if (!createBranches(worldgenlevel, state, xzChange, rand, trunkBaseHeight, origin, builder)) {
			return false;
		}
		
		builder.build(worldgenlevel);
		return true;
	}
	
	private static boolean createTrunk(BlockState state, WorldGenLevel worldgenlevel, Boolean xzChange, int baseHeight, FeatureBuilder builder, BlockPos blockpos) {
		for (int i = 0; i <= MAX_TRUNK_HEIGHT; i++) {
		
		BlockPos trunkPos = blockpos.above(i);
		BlockPos trunkOffset = trunkPos.east(1);
		
		if (xzChange) {
			trunkOffset = trunkPos.south(1);
		}
		
		if (!builder.addInput(worldgenlevel, state, trunkPos)) {
			return false;
		}
		
		if (i >= baseHeight) {
			if (!builder.addInput(worldgenlevel, state, trunkOffset)) {
				return false;
			}
		}
	}
		if (!builder.addInput(worldgenlevel, state, blockpos.above(MAX_TRUNK_HEIGHT+1))) {
			return false;
		}
		return true;
	}
	
	private static boolean createBranches(WorldGenLevel level, BlockState state, Boolean xzChange, RandomSource rand, int baseHeight, BlockPos pos, FeatureBuilder builder) {
		
		int northBranchHeight = baseHeight+rand.nextInt(1, 3);
		int westBranchHeight = baseHeight+rand.nextInt(2, 3);
		int eastBranchHeight = baseHeight+rand.nextInt(1, 2);
		boolean canBuild = true;
		int zChange = 0;
		int xChange = 1;
		
		if (xzChange) {
			zChange = 1;
			xChange = 0;
		}
		
		for (int i = 1; i <= 1; i++) {
			canBuild = builder.addInput(level, state, pos.offset(0, baseHeight, i+zChange));
			canBuild = builder.addInput(level, state, pos.offset(i+xChange, northBranchHeight, 0));
		}
		
		canBuild = builder.addInput(level, state, pos.offset(0, baseHeight+1, 2+zChange));
		canBuild = builder.addInput(level, state, pos.offset(2+xChange, northBranchHeight+1, 0));
		
		for (int i = 1; i <= 1; i++) {
			canBuild = builder.addInput(level, state, pos.offset(xChange, eastBranchHeight, -i));
			canBuild = builder.addInput(level, state, pos.offset(-i, westBranchHeight, zChange));
		}
		
		canBuild = builder.addInput(level, state, pos.offset(xChange, eastBranchHeight+1, -2));
		canBuild = builder.addInput(level, state, pos.offset(-2, westBranchHeight+1, zChange));
		
		return canBuild;
	}

}
