package com.github.dragoni7.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.common.world.biome.BiomeKeys;
import com.github.dragoni7.common.world.biome.DreamlandOverworldBiomes;
import com.github.dragoni7.util.DreamlandLoc;
import com.github.dragoni7.util.RegistryObject;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
//Credits to potionstudios, BYG.
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandBiomes {
	
	
	  public static final List<RegistryObject<Biome>> BIOMES = new ArrayList<RegistryObject<Biome>>();
	  
	  public static ResourceKey<Biome> HIVE = createBiome("hive", DreamlandOverworldBiomes.hive());
	  
	  public static ResourceKey<Biome> COLD_BLUE = createBiome("cold_blue", DreamlandOverworldBiomes.coldBlue());
	  
	  public static ResourceKey<Biome> createBiome(String name, Biome biome) {
		  
		  BIOMES.add(new RegistryObject<>(biome, name));
	  
		  return ResourceKey.create(Registry.BIOME_REGISTRY, DreamlandLoc.newLoc(name)); 
	  
	  }
	  
	  public static void init(Consumer<Collection<RegistryObject<Biome>>> registryStrategy) {
		  registryStrategy.accept(BIOMES);
	  }
	  public static Collection<RegistryObject<Biome>> init() {
		  return BIOMES;
	  }
		/*
		 * @SubscribeEvent public static void
		 * registerBiomes(RegistryEvent.Register<Biome> event) {
		 * 
		 * IForgeRegistry<Biome> registry = event.getRegistry();
		 * registry.register(DreamlandOverworldBiomes.hive().setRegistryName(BiomeKeys.
		 * HIVE.location()));
		 * registry.register(DreamlandOverworldBiomes.coldBlue().setRegistryName(
		 * BiomeKeys.COLD_BLUE.location())); }
		 */

}
