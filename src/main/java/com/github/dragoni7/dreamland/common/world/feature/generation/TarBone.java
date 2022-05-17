package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.Random;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TarBone extends Feature<NoneFeatureConfiguration> {

	private static final BlockState BONE = Blocks.BONE_BLOCK.defaultBlockState();
	
	public TarBone(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		Random random = context.random();
		boolean status = false;
		FeatureBuilder tarBoneBuilder = new FeatureBuilder();
		
		if (random.nextBoolean()) {
			blockpos = blockpos.below();
		}
		
		tarBoneBuilder.addInput(worldgenlevel, BONE, blockpos, true);
		blockpos = blockpos.above();
		status = tarBoneBuilder.addInput(worldgenlevel, BONE, blockpos, true);
		
		if (random.nextBoolean()) {
			blockpos = blockpos.above();
			status = tarBoneBuilder.addInput(worldgenlevel, BONE, blockpos, true);
		}
		
		switch (random.nextInt(3)) {
		case 0: {
			blockpos = blockpos.offset(0, 1 , 1);
			break;
		}
		case 1: {
			blockpos = blockpos.offset(0, 1 , -1);
			break;
		}
		case 2: {
			blockpos = blockpos.offset(1, 1 , 0);
			break;
		}
		case 3: {
			blockpos = blockpos.offset(-1, 1 , 0);
			break;
		}
		default: return status;
		}
		
		status = tarBoneBuilder.addInput(worldgenlevel, BONE, blockpos, true);
		tarBoneBuilder.build(worldgenlevel);
		return status;
	}

}
