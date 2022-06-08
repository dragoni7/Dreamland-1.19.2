package com.github.dragoni7.dreamland.common.blocks;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TarSprouts extends BushBlock implements net.minecraftforge.common.IForgeShearable {

	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	
	public TarSprouts(Properties properties) {
		super(properties);
	}
	
	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
	      return state.is(DreamlandBlocks.TAR_SOIL.get());
	   }
	
	public VoxelShape getShape(BlockState p_57336_, BlockGetter p_57337_, BlockPos p_57338_, CollisionContext p_57339_) {
	      return SHAPE;
	   }
	
	public BlockBehaviour.OffsetType getOffsetType() {
	      return BlockBehaviour.OffsetType.XZ;
	   }

}
