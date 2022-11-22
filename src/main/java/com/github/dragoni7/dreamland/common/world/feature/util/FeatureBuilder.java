package com.github.dragoni7.dreamland.common.world.feature.util;

import java.util.ArrayList;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

public class FeatureBuilder {
	
	private ArrayList<FeatureBuilderInput> inputs = new ArrayList<>();
	private ArrayList<BlockState> replaceables = new ArrayList<>();
	
	public FeatureBuilder() {
		
	}
	
	/**
	 * replaceables is an ArrayList of blockstates that should be overwritten when placing.
	 */
	public FeatureBuilder(ArrayList<BlockState> replaceables) {
		this.replaceables = replaceables;
	}
	
	/**
	 * Adds a new input to the builder with strict placement rules.
	 */
	public boolean addInput(WorldGenLevel level, BlockState state, BlockPos pos) {
		return addInput(level, state, pos, false);
	}
	
	/**
	 * Adds a new input to the builder, replaceBlocks dictate whether or not the placement rules should be strict or ignored.
	 */
	public boolean addInput(WorldGenLevel level, BlockState state, BlockPos pos, boolean replaceBlocks) {
		
		FeatureBuilderInput input = new FeatureBuilderInput(state, pos, replaceBlocks, replaceables);
		
		// Only add input if it can be placed.
		if (input.canPlace(level)) {
			inputs.add(input);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Places blocks according to the provided FeatureBuilderInputs.
	 */
	public void build(WorldGenLevel level) {
		if (!inputs.isEmpty()) {
			for (FeatureBuilderInput input : inputs) {
				level.setBlock(input.pos, input.state, 3);
			}
		}
	}
}
