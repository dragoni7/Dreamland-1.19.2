package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.world.feature.generation.SurfaceLake;
import com.github.dragoni7.dreamland.common.world.feature.configs.EllipsoidConfig;
import com.github.dragoni7.dreamland.common.world.feature.generation.Ellipsoid;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveComb;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveGrowthLayer;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveStrand;
import com.github.dragoni7.dreamland.common.world.feature.generation.OpalCluster;
import com.github.dragoni7.dreamland.common.world.feature.generation.PlumBirchTree;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarBarkTree;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarBone;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarSkeleton;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = Dreamland.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandFeatures {
	
	public static final Feature<NoneFeatureConfiguration> HIVE_STRAND = new HiveStrand(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<BlockStateConfiguration> HIVE_COMB = new HiveComb(BlockStateConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> HIVE_GROWTH_LAYER = new HiveGrowthLayer(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<SurfaceLake.Configuration> SURFACE_LAKE = new SurfaceLake(SurfaceLake.Configuration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_BARK_TREE_FEATURE = new TarBarkTree(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_SKELETON = new TarSkeleton(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_BONE = new TarBone(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> PLUM_BIRCH_TREE_FEATURE = new PlumBirchTree(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<EllipsoidConfig> ELLIPSOID = new Ellipsoid(EllipsoidConfig.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> OPAL_CLUSTER = new OpalCluster(NoneFeatureConfiguration.CODEC.stable());
	
	@SubscribeEvent
	public static void onRegisterEvent(RegisterEvent event) {
		
		event.register(ForgeRegistries.Keys.FEATURES, helper -> {
			helper.register("hive_strand_feature", DreamlandFeatures.HIVE_STRAND);
			helper.register("hive_comb_feature", DreamlandFeatures.HIVE_COMB);
			helper.register("hive_growth_layer", DreamlandFeatures.HIVE_GROWTH_LAYER);
			helper.register("surface_lake_feature", DreamlandFeatures.SURFACE_LAKE);
			helper.register("tar_bark_tree_feature", DreamlandFeatures.TAR_BARK_TREE_FEATURE);
			helper.register("tar_skeleton", DreamlandFeatures.TAR_SKELETON);
			helper.register("tar_bone", DreamlandFeatures.TAR_BONE);
			helper.register("plum_birch_tree", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE);
			helper.register("ellipsoid", DreamlandFeatures.ELLIPSOID);
			helper.register("opal_cluster", DreamlandFeatures.OPAL_CLUSTER);
			
		});
	}
}
