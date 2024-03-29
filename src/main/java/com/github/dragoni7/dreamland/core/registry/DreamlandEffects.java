package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.effects.EffectAntagonized;
import com.github.dragoni7.dreamland.common.effects.EffectDecay;
import com.github.dragoni7.dreamland.common.effects.EffectTarred;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Dreamland.MODID);
	
	public static final RegistryObject<MobEffect> TARRED = MOB_EFFECTS.register("tarred", () -> new EffectTarred());
	public static final RegistryObject<MobEffect> ANTAGONIZED = MOB_EFFECTS.register("antagonized", () -> new EffectAntagonized());
	public static final RegistryObject<MobEffect> DECAY = MOB_EFFECTS.register("decay", () -> new EffectDecay());
}
