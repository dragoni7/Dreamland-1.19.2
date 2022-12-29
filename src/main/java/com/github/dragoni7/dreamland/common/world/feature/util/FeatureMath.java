package com.github.dragoni7.dreamland.common.world.feature.util;

import net.minecraft.util.Mth;

public class FeatureMath {
	
	public static double distance(double x, double y, double z, double xRadius, double yRadius, double zRadius) {
		return Mth.square((double)x/(xRadius)) + Mth.square((double)y/(yRadius)) + Mth.square((double)z/(zRadius));
	}
	
	public static double distance2D(double x, double z, double xRadius, double zRadius) {
		return Mth.square((double)x/(xRadius)) + Mth.square((double)z/(zRadius));
	}
	
	public static float coneSlantHeight(int radius, int height) {
		return Mth.sqrt(Mth.square(radius) + Mth.square(height));
	}
	
	public static float coneRadius(float slantHeight, int height) {
		return Mth.sqrt(Mth.square(slantHeight) + Mth.square(height));
	}
}
