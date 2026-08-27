/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_4185
 */
package me.deftware.client.framework.gui.widgets;

import java.util.function.Function;
import me.deftware.client.framework.gui.widgets.Component;
import me.deftware.client.framework.gui.widgets.properties.Nameable;
import me.deftware.client.framework.gui.widgets.properties.Tooltipable;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_2561;
import net.minecraft.class_4185;

public interface Button
extends Component,
Nameable<Button>,
Tooltipable {
    @Deprecated
    public static Button create(int id, int x, int y, int widthIn, int heightIn, Message buttonText, boolean shouldPlaySound, Function<Integer, Boolean> onClick) {
        return Button.create(x, y, widthIn, heightIn, buttonText, shouldPlaySound, onClick);
    }

    public static Button create(int x, int y, int widthIn, int heightIn, Message buttonText, boolean shouldPlaySound, Function<Integer, Boolean> onClick) {
        class_4185 button = class_4185.method_46430((class_2561)((class_2561)buttonText), btn -> onClick.apply(0)).method_46434(x, y, widthIn, heightIn).method_46431();
        return (Button)button;
    }

    public void click();
}

