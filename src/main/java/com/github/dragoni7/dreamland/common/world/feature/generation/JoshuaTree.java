package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.Random;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.DreamlandSapling;
import com.github.dragoni7.dreamland.setup.DreamlandBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class JoshuaTree extends Feature<NoneFeatureConfiguration> {
	
	private static final int maxTreeHeight = 11;
	private static final int minTrunkHeight = 2;

	public JoshuaTree(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		Random random = context.random();
		
		int trunkHeight = minTrunkHeight + random.nextInt(2);
		BlockPos trunkWidenPos = blockpos.above(trunkHeight);
		
		if (worldgenlevel.isEmptyBlock(blockpos.below()) || !DreamlandBlocks.JOSHUA_SAPLING.get().defaultBlockState().canSurvive(worldgenlevel, blockpos)) {
			return false;
		}
		
		for (int i = 0; i <= maxTreeHeight; i++) {
			BlockPos trunkPos = blockpos.above(i);
			
			if (trunkPos == trunkWidenPos) {
				this.setBlock(worldgenlevel, trunkPos.offset(1,0,0), Blocks.ACACIA_LOG.defaultBlockState());
			}
			
			if (tryPlace(worldgenlevel, trunkPos)) {
				this.setBlock(worldgenlevel, trunkPos, Blocks.ACACIA_LOG.defaultBlockState());
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	public static void buildLeaves(WorldGenLevel level, Random rand, BlockPos pos) {
		level.setBlock(pos.offset(0,1,0), Blocks.ACACIA_LEAVES.defaultBlockState(), 0);
	}
	
	public static boolean tryPlace(WorldGenLevel level, BlockPos pos) {
		if (level.isOutsideBuildHeight(pos)) {
			return false;
		}
		
		BlockState state = level.getBlockState(pos);
		return state.getBlock() instanceof DreamlandSapling || state.getMaterial().isReplaceable() || level.isEmptyBlock(pos);
	}

}
