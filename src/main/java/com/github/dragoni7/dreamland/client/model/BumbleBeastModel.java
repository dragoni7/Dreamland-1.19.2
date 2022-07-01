package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.entities.mobs.BumbleBeastEntity;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BumbleBeastModel extends AnimatedGeoModel<BumbleBeastEntity> {

	@Override
	public ResourceLocation getAnimationResource(BumbleBeastEntity animatable) {
		return DreamlandLoc.createLoc("animations/bumble_beast.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(BumbleBeastEntity object) {
		return DreamlandLoc.createLoc("geo/bumble_beast.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BumbleBeastEntity object) {
		if (object.hasHoney()) {
			return DreamlandLoc.createLoc("textures/entity/bumble_beast_honey.png");
		}
		
		return DreamlandLoc.createLoc("textures/entity/bumble_beast.png");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(BumbleBeastEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 340F));
	}

}
