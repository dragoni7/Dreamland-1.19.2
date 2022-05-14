package com.github.dragoni7.dreamland.core;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.world.feature.generation.BorderedDisk;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveComb;
import com.github.dragoni7.dreamland.common.world.feature.generation.HiveStrand;
import com.github.dragoni7.dreamland.common.world.feature.generation.JoshuaTree;

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
	public static final Feature<BorderedDisk.Configuration> BORDERED_DISK = new BorderedDisk(BorderedDisk.Configuration.CODEC.stable());
	public static final Feature<NoneFeatureConfiguration> JOSHUA_TREE_FEATURE = new JoshuaTree(NoneFeatureConfiguration.CODEC.stable());

	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		registry.register(DreamlandFeatures.HIVE_STRAND.setRegistryName("hive_strand_feature"));
		registry.register(DreamlandFeatures.HIVE_COMB.setRegistryName("hive_comb_feature"));
		registry.register(DreamlandFeatures.BORDERED_DISK.setRegistryName("bordered_disk_feature"));
		registry.register(DreamlandFeatures.JOSHUA_TREE_FEATURE.setRegistryName("joshua_tree_feature"));
	}
}
