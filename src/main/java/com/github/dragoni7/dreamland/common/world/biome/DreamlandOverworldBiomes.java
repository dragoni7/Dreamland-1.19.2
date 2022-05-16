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

    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return biome(precipitation, category, temperature, downfall, 4159204, 329011, spawnBuilder, biomeBuilder, music);
    }
    
    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(category).temperature(temperature).downfall(downfall).specialEffects(new BiomeSpecialEffects.Builder().waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static Biome biomeWithEffects(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, BiomeSpecialEffects specialEffects, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(category).temperature(temperature).downfall(downfall).specialEffects(specialEffects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
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
    {	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        
        globalOverworldGeneration(biomeBuilder);
        DreamlandBiomeFeatures.addHiveOres(biomeBuilder);
        DreamlandBiomeFeatures.hiveBiomeFeatures(biomeBuilder);
        
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DreamlandEntities.LARVA.get(), 1, 1, 1));
        
        return biomeWithEffects(Biome.Precipitation.NONE, Biome.BiomeCategory.UNDERGROUND, 2.0F, 0.0F, new BiomeSpecialEffects.Builder()
        																										.waterColor(12511438)
        																										.waterFogColor(9680288)
        																										.fogColor(12638463)
        																										.skyColor(calculateSkyColor(2.0F))
        																										.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        																										.backgroundMusic(NORMAL_MUSIC)
        																										.build(),
        																										spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }
    
    public static Biome garden()  {
    	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    	BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    	globalOverworldGeneration(biomeBuilder);
    	DreamlandBiomeFeatures.gardenBiomeFeatures(biomeBuilder);
    	
    	return biomeWithEffects(Biome.Precipitation.RAIN, Biome.BiomeCategory.PLAINS, 0.9F, 1.0F, new BiomeSpecialEffects.Builder()
    																										.grassColorOverride(4896062)
    																										.waterColor(14417910)
    																										.waterFogColor(12245457)
    																										.fogColor(10998201)
    																										.skyColor(calculateSkyColor(2.0F))
    																										.backgroundMusic(NORMAL_MUSIC)
    																										.build(),
    																										spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    	
    }
    
    public static Biome tarlands() {
    	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    	BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    	globalOverworldGeneration(biomeBuilder);
    	DreamlandBiomeFeatures.tarlandsBiomeFeatures(biomeBuilder);
    	
    	return biomeWithEffects(Biome.Precipitation.NONE, Biome.BiomeCategory.DESERT, 2.0F, 0.0F, new BiomeSpecialEffects.Builder()
				.grassColorOverride(11334212)
				.waterColor(4751787)
				.waterFogColor(4751787)
				.fogColor(12638463)
				.skyColor(calculateSkyColor(2.0F))
				.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
				.backgroundMusic(NORMAL_MUSIC)
				.build(),
				spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }
}
