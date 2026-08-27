/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.minecraft.MinecraftSessionService
 *  com.mojang.authlib.minecraft.UserApiService
 *  com.mojang.blaze3d.systems.RenderSystem
 *  lombok.Generated
 *  net.minecraft.class_1011
 *  net.minecraft.class_155
 *  net.minecraft.class_239
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_32$class_5143
 *  net.minecraft.class_320
 *  net.minecraft.class_3283
 *  net.minecraft.class_340
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_437
 *  net.minecraft.class_638
 *  net.minecraft.class_642
 *  net.minecraft.class_6683
 *  net.minecraft.class_6683$class_6684
 *  net.minecraft.class_6904
 *  net.minecraft.class_7853
 *  org.jetbrains.annotations.Nullable
 *  org.slf4j.Logger
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.game;

import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.minecraft.UserApiService;
import com.mojang.blaze3d.systems.RenderSystem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lombok.Generated;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.minecraft.Chat;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.minecraft.ServerDetails;
import me.deftware.client.framework.render.WorldEntityRenderer;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.session.AccountSession;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.WorldTimer;
import net.minecraft.class_1011;
import net.minecraft.class_155;
import net.minecraft.class_239;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_32;
import net.minecraft.class_320;
import net.minecraft.class_3283;
import net.minecraft.class_340;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_437;
import net.minecraft.class_638;
import net.minecraft.class_642;
import net.minecraft.class_6683;
import net.minecraft.class_6904;
import net.minecraft.class_7853;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_310.class})
public abstract class MixinMinecraft
implements Minecraft {
    @Unique
    private ServerDetails lastConnectedServer;
    @Unique
    private static BlockSwingResult swingResult;
    @Unique
    private final List<Function<List<String>, List<String>>> debugModifiers = new ArrayList<Function<List<String>, List<String>>>();
    @Mutable
    @Shadow
    @Final
    private class_320 field_1726;
    @Mutable
    @Shadow
    @Final
    private MinecraftSessionService field_1723;
    @Mutable
    @Shadow
    @Final
    private UserApiService field_26902;
    @Shadow
    private static int field_1738;
    @Shadow
    private int field_1752;
    @Shadow
    @Final
    private static Logger field_1762;
    @Shadow
    @Mutable
    @Final
    private class_7853 field_39068;
    @Shadow
    @Final
    public File field_1697;
    @Unique
    private String worldName;

    @Shadow
    protected abstract boolean method_1536();

    @Shadow
    protected abstract void method_1583();

    @Shadow
    protected abstract void method_1511();

    @Inject(method={"startIntegratedServer"}, at={@At(value="HEAD")})
    private void onIntegratedServer(class_32.class_5143 session, class_3283 resourcePackManager, class_6904 saveLoader, boolean bl, CallbackInfo ci) {
        this.worldName = saveLoader.comp_359().method_150();
    }

    @Override
    public String _getWorldName() {
        return this.worldName;
    }

    @Override
    public GameCamera getCamera() {
        return (GameCamera)((class_310)this).method_1561().field_4686;
    }

    @Override
    @Nullable
    public ClientWorld getClientWorld() {
        return (ClientWorld)((class_310)this).field_1687;
    }

    @Override
    public WorldTimer getWorldTimer() {
        return (WorldTimer)((Object)this);
    }

    @Override
    @Nullable
    public ServerDetails getConnectedServer() {
        return (ServerDetails)((class_310)this).method_1558();
    }

    @Override
    public void openScreen(GenericScreen screen) {
        ((class_310)this).method_1507((class_437)screen);
    }

    @Override
    @Nullable
    public MinecraftScreen getScreen() {
        return (MinecraftScreen)((class_310)this).field_1755;
    }

    @Override
    public boolean _isOnRealms() {
        class_642 serverInfo = ((class_310)this).method_1558();
        return serverInfo != null && serverInfo.method_52811();
    }

    @Override
    public boolean _isSinglePlayer() {
        return ((class_310)this).method_1542();
    }

    @Override
    public boolean isMouseOver() {
        return ((class_310)this).field_1765 != null;
    }

    @Override
    public void runOnRenderThread(Runnable runnable) {
        RenderSystem.recordRenderCall(runnable::run);
    }

    @Override
    public int getFPS() {
        return field_1738;
    }

    @Override
    public void shutdown() {
        ((class_310)this).method_1490();
    }

    @Override
    public class_320 getSession() {
        return this.field_1726;
    }

    @Override
    public void setSession(AccountSession session) {
        this.field_1726 = session.getSession();
        try {
            this.field_1723 = session.getSessionService();
            this.field_26902 = session.getAuthenticationService().createUserApiService(this.field_1726.method_1674());
            this.field_39068 = class_7853.method_46532((UserApiService)this.field_26902, (class_320)this.field_1726, (Path)this.field_1697.toPath());
        }
        catch (Exception ex) {
            this.field_26902 = UserApiService.OFFLINE;
            field_1762.error("Failed to authenticate session", (Throwable)ex);
        }
    }

    @Override
    public BlockSwingResult getHitBlock() {
        class_239 class_2392 = class_310.method_1551().field_1765;
        if (class_2392 instanceof class_3965) {
            class_3965 blockHitResult = (class_3965)class_2392;
            if (swingResult == null) {
                swingResult = new BlockSwingResult((class_239)blockHitResult);
            } else {
                swingResult.setReference((class_239)blockHitResult);
            }
            return swingResult;
        }
        return null;
    }

    @Override
    public Entity getHitEntity() {
        class_239 class_2392 = class_310.method_1551().field_1765;
        if (class_2392 instanceof class_3966) {
            class_3966 entityHitResult = (class_3966)class_2392;
            return ClientWorld.getClientWorld().getEntityByReference(entityHitResult.method_17782());
        }
        return null;
    }

    @Override
    public void setRightClickDelayTimer(int delay) {
        this.field_1752 = delay;
    }

    @Override
    public void doClickMouse() {
        this.method_1536();
    }

    @Override
    public void doRightClickMouse() {
        this.method_1583();
    }

    @Override
    public void doMiddleClickMouse() {
        this.method_1511();
    }

    @Inject(method={"getModStatus"}, at={@At(value="TAIL")}, cancellable=true)
    private static void isModdedCheck(CallbackInfoReturnable<class_6683> cir) {
        cir.setReturnValue((Object)new class_6683(class_6683.class_6684.field_35174, "Client jar signature and brand is untouched"));
    }

    @Inject(method={"getVersionType"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetVersionType(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue((Object)"release");
    }

    @Inject(method={"getGameVersion"}, at={@At(value="TAIL")}, cancellable=true)
    private void onGetGameVersion(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue((Object)class_155.method_16673().method_48019());
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/DebugHud;shouldShowDebugHud()Z"))
    private boolean onScreenTick(class_340 instance) {
        class_437 class_4372 = ((class_310)this).field_1755;
        if (class_4372 instanceof MinecraftScreen) {
            MinecraftScreen screen = (MinecraftScreen)class_4372;
            screen.getEventScreen().setType(EventScreen.Type.Tick).broadcast();
        }
        return instance.method_53536();
    }

    @Override
    public WorldEntityRenderer getWorldEntityRenderer() {
        return (WorldEntityRenderer)((class_310)this).field_1769;
    }

    @Inject(method={"setWorld"}, at={@At(value="TAIL")})
    private void onSetWorld(class_638 world, CallbackInfo ci) {
        new EventWorldLoad((ClientWorld)world).broadcast();
    }

    @Override
    public Chat getChatSender() {
        return (Chat)((class_310)this).field_1724;
    }

    @Override
    @Unique
    public void setLastConnected(ServerDetails details) {
        this.lastConnectedServer = details;
    }

    @Override
    @Unique
    public void screenshot(File file) throws IOException {
        String name = file.getName();
        try (class_1011 image = class_318.method_1663((class_276)((class_310)this).method_1522());){
            image.method_4325(file);
        }
    }

    @Override
    @Generated
    public ServerDetails getLastConnectedServer() {
        return this.lastConnectedServer;
    }

    @Override
    @Generated
    public List<Function<List<String>, List<String>>> getDebugModifiers() {
        return this.debugModifiers;
    }
}

