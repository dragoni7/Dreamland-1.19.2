package com.github.dragoni7.dreamland.common.world.feature.configs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record HillConfig (BlockStateProvider block, BlockStateProvider liquidBlock, IntProvider xRadius, IntProvider yHeight, IntProvider zRadius, IntProvider lakeFrequency, FloatProvider noiseFrequency) implements FeatureConfiguration {
	public static final Codec<HillConfig> CODEC = RecordCodecBuilder.create((recorder) -> 
	{
		return recorder.group(
				BlockStateProvider.CODEC.fieldOf("block").forGetter(HillConfig::block),
				BlockStateProvider.CODEC.fieldOf("liquid").forGetter(HillConfig::liquidBlock),
				IntProvider.CODEC.fieldOf("xRadius").orElse(ConstantInt.of(16)).forGetter(HillConfig::xRadius),
				IntProvider.CODEC.fieldOf("yHeight").orElse(ConstantInt.of(9)).forGetter(HillConfig::yHeight),
				IntProvider.CODEC.fieldOf("zRadius").orElse(ConstantInt.of(16)).forGetter(HillConfig::zRadius),
				IntProvider.CODEC.fieldOf("lakeFrequency").orElse(ConstantInt.of(2)).forGetter(HillConfig::lakeFrequency),
				FloatProvider.CODEC.fieldOf("noiseFrequency").orElse(ConstantFloat.of(0.1F)).forGetter(HillConfig::noiseFrequency))
				.apply(recorder, HillConfig::new);
	});
}
