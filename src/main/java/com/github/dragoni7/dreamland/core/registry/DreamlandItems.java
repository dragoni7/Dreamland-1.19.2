package com.github.dragoni7.dreamland.core.registry;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.items.HiveJellyItem;
import com.github.dragoni7.dreamland.common.items.LarvaSymbioteArmorItem;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dreamland.MODID);
	
	//Items
	public static final RegistryObject<Item> HIVE_JELLY_ITEM = registerHiveJelly("hive_jelly", new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build());
	
	public static final RegistryObject<Item> TAR_BUCKET = ITEMS.register("tar_bucket", 
			() -> new BucketItem(DreamlandFluids.TAR_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).tab(Dreamland.DreamlandTab).stacksTo(1)));
	
	public static final RegistryObject<Item> OPAL = registerBasicItem("opal");
	public static final RegistryObject<Item> PRECIOUS_OPAL = registerBasicItem("precious_opal");
	
	//Armor
	public static final RegistryObject<Item> LARVA_HELMET = ITEMS.register("larva_symbiote",
			() -> new LarvaSymbioteArmorItem(DreamlandArmorMaterials.LARVA, EquipmentSlot.HEAD, new Item.Properties().rarity(Rarity.RARE).tab(Dreamland.DreamlandTab)));
	
	//Spawn Eggs
	public static final RegistryObject<Item> SPAWN_EGG_LARVA = registerSpawnEgg("spawn_egg_larva", () -> DreamlandEntities.LARVA.get(), 0Xa9f8fc, 0X2c2870);
	public static final RegistryObject<Item> SPAWN_EGG_OOZE = registerSpawnEgg("spawn_egg_ooze", () -> DreamlandEntities.OOZE.get(), 0X262445, 0X494587);
	public static final RegistryObject<Item> SPAWN_EGG_OPAL_SHELL = registerSpawnEgg("spawn_egg_opal_shell", () -> DreamlandEntities.OPAL_SHELL.get(), 0X2d595c, 0Xad1d1d);
	public static final RegistryObject<Item> SPAWN_EGG_BUMBLE_BEAST = registerSpawnEgg("spawn_egg_bumble_beast", () -> DreamlandEntities.BUMBLE_BEAST.get(), 0Xc7b922, 0X292609);
	private static RegistryObject<Item> registerSpawnEgg(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
		return ITEMS.register(name, () -> new ForgeSpawnEggItem(type, backgroundColor, highlightColor, new Item.Properties().tab(Dreamland.DreamlandTab)));
	}
	
	private static RegistryObject<Item> registerBasicItem(String name) {
		
		return ITEMS.register(name, () -> new Item(new Item.Properties().tab(Dreamland.DreamlandTab)));
	}
	
	@SuppressWarnings("unused")
	private static RegistryObject<Item> registerEdibleItem(String name, FoodProperties foodProperty) {
		
		return ITEMS.register(name, () -> new Item(new Item.Properties().tab(Dreamland.DreamlandTab).food(foodProperty)));
	}
	
	private static RegistryObject<Item> registerHiveJelly(String name, FoodProperties foodProperty) {
		
		return ITEMS.register(name, () -> new HiveJellyItem(new Item.Properties().tab(Dreamland.DreamlandTab).food(foodProperty).stacksTo(16)));
	}
}