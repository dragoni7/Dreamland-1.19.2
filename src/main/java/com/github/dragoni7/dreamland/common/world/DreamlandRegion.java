package com.github.dragoni7.dreamland.common.world;

import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class DreamlandRegion extends Region
{

    public DreamlandRegion(ResourceLocation name, RegionType type, int weight) {
		super(name, type, weight);
	}
    
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
    	this.addModifiedVanillaOverworldBiomes(mapper, builder -> { 
    		builder.replaceBiome(Biomes.DRIPSTONE_CAVES, BiomeKeys.HIVE);
    		builder.replaceBiome(Biomes.FLOWER_FOREST, BiomeKeys.GARDEN);
    		builder.replaceBiome(Biomes.FOREST, BiomeKeys.GARDEN);
    		builder.replaceBiome(Biomes.DESERT, BiomeKeys.TARLANDS);
    	});
    }
}