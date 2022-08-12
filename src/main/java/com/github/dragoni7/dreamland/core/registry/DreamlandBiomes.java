package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.github.dragoni7.dreamland.common.world.biome.DreamlandOverworldBiomes;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = Dreamland.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandBiomes {
	
	@SubscribeEvent
	public static void onRegisterEvent(RegisterEvent event) {
		
		event.register(ForgeRegistries.Keys.BIOMES, helper -> {
			helper.register(BiomeKeys.MIDAS_CAVES.location().getPath(), DreamlandOverworldBiomes.midascaves());
			helper.register(BiomeKeys.HIVE.location().getPath(), DreamlandOverworldBiomes.hive());
			helper.register(BiomeKeys.TAR_DELTAS.location().getPath(), DreamlandOverworldBiomes.tardeltas());
			helper.register(BiomeKeys.JEWELED_FOREST.location().getPath(), DreamlandOverworldBiomes.jeweledforest());
		});
	}

}
