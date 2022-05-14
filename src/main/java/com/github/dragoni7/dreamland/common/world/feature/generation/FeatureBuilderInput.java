package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.blocks.DreamlandSapling;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

public class FeatureBuilderInput {
	
	public final BlockState state;
	public final BlockPos pos;
	
	public FeatureBuilderInput(BlockState stateIn, BlockPos posIn) {
		this.state = stateIn;
		this.pos = posIn;
	}
	
	public boolean canPlace(WorldGenLevel level) {
		return canPlace(level, this.pos);
	}
	
	public boolean canPlace(WorldGenLevel level, BlockPos pos) {
		if (level.isOutsideBuildHeight(pos)) {
			return false;
		}
		
		BlockState state = level.getBlockState(pos);
		return level.isEmptyBlock(pos) || state.getMaterial().isReplaceable() || state.getBlock() instanceof DreamlandSapling;
	}
}
