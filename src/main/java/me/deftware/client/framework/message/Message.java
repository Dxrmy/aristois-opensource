/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.Message
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_2588
 *  net.minecraft.class_5250
 *  net.minecraft.class_7417
 *  net.minecraft.class_8828
 */
package me.deftware.client.framework.message;

import java.util.Optional;
import java.util.function.BiFunction;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.minecraft.Minecraft;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2588;
import net.minecraft.class_5250;
import net.minecraft.class_7417;
import net.minecraft.class_8828;

public interface Message
extends com.mojang.brigadier.Message {
    public static final Message SPACE = (Message)class_2561.method_43470((String)" ");
    public static final Message EMPTY = (Message)class_2561.method_43470((String)"");
    public static final String CHEVRON = String.valueOf('»');

    default public Optional<Message> visit(BiFunction<Appearance, String, Optional<Message>> visitor) {
        return Message.visit((class_2561)this, class_2583.field_24360, visitor);
    }

    default public Message append(Message text) {
        Message message = this;
        if (message instanceof class_5250) {
            class_5250 message2 = (class_5250)message;
            message2.method_10852((class_2561)text);
            return this;
        }
        throw new UnsupportedOperationException("Cannot append to immutable message");
    }

    default public Message style(Appearance style) {
        Message message = this;
        if (message instanceof class_5250) {
            class_5250 message2 = (class_5250)message;
            message2.method_10862((class_2583)style);
            return this;
        }
        throw new UnsupportedOperationException("Cannot style immutable message");
    }

    default public Message mutate(BiFunction<Appearance, String, Optional<Message>> visitor) {
        Builder builder = new Builder(null);
        this.visit((style, text) -> {
            Optional result = (Optional)visitor.apply((Appearance)style, (String)text);
            result.ifPresent(builder::append);
            return Optional.empty();
        });
        return builder.build();
    }

    default public Message copy() {
        return (Message)((class_2561)this).method_27661();
    }

    default public String string() {
        return this.getString();
    }

    default public boolean isMutable() {
        return this instanceof class_5250;
    }

    public static Message of(String text) {
        return (Message)class_2561.method_43470((String)text);
    }

    public static Message translated(String key, Object ... args) {
        return (Message)class_2561.method_43469((String)key, (Object[])args);
    }

    default public void print() {
        Minecraft.getMinecraftGame().getGameChat().append(this);
    }

    default public boolean isTranslatable() {
        return ((class_2561)this).method_10851() instanceof class_2588;
    }

    default public String getTranslationKey() {
        if (!this.isTranslatable()) {
            throw new IllegalStateException("Message is not translatable");
        }
        return ((class_2588)((class_2561)this).method_10851()).method_11022();
    }

    private static Optional<Message> visit(class_2561 ref, class_2583 superStyle, BiFunction<Appearance, String, Optional<Message>> visitor) {
        Optional<Message> optional;
        class_2583 style = ref.method_10866().method_27702(superStyle);
        class_7417 class_74172 = ref.method_10851();
        if (class_74172 instanceof class_8828) {
            class_8828 content = (class_8828)class_74172;
            optional = visitor.apply((Appearance)style, content.comp_737());
        } else {
            optional = ref.method_10851().method_27660((s, text) -> (Optional)visitor.apply((Appearance)s, text), style);
        }
        if (optional.isPresent()) {
            return optional;
        }
        for (class_2561 sibling : ref.method_10855()) {
            Optional<Message> result = Message.visit(sibling, style, visitor);
            if (!result.isPresent()) continue;
            return result;
        }
        return Optional.empty();
    }

    public static class Builder {
        private Message message;

        public Builder(Message message) {
            this.message = message;
        }

        public Builder() {
            this(Message.of(class_8828.field_46625.comp_737()).style(Appearance.of(DefaultColors.WHITE)));
        }

        public Builder append(Message message) {
            if (this.message == null) {
                this.message = message;
            } else {
                this.message.append(message);
            }
            return this;
        }

        public Builder append(Message message, Appearance style) {
            message.style(style);
            return this.append(message);
        }

        public Builder append(String text, Appearance style) {
            Message message = Message.of(text);
            message.style(style);
            return this.append(message);
        }

        public Builder append(String text) {
            return this.append(Message.of(text));
        }

        public Message build() {
            if (this.message == null) {
                throw new IllegalStateException("Cannot build empty message");
            }
            return this.message;
        }
    }
}

