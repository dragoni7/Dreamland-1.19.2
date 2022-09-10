package com.github.dragoni7.dreamland.core.registry;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.items.BreatherHelmetArmorItem;
import com.github.dragoni7.dreamland.common.items.CrystalizedPurityItem;
import com.github.dragoni7.dreamland.common.items.HiveJellyItem;
import com.github.dragoni7.dreamland.common.items.LarvaSymbioteArmorItem;
import com.github.dragoni7.dreamland.common.items.NecratheneArmorItem;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.BowlFoodItem;
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
	public static final RegistryObject<Item> JELLY_BOWL_ITEM = ITEMS.register("bowl_of_jelly",
			() -> new BowlFoodItem((new Item.Properties()).stacksTo(1).tab(Dreamland.DreamlandTab).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build())));
	
	public static final RegistryObject<Item> TAR_BUCKET = ITEMS.register("tar_bucket", 
			() -> new BucketItem(DreamlandFluids.TAR_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).tab(Dreamland.DreamlandTab).stacksTo(1)));
	public static final RegistryObject<Item> OOZE_BALL = registerBasicItem("ooze_ball");
	public static final RegistryObject<Item> CANDIED_OOZE = registerFoodItem("candied_ooze", new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(DreamlandEffects.TARRED.get(), 40), 1.0F).build());
	public static final RegistryObject<Item> OOZE_PIE = registerFoodItem("ooze_pie", new FoodProperties.Builder().nutrition(8).saturationMod(0.3F).effect(() ->  new MobEffectInstance(DreamlandEffects.TARRED.get(), 40), 1.0F).build());
	
	public static final RegistryObject<Item> OPAL = registerBasicItem("opal");
	public static final RegistryObject<Item> PRECIOUS_OPAL = registerBasicItem("precious_opal");
	
	public static final RegistryObject<Item> RAW_NECRATHENE = registerBasicItem("raw_necrathene");
	public static final RegistryObject<Item> NECRATHENE_INGOT = registerBasicItem("necrathene_ingot");
	public static final RegistryObject<Item> CRYSTALIZED_PURITY = ITEMS.register("crystalized_purity", () -> new CrystalizedPurityItem(new Item.Properties().tab(Dreamland.DreamlandTab)));
	
	//Armor
	public static final RegistryObject<Item> LARVA_HELMET = ITEMS.register("larva_symbiote", () -> new LarvaSymbioteArmorItem(DreamlandArmorMaterials.LARVA, EquipmentSlot.HEAD, new Item.Properties().rarity(Rarity.RARE).tab(Dreamland.DreamlandTab)));
	public static final RegistryObject<Item> BREATHER_HELMET = ITEMS.register("breather_helmet", () -> new BreatherHelmetArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Properties().tab(Dreamland.DreamlandTab)));
	public static final RegistryObject<Item> NECRATHENE_BREATHER_HELMET = ITEMS.register("necrathene_breather_helmet", () -> new NecratheneArmorItem(DreamlandArmorMaterials.NECRATHENE, EquipmentSlot.HEAD, new Item.Properties().tab(Dreamland.DreamlandTab)));
	public static final RegistryObject<Item> NECRATHENE_CHESTPLATE = ITEMS.register("necrathene_chestplate", () -> new NecratheneArmorItem(DreamlandArmorMaterials.NECRATHENE, EquipmentSlot.CHEST, new Item.Properties().tab(Dreamland.DreamlandTab)));
	public static final RegistryObject<Item> NECRATHENE_LEGGINGS = ITEMS.register("necrathene_leggings", () -> new NecratheneArmorItem(DreamlandArmorMaterials.NECRATHENE, EquipmentSlot.LEGS, new Item.Properties().tab(Dreamland.DreamlandTab)));
	public static final RegistryObject<Item> NECRATHENE_BOOTS = ITEMS.register("necrathene_boots", () -> new NecratheneArmorItem(DreamlandArmorMaterials.NECRATHENE, EquipmentSlot.FEET, new Item.Properties().tab(Dreamland.DreamlandTab)));
	
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
	
	private static RegistryObject<Item> registerFoodItem(String name, FoodProperties foodProperties) {
		return ITEMS.register(name, () -> new Item(new Item.Properties().tab(Dreamland.DreamlandTab).food(foodProperties)));
	}
	
	private static RegistryObject<Item> registerHiveJelly(String name, FoodProperties foodProperty) {
		return ITEMS.register(name, () -> new HiveJellyItem(new Item.Properties().tab(Dreamland.DreamlandTab).food(foodProperty).stacksTo(16)));
	}
}