package com.github.dragoni7.common.world.feature;

import com.github.dragoni7.common.world.feature.generation.HiveComb;
import com.github.dragoni7.common.world.feature.generation.HiveStrand;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandFeatures {
	
	public static final Feature<NoneFeatureConfiguration> HIVE_STRAND = new HiveStrand(NoneFeatureConfiguration.CODEC.stable());
	public static final Feature<BlockStateConfiguration> HIVE_COMB = new HiveComb(BlockStateConfiguration.CODEC.stable());

	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		registry.register(DreamlandFeatures.HIVE_STRAND.setRegistryName("hive_strand"));
		registry.register(DreamlandFeatures.HIVE_COMB.setRegistryName("hive_comb"));
	}
}
