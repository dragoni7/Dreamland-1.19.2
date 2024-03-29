package com.github.dragoni7.dreamland.common.blocks;

import com.github.dragoni7.dreamland.common.blocks.tiles.AncientEggTile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AncientEggBlock extends Block implements EntityBlock {
	
	// WIP
	public AncientEggBlock(Properties properties) {
		super(properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new AncientEggTile(pos, state);
	}
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}
}
