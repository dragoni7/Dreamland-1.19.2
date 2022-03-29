package com.github.dragoni7.common.world.feature;

import com.github.dragoni7.common.world.feature.generation.HiveSpike;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandFeatures {
	
	public static final Feature<NoneFeatureConfiguration> HIVE_SPIKE = new HiveSpike(NoneFeatureConfiguration.CODEC.stable());

	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		registry.register(DreamlandFeatures.HIVE_SPIKE.setRegistryName("hive_spike"));
	}
}
