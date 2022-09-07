package com.github.dragoni7.dreamland.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class MoldSporesParticle extends TextureSheetParticle {

	protected MoldSporesParticle(ClientLevel level, double x, double y, double z,
			double motionX, double motionY, double motionZ) {
		super(level, x, y, z);
		
		this.gravity = -0.125F;
	    this.friction = 0.65F;
	    this.setSize(0.04F, 0.04F);
		this.quadSize *= this.random.nextFloat() * 0.6F + 0.3F;
		this.xd = motionX * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
	    this.yd = motionY * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
	    this.zd = motionZ * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
	    this.lifetime = (int)(15.0D / (Math.random() * 0.8D + 0.2D));
	}
	
	public void tick() {
		super.tick();
		if (this.lifetime < 0.5D) {
			this.yd = -this.yd;
		}
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}
	
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;
		
		public Provider(SpriteSet set) {
			this.sprite = set;
		}

		@Override
		public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x,
				double y, double z, double motionX, double motionY, double motionZ) {
			
			MoldSporesParticle bubble = new MoldSporesParticle(level, x, y, z, motionX, motionY, motionZ);
			bubble.pickSprite(sprite);
			return bubble;
		}
		
	}
}
