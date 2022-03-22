package com.github.dragoni7.registry;

import java.util.List;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.util.DreamlandLoc;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
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
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ConfiguredDreamlandFeatures {
	
	public static final RuleTest HIVE_ORES_REPLACEABLE = new TagMatchTest(DreamlandCustomTags.HIVE_ORES_REPLACEABLE);
	
	public static final List<OreConfiguration.TargetBlockState> HIVE_IRON_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_IRON.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_COPPER_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_COPPER.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_GOLD_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_GOLD.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_REDSTONE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_LAPIS_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_LAPIS.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_DIAMOND_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_DIAMOND.get().defaultBlockState()));
	
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> CAVE_SLIME = FeatureUtils.register("cave_slime", 
			Feature.BLOCK_COLUMN,
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
							true));
	
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> HIVE_SLUDGE = FeatureUtils.register("hive_sludge", 
			Feature.BLOCK_COLUMN, (BlockColumnConfiguration.simple(UniformInt.of(1, 3), BlockStateProvider.simple(DreamlandBlocks.HIVE_SLUDGE.get()))));
	
	
	
	/*
	 * public static final ConfiguredFeature<BlockColumnConfiguration, ?>
	 * HIVE_PILLAR = FeatureUtils.register("hive_pillar",
	 * Feature.BLOCK_COLUMN.configured(BlockColumnConfiguration.simple(UniformInt.of
	 * (4, 10), BlockStateProvider.simple(DreamlandBlocks.HIVE_BLOCK.get()))));
	 */
	 
	 	
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HIVE_PILLAR = FeatureUtils.register("hive_pillar", DreamlandFeatures.HIVE_SPIKE, (FeatureConfiguration.NONE));

	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> HIVE_JELLY = FeatureUtils.register("hive_jelly", Feature.SIMPLE_BLOCK, (new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.HIVE_JELLY.get()))));

	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> WHITE_MOLD = FeatureUtils.register("white_mold", Feature.SIMPLE_BLOCK, (new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.WHITE_MOLD.get()))));
	
	public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> MOLD_PATCH = FeatureUtils.register("mold_patch", Feature.VEGETATION_PATCH, (new VegetationPatchConfiguration(DreamlandCustomTags.HIVE_ORES_REPLACEABLE.getName(), BlockStateProvider.simple(DreamlandBlocks.HIVE_BLOCK.get()), () -> {
	      return WHITE_MOLD.placed();
	   }, CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.5F, UniformInt.of(1, 3), 0.3F)));
	
	public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> HIVE_SLUDGE_PATCH = FeatureUtils.register("sludge_patch", Feature.VEGETATION_PATCH, (new VegetationPatchConfiguration(DreamlandCustomTags.HIVE_ORES_REPLACEABLE.getName(), BlockStateProvider.simple(DreamlandBlocks.HIVE_BLOCK.get()), () -> {
		return HIVE_SLUDGE.placed();
	}, CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 1.0F, ConstantInt.of(1), 0.3F)));
	
	public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> HIVE_PILLAR_PATCH = FeatureUtils.register("hive_pillar_patch", Feature.VEGETATION_PATCH, (new VegetationPatchConfiguration(DreamlandCustomTags.HIVE_ORES_REPLACEABLE.getName(), BlockStateProvider.simple(DreamlandBlocks.HIVE_BLOCK.get()), () -> {
		return HIVE_PILLAR.placed();
	}, CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 6, 1.0F, ConstantInt.of(1), 0.3F)));
	
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_IRON = FeatureUtils.register("hive_iron", Feature.ORE, (new OreConfiguration(HIVE_IRON_TARGET_LIST, 9)));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_GOLD = FeatureUtils.register("hive_gold", Feature.ORE, (new OreConfiguration(HIVE_GOLD_TARGET_LIST, 4, 0.5F)));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_REDSTONE = FeatureUtils.register("hive_redstone", Feature.ORE, (new OreConfiguration(HIVE_REDSTONE_TARGET_LIST, 8)));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_LAPIS = FeatureUtils.register("hive_lapis", Feature.ORE, (new OreConfiguration(HIVE_LAPIS_TARGET_LIST, 7)));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_COPPER = FeatureUtils.register("hive_copper", Feature.ORE, (new OreConfiguration(HIVE_COPPER_TARGET_LIST, 10)));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_COPPER_LARGE = FeatureUtils.register("hive_copper_large", Feature.ORE, (new OreConfiguration(HIVE_COPPER_TARGET_LIST, 20)));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_DIAMOND = FeatureUtils.register("hive_diamond", Feature.ORE, (new OreConfiguration(HIVE_DIAMOND_TARGET_LIST, 4, 0.5F)));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_DIAMOND_LARGE = FeatureUtils.register("hive_diamond_large", Feature.ORE, (new OreConfiguration(HIVE_DIAMOND_TARGET_LIST, 12, 0.7F)));
	
	private static void registerConfiguredFeature(String path, Holder<ConfiguredFeature<?,?>> feature) {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, DreamlandLoc.newLoc(path), feature);
	}
	
	public static void init() {
		registerConfiguredFeature("cave_slime", CAVE_SLIME);
		registerConfiguredFeature("hive_sludge", HIVE_SLUDGE);
		registerConfiguredFeature("hive_sludge_patch", HIVE_SLUDGE_PATCH);
		registerConfiguredFeature("hive_jelly", HIVE_JELLY);
		registerConfiguredFeature("white_mold", WHITE_MOLD);
		registerConfiguredFeature("mold_patch", MOLD_PATCH);
		registerConfiguredFeature("hive_pillar", HIVE_PILLAR);
		registerConfiguredFeature("hive_pillar_patch", HIVE_PILLAR_PATCH);
		
		registerConfiguredFeature("hive_iron", HIVE_IRON);
		registerConfiguredFeature("hive_copper", HIVE_COPPER);
		registerConfiguredFeature("hive_copper_large", HIVE_COPPER_LARGE);
		registerConfiguredFeature("hive_redstone", HIVE_REDSTONE);
		registerConfiguredFeature("hive_gold", HIVE_GOLD);
		registerConfiguredFeature("hive_lapis", HIVE_LAPIS);
		registerConfiguredFeature("hive_diamond", HIVE_DIAMOND);
		registerConfiguredFeature("hive_diamond_large", HIVE_DIAMOND_LARGE);
	 }
}
