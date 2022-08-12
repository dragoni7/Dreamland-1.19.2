package com.github.dragoni7.dreamland.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidashroomSporesParticle extends TextureSheetParticle {
	private final double xStart;
	private final double yStart;
	private final double zStart;

	protected MidashroomSporesParticle(ClientLevel level, double p_107552_, double p_107553_, double p_107554_, double motionX, double motionY, double motionZ) {
	      super(level, p_107552_, p_107553_, p_107554_);
	      this.xd = motionX;
	      this.yd = motionY;
	      this.zd = motionZ;
	      this.x = p_107552_;
	      this.y = p_107553_;
	      this.z = p_107554_;
	      this.xStart = this.x;
	      this.yStart = this.y;
	      this.zStart = this.z;
	      this.quadSize = 0.1F * (this.random.nextFloat() * 0.2F + 0.7F);
	      this.lifetime = (int)(Math.random() * 10.0D) + 70;
	}
	
	public void move(double x, double y, double z) {
	    this.setBoundingBox(this.getBoundingBox().move(x, y, z));
	    this.setLocationFromBoundingbox();
	 }

	 public float getQuadSize(float p_107567_) {
	    float f = ((float)this.age + p_107567_) / (float)this.lifetime;
	    f = 1.0F - f;
	    f *= f;
	    f = 1.0F - f;
	    return this.quadSize * f;
	 }

	   public int getLightColor(float p_107564_) {
	      int i = super.getLightColor(p_107564_);
	      float f = (float)this.age / (float)this.lifetime;
	      f *= f;
	      f *= f;
	      int j = i & 255;
	      int k = i >> 16 & 255;
	      k += (int)(f * 15.0F * 16.0F);
	      if (k > 240) {
	         k = 240;
	      }

	      return j | k << 16;
	   }

	   public void tick() {
	      this.xo = this.x;
	      this.yo = this.y;
	      this.zo = this.z;
	      if (this.age++ >= this.lifetime) {
	         this.remove();
	      } else {
	         float f = (float)this.age / (float)this.lifetime;
	         float f1 = -f + f * f * 2.0F;
	         float f2 = 1.0F - f1;
	         this.x = this.xStart + this.xd * (double)f2;
	         this.y = this.yStart + this.yd * (double)f2 - (double)(1.0F - f);
	         this.z = this.zStart + this.zd * (double)f2;
	      }
	   }

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}
	
	@OnlyIn(Dist.CLIENT)
	 public static class Provider implements ParticleProvider<SimpleParticleType> {
	    private final SpriteSet sprite;

	    public Provider(SpriteSet set) {
	       this.sprite = set;
	    }

	    public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double motionX, double motionY, double motionZ) {
	       MidashroomSporesParticle particle = new MidashroomSporesParticle(level, x, y, z, motionX, motionY, motionZ);
	       particle.pickSprite(this.sprite);
	       return particle;
	      }
	   }

}
