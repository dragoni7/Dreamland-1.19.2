package com.github.dragoni7.util;

import com.github.dragoni7.Dreamland;

import net.minecraft.resources.ResourceLocation;

public class DreamlandLoc{

	public static ResourceLocation newLoc(String name) {
		return new ResourceLocation(Dreamland.MODID, name);
	}
}
