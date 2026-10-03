/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.ParseResults
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.listener.ServerPlayPacketListener
 *  net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.network.encryption.NetworkEncryptionUtils$SecureRandomUtil
 *  net.minecraft.client.network.ClientCommandSource
 *  net.minecraft.network.message.ArgumentSignatureDataMap
 *  net.minecraft.network.message.MessageSignatureData
 *  net.minecraft.network.packet.c2s.play.CommandExecutionC2SPacket
 *  net.minecraft.network.message.MessageBody
 *  net.minecraft.network.message.LastSeenMessagesCollector$LastSeenMessages
 *  net.minecraft.command.argument.SignedArgumentList
 *  net.minecraft.network.packet.c2s.play.ChatCommandSignedC2SPacket
 */
package me.deftware.client.framework.network.packets;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import java.time.Instant;
import me.deftware.client.framework.network.NetworkHandler;
import me.deftware.client.framework.network.PacketWrapper;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.encryption.NetworkEncryptionUtils;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.network.message.ArgumentSignatureDataMap;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.network.packet.c2s.play.CommandExecutionC2SPacket;
import net.minecraft.network.message.MessageBody;
import net.minecraft.network.message.LastSeenMessagesCollector;
import net.minecraft.command.argument.SignedArgumentList;
import net.minecraft.network.packet.c2s.play.ChatCommandSignedC2SPacket;

public class CPacketChatMessage
extends PacketWrapper {
    public CPacketChatMessage(class_2596<?> packet) {
        super(packet);
    }

    public CPacketChatMessage(String text) {
        super(CPacketChatMessage.of(text));
    }

    private static class_2596<class_2792> of(String text) {
        if (text.startsWith("/")) {
            return CPacketChatMessage.command(text.substring(1));
        }
        return CPacketChatMessage.message(text);
    }

    private static class_2596<class_2792> message(String text) {
        NetworkHandler networkHandler = NetworkHandler.getNetworkHandler();
        Instant instant = Instant.now();
        long salt = class_3515.class_7426.method_43531();
        class_7637.class_7816 lastSeenMessages = networkHandler.collect();
        class_7469 messageSignatureData = networkHandler.pack(new class_7608(text, instant, salt, lastSeenMessages.comp_1073()));
        return new class_2797(text, instant, salt, messageSignatureData, lastSeenMessages.comp_1074());
    }

    private static class_2596<class_2792> command(String text) {
        class_637 source;
        NetworkHandler networkHandler = NetworkHandler.getNetworkHandler();
        CommandDispatcher dispatcher = class_310.method_1551().method_1562().method_2886();
        class_7644 signedArgumentList = class_7644.method_45043((ParseResults)dispatcher.parse(text, (Object)(source = class_310.method_1551().method_1562().method_2875())));
        if (signedArgumentList.comp_974().isEmpty()) {
            return new class_7472(text);
        }
        Instant instant = Instant.now();
        long salt = class_3515.class_7426.method_43531();
        class_7637.class_7816 lastSeenMessages = networkHandler.collect();
        class_7450 argumentSignatureDataMap = class_7450.method_44797((class_7644)signedArgumentList, value -> {
            class_7608 messageBody = new class_7608(value, instant, salt, lastSeenMessages.comp_1073());
            return networkHandler.pack(messageBody);
        });
        return new class_9449(text, instant, salt, argumentSignatureDataMap, lastSeenMessages.comp_1074());
    }
}

