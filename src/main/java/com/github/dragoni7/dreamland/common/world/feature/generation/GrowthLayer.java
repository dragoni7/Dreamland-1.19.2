package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.configs.GrowthLayerConfig;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class GrowthLayer extends Feature<GrowthLayerConfig> {

	public GrowthLayer(Codec<GrowthLayerConfig> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<GrowthLayerConfig> context) {
		WorldGenLevel worldgenlevel = context.level();
		RandomSource rand = context.random();
	    BlockPos origin = context.origin();
	    BlockPos blockpos = origin;
	    FeatureBuilder builder = new FeatureBuilder();
	    boolean status = true;
	    BlockState growthBlock = context.config().growthBlock().getState(rand, origin);
	    BlockState groundBlock = context.config().underBlock().getState(rand, origin);
	    int radius = context.config().radius().sample(rand);
	    int height = context.config().height().sample(rand);
	    
	    for (int x = -radius; x < radius; x++) {
	    	for (int y = -height; y < height; y++) {
	    		for (int z = -radius; z < radius; z++) {
	    			blockpos = origin.offset(x, y, z);
	    			if (worldgenlevel.getBlockState(blockpos).is(groundBlock.getBlock()) && worldgenlevel.isEmptyBlock(blockpos.above()) && RollBoolean.roll(2, context.random())) {
	    		    	status = builder.addInput(worldgenlevel, growthBlock, blockpos.above());
	    		    	if (groundBlock.hasProperty(BlockStateProperties.CONDITIONAL)) {
	    		    		status = builder.addInput(worldgenlevel, groundBlock.setValue(BlockStateProperties.CONDITIONAL, Boolean.valueOf(true)), blockpos, true);
	    		    	}
	    		    	else {
	    		    		status = builder.addInput(worldgenlevel, groundBlock, blockpos, true);
	    		    	}
	    		    }
	    		}
	    	}
	    }
		
	    builder.build(worldgenlevel);
		return status;
	}

}
