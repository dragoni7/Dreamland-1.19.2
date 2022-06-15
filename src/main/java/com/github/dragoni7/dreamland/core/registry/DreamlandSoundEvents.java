package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandSoundEvents {

	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Dreamland.MODID);
	
	public static final RegistryObject<SoundEvent> HIVE_BLOCK_BREAK = register("hive_block_break");
	public static final RegistryObject<SoundEvent> HIVE_BLOCK_STEP = register("hive_block_step");
	
	private static RegistryObject<SoundEvent> register(String name) {
		return SOUND_EVENTS.register(name, () -> new SoundEvent(DreamlandLoc.createLoc(name)));
	}
}
