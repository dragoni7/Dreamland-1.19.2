package com.github.dragoni7.dreamland.core.registry;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum DreamlandArmorMaterials implements ArmorMaterial {

	LARVA("larva", 33, new int[]{3, 6, 8, 3}, 12, DreamlandSoundEvents.LARVA_HIT.get(), 0.5F, 0.0F, () -> {
	      return Ingredient.of(DreamlandItems.HIVE_JELLY_ITEM.get());
	   }),
	
	NECRATHENE("necrathene", 39, new int[]{4, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.0F, () -> {
	      return Ingredient.of(DreamlandItems.NECRATHENE_INGOT.get());
	   });
	
	private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	@SuppressWarnings("deprecation")
	private final LazyLoadedValue<Ingredient> repairIngredient;
	
	@SuppressWarnings("deprecation")
	DreamlandArmorMaterials(String name, int durabilityMult, int[] protectionValues, int enchantValue, SoundEvent equipSound, float toughnessValue,
			float knockbackResistValue, Supplier<Ingredient> repairItem) {
		
		this.name = name;
		this.durabilityMultiplier = durabilityMult;
		this.slotProtections = protectionValues;
		this.enchantmentValue = enchantValue;
		this.sound = equipSound;
		this.toughness = toughnessValue;
		this.knockbackResistance = knockbackResistValue;
		this.repairIngredient = new LazyLoadedValue<>(repairItem);
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot slot) {
		return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot slot) {
		return this.slotProtections[slot.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

}
