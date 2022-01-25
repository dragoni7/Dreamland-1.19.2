package com.github.dragoni7.registry;

import java.util.List;

import com.github.dragoni7.Dreamland;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class DreamlandFeatures {

	public static final ConfiguredFeature<BlockColumnConfiguration, ?> CAVE_SLIME = FeatureUtils.register("cave_slime", Feature.BLOCK_COLUMN.configured(new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(0, 19), 2).add(UniformInt.of(0, 2), 3).add(UniformInt.of(0, 6), 10).build()), BlockStateProvider.simple(DreamlandBlocks.CAVE_SLIME_PLANT.get())), BlockColumnConfiguration.layer(ConstantInt.of(1), BlockStateProvider.simple(DreamlandBlocks.CAVE_SLIME.get()))), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true)));
			
	public static void init() {
		 
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "cave_slime"), CAVE_SLIME);
	 }
}
