package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.entities.mobs.OozeEntity;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class OozeModel extends AnimatedGeoModel<OozeEntity> {

	@Override
	public ResourceLocation getAnimationResource(OozeEntity animatable) {
		return DreamlandLoc.createLoc("animations/ooze.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(OozeEntity object) {
		return DreamlandLoc.createLoc("geo/ooze.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OozeEntity object) {
		return DreamlandLoc.createLoc("textures/entity/ooze.png");
	}

}
