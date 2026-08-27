/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.config.Settings
 *  me.deftware.client.framework.gui.screens.GenericScreen
 *  me.deftware.client.framework.gui.screens.MinecraftScreen
 *  me.deftware.client.framework.helper.WindowHelper
 *  me.deftware.client.framework.main.EMCMod
 *  me.deftware.client.framework.minecraft.Minecraft
 *  org.apache.commons.io.IOUtils
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCharCallback
 *  org.lwjgl.glfw.GLFWCharCallbackI
 */
package me.deftware.aristois.main;

import \u0000nunyaboolean.catch.for.if.break;
import \u0000nunyaboolean.catch.for.if.break.synchronized;
import \u0000nunyaboolean.catch.for.implements.extends;
import \u0000nunyaboolean.catch.for.int.enum;
import \u0000nunyaboolean.catch.for.super.enum.default;
import \u0000nunyaboolean.catch.for.transient.do;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;
import me.deftware.aristois.main.Validator;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.minecraft.Minecraft;
import org.apache.commons.io.IOUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCharCallbackI;

public class Main
extends EMCMod {
    private static Main instance;

    public static Settings getConfig() {
        return instance.getSettings();
    }

    public void setup() {
        GLFW.glfwSetCharCallback((long)WindowHelper.getWindowHandle(), (GLFWCharCallbackI)new GLFWCharCallback(){

            public void invoke(long window, int codepoint) {
                try {
                    MinecraftScreen screen = Minecraft.getMinecraftGame().getScreen();
                    if (screen instanceof break) {
                        break builder = (break)screen;
                        for (synchronized widget : builder.long()) {
                            if (!(widget instanceof default)) continue;
                            default consumer = (default)((Object)widget);
                            consumer.long(codepoint);
                        }
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        });
        if (!extends.static\u00a0const.implements()) {
            this.getResourceManager().setTransformer(this::transform);
        }
        enum.values();
        new \u0000nunyaboolean.catch.for.catch.do().run();
        new \u0000nunyaboolean.catch.for.null.enum();
    }

    public void initialize() {
        instance = this;
        if (Validator.isRuntimeValid()) {
            this.setup();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private InputStream transform(String path, InputStream stream) {
        if (!path.endsWith(".fsh")) return stream;
        try (InputStreamReader reader = new InputStreamReader(stream);){
            BufferedReader buffer = new BufferedReader(reader);
            String transformed = buffer.lines().map(this::transform).map(line -> line + "\n").collect(Collectors.joining());
            InputStream inputStream = IOUtils.toInputStream((String)transformed, (Charset)StandardCharsets.UTF_8);
            return inputStream;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return stream;
    }

    private String transform(String glsl) {
        if (glsl.startsWith("#version")) {
            return "#version 110";
        }
        if (glsl.startsWith("out")) {
            return "";
        }
        if (glsl.startsWith("in")) {
            return glsl.replace("in", "varying");
        }
        if (glsl.contains("texture")) {
            return glsl.replace("texture", "texture2D");
        }
        if (glsl.contains("fragColor")) {
            return glsl.replace("fragColor", "gl_FragColor");
        }
        return glsl;
    }

    public void postInit() {
        boolean isLegacy = this.isPresent("me.deftware.client.framework.chat.ChatMessage");
        try {
            int protocol = Minecraft.getMinecraftProtocolVersion();
            Validator.Version[] versions = Validator.getVersions();
            boolean isHigher = protocol > versions[0].protocol;
            boolean isSupported = Arrays.stream(versions).anyMatch(v -> v.protocol == protocol);
            if (!isSupported && !isHigher) {
                System.out.println("Aristois is no longer supported on this Minecraft version!");
                System.out.println("Please updated to a newer version of Minecraft");
                System.out.println("Aristois has built-in support for using lower versions with multiconnect");
                System.out.println("It can be installed in ESC > Addons");
                String clazz = "me.deftware.aristois.main.GuiOutdated";
                if (isLegacy) {
                    this.outdated(clazz);
                } else {
                    this.outdated(clazz + "Modern");
                }
                return;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if (!Validator.isRuntimeValid()) {
            System.out.println("Cannot start Aristois, please update");
            String clazz = "me.deftware.aristois.main.GuiUnsupported";
            if (isLegacy) {
                System.out.println("Invoking legacy unsupported screen");
                this.unsupported(clazz);
            } else {
                this.unsupported(clazz + "Modern");
            }
            return;
        }
        \u0000nunyaboolean.catch.for.null.enum.finally().switch();
    }

    public void onUnload() {
        do irc = \u0000nunyaboolean.catch.for.null.enum.finally().static();
        if (irc != null && irc.false()) {
            irc.implements();
        }
    }

    private boolean isPresent(String name) {
        try {
            Class.forName(name);
            return true;
        }
        catch (ClassNotFoundException e) {
            return false;
        }
    }

    private void unsupported(String name) {
        try {
            Class<?> clazz = Class.forName(name);
            Class<?> reason = Class.forName(name + "$UnsupportedReason");
            Object reasonInstance = reason.getEnumConstants()[0];
            clazz.getMethod("open", reason).invoke(null, reasonInstance);
        }
        catch (Throwable e) {
            throw new RuntimeException("Unable to load deprecated Aristois screen", e);
        }
    }

    private void outdated(String name) {
        try {
            Class<?> clazz = Class.forName(name);
            Object instance = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
            Minecraft.getMinecraftGame().openScreen((GenericScreen)((MinecraftScreen)instance));
        }
        catch (Throwable e) {
            throw new RuntimeException("Unable to load outdated Aristois screen", e);
        }
    }

    public static Main getInstance() {
        return instance;
    }
}

