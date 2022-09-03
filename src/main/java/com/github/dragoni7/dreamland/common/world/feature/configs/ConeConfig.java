package com.github.dragoni7.dreamland.common.world.feature.configs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record ConeConfig (BlockStateProvider block1, BlockStateProvider block2, IntProvider radius, IntProvider height, FloatProvider noiseFrequency) implements FeatureConfiguration {
	public static final Codec<ConeConfig> CODEC = RecordCodecBuilder.create((recorder) -> 
	{
		return recorder.group(
				BlockStateProvider.CODEC.fieldOf("block1").forGetter(ConeConfig::block1),
				BlockStateProvider.CODEC.fieldOf("block2").forGetter(ConeConfig::block2),
				IntProvider.CODEC.fieldOf("radius").orElse(ConstantInt.of(4)).forGetter(ConeConfig::radius),
				IntProvider.CODEC.fieldOf("height").orElse(ConstantInt.of(16)).forGetter(ConeConfig::height),
				FloatProvider.CODEC.fieldOf("noiseFrequency").orElse(ConstantFloat.of(0.1F)).forGetter(ConeConfig::noiseFrequency))
				.apply(recorder, ConeConfig::new);
	});
}
