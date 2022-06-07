package com.github.dragoni7.dreamland.core;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber
public class Config {

	public static final String CATEGORY_GENERAL = "general";
	public static final String CATEGORY_SPAWNING = "spawning";
	
	public static ForgeConfigSpec.IntValue REGION_WEIGHT;
	
	public static ForgeConfigSpec SERVER_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;
	
	
	static {
		
		ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
		ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
		
		SERVER_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
		REGION_WEIGHT = SERVER_BUILDER.comment("dreamland region weight (smaller values means more common). Default = 2").defineInRange("weight", 2, 0, Integer.MAX_VALUE);
		SERVER_BUILDER.comment("Spawn Settings").push(CATEGORY_SPAWNING);
		
		SERVER_BUILDER.pop();
		
		SERVER_CONFIG = SERVER_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
	
	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		
	}
	
	@SubscribeEvent
	public static void onReload(final ModConfigEvent.Reloading configEvent) {
		
	}
}
