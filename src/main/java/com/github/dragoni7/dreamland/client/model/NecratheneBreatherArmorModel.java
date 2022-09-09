package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.items.NecratheneBreatherArmorItem;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NecratheneBreatherArmorModel extends AnimatedGeoModel<NecratheneBreatherArmorItem> {

	@Override
	public ResourceLocation getAnimationResource(NecratheneBreatherArmorItem animatable) {
		return DreamlandLoc.createLoc("animations/breather.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(NecratheneBreatherArmorItem object) {
		return DreamlandLoc.createLoc("geo/necrathene_breather.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NecratheneBreatherArmorItem object) {
		return DreamlandLoc.createLoc("textures/item/necrathene_breather.png");
	}
}
