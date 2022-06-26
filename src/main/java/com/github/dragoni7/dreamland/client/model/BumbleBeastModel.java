package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.entities.mobs.BumbleBeastEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

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
		return DreamlandLoc.createLoc("textures/entity/bumble_beast.png");
	}

}
