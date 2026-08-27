/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_2596
 *  net.minecraft.class_2616
 *  net.minecraft.class_2684
 *  net.minecraft.class_2761
 *  net.minecraft.class_2797
 *  net.minecraft.class_2799
 *  net.minecraft.class_2815
 *  net.minecraft.class_2824
 *  net.minecraft.class_2827
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2828$class_5911
 *  net.minecraft.class_2848
 *  net.minecraft.class_3943
 *  net.minecraft.class_3944
 */
package me.deftware.client.framework.network;

import java.util.HashMap;
import lombok.Generated;
import me.deftware.client.framework.network.PacketWrapper;
import me.deftware.client.framework.network.SocksProxy;
import me.deftware.client.framework.network.packets.CPacketChatMessage;
import me.deftware.client.framework.network.packets.CPacketClientStatus;
import me.deftware.client.framework.network.packets.CPacketCloseWindow;
import me.deftware.client.framework.network.packets.CPacketEntityAction;
import me.deftware.client.framework.network.packets.CPacketKeepAlive;
import me.deftware.client.framework.network.packets.CPacketPlayer;
import me.deftware.client.framework.network.packets.CPacketPosition;
import me.deftware.client.framework.network.packets.CPacketPositionRotation;
import me.deftware.client.framework.network.packets.CPacketRotation;
import me.deftware.client.framework.network.packets.CPacketUseEntity;
import me.deftware.client.framework.network.packets.SPacketAnimation;
import me.deftware.client.framework.network.packets.SPacketEntity;
import me.deftware.client.framework.network.packets.SPacketOpenScreen;
import me.deftware.client.framework.network.packets.SPacketTradeOffers;
import me.deftware.client.framework.network.packets.SPacketWorldTime;
import net.minecraft.class_2596;
import net.minecraft.class_2616;
import net.minecraft.class_2684;
import net.minecraft.class_2761;
import net.minecraft.class_2797;
import net.minecraft.class_2799;
import net.minecraft.class_2815;
import net.minecraft.class_2824;
import net.minecraft.class_2827;
import net.minecraft.class_2828;
import net.minecraft.class_2848;
import net.minecraft.class_3943;
import net.minecraft.class_3944;

public class PacketRegistry {
    public static final PacketRegistry INSTANCE = new PacketRegistry();
    private SocksProxy proxy;
    private final HashMap<Class<? extends class_2596<?>>, Class<? extends PacketWrapper>> packetMap = new HashMap();

    private PacketRegistry() {
        this.register(class_2824.class, CPacketUseEntity.class);
        this.register(class_2815.class, CPacketCloseWindow.class);
        this.register(class_2827.class, CPacketKeepAlive.class);
        this.register(class_2799.class, CPacketClientStatus.class);
        this.register(class_2797.class, CPacketChatMessage.class);
        this.register(class_2828.class, CPacketPlayer.class);
        this.register(class_2828.class_5911.class, CPacketPlayer.class);
        this.register(class_2828.class_2830.class, CPacketPositionRotation.class);
        this.register(class_2828.class_2831.class, CPacketRotation.class);
        this.register(class_2828.class_2829.class, CPacketPosition.class);
        this.register(class_2848.class, CPacketEntityAction.class);
        this.register(class_2684.class, SPacketEntity.class);
        this.register(class_2616.class, SPacketAnimation.class);
        this.register(class_2761.class, SPacketWorldTime.class);
        this.register(class_3944.class, SPacketOpenScreen.class);
        this.register(class_3943.class, SPacketTradeOffers.class);
    }

    public void register(Class<? extends class_2596<?>> minecraft, Class<? extends PacketWrapper> translated) {
        this.packetMap.putIfAbsent(minecraft, translated);
    }

    public PacketWrapper translate(class_2596<?> packet) {
        if (this.packetMap.containsKey(packet.getClass())) {
            Class<? extends PacketWrapper> wrapper = this.packetMap.get(packet.getClass());
            try {
                return wrapper.getDeclaredConstructor(class_2596.class).newInstance(packet);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new PacketWrapper(packet);
    }

    @Generated
    public SocksProxy getProxy() {
        return this.proxy;
    }

    @Generated
    public void setProxy(SocksProxy proxy) {
        this.proxy = proxy;
    }
}

