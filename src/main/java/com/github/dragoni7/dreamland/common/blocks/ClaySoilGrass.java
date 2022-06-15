package com.github.dragoni7.dreamland.common.blocks;

import java.util.List;
import java.util.Random;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ClaySoilGrass extends DreamlandSpreadingGrassBlock {

	public ClaySoilGrass(Properties blockProperties) {
		super(blockProperties, () -> DreamlandBlocks.CLAY_SOIL.block().get());
	}
	
	@Override
	public void performBonemeal(ServerLevel serverLevel, RandomSource rand, BlockPos pos, BlockState state) {
	      BlockPos blockpos = pos.above();
	      BlockState blockstate = Blocks.GRASS.defaultBlockState();

	      label46:
	      for(int i = 0; i < 128; ++i) {
	         BlockPos blockpos1 = blockpos;

	         for(int j = 0; j < i / 16; ++j) {
	            blockpos1 = blockpos1.offset(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
	            if (!serverLevel.getBlockState(blockpos1.below()).is(this) || serverLevel.getBlockState(blockpos1).isCollisionShapeFullBlock(serverLevel, blockpos1)) {
	               continue label46;
	            }
	         }

	         BlockState blockstate1 = serverLevel.getBlockState(blockpos1);
	         if (blockstate1.is(blockstate.getBlock()) && rand.nextInt(10) == 0) {
	            ((BonemealableBlock)blockstate.getBlock()).performBonemeal(serverLevel, rand, blockpos1, blockstate1);
	         }

	         if (blockstate1.isAir()) {
	            Holder<PlacedFeature> holder;
	            if (rand.nextInt(8) == 0) {
	               List<ConfiguredFeature<?, ?>> list = serverLevel.getBiome(blockpos1).value().getGenerationSettings().getFlowerFeatures();
	               if (list.isEmpty()) {
	                  continue;
	               }

	               holder = ((RandomPatchConfiguration)list.get(0).config()).feature();
	            } else {
	               holder = VegetationPlacements.GRASS_BONEMEAL;
	            }

	            holder.value().place(serverLevel, serverLevel.getChunkSource().getGenerator(), rand, blockpos1);
	         }
	      }

	   }
}
