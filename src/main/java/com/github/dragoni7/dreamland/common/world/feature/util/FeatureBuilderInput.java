package com.github.dragoni7.dreamland.common.world.feature.util;

import java.util.ArrayList;

import com.github.dragoni7.dreamland.common.blocks.DreamlandSaplingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

public class FeatureBuilderInput {
	
	public final BlockState state;
	public final BlockPos pos;
	private final boolean replaceBlocks;
	private final ArrayList<BlockState> replaceables;
	
	public FeatureBuilderInput(BlockState state, BlockPos pos, boolean replaceBlocks, ArrayList<BlockState> replaceables) {
		this.state = state;
		this.pos = pos;
		this.replaceBlocks = replaceBlocks;
		this.replaceables = replaceables;
	}
	
	/**
	 * whether or not the level can place a block at the current BlockPos.
	 */
	public boolean canPlace(WorldGenLevel level) {
		return canPlace(level, this.pos);
	}
	
	/**
	 * whether or not the level can place a block at the current BlockPos.
	 */
	public boolean canPlace(WorldGenLevel level, BlockPos pos) {
		if (level.isOutsideBuildHeight(pos)) {
			return false;
		}
		
		// Always return true if feature replaces blocks. Ignores the replaceable blocks list.
		if (replaceBlocks) {
			return true;
		}
		
		// Checks if the blockstate at the current pos can be replaced.
		BlockState state = level.getBlockState(pos);
		return replaceables != null ? (replaceables.contains(state) ? true : defaultReplaceableState(level)) : defaultReplaceableState(level);
	}
	
	// Always replace these BlockStates.
	private boolean defaultReplaceableState(WorldGenLevel level) {
		return level.isEmptyBlock(pos) || state.getMaterial().isLiquid() || state.getMaterial().isReplaceable() || state.getBlock() instanceof DreamlandSaplingBlock;
	}
}
