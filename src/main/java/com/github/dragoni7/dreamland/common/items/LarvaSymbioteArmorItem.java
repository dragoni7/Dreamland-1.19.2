package com.github.dragoni7.dreamland.common.items;

import java.util.ArrayList;
import java.util.List;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandSoundEvents;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class LarvaSymbioteArmorItem extends GeoArmorItem implements IAnimatable {

	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	
	public LarvaSymbioteArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
		super(materialIn, slot, builder.tab(Dreamland.DreamlandTab));
	}
	
	@SuppressWarnings("unused")
	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		List<EquipmentSlot> slotData = event.getExtraDataOfType(EquipmentSlot.class);
		List<ItemStack> stackData = event.getExtraDataOfType(ItemStack.class);
		LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);
		
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.larva_symbiote.idle", EDefaultLoopTypes.LOOP));
		
		if (livingEntity instanceof ArmorStand) {
			return PlayState.CONTINUE;
		}
		
		List<Item> armorList = new ArrayList<>(4);
		for (EquipmentSlot slot : EquipmentSlot.values()) {
			if (slot.getType() == EquipmentSlot.Type.ARMOR) {
				if (livingEntity.getItemBySlot(slot) != null) {
					armorList.add(livingEntity.getItemBySlot(slot).getItem());
				}
			}
		}
		
		boolean isWearing = armorList.contains(DreamlandItems.LARVA_HELMET.get());
		
		return isWearing ? PlayState.CONTINUE : PlayState.STOP;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "LarvaSymbioteController", 20, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	@Override
	public SoundEvent getEquipSound() {
	   return DreamlandSoundEvents.LARVA_HIT.get();
	}

}
