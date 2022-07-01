package com.github.dragoni7.dreamland;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber
public class Config {

	public static final String CATEGORY_GENERAL = "general";
	public static final String CATEGORY_SPAWNING = "spawning";
	public static final String CATEGORY_MOBS = "mobs";
	public static final String CATEGORY_MISC = "misc";
	
	public static ForgeConfigSpec.IntValue REGION_WEIGHT;
	
	public static ForgeConfigSpec.IntValue LARVA_EXTRA_ROLL;
	public static ForgeConfigSpec.IntValue OOZE_EXTRA_ROLL;
	public static ForgeConfigSpec.IntValue BUMBLE_BEAST_EXTRA_ROLL;
	public static ForgeConfigSpec.IntValue OPAL_SHELL_EXTRA_ROLL;
	
	public static ForgeConfigSpec.DoubleValue LARVA_DAMAGE;
	public static ForgeConfigSpec.DoubleValue OOZE_DAMAGE;
	public static ForgeConfigSpec.DoubleValue BUMBLE_BEAST_DAMAGE;
	public static ForgeConfigSpec.DoubleValue LARVA_HEALTH;
	public static ForgeConfigSpec.DoubleValue OOZE_HEALTH;
	public static ForgeConfigSpec.DoubleValue BUMBLE_BEAST_HEALTH;
	public static ForgeConfigSpec.DoubleValue OPAL_SHELL_HEALTH;
	
	public static ForgeConfigSpec.IntValue ANTAGONIZED_DURATION;
	
	public static ForgeConfigSpec SERVER_CONFIG;
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;
	
	
	static {
		ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
		
		COMMON_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
		REGION_WEIGHT = COMMON_BUILDER.comment("dreamland region weight (smaller values means more common). Default = 2").defineInRange("weight", 2, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();
		COMMON_BUILDER.comment("Spawn Settings").push(CATEGORY_SPAWNING);
		COMMON_BUILDER.comment("Note: higher spawn roll = lower chance to spawn");
		LARVA_EXTRA_ROLL = COMMON_BUILDER.comment("Larva extra spawn roll amount. Default = 2").defineInRange("spawn roll", 2, 0, Integer.MAX_VALUE);
		OOZE_EXTRA_ROLL = COMMON_BUILDER.comment("Ooze extra spawn roll amount. Default = 2").defineInRange("spawn roll", 2, 0, Integer.MAX_VALUE);
		BUMBLE_BEAST_EXTRA_ROLL = COMMON_BUILDER.comment("Bumble Beast extra spawn roll amount. Default = 2").defineInRange("spawn roll", 2, 0, Integer.MAX_VALUE);
		OPAL_SHELL_EXTRA_ROLL = COMMON_BUILDER.comment("Opal Shell extra spawn roll amount. Default = 1").defineInRange("spawn roll", 1, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();
		COMMON_BUILDER.comment("Mob Attributes").push(CATEGORY_MOBS);
		LARVA_DAMAGE = COMMON_BUILDER.comment("Larva damage. Default = 1.5").defineInRange("damage", 1.5, 0, Integer.MAX_VALUE);
		LARVA_HEALTH = COMMON_BUILDER.comment("Larva health. Default = 8.0").defineInRange("health", 8.0, 0, Integer.MAX_VALUE);
		OOZE_DAMAGE = COMMON_BUILDER.comment("Ooze damage. Default = 1.0").defineInRange("damage", 1.0, 0, Integer.MAX_VALUE);
		OOZE_HEALTH = COMMON_BUILDER.comment("Ooze health. Default = 20.0").defineInRange("health", 20.0, 0, Integer.MAX_VALUE);
		BUMBLE_BEAST_DAMAGE = COMMON_BUILDER.comment("Bumble Beast damage. Default = 5.0").defineInRange("damage", 5.0, 0, Integer.MAX_VALUE);
		BUMBLE_BEAST_HEALTH = COMMON_BUILDER.comment("Bumble Beast health. Default = 40.0").defineInRange("health", 40.0, 0, Integer.MAX_VALUE);
		OPAL_SHELL_HEALTH = COMMON_BUILDER.comment("Opal Shell health. Default = 15.0").defineInRange("health", 15.0, 0, Integer.MAX_VALUE);
		COMMON_BUILDER.pop();
		COMMON_BUILDER.comment("Misc").push(CATEGORY_MISC);
		ANTAGONIZED_DURATION = COMMON_BUILDER.comment("Duration the antagonized effect is applied for. Default 200 ticks. Note: 20 ticks = 1 sec").defineInRange("duration", 200, 0, Integer.MAX_VALUE);
		
		COMMON_BUILDER.pop();
		COMMON_CONFIG = COMMON_BUILDER.build();
	}
	
	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		
	}
	
	@SubscribeEvent
	public static void onReload(final ModConfigEvent.Reloading configEvent) {
		
	}
}
