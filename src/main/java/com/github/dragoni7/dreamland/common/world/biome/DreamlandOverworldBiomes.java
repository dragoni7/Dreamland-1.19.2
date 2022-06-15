package com.github.dragoni7.dreamland.common.world.biome;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

public class DreamlandOverworldBiomes {

	@Nullable
    private static final Music NORMAL_MUSIC = null;

    protected static int calculateSkyColor(float color)
    {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, BiomeSpecialEffects specialEffects, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder)
    {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temperature).downfall(downfall).specialEffects(specialEffects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder)
    {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
    }

    public static Biome hive()
    {	
    	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        
        globalOverworldGeneration(biomeBuilder);
        DreamlandBiomeFeatures.addHiveOres(biomeBuilder);
        DreamlandBiomeFeatures.hiveBiomeFeatures(biomeBuilder);
        
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DreamlandEntities.LARVA.get(), 20, 1, 2));
        
        return biome(Biome.Precipitation.NONE, 0.8F, 0.0F, new BiomeSpecialEffects.Builder()
        		.waterColor(12511438)
        		.waterFogColor(9680288)
        		.fogColor(12638463)
        		.skyColor(calculateSkyColor(0.8F))
        		.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        		.backgroundMusic(NORMAL_MUSIC)
        		.build(),
        		 spawnBuilder, biomeBuilder);
    }
    
    public static Biome tardeltas() {
    	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    	BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    	globalOverworldGeneration(biomeBuilder);
    	DreamlandBiomeFeatures.tardeltasBiomeFeatures(biomeBuilder);
    	
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DreamlandEntities.OOZE.get(), 7, 1, 1));
    	
    	return biome(Biome.Precipitation.NONE, 2.0F, 0.0F, new BiomeSpecialEffects.Builder()
				.grassColorOverride(11334212)
				.foliageColorOverride(11334212)
				.waterColor(3604469)
				.waterFogColor(3604469)
				.fogColor(12559221)
				.skyColor(12559221)
				.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
				.backgroundMusic(NORMAL_MUSIC)
				.build(),
				spawnBuilder, biomeBuilder);
    }
    
    public static Biome jeweledforest() {
    	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    	BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    	globalOverworldGeneration(biomeBuilder);
    	DreamlandBiomeFeatures.jeweledForestBiomeFeatures(biomeBuilder);
    	
    	return biome(Biome.Precipitation.RAIN, 0.9F, 1.0F, new BiomeSpecialEffects.Builder()
    			.grassColorOverride(14370147)
    			.waterColor(4751787)
    			.waterFogColor(4751787)
    			.fogColor(12875400)
    			.skyColor(12875400)
    			.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
    			.backgroundMusic(NORMAL_MUSIC)
    			.build(),
    			spawnBuilder, biomeBuilder);
    }
}
