package com.github.dragoni7.dreamland.core.registry;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.items.HiveJelly;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dreamland.MODID);
	
	//Items
	public static final RegistryObject<Item> HIVE_JELLY_ITEM = registerHiveJelly("hive_jelly", new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build());
	
	public static final RegistryObject<Item> TAR_BUCKET = ITEMS.register("tar_bucket", 
			() -> new BucketItem(DreamlandFluids.TAR_FLUID, new Item.Properties().tab(Dreamland.DreamlandTab).stacksTo(1)));
	
	//Spawn Eggs
	public static final RegistryObject<Item> SPAWN_EGG_LARVA = registerSpawnEgg("spawn_egg_larva", () -> DreamlandEntities.LARVA.get(), 0Xa9f8fc, 0X2c2870);
	public static final RegistryObject<Item> SPAWN_EGG_OOZE = registerSpawnEgg("spawn_egg_ooze", () -> DreamlandEntities.OOZE.get(), 0X262445, 0X494587);
	
	private static RegistryObject<Item> registerSpawnEgg(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
		return ITEMS.register(name, () -> new ForgeSpawnEggItem(type, backgroundColor, highlightColor, new Item.Properties().tab(Dreamland.DreamlandTab)));
	}
	
	@SuppressWarnings("unused")
	private static RegistryObject<Item> registerBasicItem(String name) {
		
		return ITEMS.register(name, () -> new Item(new Item.Properties().tab(Dreamland.DreamlandTab)));
	}
	
	@SuppressWarnings("unused")
	private static RegistryObject<Item> registerEdibleItem(String name, FoodProperties foodProperty) {
		
		return ITEMS.register(name, () -> new Item(new Item.Properties().tab(Dreamland.DreamlandTab).food(foodProperty)));
	}
	
	private static RegistryObject<Item> registerHiveJelly(String name, FoodProperties foodProperty) {
		
		return ITEMS.register(name, () -> new HiveJelly(new Item.Properties().tab(Dreamland.DreamlandTab).food(foodProperty).stacksTo(16)));
	}
}