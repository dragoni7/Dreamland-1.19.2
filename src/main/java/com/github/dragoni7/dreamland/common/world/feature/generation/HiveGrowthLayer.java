package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.blocks.HiveBlock;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class HiveGrowthLayer extends Feature<NoneFeatureConfiguration> {

	public HiveGrowthLayer(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
	    BlockPos origin = context.origin();
	    BlockPos blockpos = origin;
	    FeatureBuilder builder = new FeatureBuilder();
	    boolean status = true;
	    
	    for (int x = -4; x < 4; x++) {
	    	for (int y = -2; y < 2; y++) {
	    		for (int z = -4; z < 4; z++) {
	    			blockpos = origin.offset(x, y, z);
	    			if (worldgenlevel.getBlockState(blockpos).is(DreamlandBlocks.HIVE_BLOCK.get()) && worldgenlevel.isEmptyBlock(blockpos.above()) && RollBoolean.roll(2, context.random())) {
	    		    	status = builder.addInput(worldgenlevel, DreamlandBlocks.HIVE_GROWTH.get().defaultBlockState(), blockpos.above());
	    		    	status = builder.addInput(worldgenlevel, DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState().setValue(HiveBlock.HAS_GROWTH, Boolean.valueOf(true)), blockpos, true);
	    		    }
	    		}
	    	}
	    }
		
	    builder.build(worldgenlevel);
		return status;
	}

}
