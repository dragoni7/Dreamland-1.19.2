package com.github.dragoni7.dreamland.common.world.biome;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandParticles;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
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

    private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, BiomeSpecialEffects specialEffects, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temperature).downfall(downfall).specialEffects(specialEffects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
    }
    
    public static Biome midascaves() {
    	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        DreamlandBiomeFeatures.midascavesBiomeFeatures(biomeBuilder);
        
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 105, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        
        return biome(Biome.Precipitation.NONE, 0.7F, 0.0F, new BiomeSpecialEffects.Builder()
        		.grassColorOverride(13082890)
				.foliageColorOverride(13082890)
        		.waterColor(4789140)
        		.waterFogColor(4789140)
        		.fogColor(4789140)
        		.skyColor(calculateSkyColor(0.8F))
        		.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
        		.ambientParticle(new AmbientParticleSettings(DreamlandParticles.GOLD_GLITTER.get(), 0.001F))
        		.backgroundMusic(NORMAL_MUSIC)
        		.build(),
        		 spawnBuilder, biomeBuilder);
    }

    public static Biome hive() {	
    	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        
        globalOverworldGeneration(biomeBuilder);
        DreamlandBiomeFeatures.addHiveOres(biomeBuilder);
        DreamlandBiomeFeatures.hiveBiomeFeatures(biomeBuilder);
        
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DreamlandEntities.LARVA.get(), 35, 2, 4));
        
        return biome(Biome.Precipitation.NONE, 0.8F, 0.2F, new BiomeSpecialEffects.Builder()
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
    	
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DreamlandEntities.OOZE.get(), 25, 1, 2));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
    	
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
    	
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DreamlandEntities.BUMBLE_BEAST.get(), 13, 1, 1));
    	spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(DreamlandEntities.OPAL_SHELL.get(), 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 10, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 9, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
    	
    	return biome(Biome.Precipitation.RAIN, 0.6F, 0.6F, new BiomeSpecialEffects.Builder()
    			.grassColorOverride(14370147)
    			.waterColor(4751787)
    			.waterFogColor(4751787)
    			.fogColor(12875400)
    			.skyColor(12875400)
    			.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
    			.ambientParticle(new AmbientParticleSettings(DreamlandParticles.WHITE_POLLEN.get(), 0.00128F))
    			.backgroundMusic(NORMAL_MUSIC)
    			.build(),
    			spawnBuilder, biomeBuilder);
    }
    
    public static Biome toxicjungle() {
    	MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    	BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    	globalOverworldGeneration(biomeBuilder);
    	DreamlandBiomeFeatures.toxicJungleBiomeFeatures(biomeBuilder);
    	
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 110, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
    	spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
    	
    	return biome(Biome.Precipitation.RAIN, 0.95F, 0.9F, new BiomeSpecialEffects.Builder()
    			.grassColorOverride(7315624)
    			.waterColor(6280390)
    			.waterFogColor(6280390)
    			.fogColor(5880459)
    			.skyColor(9541304)
    			.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
    			.backgroundMusic(NORMAL_MUSIC)
    			.build(),
    			spawnBuilder, biomeBuilder);
    }
}
