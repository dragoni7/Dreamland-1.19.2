package com.github.dragoni7.dreamland.network;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

public class PacketApplyTarred {

	private int livingEntity;
	
	public PacketApplyTarred(FriendlyByteBuf buf) {
		livingEntity = buf.readInt();
	}
	
	public PacketApplyTarred(int entity) {
		this.livingEntity = entity;
	}
	
	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(livingEntity);
	}
	
	public boolean handle(Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			if (context.get().getDirection().getReceptionSide().isServer()) {
				ServerPlayer player = context.get().getSender();
				ServerLevel world = player.getLevel();
				Entity entity = world.getEntity(livingEntity);
				
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addEffect(new MobEffectInstance(DreamlandEffects.TARRED.get(), 600));
				}
			}
		});
		
		return true;
	}
}