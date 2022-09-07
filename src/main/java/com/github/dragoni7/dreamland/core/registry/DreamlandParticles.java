package com.github.dragoni7.dreamland.core.registry;


import com.github.dragoni7.dreamland.Dreamland;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandParticles {

	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Dreamland.MODID);
	
	public static final RegistryObject<SimpleParticleType> TAR_BUBBLE = PARTICLES.register("tar_bubble",
			() -> new SimpleParticleType(true));
	
	public static final RegistryObject<SimpleParticleType> WHITE_POLLEN = PARTICLES.register("white_pollen",
			() -> new SimpleParticleType(false));
	
	public static final RegistryObject<SimpleParticleType> 	GOLD_GLITTER = PARTICLES.register("gold_glitter",
			() -> new SimpleParticleType(true));
	
	public static final RegistryObject<SimpleParticleType> 	MIDASHROOM_SPORES = PARTICLES.register("midashroom_spores",
			() -> new SimpleParticleType(true));
	
	public static final RegistryObject<SimpleParticleType> 	MOLD_SPORES = PARTICLES.register("mold_spores",
			() -> new SimpleParticleType(true));
}
