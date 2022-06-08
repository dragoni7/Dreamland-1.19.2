package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.Random;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TarSkeleton extends Feature<NoneFeatureConfiguration> {
	
	private static final BlockState BONE = Blocks.BONE_BLOCK.defaultBlockState();

	public TarSkeleton(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		RandomSource random = context.random();
		FeatureBuilder tarSkeletonBuilder = new FeatureBuilder();
		
		if (RollBoolean.roll(1, random)) {
			if (!createSpineNorth(worldgenlevel, tarSkeletonBuilder, blockpos, random)) {
				return false;
			}
		}
		else {
			if (!createSpineSouth(worldgenlevel, tarSkeletonBuilder, blockpos, random)) {
				return false;
			}
		}
		
		tarSkeletonBuilder.build(worldgenlevel);
		return true;
	}
	
	private boolean createSpineNorth(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, RandomSource random) {
		boolean status = true;
		BlockPos pos = blockpos;
		
		if (RollBoolean.roll(1, random)) {
			pos = blockpos.below();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int xChange = 0; xChange < 3; xChange++) {
				status = builder.addInput(worldgenlevel, BONE.rotate(Rotation.CLOCKWISE_180), pos, true);
				pos = pos.north();
			}
			pos = pos.above();
			status = builder.addInput(worldgenlevel, BONE, pos.south(), true);
		}
		
		if (status) {
			status = createRibsNorth(worldgenlevel, builder, pos);
		}
		
		return status;
	}
	
	private boolean createSpineSouth(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, RandomSource random) {
		boolean status = true;
		BlockPos pos = blockpos;
		
		if (RollBoolean.roll(1, random)) {
			pos = blockpos.below();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				status = builder.addInput(worldgenlevel, BONE.rotate(Rotation.CLOCKWISE_180), pos, true);
				pos = pos.south();
			}
			pos = pos.above();
			status = builder.addInput(worldgenlevel, BONE, pos.north(), true);
		}
		
		if (status) {
			status = createRibsSouth(worldgenlevel, builder, pos);
		}
		
		return status;
	}
	
	private boolean createRibsNorth(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos) {
		BlockPos pos = blockpos.offset(0, -1, 1);
		boolean status = true;
		int length = 4;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (j == 3) {
					
					for (int k = 1; k <= length; k++) {
						status = builder.addInput(worldgenlevel, BONE, pos.offset(j, -k, 0), true);
						status = builder.addInput(worldgenlevel, BONE, pos.offset(-j, -k, 0), true);
					}
				}
				else {
					status = builder.addInput(worldgenlevel, BONE, pos.offset(j, 0, 0), true);
					status = builder.addInput(worldgenlevel, BONE, pos.offset(-j, 0, 0), true);
				}
			}
			
			length -= 1;
			pos = pos.offset(0, -1, 3);
		}
		
		return status;
	}
	
	private boolean createRibsSouth(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos) {
		BlockPos pos = blockpos.offset(0, -1, -1);
		boolean status = true;
		int length = 3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (j == 3) {
					
					for (int k = 1; k <= length; k++) {
						status = builder.addInput(worldgenlevel, BONE, pos.offset(j, -k, 0), true);
						status = builder.addInput(worldgenlevel, BONE, pos.offset(-j, -k, 0), true);
					}
				}
				else {
					status = builder.addInput(worldgenlevel, BONE, pos.offset(j, 0, 0), true);
					status = builder.addInput(worldgenlevel, BONE, pos.offset(-j, 0, 0), true);
				}
			}
			
			length -= 1;
			pos = pos.offset(0, -1, -3);
		}
		
		return status;
	}

}
