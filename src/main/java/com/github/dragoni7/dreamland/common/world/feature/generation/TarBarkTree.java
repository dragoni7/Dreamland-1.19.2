package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TarBarkTree extends Feature<NoneFeatureConfiguration> {
	
	private static final int MAX_TRUNK_HEIGHT = 6;
	private static final int MIN_TRUNK_HEIGHT = 2;

	public TarBarkTree(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		RandomSource rand = context.random();
		FeatureBuilder builder = new FeatureBuilder();
		
		int trunkBaseHeight = MIN_TRUNK_HEIGHT + rand.nextInt(2);
		boolean xzChange = rand.nextBoolean();
		
		if (worldgenlevel.isEmptyBlock(blockpos.below()) || !DreamlandBlocks.TAR_BARK_SAPLING.block().get().defaultBlockState().canSurvive(worldgenlevel, blockpos)) {
			return false;
		}
		
		if(!createTrunk(worldgenlevel, xzChange, trunkBaseHeight, builder, blockpos)) {
			return false;
		}
		
		if (!createBranches(worldgenlevel, xzChange, rand, trunkBaseHeight, blockpos, builder)) {
			return false;
		}
		
		if(!createLeaves(worldgenlevel, blockpos.above(MAX_TRUNK_HEIGHT+2), builder, rand)) {
			return false;
		}
		
		builder.build(worldgenlevel);
		return true;
	}
	
	private static boolean createTrunk(WorldGenLevel worldgenlevel, Boolean xzChange, int baseHeight, FeatureBuilder builder, BlockPos blockpos) {
		final BlockState log = DreamlandWoodSets.TAR_BARK.log().block().get().defaultBlockState();
		
		for (int i = 0; i <= MAX_TRUNK_HEIGHT; i++) {
		
		BlockPos trunkPos = blockpos.above(i);
		BlockPos trunkOffset = trunkPos.east(1);
		
		if (xzChange) {
			trunkOffset = trunkPos.south(1);
		}
		
		if (!builder.addInput(worldgenlevel, log, trunkPos)) {
			return false;
		}
		
		if (i >= baseHeight) {
			if (!builder.addInput(worldgenlevel, log, trunkOffset)) {
				return false;
			}
		}
	}
		if (!builder.addInput(worldgenlevel, log, blockpos.above(MAX_TRUNK_HEIGHT+1))) {
			return false;
		}
		return true;
	}
	
	private static boolean createBranches(WorldGenLevel level, Boolean xzChange, RandomSource rand, int baseHeight, BlockPos pos, FeatureBuilder builder) {
		final BlockState log = DreamlandWoodSets.TAR_BARK.log().block().get().defaultBlockState();
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
		
		for (int i = 1; i <= 2; i++) {
			canBuild = builder.addInput(level, log.setValue(RotatedPillarBlock.AXIS, Direction.NORTH.getAxis()), pos.offset(0, baseHeight, i+zChange));
			canBuild = builder.addInput(level, log.setValue(RotatedPillarBlock.AXIS, Direction.EAST.getAxis()), pos.offset(i+xChange, northBranchHeight, 0));
		}
		
		canBuild = builder.addInput(level, log.setValue(RotatedPillarBlock.AXIS, Direction.UP.getAxis()), pos.offset(0, baseHeight+1, 3+zChange));
		canBuild = createLeaves(level, pos.offset(0, baseHeight+2, 3+zChange), builder, rand);
		canBuild = builder.addInput(level, log.setValue(RotatedPillarBlock.AXIS, Direction.UP.getAxis()), pos.offset(3+xChange, northBranchHeight+1, 0));
		canBuild = createLeaves(level, pos.offset(3+xChange, northBranchHeight+2, 0), builder, rand);
		
		for (int i = 1; i <= 2; i++) {
			canBuild = builder.addInput(level,log.setValue(RotatedPillarBlock.AXIS, Direction.SOUTH.getAxis()), pos.offset(xChange, eastBranchHeight, -i));
			canBuild = builder.addInput(level, log.setValue(RotatedPillarBlock.AXIS, Direction.WEST.getAxis()), pos.offset(-i, westBranchHeight, zChange));
		}
		
		canBuild = builder.addInput(level, log.setValue(RotatedPillarBlock.AXIS, Direction.UP.getAxis()), pos.offset(xChange, eastBranchHeight+1, -3));
		canBuild = createLeaves(level, pos.offset(xChange, eastBranchHeight+2, -3), builder, rand);
		canBuild = builder.addInput(level, log.setValue(RotatedPillarBlock.AXIS, Direction.UP.getAxis()), pos.offset(-3, westBranchHeight+1, zChange));
		canBuild = createLeaves(level, pos.offset(-3, westBranchHeight+2, zChange), builder, rand);
		
		return canBuild;
	}
	
	private static boolean createLeaves(WorldGenLevel level, BlockPos pos, FeatureBuilder builder, RandomSource rand) {
		final BlockState leaves = DreamlandBlocks.TAR_BARK_LEAVES.block().get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1).setValue(LeavesBlock.PERSISTENT, Boolean.valueOf(true));
		boolean canBuild = true;
		int extraLength = 1 + rand.nextInt(2);
		
		canBuild = builder.addInput(level, leaves, pos);
		
		for (int i = 0; i <= extraLength; i++) {
			canBuild = builder.addInput(level, leaves, pos.east(1).north(1).below(i));
			canBuild = builder.addInput(level, leaves, pos.west(1).north(1).below(i));
			canBuild = builder.addInput(level, leaves, pos.east(1).south(1).below(i));
			canBuild = builder.addInput(level, leaves, pos.west(1).south(1).below(i));
		}
		
		return canBuild;
	}
	

}
