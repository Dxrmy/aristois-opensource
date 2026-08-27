/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_7172
 */
package me.deftware.client.framework.minecraft;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.class_310;
import net.minecraft.class_7172;

public abstract class GameSetting<T> {
    public static GameSetting<Integer> VIEW_DISTANCE = GameSetting.getSimpleOption(class_310.method_1551().field_1690.method_42503());
    public static GameSetting<Double> GAMMA = GameSetting.getSimpleOption(class_310.method_1551().field_1690.method_42473());
    public static GameSetting<Integer> MAX_FPS = GameSetting.getSimpleOption(class_310.method_1551().field_1690.method_42524());
    public static GameSetting<Boolean> DEBUG_INFO = GameSetting.getSimpleOption(() -> class_310.method_1551().method_53526().method_53536(), state -> class_310.method_1551().method_53526().method_53539());

    private static <E> GameSetting<E> getSimpleOption(final class_7172<E> option) {
        return new GameSetting<E>(){

            @Override
            public E get() {
                return option.method_41753();
            }

            @Override
            public void set(E value) {
                option.method_41748(value);
            }
        };
    }

    public static <E> GameSetting<E> getSimpleOption(final Supplier<E> supplier, final Consumer<E> consumer) {
        return new GameSetting<E>(){

            @Override
            public E get() {
                return supplier.get();
            }

            @Override
            public void set(E value) {
                consumer.accept(value);
            }
        };
    }

    public abstract T get();

    public abstract void set(T var1);

    public static class GuiScaleSetting
    extends GameSetting<Integer> {
        public static GuiScaleSetting INSTANCE = new GuiScaleSetting();

        private class_7172<Integer> getSetting() {
            return class_310.method_1551().field_1690.method_42474();
        }

        @Override
        public Integer get() {
            return (Integer)this.getSetting().method_41753();
        }

        @Override
        public void set(Integer value) {
            this.getSetting().method_41748((Object)value);
        }

        public double getScaleFactor() {
            return class_310.method_1551().method_22683().method_4495();
        }
    }
}

