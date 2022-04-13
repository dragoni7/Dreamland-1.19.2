package com.github.dragoni7.dreamland.util;

import com.github.dragoni7.dreamland.Dreamland;

import net.minecraft.resources.ResourceLocation;

public class DreamlandLoc{

	public static ResourceLocation createLoc(String name) {
		return new ResourceLocation(Dreamland.MODID, name);
	}
}
