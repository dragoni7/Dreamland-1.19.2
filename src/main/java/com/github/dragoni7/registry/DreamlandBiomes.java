package com.github.dragoni7.registry;

import com.github.dragoni7.worldgen.BiomeKeys;
import com.github.dragoni7.worldgen.DreamlandOverworldBiomes;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandBiomes {
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		
		IForgeRegistry<Biome> registry = event.getRegistry();
		registry.register(DreamlandOverworldBiomes.hive().setRegistryName(BiomeKeys.HIVE.location()));
		registry.register(DreamlandOverworldBiomes.coldBlue().setRegistryName(BiomeKeys.COLD_BLUE.location()));
	}

}
