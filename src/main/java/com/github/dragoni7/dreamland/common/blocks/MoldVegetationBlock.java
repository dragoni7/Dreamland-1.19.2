package com.github.dragoni7.dreamland.common.blocks;
import com.github.dragoni7.dreamland.data.DreamlandBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public class MoldVegetationBlock extends GroundPlantBlock {

	public MoldVegetationBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
	      BlockPos blockpos = pos.below();
	      if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
	         return levelReader.getBlockState(blockpos).canSustainPlant(levelReader, blockpos, Direction.UP, this) || levelReader.getBlockState(blockpos).is(DreamlandBlockTags.TOXIC_JUNGLE_GROUND_BLOCKS);
	      return this.mayPlaceOn(levelReader.getBlockState(blockpos), levelReader, blockpos);
	}

}
