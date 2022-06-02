package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.Random;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class PlumBirchTree extends Feature<NoneFeatureConfiguration> {
	
	private static final int MAX_TRUNK_HEIGHT = 16;
	private static final int MIN_TRUNK_HEIGHT = 9;
	private BlockPos beeHivePos;

	public PlumBirchTree(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		Random rand = context.random();
		int height = rand.nextInt(MIN_TRUNK_HEIGHT, MAX_TRUNK_HEIGHT);
		BlockPos blockpos = context.origin();
		BlockPos branchPos = blockpos.above(height - rand.nextInt(5, 6));
		FeatureBuilder plumBirchTreeBuilder = new FeatureBuilder();
		final BlockState log = DreamlandWoodSets.PLUM_BIRCH.getLog().defaultBlockState();
		Boolean branchResult = false;
		
		
		if (worldgenlevel.isEmptyBlock(blockpos.below()) || !DreamlandBlocks.PLUM_BIRCH_SAPLING.get().defaultBlockState().canSurvive(worldgenlevel, blockpos)) {
			return false;
		}
		
		if ( !createTrunk(worldgenlevel, plumBirchTreeBuilder, blockpos, log, height)) {
			return false;
		}
		
		if (RollBoolean.roll(4, rand)) {
			switch (rand.nextInt(4)) {
			case 0: {
				branchPos = branchPos.north();
				branchResult = plumBirchTreeBuilder.addInput(worldgenlevel, log.setValue(RotatedPillarBlock.AXIS, Direction.NORTH.getAxis()), branchPos);
				break;
			}
			case 1: {
				branchPos = branchPos.south();
				branchResult = plumBirchTreeBuilder.addInput(worldgenlevel, log.setValue(RotatedPillarBlock.AXIS, Direction.SOUTH.getAxis()), branchPos);
				break;
			}
			case 2: {
				branchPos = branchPos.east();
				branchResult = plumBirchTreeBuilder.addInput(worldgenlevel, log.setValue(RotatedPillarBlock.AXIS, Direction.EAST.getAxis()), branchPos);
				break;
			}
			case 3: {
				branchPos = branchPos.west();
				branchResult = plumBirchTreeBuilder.addInput(worldgenlevel, log.setValue(RotatedPillarBlock.AXIS, Direction.WEST.getAxis()), branchPos);
				break;
			}
			}
			
			if ( !branchResult) {
				return false;
			}
		}
		
		if ( !createLeaves(worldgenlevel, blockpos, plumBirchTreeBuilder, rand, height)) {
			return false;
		}
		
		plumBirchTreeBuilder.build(worldgenlevel);
		
		if (RollBoolean.roll(16, rand) && branchResult) {
			worldgenlevel.setBlock(branchPos.below(), Blocks.BEE_NEST.defaultBlockState().setValue(BeehiveBlock.FACING, Direction.SOUTH), 3);
			worldgenlevel.getBlockEntity(branchPos.below(), BlockEntityType.BEEHIVE).ifPresent((beeHive) -> {
                  int j = 2 + rand.nextInt(2);

                  for(int k = 0; k < j; ++k) {
                     CompoundTag compoundtag = new CompoundTag();
                     compoundtag.putString("id", Registry.ENTITY_TYPE.getKey(EntityType.BEE).toString());
                     beeHive.storeBee(compoundtag, rand.nextInt(599), false);
                  }

               });
		}
		
		return true;
	}
	
	private static boolean createTrunk(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, BlockState log, int height) {
		
		for (int i = 0; i <= height; i++) {
			BlockPos trunkPos = blockpos.above(i);
			
			if (!builder.addInput(worldgenlevel, log, trunkPos)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean createLeaves(WorldGenLevel level, BlockPos pos, FeatureBuilder builder, Random rand, int height) {
		final BlockState leaves = DreamlandBlocks.PLUM_BIRCH_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1);
		BlockPos leavesPos = pos.above(height);
		boolean canBuild = true;
		
		canBuild = builder.addInput(level, leaves, leavesPos);
		canBuild = builder.addInput(level, leaves, leavesPos.north());
		canBuild = builder.addInput(level, leaves, leavesPos.south());
		canBuild = builder.addInput(level, leaves, leavesPos.east());
		canBuild = builder.addInput(level, leaves, leavesPos.west());
		
		leavesPos = leavesPos.below();
		
		canBuild = builder.addInput(level, leaves, leavesPos.north());
		canBuild = builder.addInput(level, leaves, leavesPos.south());
		canBuild = builder.addInput(level, leaves, leavesPos.east());
		canBuild = builder.addInput(level, leaves, leavesPos.west());
		
		if (RollBoolean.roll(2, rand)) {
			canBuild = builder.addInput(level, leaves, leavesPos.north().east());
		}
		if (RollBoolean.roll(2, rand)) {
			canBuild = builder.addInput(level, leaves, leavesPos.north().west());
		}
		if (RollBoolean.roll(2, rand)) {
			canBuild = builder.addInput(level, leaves, leavesPos.south().east());
		}
		if (RollBoolean.roll(2, rand)) {
			canBuild = builder.addInput(level, leaves, leavesPos.south().west());
		}
		
		for ( int i = 1; i <= 2; i++) {
			for ( int j = 1; j <= 2; j++) {
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).north(j));
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).north(j).east());
				if (RollBoolean.roll(2, rand)) {
					canBuild = builder.addInput(level, leaves, leavesPos.below(i).north(j).east().east());
				}
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).north(j).west());
				if (RollBoolean.roll(2, rand)) {
					canBuild = builder.addInput(level, leaves, leavesPos.below(i).north(j).west().west());
				}
				
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).south(j));
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).south(j).east());
				if (RollBoolean.roll(2, rand)) {
					canBuild = builder.addInput(level, leaves, leavesPos.below(i).south(j).east().east());
				}
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).south(j).west());
				if (RollBoolean.roll(2, rand)) {
					canBuild = builder.addInput(level, leaves, leavesPos.below(i).south(j).west().west());
				}
				
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).east(j));
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).east(j).north());
				if (RollBoolean.roll(2, rand)) {
					canBuild = builder.addInput(level, leaves, leavesPos.below(i).east(j).north().north());
				}
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).east(j).south());
				if (RollBoolean.roll(2, rand)) {
					canBuild = builder.addInput(level, leaves, leavesPos.below(i).east(j).south().south());
				}
				
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).west(j));
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).west(j).north());
				if (RollBoolean.roll(2, rand)) {
					canBuild = builder.addInput(level, leaves, leavesPos.below(i).west(j).north().north());
				}
				canBuild = builder.addInput(level, leaves, leavesPos.below(i).west(j).south());
				if (RollBoolean.roll(2, rand)) {
					canBuild = builder.addInput(level, leaves, leavesPos.below(i).west(j).south().south());
				}
			}
		}
		
		return canBuild;
	}

}
