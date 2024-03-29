package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.util.WoodSet;

import net.minecraft.world.level.material.MaterialColor;

public class DreamlandWoodSets {
	public static final WoodSet PLUM_BIRCH = new WoodSet("plum_birch", MaterialColor.COLOR_PURPLE);
	public static final WoodSet TAR_BARK = new WoodSet("tar_bark", MaterialColor.COLOR_PINK);
	public static final WoodSet MOLD_WOOD = new WoodSet("mold_wood", MaterialColor.COLOR_CYAN);
	
	public static void init() {
		Dreamland.LOGGER.always().log("Registered Dreamland Wood Sets");
	}
}
