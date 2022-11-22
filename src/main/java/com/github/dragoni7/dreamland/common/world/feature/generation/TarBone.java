package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.ArrayList;
import java.util.Arrays;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
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
		RandomSource random = context.random();
		boolean status = false;
		
		FeatureBuilder tarBoneBuilder = new FeatureBuilder(new ArrayList<BlockState>(
				// Only replace tar mud and tar fluid.
				Arrays.asList(DreamlandBlocks.TAR_MUD.block().get().defaultBlockState(), DreamlandFluids.TAR_BLOCK.get().defaultBlockState())));
		
		if (random.nextBoolean()) {
			blockpos = blockpos.below();
		}
		
		tarBoneBuilder.addInput(worldgenlevel, BONE, blockpos, false);
		blockpos = blockpos.above();
		status = tarBoneBuilder.addInput(worldgenlevel, BONE, blockpos, false);
		
		if (random.nextBoolean()) {
			blockpos = blockpos.above();
			status = tarBoneBuilder.addInput(worldgenlevel, BONE, blockpos, false);
		}
		
		BlockState rotated = BONE;
		switch (random.nextInt(3)) {
		case 0: {
			blockpos = blockpos.offset(0, 1 , 1);
			rotated = rotated.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z);
			break;
		}
		case 1: {
			blockpos = blockpos.offset(0, 1 , -1);
			rotated = rotated.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z);
			break;
		}
		case 2: {
			blockpos = blockpos.offset(1, 1 , 0);
			rotated = rotated.setValue(RotatedPillarBlock.AXIS, Direction.Axis.X);
			break;
		}
		case 3: {
			blockpos = blockpos.offset(-1, 1 , 0);
			rotated = rotated.setValue(RotatedPillarBlock.AXIS, Direction.Axis.X);
			break;
		}
			default: return status;
		}
		
		status = tarBoneBuilder.addInput(worldgenlevel, rotated, blockpos, false);
		
		if (status) {
			tarBoneBuilder.build(worldgenlevel);
		}
		
		return status;
	}

}
