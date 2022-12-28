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
			helper.register(BiomeKeys.MIDAS_CAVES.location().getPath(), DreamlandOverworldBiomes.midasCaves());
			helper.register(BiomeKeys.HIVE.location().getPath(), DreamlandOverworldBiomes.hive());
			helper.register(BiomeKeys.TAR_DELTAS.location().getPath(), DreamlandOverworldBiomes.tarDeltas());
			helper.register(BiomeKeys.JEWELED_FOREST.location().getPath(), DreamlandOverworldBiomes.jeweledForest());
			helper.register(BiomeKeys.TOXIC_JUNGLE.location().getPath(), DreamlandOverworldBiomes.toxicJungle());
			helper.register(BiomeKeys.DAWNIC_FROSTFIELD.location().getPath(), DreamlandOverworldBiomes.dawnicFrostfield());
		});
	}

}
