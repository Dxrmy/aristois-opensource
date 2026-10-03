/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.minecraft;

import java.util.function.Consumer;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.event.events.EventChatSend;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.jetbrains.annotations.ApiStatus;

public interface Chat {
    public void message(String var1, Class<?> var2);

    public void command(String var1, Class<?> var2);

    default public void send(String text, Class<?> sender) {
        if (text.startsWith("/")) {
            this.command(text.substring(1), sender);
        } else {
            this.message(text, sender);
        }
    }

    @ApiStatus.Internal
    public static void send(Consumer<String> consumer, String text, Class<?> sender, EventChatSend.Type type) {
        EventChatSend event = (EventChatSend)new EventChatSend(text, sender, type).broadcast();
        if (!event.isCanceled()) {
            String trigger = CommandRegister.getCommandTrigger();
            if (text.startsWith(trigger)) {
                text = text.substring(trigger.length());
                try {
                    class_634 networkHandler = class_310.method_1551().method_1562();
                    if (networkHandler != null) {
                        CommandRegister.getDispatcher().execute(text, (Object)networkHandler.method_2875());
                    }
                }
                catch (Exception ex) {
                    Message.of(ex.getMessage()).style(Appearance.of(DefaultColors.RED)).print();
                }
                return;
            }
            if (!event.getMessage().equalsIgnoreCase(text)) {
                text = event.getMessage();
            }
            consumer.accept(text);
        }
    }
}

