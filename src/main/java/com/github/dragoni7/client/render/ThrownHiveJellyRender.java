package com.github.dragoni7.client.render;

import com.github.dragoni7.common.entities.ThrownHiveJelly;
import com.github.dragoni7.util.DreamlandLoc;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ThrownHiveJellyRender extends EntityRenderer<ThrownHiveJelly>{

	protected ThrownHiveJellyRender(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(ThrownHiveJelly p_114482_) {
		return DreamlandLoc.createLoc("textures/item/jelly.png");
	}

}
