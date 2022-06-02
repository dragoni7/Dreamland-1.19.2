package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.world.feature.generation.SurfaceLake;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveComb;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveStrand;
import com.github.dragoni7.dreamland.common.world.feature.generation.PlumBirchTree;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarBarkTree;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarBone;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarSkeleton;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Dreamland.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandFeatures {
	
	public static final Feature<NoneFeatureConfiguration> HIVE_STRAND = new HiveStrand(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<BlockStateConfiguration> HIVE_COMB = new HiveComb(BlockStateConfiguration.CODEC.stable());
	public static final Feature<SurfaceLake.Configuration> SURFACE_LAKE = new SurfaceLake(SurfaceLake.Configuration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_BARK_TREE_FEATURE = new TarBarkTree(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_SKELETON = new TarSkeleton(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_BONE = new TarBone(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> PLUM_BIRCH_TREE_FEATURE = new PlumBirchTree(NoneFeatureConfiguration.CODEC.stable());

	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		registry.register(DreamlandFeatures.HIVE_STRAND.setRegistryName("hive_strand_feature"));
		registry.register(DreamlandFeatures.HIVE_COMB.setRegistryName("hive_comb_feature"));
		registry.register(DreamlandFeatures.SURFACE_LAKE.setRegistryName("surface_lake_feature"));
		registry.register(DreamlandFeatures.TAR_BARK_TREE_FEATURE.setRegistryName("tar_bark_tree_feature"));
		registry.register(DreamlandFeatures.TAR_SKELETON.setRegistryName("tar_skeleton"));
		registry.register(DreamlandFeatures.TAR_BONE.setRegistryName("tar_bone"));
		registry.register(DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE.setRegistryName("plum_birch_tree"));
	}
}
