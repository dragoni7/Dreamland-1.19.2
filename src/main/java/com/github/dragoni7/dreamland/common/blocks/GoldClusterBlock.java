package com.github.dragoni7.dreamland.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GoldClusterBlock extends Block implements SimpleWaterloggedBlock {
	
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	protected final VoxelShape northAabb;
	protected final VoxelShape southAabb;
	protected final VoxelShape eastAabb;
	protected final VoxelShape westAabb;
	protected final VoxelShape upAabb;
	protected final VoxelShape downAabb;

	public GoldClusterBlock(int i, int j, Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.UP));
	    this.upAabb = Block.box((double)j, 0.0D, (double)j, (double)(16 - j), (double)i, (double)(16 - j));
	    this.downAabb = Block.box((double)j, (double)(16 - i), (double)j, (double)(16 - j), 16.0D, (double)(16 - j));
	    this.northAabb = Block.box((double)j, (double)j, (double)(16 - i), (double)(16 - j), (double)(16 - j), 16.0D);
	    this.southAabb = Block.box((double)j, (double)j, 0.0D, (double)(16 - j), (double)(16 - j), (double)i);
	    this.eastAabb = Block.box(0.0D, (double)j, (double)j, (double)i, (double)(16 - j), (double)(16 - j));
	    this.westAabb = Block.box((double)(16 - i), (double)j, (double)j, 16.0D, (double)(16 - j), (double)(16 - j));
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
	    Direction direction = state.getValue(FACING);
	    switch (direction) {
	       case NORTH:
	          return this.northAabb;
	       case SOUTH:
	          return this.southAabb;
	       case EAST:
	          return this.eastAabb;
	       case WEST:
	          return this.westAabb;
	       case DOWN:
	          return this.downAabb;
	       case UP:
	       default:
	          return this.upAabb;
	      }
	 }
	
	public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
	      Direction direction = state.getValue(FACING);
	      BlockPos blockpos = pos.relative(direction.getOpposite());
	      return levelReader.getBlockState(blockpos).isFaceSturdy(levelReader, blockpos, direction);
	   }

	   public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor levelAccessor, BlockPos pos1, BlockPos pos2) {
	      if (state.getValue(WATERLOGGED)) {
	         levelAccessor.scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
	      }

	      return direction == state.getValue(FACING).getOpposite() && !state.canSurvive(levelAccessor, pos1) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state2, levelAccessor, pos1, pos2);
	   }

	   @Nullable
	   public BlockState getStateForPlacement(BlockPlaceContext context) {
	      LevelAccessor levelaccessor = context.getLevel();
	      BlockPos blockpos = context.getClickedPos();
	      return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(FACING, context.getClickedFace());
	   }

	   public BlockState rotate(BlockState state, Rotation rotation) {
	      return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	   }

	   public BlockState mirror(BlockState state, Mirror mirror) {
	      return state.rotate(mirror.getRotation(state.getValue(FACING)));
	   }

	   public FluidState getFluidState(BlockState state) {
	      return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	   }

	   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	      builder.add(WATERLOGGED, FACING);
	   }

	   public PushReaction getPistonPushReaction(BlockState state) {
	      return PushReaction.DESTROY;
	   }
	
}
