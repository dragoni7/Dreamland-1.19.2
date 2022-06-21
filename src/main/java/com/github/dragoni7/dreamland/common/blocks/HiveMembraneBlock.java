package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class HiveMembraneBlock extends Block {
	
	public static final BooleanProperty CONNECTED = BlockStateProperties.CONDITIONAL;

	public HiveMembraneBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(CONNECTED, Boolean.valueOf(true)));
	}
	
	public void randomTick(BlockState blockstate, ServerLevel level, BlockPos blockpos, RandomSource random) {
		if (blockstate.getValue(HiveMembraneBlock.CONNECTED).equals(Boolean.valueOf(false))) {
			level.removeBlock(blockpos, false);
		}
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	      builder.add(CONNECTED);
	}
}
