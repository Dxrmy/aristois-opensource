/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_408
 *  net.minecraft.class_418
 *  net.minecraft.class_419
 *  net.minecraft.class_429
 *  net.minecraft.class_4325
 *  net.minecraft.class_433
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_465
 *  net.minecraft.class_500
 *  net.minecraft.class_525
 *  net.minecraft.class_526
 */
package me.deftware.client.framework.gui;

import java.util.Arrays;
import java.util.Optional;
import lombok.Generated;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.minecraft.Minecraft;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_418;
import net.minecraft.class_419;
import net.minecraft.class_429;
import net.minecraft.class_4325;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_465;
import net.minecraft.class_500;
import net.minecraft.class_525;
import net.minecraft.class_526;

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

