package com.github.dragoni7.dreamland.network;

import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Networking {

	private static SimpleChannel INSTANCE;
	private static int ID = 0;
	
	private static int nextID() {
		return ID++;
	}
	
	public static void registerMessages() {
		INSTANCE = NetworkRegistry.newSimpleChannel(DreamlandLoc.createLoc("dreamland"), () -> "1.0", s -> true, s -> true);
		
		INSTANCE.messageBuilder(PacketApplyTarredPlayer.class, nextID())
		.encoder(PacketApplyTarredPlayer::toBytes)
		.decoder(PacketApplyTarredPlayer::new)
		.consumer(PacketApplyTarredPlayer::handle)
		.add();
		
		INSTANCE.messageBuilder(PacketUpateSporeNode.class, nextID())
		.encoder(PacketUpateSporeNode::toBytes)
		.decoder(PacketUpateSporeNode::new)
		.consumer(PacketUpateSporeNode::handle)
		.add();
	}
	
	public static void sendToClient(Object packet, ServerPlayer player) {
		INSTANCE.sendTo(packet, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
	}
	
	public static void sendToServer(Object packet) {
		INSTANCE.sendToServer(packet);
	}
}
