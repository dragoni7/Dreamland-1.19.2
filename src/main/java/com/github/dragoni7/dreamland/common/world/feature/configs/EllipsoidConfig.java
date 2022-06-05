package com.github.dragoni7.dreamland.common.world.feature.configs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record EllipsoidConfig(BlockStateProvider block, BlockStateProvider noiseBlock, IntProvider xRadius, IntProvider yRadius, IntProvider zRadius) implements FeatureConfiguration {
	public static final Codec<EllipsoidConfig> CODEC = RecordCodecBuilder.create( (recorder) -> 
	{
		return recorder.group(
				BlockStateProvider.CODEC.fieldOf("block").forGetter(EllipsoidConfig::block),
				BlockStateProvider.CODEC.fieldOf("noiseBlock").orElse(BlockStateProvider.simple(Blocks.AIR)).forGetter(EllipsoidConfig::noiseBlock),
				IntProvider.CODEC.fieldOf("xRadius").orElse(ConstantInt.of(1)).forGetter(EllipsoidConfig::xRadius),
				IntProvider.CODEC.fieldOf("yRadius").orElse(ConstantInt.of(1)).forGetter(EllipsoidConfig::yRadius),
				IntProvider.CODEC.fieldOf("zRadius").orElse(ConstantInt.of(1)).forGetter(EllipsoidConfig::zRadius))
				.apply(recorder, EllipsoidConfig::new);
	});
}
