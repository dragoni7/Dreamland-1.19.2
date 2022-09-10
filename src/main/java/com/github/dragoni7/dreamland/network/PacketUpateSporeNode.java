package com.github.dragoni7.dreamland.network;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.common.blocks.SporeNodeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.network.NetworkEvent;

public class PacketUpateSporeNode {
	BlockPos pos;
	
	public PacketUpateSporeNode(FriendlyByteBuf buf) {
		pos = buf.readBlockPos();
	}
	
	public PacketUpateSporeNode(BlockPos pos) {
		this.pos = pos;
	}
	
	public void toBytes(FriendlyByteBuf buf) {
		buf.writeBlockPos(pos);
	}
	
	public boolean handle(Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			if (context.get().getDirection().getReceptionSide().isServer()) {
				ServerLevel level = context.get().getSender().getLevel();
				Block block = level.getBlockState(pos).getBlock();
				if (block instanceof SporeNodeBlock) {
					((SporeNodeBlock) block).updateSporing(level, pos, level.getBlockState(pos));
				}
			}
		});
		return true;
	}
}
