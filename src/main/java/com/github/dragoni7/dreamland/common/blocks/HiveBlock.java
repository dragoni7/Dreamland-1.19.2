package com.github.dragoni7.dreamland.common.blocks;

import java.util.Random;

import com.github.dragoni7.dreamland.setup.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class HiveBlock extends LarvaAngerableBlock {
	
	public static final BooleanProperty HAS_GROWTH = BlockStateProperties.CONDITIONAL;

	public HiveBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(HAS_GROWTH, Boolean.valueOf(false)));
	}
	
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState blockstate, ServerLevel level, BlockPos blockpos, Random random) {
		if(!level.isAreaLoaded(blockpos, 1)) return;
		else if(level.getBlockState(blockpos.above()).is(DreamlandBlocks.HIVE_GROWTH.get())) {
				level.setBlockAndUpdate(blockpos, blockstate.setValue(HAS_GROWTH, Boolean.valueOf(true)));
			}
		else {
			level.setBlockAndUpdate(blockpos, blockstate.setValue(HAS_GROWTH, Boolean.valueOf(false)));
		}	
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	      builder.add(HAS_GROWTH);
	   }

}
