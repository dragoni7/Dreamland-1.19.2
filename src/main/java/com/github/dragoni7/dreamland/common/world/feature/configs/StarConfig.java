package com.github.dragoni7.dreamland.common.world.feature.configs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record StarConfig (BlockStateProvider block, IntProvider radius, IntProvider height) implements FeatureConfiguration {
	public static final Codec<StarConfig> CODEC = RecordCodecBuilder.create((recorder) -> 
	{
		return recorder.group(
				BlockStateProvider.CODEC.fieldOf("block").forGetter(StarConfig::block),
				IntProvider.CODEC.fieldOf("radius").orElse(ConstantInt.of(6)).forGetter(StarConfig::radius),
				IntProvider.CODEC.fieldOf("height").orElse(ConstantInt.of(10)).forGetter(StarConfig::height))
				.apply(recorder, StarConfig::new);
	});
}
