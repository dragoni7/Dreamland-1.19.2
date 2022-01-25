package com.github.dragoni7.worldgen;

import com.github.dragoni7.Dreamland;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BiomeKeys {
	
	public static final ResourceKey<Biome> HOT_RED = register("hot_red");
	public static final ResourceKey<Biome> COLD_BLUE = register("cold_blue");

	private static ResourceKey<Biome> register(String name) {
		
		return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Dreamland.MODID, name));
	}

}
