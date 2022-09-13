package com.github.dragoni7.dreamland.network;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

public class PacketApplyTarredPlayer {

	private int entity;
	
	public PacketApplyTarredPlayer(FriendlyByteBuf buf) {
		entity = buf.readInt();
	}
	
	public PacketApplyTarredPlayer(int entity) {
		this.entity = entity;
	}
	
	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(entity);
	}
	
	public boolean handle(Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			if (context.get().getDirection().getReceptionSide().isServer()) {
				Entity target = context.get().getSender().getLevel().getEntity(entity);
				if(target instanceof LivingEntity) {
					((LivingEntity) target).addEffect(new MobEffectInstance(DreamlandEffects.TARRED.get(), 600));
				}
			}
		});
		
		return true;
	}
}
