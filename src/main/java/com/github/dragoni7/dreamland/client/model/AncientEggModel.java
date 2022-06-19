package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.blocks.tiles.AncientEggTile;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AncientEggModel extends AnimatedGeoModel<AncientEggTile> {

	@Override
	public ResourceLocation getAnimationResource(AncientEggTile animatable) {
		return DreamlandLoc.createLoc("animations/ancient_egg.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(AncientEggTile object) {
		return DreamlandLoc.createLoc("geo/ancient_egg.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AncientEggTile object) {
		return DreamlandLoc.createLoc("textures/block/ancient_egg.png");
	}
}
