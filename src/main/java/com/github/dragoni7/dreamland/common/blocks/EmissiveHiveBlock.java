package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import net.minecraft.world.level.block.state.BlockState;

public class EmissiveHiveBlock extends LarvaAngerableBlock {
	
	public EmissiveHiveBlock(Properties p_49795_) {
		super(p_49795_);
	}

	public static ToIntFunction<BlockState> emission(int p_181223_) {
		      return (p_181221_) -> {
		         return p_181223_;
		      };
		   }

}
