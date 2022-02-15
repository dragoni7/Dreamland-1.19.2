package com.github.dragoni7.registry;

import com.github.dragoni7.Dreamland;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandParticles {

	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Dreamland.MODID);
	public static final RegistryObject<SimpleParticleType> WHITE_MOLD_PARTICLE = PARTICLE_TYPES.register("white_mold_particle", () -> new SimpleParticleType(true));
	
}
