/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import me.deftware.client.framework.network.PacketRegistry;
import me.deftware.client.framework.network.SocksProxy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets={"net/minecraft/network/ClientConnection$1"})
public class MixinProxyConnection {
    @Inject(method={"initChannel(Lio/netty/channel/Channel;)V"}, at={@At(value="HEAD")})
    public void connect(Channel channel, CallbackInfo cir) {
        SocksProxy proxy = PacketRegistry.INSTANCE.getProxy();
        if (proxy != null) {
            channel.pipeline().addFirst(new ChannelHandler[]{proxy.getProxyHandler()});
        }
    }
}

