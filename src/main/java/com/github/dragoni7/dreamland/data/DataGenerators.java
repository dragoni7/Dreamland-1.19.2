package com.github.dragoni7.dreamland.data;

import java.io.IOException;
import java.nio.file.Path;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.github.dragoni7.dreamland.common.world.feature.DreamlandConfiguredFeatures;
import com.github.dragoni7.dreamland.common.world.feature.DreamlandFeaturePlacements;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		Path outputFolder = generator.getOutputFolder();
		RegistryAccess registries = RegistryAccess.builtinCopy();
		RegistryOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, registries);
		Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.create();
		
		if (event.includeServer()) {
			generator.addProvider(true, new DreamlandRecipes(generator));
			generator.addProvider(true, new DreamlandLootTables(generator));
			BlockTagsProvider blocks = new BlockTagsProvider(generator, Dreamland.MODID, fileHelper);
	        generator.addProvider(true, new AddBlockTags(generator, fileHelper));
	        generator.addProvider(true, new AddFluidTags(generator, fileHelper));
	        generator.addProvider(true, new AddItemTags(generator, blocks, fileHelper));
	        generator.addProvider(true, new AddBiomeTags(generator, fileHelper));
	        
	        for (ResourceKey<ConfiguredFeature<?,?>> key : DreamlandConfiguredFeatures.getKeys()) {
	        	generator.addProvider(true, makeBuiltinRegistryProvider(Dreamland.MODID, outputFolder, gson, ops, registries, Registry.CONFIGURED_FEATURE_REGISTRY, ConfiguredFeature.DIRECT_CODEC, 
						key));
	        }
	        
	        for (ResourceKey<PlacedFeature> key : DreamlandFeaturePlacements.getKeys()) {
	        	generator.addProvider(true, makeBuiltinRegistryProvider(Dreamland.MODID, outputFolder, gson, ops, registries, Registry.PLACED_FEATURE_REGISTRY, PlacedFeature.DIRECT_CODEC,
						key));
	        }
	        
	        for (ResourceKey<Biome> key : BiomeKeys.getAllKeys()) {
	        	generator.addProvider(true, makeBuiltinRegistryProvider(Dreamland.MODID, outputFolder, gson, ops, registries, Registry.BIOME_REGISTRY, Biome.DIRECT_CODEC,
						key));
	        }
	        
		}
		
		if(event.includeClient()) {
			generator.addProvider(true, new DreamlandBlockStates(generator, Dreamland.MODID, fileHelper));
			generator.addProvider(true, new DreamlandItemModels(generator, Dreamland.MODID, fileHelper));
			generator.addProvider(true, new DreamlandLanguageProvider(generator,"en_us"));
			
		}
		
		
        
	}

	// Author: Commoble
	// Source: https://gist.github.com/Commoble/458506bbae386dac9432c77b3f8fe7f1
	@SafeVarargs
	private static <T> DataProvider makeBuiltinRegistryProvider(String modid, Path outputFolder, Gson gson, RegistryOps<JsonElement> ops, RegistryAccess registries, ResourceKey<Registry<T>> registryKey, Codec<T> codec, ResourceKey<T>... keys)
	{
		return new DataProvider()
		{
			@Override
			public void run(CachedOutput cache) throws IOException
			{
				Registry<T> registry = registries.registryOrThrow(registryKey);
				for (ResourceKey<T> key : keys)
				{
					ResourceLocation id = key.location();
					Path path = outputFolder.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), id.getNamespace(), registryKey.location().getPath(), id.getPath()+".json"));
					
					T t = registry.getOrThrow(key);
					codec.encodeStart(ops, t)
						.resultOrPartial(msg -> Dreamland.LOGGER.error("Failed to encode {}: {}", path, msg))
						.ifPresent(json -> {
							try
							{
								DataProvider.saveStable(cache, json, path);
							}
							catch (IOException e)
							{
								e.printStackTrace();
							}
						});
				}
			}

			@Override
			public String getName()
			{
				return modid + " " + registryKey.location().toString();
			}
		};
	}
}
