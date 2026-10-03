/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.client.gui.screen.Screen
 */
package me.deftware.client.framework.event.events;

import lombok.Generated;
import me.deftware.client.framework.event.events.EventRenderBase;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import net.minecraft.client.gui.screen.Screen;

public class EventScreen
extends EventRenderBase {
    private final class_437 screen;
    private Type type = Type.Init;
    private int mouseX;
    private int mouseY;

    public EventScreen(class_437 screen) {
        this.screen = screen;
    }

    public EventScreen setType(Type type) {
        this.setCanceled(false);
        this.type = type;
        return this;
    }

    public MinecraftScreen getScreen() {
        return (MinecraftScreen)this.screen;
    }

    @Generated
    public Type getType() {
        return this.type;
    }

    @Generated
    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    @Generated
    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    @Generated
    public int getMouseX() {
        return this.mouseX;
    }

    @Generated
    public int getMouseY() {
        return this.mouseY;
    }

    public static enum Type {
        Init,
        Setup,
        Tick,
        Draw,
        PostDraw;

    }
}

