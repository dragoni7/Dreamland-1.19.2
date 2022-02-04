package com.github.dragoni7.worldgen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.SurfaceRules;
import terrablender.api.BiomeProvider;
import terrablender.api.ParameterUtils.Depth;
import terrablender.api.ParameterUtils.ParameterPointListBuilder;
import terrablender.worldgen.TBClimate;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class DreamlandBiomeProvider extends BiomeProvider
{
    public DreamlandBiomeProvider(ResourceLocation name, int overworldWeight)
    {
        super(name, overworldWeight);
    }

    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
    	
    	this.addBiomeSimilar(mapper, Biomes.DRIPSTONE_CAVES, BiomeKeys.HIVE);
    	
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
        	
			
			  List<Climate.ParameterPoint> frozenPeaksPoints = new
			  ParameterPointListBuilder() .temperature(Temperature.ICY, Temperature.COOL,
			  Temperature.NEUTRAL) .humidity(Humidity.ARID, Humidity.DRY, Humidity.NEUTRAL,
			  Humidity.WET, Humidity.HUMID)
			  .continentalness(Continentalness.span(Continentalness.COAST,
			  Continentalness.FAR_INLAND), Continentalness.span(Continentalness.MID_INLAND,
			  Continentalness.FAR_INLAND)) .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
			  .depth(Depth.UNDERGROUND) .weirdness(Weirdness.HIGH_SLICE_VARIANT_ASCENDING,
			  Weirdness.HIGH_SLICE_VARIANT_DESCENDING) .buildVanilla();
			  
			  frozenPeaksPoints.forEach(point -> builder.replaceBiome(point,
			  BiomeKeys.COLD_BLUE));
        });
    }

    @Override
    public Optional<SurfaceRules.RuleSource> getOverworldSurfaceRules()
    {
        return Optional.of(DreamlandSurfaceRules.makeRules());
    }
}