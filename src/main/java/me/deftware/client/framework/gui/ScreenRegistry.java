/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.DeathScreen
 *  net.minecraft.client.gui.screen.DisconnectedScreen
 *  net.minecraft.client.gui.screen.option.OptionsScreen
 *  net.minecraft.client.realms.gui.screen.RealmsMainScreen
 *  net.minecraft.client.gui.screen.GameMenuScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.TitleScreen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen
 *  net.minecraft.client.gui.screen.world.CreateWorldScreen
 *  net.minecraft.client.gui.screen.world.SelectWorldScreen
 */
package me.deftware.client.framework.gui;

import java.util.Arrays;
import java.util.Optional;
import lombok.Generated;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.minecraft.Minecraft;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.realms.gui.screen.RealmsMainScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;

public enum ScreenRegistry {
    Multiplayer(class_500.class),
    WorldSelection(class_526.class),
    CreateWorld(class_525.class),
    Options(class_429.class, args -> new class_429((class_437)args[0], class_310.method_1551().field_1690)),
    MainMenu(class_442.class, parent -> new class_442()),
    IngameMenu(class_433.class),
    Disconnected(class_419.class, args -> new class_419((class_437)args[0], (class_2561)args[1], (class_2561)args[2])),
    Container(class_465.class),
    Chat(class_408.class),
    Death(class_418.class),
    Realms(class_4325.class);

    private final Class<? extends class_437> clazz;
    private final CatchableFunction supplier;

    private ScreenRegistry(Class<? extends class_437> clazz) {
        this.clazz = clazz;
        this.supplier = args -> this.clazz.getDeclaredConstructor((Class[])Arrays.stream(args).map(o -> {
            if (o instanceof class_437) {
                return class_437.class;
            }
            return o.getClass();
        }).toArray(Class[]::new)).newInstance(args);
    }

    private ScreenRegistry(Class<? extends class_437> clazz, CatchableFunction supplier) {
        this.clazz = clazz;
        this.supplier = supplier;
    }

    public MinecraftScreen create(Object ... params) {
        try {
            class_437 screen = this.supplier.apply(params);
            if (screen == null) {
                throw new Exception("Null screen");
            }
            return (MinecraftScreen)screen;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void open(Object ... params) {
        MinecraftScreen screen = this.create(params);
        if (screen != null) {
            Minecraft.getMinecraftGame().openScreen(screen);
        }
    }

    public boolean isOpen() {
        class_437 current = class_310.method_1551().field_1755;
        return current != null && this.clazz.isAssignableFrom(current.getClass());
    }

    public static Optional<ScreenRegistry> valueOf(Class<? extends class_437> screen) {
        return Arrays.stream(ScreenRegistry.values()).filter(m -> m.getClazz().isAssignableFrom(screen)).findFirst();
    }

    @Generated
    public Class<? extends class_437> getClazz() {
        return this.clazz;
    }

    @FunctionalInterface
    private static interface CatchableFunction {
        public class_437 apply(Object ... var1) throws Exception;
    }
}

