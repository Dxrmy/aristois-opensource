/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_155
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 *  org.jetbrains.annotations.ApiStatus$Internal
 *  org.jetbrains.annotations.Nullable
 */
package me.deftware.client.framework.minecraft;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.message.GameChat;
import me.deftware.client.framework.minecraft.Chat;
import me.deftware.client.framework.minecraft.ServerDetails;
import me.deftware.client.framework.render.WorldEntityRenderer;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.session.AccountSession;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.WorldTimer;
import net.minecraft.class_1297;
import net.minecraft.class_155;
import net.minecraft.class_310;
import net.minecraft.class_320;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

public interface Minecraft {
    public static Minecraft getMinecraftGame() {
        return (Minecraft)class_310.method_1551();
    }

    @Nullable
    default public MainEntityPlayer _getPlayer() {
        if (this.getClientWorld() == null) {
            return null;
        }
        return (MainEntityPlayer)this.getClientWorld().getEntityByReference((class_1297)class_310.method_1551().field_1724);
    }

    @Nullable
    default public Entity _getCameraEntity() {
        if (this.getClientWorld() == null) {
            return null;
        }
        return this.getClientWorld().getEntityByReference(class_310.method_1551().field_1719);
    }

    default public GameChat getGameChat() {
        return (GameChat)class_310.method_1551().field_1705.method_1743();
    }

    public WorldEntityRenderer getWorldEntityRenderer();

    public GameCamera getCamera();

    default public File _getGameDir() {
        return class_310.method_1551().field_1697;
    }

    @Nullable
    public ClientWorld getClientWorld();

    public WorldTimer getWorldTimer();

    @Nullable
    public ServerDetails getConnectedServer();

    @Nullable
    public ServerDetails getLastConnectedServer();

    public void openScreen(GenericScreen var1);

    public Chat getChatSender();

    @Nullable
    public MinecraftScreen getScreen();

    public boolean _isOnRealms();

    public boolean _isSinglePlayer();

    public String _getWorldName();

    public boolean isMouseOver();

    @Nullable
    public BlockSwingResult getHitBlock();

    @Nullable
    public Entity getHitEntity();

    public void runOnRenderThread(Runnable var1);

    public void screenshot(File var1) throws IOException;

    public static String getMinecraftVersion() {
        return class_155.method_16673().method_48019();
    }

    public static int getMinecraftProtocolVersion() {
        return class_155.method_16673().method_48020();
    }

    public List<Function<List<String>, List<String>>> getDebugModifiers();

    public int getFPS();

    public void shutdown();

    @ApiStatus.Internal
    public class_320 getSession();

    @ApiStatus.Internal
    public void setSession(AccountSession var1);

    public void doRightClickMouse();

    public void doClickMouse();

    public void doMiddleClickMouse();

    public void setRightClickDelayTimer(int var1);

    public void setLastConnected(ServerDetails var1);
}

