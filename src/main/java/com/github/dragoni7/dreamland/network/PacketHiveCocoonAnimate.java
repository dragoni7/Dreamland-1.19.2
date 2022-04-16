package com.github.dragoni7.dreamland.network;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.common.blocks.hivecocoon.HiveCocoonTile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PacketHiveCocoonAnimate {
	final int x;
    final int y;
    final int z;
    final int arg;

    public PacketHiveCocoonAnimate(int x, int y, int z, int arg){
        this.x = x;
        this.y = y;
        this.z = z;
        this.arg = arg;
    }

    public PacketHiveCocoonAnimate(BlockPos pos, int arg){
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
        this.arg = arg;
    }

    public PacketHiveCocoonAnimate(BlockPos pos){
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
        this.arg = 0;
    }

    public static PacketHiveCocoonAnimate decode(FriendlyByteBuf buf) {
        return new PacketHiveCocoonAnimate(buf.readInt(),buf.readInt(), buf.readInt(), buf.readInt());
    }

    public static void encode(PacketHiveCocoonAnimate msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.x);
        buf.writeInt(msg.y);
        buf.writeInt(msg.z);
        buf.writeInt(msg.arg);
    }
    public static class Handler {
        public static void handle(final PacketHiveCocoonAnimate m, final Supplier<NetworkEvent.Context> ctx) {
            if (ctx.get().getDirection().getReceptionSide().isServer()) {
                ctx.get().setPacketHandled(true);
                return;
            }

            ctx.get().enqueueWork(new Runnable() {
                @Override
                public void run() {
                    Minecraft mc = Minecraft.getInstance();
                    ClientLevel world = mc.level;
                    if(world.getBlockEntity(new BlockPos(m.x, m.y, m.z)) instanceof HiveCocoonTile){
                        ((HiveCocoonTile) world.getBlockEntity(new BlockPos(m.x, m.y, m.z))).setOpenAnimate(m.arg);
                    }
                }
            });
            ctx.get().setPacketHandled(true);

        }
    }
}
