package com.github.dragoni7.dreamland.common.world.biome;

import java.util.ArrayList;

import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeKeys {
	private static final ArrayList<ResourceKey<Biome>> KEYS = new ArrayList<ResourceKey<Biome>>();
	
	public static final ResourceKey<Biome> MIDAS_CAVES = registerBiome("midas_caves");
	public static final ResourceKey<Biome> HIVE = registerBiome("hive");
	public static final ResourceKey<Biome> TAR_DELTAS = registerBiome("tar_deltas");
	public static final ResourceKey<Biome> JEWELED_FOREST = registerBiome("jeweled_forest");
	public static final ResourceKey<Biome> TOXIC_JUNGLE = registerBiome("toxic_jungle");
	
	public static ArrayList<ResourceKey<Biome>> getAllKeys() {
		return KEYS;
	}
	
	private static ResourceKey<Biome> registerBiome(String name) {
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, DreamlandLoc.createLoc(name));
		KEYS.add(key);
		return key;
	}
}
