package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.github.dragoni7.dreamland.common.world.biome.DreamlandOverworldBiomes;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Dreamland.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandBiomes {
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		IForgeRegistry<Biome> registry = event.getRegistry();
		registry.register(DreamlandOverworldBiomes.hive().setRegistryName(BiomeKeys.HIVE.location()));
		registry.register(DreamlandOverworldBiomes.tardeltas().setRegistryName(BiomeKeys.TAR_DELTAS.location()));
		registry.register(DreamlandOverworldBiomes.jeweledforest().setRegistryName(BiomeKeys.JEWELED_FOREST.location()));
	}

}
