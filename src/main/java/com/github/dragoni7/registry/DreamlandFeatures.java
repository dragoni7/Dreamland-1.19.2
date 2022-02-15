package com.github.dragoni7.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.common.world.feature.HiveSpikeFeature;
import com.github.dragoni7.util.RegistryObject;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//Credits to potionstudios, BYG.
public class DreamlandFeatures {
	
	public static List<RegistryObject<Feature<?>>> FEATURES = new ArrayList<>();
	
	//public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Dreamland.MODID);

	//public static final RegistryObject <Feature<NoneFeatureConfiguration>> HIVE_SPIKE = FEATURES.register("hive_spike", () -> new HiveSpikeFeature(NoneFeatureConfiguration.CODEC.stable()));

	public static final Feature<NoneFeatureConfiguration> HIVE_SPIKE = register("hive_spike", new HiveSpikeFeature(NoneFeatureConfiguration.CODEC.stable()));
	private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String name, F feature) {
		DreamlandFeatures.FEATURES.add(new RegistryObject<>(feature,name));
		return feature;
	}
	
	public static void init(Consumer<Collection<RegistryObject<Feature<?>>>> registryStrategy) {
		registryStrategy.accept(FEATURES);
	}
	
	public static Collection<RegistryObject<Feature<?>>> init() {
		return FEATURES;
	}
}
