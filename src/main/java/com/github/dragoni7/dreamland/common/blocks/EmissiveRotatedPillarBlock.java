package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class EmissiveRotatedPillarBlock extends RotatedPillarBlock {

	public EmissiveRotatedPillarBlock(Properties properties) {
		super(properties);
	}
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
	      return (light) -> {
	         return lightLevel;
	      };
	}

}
