package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import net.minecraft.world.level.block.state.BlockState;

public class EmissiveHiveBlock extends LarvaAngerableBlock {
	
	public EmissiveHiveBlock(Properties properties) {
		super(properties);
	}
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
	      return (light) -> {
	         return lightLevel;
	      };
	}
}
