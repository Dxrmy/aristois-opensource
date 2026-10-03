/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.text.OrderedText
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.gui.tooltip.HoveredTooltipPositioner
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.gui.screens;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.GenericComponent;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.text.Text;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.OrderedText;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.gui.tooltip.HoveredTooltipPositioner;
import org.jetbrains.annotations.ApiStatus;

public interface MinecraftScreen
extends GenericScreen {
    default public ScreenRegistry getScreenType() {
        return ScreenRegistry.valueOf(((class_437)this).getClass()).orElse(null);
    }

    default public void close() {
        class_310.method_1551().method_1507(null);
    }

    public static void closeHandledScreen(int syncId) {
        class_746 entity = class_310.method_1551().field_1724;
        if (entity != null && entity.field_3944 != null) {
            entity.field_3944.method_52787((class_2596)new class_2815(syncId));
        }
    }

    default public <T extends GenericComponent> T getFirstOfType(Class<T> clazz) {
        List<T> children = this.getChildren(clazz);
        if (!children.isEmpty()) {
            return (T)((GenericComponent)children.get(0));
        }
        return null;
    }

    public <T extends GenericComponent> List<T> getChildren(Class<T> var1);

    public void _clearChildren();

    public void addScreenComponent(GenericComponent var1, int var2);

    default public void addScreenComponent(GenericComponent component) {
        this.addScreenComponent(component, -1);
    }

    public EventScreen getEventScreen();

    default public void renderTooltip(GLX context, int x, int y, Message ... tooltip) {
        this.renderTooltip(context, x, y, MinecraftScreen.getTooltipList(tooltip));
    }

    @ApiStatus.Internal
    public static List<class_5481> getTooltipList(Message ... tooltip) {
        return Arrays.stream(tooltip).map(class_2561.class::cast).map(class_2561::method_30937).collect(Collectors.toList());
    }

    @ApiStatus.Internal
    default public void renderTooltip(GLX context, int x, int y, List<class_5481> tooltipComponents) {
        context.getContext().method_51436(class_310.method_1551().field_1772, tooltipComponents, class_8001.field_41687, x, y);
    }
}

