package com.github.dragoni7.dreamland.core.registry;

import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;

public class DreamlandSoundTypes {
	
	public static final SoundType HIVE_BLOCK = new ForgeSoundType(1.3F, 1.0F, () -> DreamlandSoundEvents.HIVE_BLOCK_BREAK.get(), () -> DreamlandSoundEvents.HIVE_BLOCK_STEP.get(), () -> DreamlandSoundEvents.HIVE_BLOCK_BREAK.get(), () -> DreamlandSoundEvents.HIVE_BLOCK_BREAK.get(), () -> DreamlandSoundEvents.HIVE_BLOCK_BREAK.get());
	
	public static void init() {
		
	}
}
