package com.github.dragoni7.dreamland.common.world.feature.configs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record GrowthLayerConfig (BlockStateProvider growthBlock, BlockStateProvider underBlock, IntProvider radius, IntProvider height) implements FeatureConfiguration {
	public static final Codec<GrowthLayerConfig> CODEC = RecordCodecBuilder.create((recorder) -> 
	{
		return recorder.group(
				BlockStateProvider.CODEC.fieldOf("growthBlock").forGetter(GrowthLayerConfig::growthBlock),
				BlockStateProvider.CODEC.fieldOf("underBlock").forGetter(GrowthLayerConfig::underBlock),
				IntProvider.CODEC.fieldOf("radius").orElse(ConstantInt.of(4)).forGetter(GrowthLayerConfig::radius),
				IntProvider.CODEC.fieldOf("height").orElse(ConstantInt.of(2)).forGetter(GrowthLayerConfig::height))
				.apply(recorder, GrowthLayerConfig::new);
	});
}
