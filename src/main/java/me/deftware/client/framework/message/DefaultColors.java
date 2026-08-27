/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.message;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import me.deftware.client.framework.message.Appearance;

public enum DefaultColors implements Appearance.FormattingColor
{
    BLACK("BLACK", '0', 0),
    DARK_BLUE("DARK_BLUE", '1', 170),
    DARK_GREEN("DARK_GREEN", '2', 43520),
    DARK_AQUA("DARK_AQUA", '3', 43690),
    DARK_RED("DARK_RED", '4', 0xAA0000),
    DARK_PURPLE("DARK_PURPLE", '5', 0xAA00AA),
    GOLD("GOLD", '6', 0xFFAA00),
    GRAY("GRAY", '7', 0xAAAAAA),
    DARK_GRAY("DARK_GRAY", '8', 0x555555),
    BLUE("BLUE", '9', 0x5555FF),
    GREEN("GREEN", 'a', 0x55FF55),
    AQUA("AQUA", 'b', 0x55FFFF),
    RED("RED", 'c', 0xFF5555),
    LIGHT_PURPLE("LIGHT_PURPLE", 'd', 0xFF55FF),
    YELLOW("YELLOW", 'e', 0xFFFF55),
    WHITE("WHITE", 'f', 0xFFFFFF);

    public static final Map<Character, Appearance.FormattingColor> CODE_TO_RGB;
    private final String name;
    private final char code;
    private final int rgb;

    private DefaultColors(String name, char code, int rgb) {
        this.name = name;
        this.code = code;
        this.rgb = rgb;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Optional<Character> getCode() {
        return Optional.of(Character.valueOf(this.code));
    }

    @Override
    public int getColor() {
        return this.rgb;
    }

    static {
        CODE_TO_RGB = Arrays.stream(DefaultColors.values()).collect(Collectors.toMap(v -> v.getCode().get(), Function.identity()));
    }
}

