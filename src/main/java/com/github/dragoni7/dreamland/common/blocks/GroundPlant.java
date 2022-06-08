package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GroundPlant extends BushBlock implements net.minecraftforge.common.IForgeShearable {
	protected static final float AABB_OFFSET = 6.0F;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	
	public GroundPlant(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
	      return SHAPE;
	   }
	
	public BlockBehaviour.OffsetType getOffsetType() {
	      return BlockBehaviour.OffsetType.XZ;
	   }

}
