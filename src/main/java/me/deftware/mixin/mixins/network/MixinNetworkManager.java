/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.listener.PacketListener
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.PacketCallbacks
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.network;

import me.deftware.client.framework.event.events.EventPacketReceive;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.mixin.imp.IMixinNetworkManager;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.PacketCallbacks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_2535.class})
public abstract class MixinNetworkManager
implements IMixinNetworkManager {
    @Shadow
    protected abstract void method_10764(class_2596<?> var1, class_7648 var2, boolean var3);

    @Redirect(method={"channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/packet/Packet;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/network/ClientConnection;handlePacket(Lnet/minecraft/network/packet/Packet;Lnet/minecraft/network/listener/PacketListener;)V"))
    private void channelRead0(class_2596<?> packet, class_2547 listener) {
        EventPacketReceive event = (EventPacketReceive)new EventPacketReceive(packet).broadcast();
        if (!event.isCanceled()) {
            event.getIPacket().getPacket().method_65081(listener);
        }
    }

    @Redirect(method={"send(Lnet/minecraft/network/packet/Packet;Lnet/minecraft/network/PacketCallbacks;Z)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/network/ClientConnection;sendImmediately(Lnet/minecraft/network/packet/Packet;Lnet/minecraft/network/PacketCallbacks;Z)V"))
    private void sendPacket$dispatchPacket(class_2535 instance, class_2596<?> packet, class_7648 callbacks, boolean flush) {
        EventPacketSend event = new EventPacketSend(packet);
        event.broadcast();
        if (event.isCanceled()) {
            return;
        }
        this.method_10764(event.getPacket(), callbacks, flush);
    }

    @Override
    @Unique
    public void sendPacketImmediately(class_2596<?> packet) {
        this.method_10764(packet, null, true);
    }
}

