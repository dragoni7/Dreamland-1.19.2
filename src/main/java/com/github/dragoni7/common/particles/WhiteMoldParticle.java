package com.github.dragoni7.common.particles;

import java.util.Locale;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.RisingParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;

public class WhiteMoldParticle extends RisingParticle implements ParticleOptions {
	
	protected WhiteMoldParticle(ClientLevel p_107631_, double p_107632_, double p_107633_, double p_107634_,
			double p_107635_, double p_107636_, double p_107637_) {
		super(p_107631_, p_107632_, p_107633_, p_107634_, p_107635_, p_107636_, p_107637_);
	}

	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}
	
	public void move(double motionX, double motionY, double motionZ) {
		this.setBoundingBox(this.getBoundingBox().move(motionX, motionY, motionZ));
		this.setLocationFromBoundingbox();
	}
	
	public float getQuadSize(float size) {
		float f = ((float) this.age + size) / (float) this.lifetime;
		return this.quadSize * (1.0F - f * f * 0.5F);
		}
	
	public int getLightColor(float color) {
		float f = ((float) this.age + color) / (float) this.lifetime;
        f = Mth.clamp(f, 0.0F, 1.0F);
        int i = super.getLightColor(color);
        int j = i & 255;
        int k = i >> 16 & 255;
        j = j + (int) (f * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
	}
	
	@Override
	public ParticleType<?> getType() {
		return null;
	}

	@Override
	public void writeToNetwork(FriendlyByteBuf p_123732_) {
		
	}

	@Override
	public String writeToString() {
		return null;
	}
	
	public static class Factory implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;
		
		public Factory(SpriteSet spriteSet) {
			this.sprite = spriteSet;
		}
		
		public Particle createParticle(SimpleParticleType p_172162_, ClientLevel p_172163_, double p_172164_,
				double p_172165_, double p_172166_, double p_172167_, double p_172168_, double p_172169_) {
			WhiteMoldParticle moldParticle = new WhiteMoldParticle(p_172163_, p_172169_, p_172169_, p_172169_, p_172169_, p_172169_, p_172169_);
			moldParticle.pickSprite(sprite);
			return moldParticle;
		}
	}
	
	public static class WhiteMoldParticleData implements ParticleOptions {
		public static final WhiteMoldParticleData WHITE_MOLD = new WhiteMoldParticleData(0.0F,1.0F,0.2F,1.0F);
		public static final Codec<WhiteMoldParticleData> CODEC = RecordCodecBuilder.create((p_239803_0_) -> {
			return p_239803_0_.group(Codec.FLOAT.fieldOf("r").forGetter((p_239807_0_) -> {
				return p_239807_0_.red;
			}), Codec.FLOAT.fieldOf("g").forGetter((p_239806_0_) -> {
				return p_239806_0_.green;
			}), Codec.FLOAT.fieldOf("b").forGetter((p_239805_0_) -> {
				return p_239805_0_.blue;
			}), Codec.FLOAT.fieldOf("scale").forGetter((p_239804_0_) -> {
				return p_239804_0_.alpha;
			})).apply(p_239803_0_, WhiteMoldParticleData::new);
		});
		
		public static final Deserializer<WhiteMoldParticleData> DESERIALIZER = new Deserializer<WhiteMoldParticleData>() {
			
			@Override
			public WhiteMoldParticleData fromCommand(ParticleType<WhiteMoldParticleData> particelTypeIn,
											 StringReader reader) throws CommandSyntaxException {
				reader.expect(' ');
				float red = (float) reader.readDouble();
				reader.expect(' ');
				float green = (float) reader.readDouble();
				reader.expect(' ');
				float blue = (float) reader.readDouble();
				reader.expect(' ');
				float alpha = (float) reader.readDouble();
				return new WhiteMoldParticleData(red,green,blue,alpha);
			}
			
			@Override
			public WhiteMoldParticleData fromNetwork(ParticleType<WhiteMoldParticleData> partcleTypeIn, FriendlyByteBuf buffer) {
				return new WhiteMoldParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(),
						buffer.readFloat());
			}
			
		};
		
		private final float red;
		private final float green;
		private final float blue;
		private final float alpha;
		
		public WhiteMoldParticleData(float redIn, float greenIn, float blueIn, float alphaIn) {
			this.red = redIn;
			this.green = greenIn;
			this.blue = blueIn;
			this.alpha = Mth.clamp(alphaIn, 0.01F, 4.0F);
		}
		
		@Override
		public ParticleType<?> getType() {

			return null;
		}

		@Override
		public void writeToNetwork(FriendlyByteBuf p_123732_) {
			p_123732_.writeFloat(this.red);
			p_123732_.writeFloat(this.green);
			p_123732_.writeFloat(this.blue);
			p_123732_.writeFloat(this.alpha);
			
		}

		@Override
		public String writeToString() {

			return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f", Registry.PARTICLE_TYPE.getKey(this.getType()),
					this.red,this.green,this.blue,this.alpha);
		}
		
	}

}
