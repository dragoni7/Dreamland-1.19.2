package com.github.dragoni7.registry;

import java.util.List;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.util.CustomTags;

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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class DreamlandFeatures {
	
	public static final RuleTest HIVE_ORES_REPLACEABLE = new TagMatchTest(CustomTags.Blocks.HIVE_ORES_REPLACEABLE);
	
	public static final List<OreConfiguration.TargetBlockState> HIVE_IRON_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_IRON.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_COPPER_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_COPPER.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_GOLD_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_GOLD.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_REDSTONE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_LAPIS_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_LAPIS.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_DIAMOND_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_DIAMOND.get().defaultBlockState()));
	
	public static final ConfiguredFeature<BlockColumnConfiguration, ?> CAVE_SLIME = FeatureUtils.register("cave_slime", 
			Feature.BLOCK_COLUMN.configured(
					new BlockColumnConfiguration(
							List.of(BlockColumnConfiguration.layer( 
									new WeightedListInt(
											SimpleWeightedRandomList.<IntProvider>builder()
											.add(UniformInt.of(0, 19), 2)
											.add(UniformInt.of(0, 2), 3)
											.add(UniformInt.of(0, 6), 10)
											.build()), 
									BlockStateProvider.simple(
											DreamlandBlocks.CAVE_SLIME_PLANT.get())),
									BlockColumnConfiguration.layer(
											ConstantInt.of(1), 
											BlockStateProvider.simple(
													DreamlandBlocks.CAVE_SLIME.get()))),
							Direction.DOWN, 
							BlockPredicate.ONLY_IN_AIR_PREDICATE, 
							true)));
	
	public static final ConfiguredFeature<?, ?> HIVE_IRON = FeatureUtils.register("hive_iron", Feature.ORE.configured(new OreConfiguration(HIVE_IRON_TARGET_LIST, 9)));
	public static final ConfiguredFeature<?, ?> HIVE_GOLD = FeatureUtils.register("hive_gold", Feature.ORE.configured(new OreConfiguration(HIVE_GOLD_TARGET_LIST, 4, 0.5F)));
	public static final ConfiguredFeature<?, ?> HIVE_REDSTONE = FeatureUtils.register("hive_redstone", Feature.ORE.configured(new OreConfiguration(HIVE_REDSTONE_TARGET_LIST, 8)));
	public static final ConfiguredFeature<?, ?> HIVE_LAPIS = FeatureUtils.register("hive_lapis", Feature.ORE.configured(new OreConfiguration(HIVE_LAPIS_TARGET_LIST, 7)));
	public static final ConfiguredFeature<?, ?> HIVE_COPPER = FeatureUtils.register("hive_copper", Feature.ORE.configured(new OreConfiguration(HIVE_COPPER_TARGET_LIST, 10)));
	public static final ConfiguredFeature<?, ?> HIVE_COPPER_LARGE = FeatureUtils.register("hive_copper_large", Feature.ORE.configured(new OreConfiguration(HIVE_COPPER_TARGET_LIST, 20)));
	public static final ConfiguredFeature<?, ?> HIVE_DIAMOND = FeatureUtils.register("hive_diamond", Feature.ORE.configured(new OreConfiguration(HIVE_DIAMOND_TARGET_LIST, 4, 0.5F)));
	public static final ConfiguredFeature<?, ?> HIVE_DIAMOND_LARGE = FeatureUtils.register("hive_diamond_large", Feature.ORE.configured(new OreConfiguration(HIVE_DIAMOND_TARGET_LIST, 12, 0.7F)));
	
	public static void init() {
		 
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "cave_slime"), CAVE_SLIME);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "hive_iron"), HIVE_IRON);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "hive_copper"), HIVE_COPPER);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "hive_copper_large"), HIVE_COPPER_LARGE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "hive_redstone"), HIVE_REDSTONE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "hive_gold"), HIVE_GOLD);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "hive_lapis"), HIVE_LAPIS);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "hive_diamond"), HIVE_DIAMOND);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Dreamland.MODID, "hive_diamond_large"), HIVE_DIAMOND_LARGE);
	 }
}
