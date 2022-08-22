package com.github.dragoni7.dreamland.util;


import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class RollBoolean {
	
	public static Boolean roll(int bound, RandomSource rand) {
		return rand.nextInt(bound) == 0;
	}
	
	public static Boolean roll(float bound, RandomSource rand) {
		return Mth.nextFloat(rand, bound, bound) == 0;
	}
}
