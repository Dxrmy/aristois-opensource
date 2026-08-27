/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_2558
 *  net.minecraft.class_2558$class_2559
 *  net.minecraft.class_2561
 *  net.minecraft.class_2568
 *  net.minecraft.class_2568$class_5247
 *  net.minecraft.class_2583
 */
package me.deftware.client.framework.message;

import java.util.ArrayList;
import java.util.Optional;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_124;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2568;
import net.minecraft.class_2583;

public interface Appearance {
    public static final int OBFUSCATED = 1;
    public static final int BOLD = 2;
    public static final int STRIKETHROUGH = 4;
    public static final int UNDERLINED = 8;
    public static final int ITALIC = 16;

    public static Appearance empty() {
        return (Appearance)class_2583.field_24360;
    }

    public static Appearance of(FormattingColor color) {
        return Appearance.of(0, color);
    }

    public static Appearance of(int flags) {
        return Appearance.of(flags, null);
    }

    public static Appearance of(int flags, FormattingColor color) {
        Appearance style = (Appearance)class_2583.field_24360;
        if (flags > 0) {
            style = style.format(flags);
        }
        if (color != null) {
            style = style.color(color);
        }
        return style;
    }

    default public Appearance format(int flags) {
        ArrayList<class_124> options = new ArrayList<class_124>();
        if ((flags & 0x10) != 0) {
            options.add(class_124.field_1056);
        }
        if ((flags & 2) != 0) {
            options.add(class_124.field_1067);
        }
        if ((flags & 8) != 0) {
            options.add(class_124.field_1073);
        }
        if ((flags & 4) != 0) {
            options.add(class_124.field_1055);
        }
        if ((flags & 1) != 0) {
            options.add(class_124.field_1051);
        }
        return (Appearance)((class_2583)this).method_27705(options.toArray(new class_124[0]));
    }

    default public Appearance color(FormattingColor color) {
        return (Appearance)((class_2583)this).method_36139(color.getColor());
    }

    default public Appearance withClickEvent(ClickAction action, String value) {
        class_2558 event = new class_2558(action.getAction(), value);
        return (Appearance)((class_2583)this).method_10958(event);
    }

    default public Appearance withTextHoverEvent(Message text) {
        class_2568 event = new class_2568(class_2568.class_5247.field_24342, (Object)((class_2561)text));
        return (Appearance)((class_2583)this).method_10949(event);
    }

    public boolean isItalic();

    public boolean isBold();

    public boolean isUnderlined();

    public boolean isStrikethrough();

    public boolean isObfuscated();

    public static interface FormattingColor {
        public String getName();

        public Optional<Character> getCode();

        public int getColor();

        public static FormattingColor ofRGB(final int rgb) {
            return new FormattingColor(){

                @Override
                public String getName() {
                    return "RGB";
                }

                @Override
                public Optional<Character> getCode() {
                    return Optional.empty();
                }

                @Override
                public int getColor() {
                    return rgb;
                }
            };
        }
    }

    public static enum ClickAction {
        OPEN_URL(class_2558.class_2559.field_11749),
        OPEN_FILE(class_2558.class_2559.field_11746),
        RUN_COMMAND(class_2558.class_2559.field_11750),
        SUGGEST_COMMAND(class_2558.class_2559.field_11745),
        CHANGE_PAGE(class_2558.class_2559.field_11748),
        COPY_TO_CLIPBOARD(class_2558.class_2559.field_21462);

        private final class_2558.class_2559 action;

        private ClickAction(class_2558.class_2559 action) {
            this.action = action;
        }

        public class_2558.class_2559 getAction() {
            return this.action;
        }
    }
}

