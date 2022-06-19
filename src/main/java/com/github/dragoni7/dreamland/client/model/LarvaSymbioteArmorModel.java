package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.items.LarvaSymbioteArmorItem;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LarvaSymbioteArmorModel extends AnimatedGeoModel<LarvaSymbioteArmorItem> {

	@Override
	public ResourceLocation getAnimationResource(LarvaSymbioteArmorItem animatable) {
		return DreamlandLoc.createLoc("animations/larva_symbiote.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(LarvaSymbioteArmorItem object) {
		return DreamlandLoc.createLoc("geo/larva_symbiote.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LarvaSymbioteArmorItem object) {
		return DreamlandLoc.createLoc("textures/item/larva_symbiote.png");
	}

}
