package com.github.dragoni7.dreamland.util;

import java.util.Random;

public class RollBoolean {
	
	public static Boolean roll(int bound, Random rand) {
		return rand.nextInt(bound) == 0;
	}
}
