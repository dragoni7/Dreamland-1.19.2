package com.github.dragoni7.dreamland.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GoldGlitterParticle extends TextureSheetParticle {
	
	GoldGlitterParticle(ClientLevel level, SpriteSet spriteSet, double p_172405_, double p_172406_, double p_172407_) {
	    super(level, p_172405_, p_172406_ - 0.125D, p_172407_);
	    this.setSize(0.01F, 0.01F);
	    this.pickSprite(spriteSet);
	    this.quadSize *= this.random.nextFloat() * 0.6F + 0.2F;
	    this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
	    this.hasPhysics = false;
	    this.friction = 1.0F;
	    this.gravity = 0.0F;
	 }
	
	GoldGlitterParticle(ClientLevel level, SpriteSet spriteSet, double p_172411_, double p_172412_, double p_172413_, double p_172414_, double p_172415_, double p_172416_) {
	    super(level, p_172411_, p_172412_ - 0.125D, p_172413_, p_172414_, p_172415_, p_172416_);
	    this.setSize(0.01F, 0.01F);
	    this.pickSprite(spriteSet);
	    this.quadSize *= this.random.nextFloat() * 0.6F + 0.6F;
	    this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
	    this.hasPhysics = false;
	    this.friction = 1.0F;
	    this.gravity = 0.0F;
	 }
	
	public ParticleRenderType getRenderType() {
	    return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	 }
	
	@OnlyIn(Dist.CLIENT)
	   public static class Provider implements ParticleProvider<SimpleParticleType> {
	      private final SpriteSet sprite;

	      public Provider(SpriteSet p_172419_) {
	         this.sprite = p_172419_;
	      }

	      public Particle createParticle(SimpleParticleType p_172430_, ClientLevel p_172431_, double p_172432_, double p_172433_, double p_172434_, double p_172435_, double p_172436_, double p_172437_) {
	    	  GoldGlitterParticle goldglitterparticle = new GoldGlitterParticle(p_172431_, this.sprite, p_172432_, p_172433_, p_172434_, 0.0D, (double)-0.8F, 0.0D) {
	         };
	         goldglitterparticle.lifetime = Mth.randomBetweenInclusive(p_172431_.random, 250, 650);
	         goldglitterparticle.gravity = 0.01F;
	         return goldglitterparticle;
	      }
	   }
}
