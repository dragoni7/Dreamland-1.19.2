package com.github.dragoni7.dreamland.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.BaseAshSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class WhitePollenParticle extends BaseAshSmokeParticle {
	
	protected WhitePollenParticle(ClientLevel level, double x, double y, double z,
			double motionX, double motionY, double motionZ, float f, SpriteSet set) {
		super(level, x, y, z, 0.1F, -0.1F, 0.1F, motionX, motionY, motionZ, f, set, 0.0F, 20, 0.0125F, false);
		
		this.rCol = 0.90980392156F;
	    this.gCol = 0.92156862745F;
	    this.bCol = 0.76470588235F;
	}
	
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;
		
		public Provider(SpriteSet set) {
			this.sprite = set;
		}

		@Override
		public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x,
				double y, double z, double motionX, double motionY, double motionZ) {
			RandomSource randomsource = level.random;
			double d0 = (double)randomsource.nextFloat() * -1.9D * (double)randomsource.nextFloat() * 0.1D;
	        double d1 = (double)randomsource.nextFloat() * -0.5D * (double)randomsource.nextFloat() * 0.1D * 5.0D;
	        double d2 = (double)randomsource.nextFloat() * -1.9D * (double)randomsource.nextFloat() * 0.1D;
			
			return new WhitePollenParticle(level, x, y, z, d0, d1, d2, 1.0F, this.sprite);
		}
		
	}
}
