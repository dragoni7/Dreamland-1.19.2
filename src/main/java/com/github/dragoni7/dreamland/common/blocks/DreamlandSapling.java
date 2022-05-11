package com.github.dragoni7.dreamland.common.blocks;

import java.util.Optional;
import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DreamlandSapling extends SaplingBlock {
	
	public final Feature<NoneFeatureConfiguration> tree;
	public DreamlandSapling(Feature<NoneFeatureConfiguration> joshuaTree, BlockBehaviour.Properties properties) {
		super(null, properties);
		this.tree = joshuaTree;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, Random rand) {
		
		if (state.getValue(STAGE) == 0) {
			level.setBlock(pos, state.cycle(STAGE), UPDATE_NONE);
		} 
		else {
			if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(level, rand, pos)) {
				return;
			}
			
			tree.place(new FeaturePlaceContext(Optional.empty(), level, level.getChunkSource().getGenerator(), rand, pos, NoneFeatureConfiguration.INSTANCE));
		}
	}

}
