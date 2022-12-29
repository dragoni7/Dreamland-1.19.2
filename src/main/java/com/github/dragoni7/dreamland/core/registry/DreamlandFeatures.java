package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.world.feature.generation.SurfaceLake;
import com.github.dragoni7.dreamland.common.world.feature.configs.ConeConfig;
import com.github.dragoni7.dreamland.common.world.feature.configs.EllipsoidConfig;
import com.github.dragoni7.dreamland.common.world.feature.configs.GrowthLayerConfig;
import com.github.dragoni7.dreamland.common.world.feature.configs.HillConfig;
import com.github.dragoni7.dreamland.common.world.feature.configs.SphereConfig;
import com.github.dragoni7.dreamland.common.world.feature.configs.StarConfig;
import com.github.dragoni7.dreamland.common.world.feature.generation.Cone;
import com.github.dragoni7.dreamland.common.world.feature.generation.Ellipsoid;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveComb;
import com.github.dragoni7.dreamland.common.world.feature.generation.GrowthLayer;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveStrand;
import com.github.dragoni7.dreamland.common.world.feature.generation.MoldGrowth;
import com.github.dragoni7.dreamland.common.world.feature.generation.MoldPuffTree;
import com.github.dragoni7.dreamland.common.world.feature.generation.MoldWoodRoots;
import com.github.dragoni7.dreamland.common.world.feature.generation.MoldWoodTree;
import com.github.dragoni7.dreamland.common.world.feature.generation.OpalCluster;
import com.github.dragoni7.dreamland.common.world.feature.generation.PlumBirchTree;
import com.github.dragoni7.dreamland.common.world.feature.generation.Sphere;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarBarkTree;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarBone;
import com.github.dragoni7.dreamland.common.world.feature.generation.Hill;
import com.github.dragoni7.dreamland.common.world.feature.generation.TarSkeleton;
import com.github.dragoni7.dreamland.common.world.feature.generation.FrostStar;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Dreamland.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandFeatures {
	
	public static final Feature<NoneFeatureConfiguration> HIVE_STRAND = new HiveStrand(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<BlockStateConfiguration> HIVE_COMB = new HiveComb(BlockStateConfiguration.CODEC.stable());
	public static final Feature<GrowthLayerConfig> GROWTH_LAYER = new GrowthLayer(GrowthLayerConfig.CODEC.stable());
	
	public static final Feature<SurfaceLake.Configuration> SURFACE_LAKE = new SurfaceLake(SurfaceLake.Configuration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_BARK_TREE_FEATURE = new TarBarkTree(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_SKELETON = new TarSkeleton(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> TAR_BONE = new TarBone(NoneFeatureConfiguration.CODEC.stable());
	
	public static final Feature<NoneFeatureConfiguration> PLUM_BIRCH_TREE_FEATURE = new PlumBirchTree(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> OPAL_CLUSTER = new OpalCluster(NoneFeatureConfiguration.CODEC.stable());
	
	public static final Feature<HillConfig> NOISE_HILL = new Hill(HillConfig.CODEC.stable());
	public static final Feature<EllipsoidConfig> ELLIPSOID = new Ellipsoid(EllipsoidConfig.CODEC.stable());
	public static final Feature<ConeConfig> NOISE_CONE = new Cone(ConeConfig.CODEC.stable());
	public static final Feature<SphereConfig> NOISE_SPHERE = new Sphere(SphereConfig.CODEC.stable());
	public static final Feature<StarConfig> FROST_STAR = new FrostStar(StarConfig.CODEC.stable());
	
	public static final Feature<SimpleBlockConfiguration> MOLD_PUFF_TREE = new MoldPuffTree(SimpleBlockConfiguration.CODEC.stable());
	public static final Feature<SimpleBlockConfiguration> MOLD_GROWTH = new MoldGrowth(SimpleBlockConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> MOLD_WOOD_ROOTS = new MoldWoodRoots(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> MOLD_WOOD_TREE = new MoldWoodTree(NoneFeatureConfiguration.CODEC.stable());
	
	@SubscribeEvent
	public static void onRegisterEvent(RegisterEvent event) {
		
		event.register(ForgeRegistries.Keys.FEATURES, helper -> {
			helper.register("hive_strand_feature", DreamlandFeatures.HIVE_STRAND);
			helper.register("hive_comb_feature", DreamlandFeatures.HIVE_COMB);
			helper.register("hive_growth_layer", DreamlandFeatures.GROWTH_LAYER);
			helper.register("surface_lake_feature", DreamlandFeatures.SURFACE_LAKE);
			helper.register("tar_bark_tree_feature", DreamlandFeatures.TAR_BARK_TREE_FEATURE);
			helper.register("tar_skeleton", DreamlandFeatures.TAR_SKELETON);
			helper.register("tar_bone", DreamlandFeatures.TAR_BONE);
			helper.register("noise_hill", DreamlandFeatures.NOISE_HILL);
			helper.register("plum_birch_tree", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE);
			helper.register("ellipsoid", DreamlandFeatures.ELLIPSOID);
			helper.register("noise_cone", DreamlandFeatures.NOISE_CONE);
			helper.register("opal_cluster", DreamlandFeatures.OPAL_CLUSTER);
			helper.register("sphere", DreamlandFeatures.NOISE_SPHERE);
			helper.register("mold_puff_tree", DreamlandFeatures.MOLD_PUFF_TREE);
			helper.register("mold_growth", DreamlandFeatures.MOLD_GROWTH);
			helper.register("mold_wood_roots", DreamlandFeatures.MOLD_WOOD_ROOTS);
			helper.register("mold_wood_tree", DreamlandFeatures.MOLD_WOOD_TREE);
			helper.register("frost_star", DreamlandFeatures.FROST_STAR);
			
		});
	}
}
