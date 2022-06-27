package com.github.dragoni7.dreamland.core.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;

public class DreamlandSoundTypes {
	
	public static final SoundType BUMBLE_BLOCK = new ForgeSoundType(0.8F, 0.7F, () -> SoundEvents.WOOL_BREAK, () -> SoundEvents.BEE_HURT, () -> SoundEvents.BEE_HURT, () -> SoundEvents.WOOL_HIT, () -> SoundEvents.WOOL_FALL);
	public static final SoundType HIVE_BLOCK = new ForgeSoundType(1.3F, 1.0F, () -> DreamlandSoundEvents.HIVE_BLOCK_BREAK.get(), () -> DreamlandSoundEvents.HIVE_BLOCK_STEP.get(), () -> DreamlandSoundEvents.HIVE_BLOCK_BREAK.get(), () -> DreamlandSoundEvents.HIVE_BLOCK_BREAK.get(), () -> DreamlandSoundEvents.HIVE_BLOCK_BREAK.get());
	public static final SoundType HIVE_JELLY = new ForgeSoundType(1.0F, 0.8F, () -> SoundEvents.SLIME_BLOCK_BREAK, () -> DreamlandSoundEvents.HIVE_JELLY_STEP.get(), () -> SoundEvents.SLIME_BLOCK_PLACE, () -> SoundEvents.SLIME_BLOCK_HIT, () -> SoundEvents.SLIME_BLOCK_FALL);
	public static final SoundType TAR_MUD = new ForgeSoundType(0.8F, 0.4F, () -> SoundEvents.MUD_BREAK, () -> SoundEvents.MUD_STEP, () -> SoundEvents.MUD_PLACE, () -> SoundEvents.MUD_HIT, () -> SoundEvents.MUD_FALL);
	public static final SoundType PACKED_TAR_MUD = new ForgeSoundType(0.8F, 0.5F, () -> SoundEvents.PACKED_MUD_BREAK, () -> SoundEvents.PACKED_MUD_STEP, () -> SoundEvents.PACKED_MUD_PLACE, () -> SoundEvents.PACKED_MUD_HIT, () -> SoundEvents.PACKED_MUD_FALL);
	public static final SoundType TAR_MUD_BRICKS = new ForgeSoundType(0.8F, 0.5F, () -> SoundEvents.MUD_BRICKS_BREAK, () -> SoundEvents.MUD_BRICKS_STEP, () -> SoundEvents.MUD_BRICKS_PLACE, () -> SoundEvents.MUD_BRICKS_HIT, () -> SoundEvents.MUD_BRICKS_FALL);
	
	public static void init() {
		
	}
}
