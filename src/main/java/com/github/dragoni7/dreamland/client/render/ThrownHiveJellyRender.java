package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.common.entities.projectiles.ThrownHiveJelly;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ThrownHiveJellyRender extends EntityRenderer<ThrownHiveJelly>{

	public ThrownHiveJellyRender(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(ThrownHiveJelly p_114482_) {
		return DreamlandLoc.createLoc("textures/item/jelly.png");
	}

}
