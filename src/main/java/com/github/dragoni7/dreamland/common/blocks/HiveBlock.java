package com.github.dragoni7.dreamland.common.blocks;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class HiveBlock extends LarvaAngerableBlock {
	
	public static final BooleanProperty HAS_GROWTH = BlockStateProperties.CONDITIONAL;

	public HiveBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HAS_GROWTH, Boolean.valueOf(false)));
	}
	
	public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor accessor, BlockPos pos1, BlockPos pos2) {
	      return direction == Direction.UP ? state1.setValue(HAS_GROWTH, Boolean.valueOf(hasGrowth(state2))) : super.updateShape(state1, direction, state2, accessor, pos1, pos2);
	 }
	
	private static boolean hasGrowth(BlockState state) {
		return state.is(DreamlandBlocks.HIVE_GROWTH.get());
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	      builder.add(HAS_GROWTH);
	   }

}
