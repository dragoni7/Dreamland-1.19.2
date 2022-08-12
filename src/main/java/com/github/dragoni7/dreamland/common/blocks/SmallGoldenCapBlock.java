package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import com.github.dragoni7.dreamland.common.world.feature.DreamlandConfiguredFeatures;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmallGoldenCapBlock extends MushroomBlock {
	
	protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

	public SmallGoldenCapBlock(Properties properties) {
		super(properties, () -> DreamlandConfiguredFeatures.GOLDEN_CAP);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
	      return SHAPE;
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
	      BlockPos blockpos = pos.below();
	      BlockState blockstate = levelReader.getBlockState(blockpos);
	      if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK) || blockstate.is(DreamlandBlocks.GOLDEN_MOSS_BLOCK.block().get())) {
	         return true;
	      } else {
	         return levelReader.getRawBrightness(pos, 0) < 13 && blockstate.canSustainPlant(levelReader, blockpos, net.minecraft.core.Direction.UP, this);
	      }
	}
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
	      return (light) -> {
	         return lightLevel;
	      };
	   }
}
