/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1060
 *  net.minecraft.class_310
 *  net.minecraft.class_425
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import net.minecraft.class_1060;
import net.minecraft.class_310;
import net.minecraft.class_425;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_425.class})
public class MixinSplashScreen {
    @Shadow
    @Final
    private boolean field_18219;

    @Inject(method={"init"}, at={@At(value="HEAD")})
    private static void init(class_1060 textureManager, CallbackInfo ci) {
        Bootstrap.init();
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;init(Lnet/minecraft/client/MinecraftClient;II)V"))
    private void onInit(class_437 instance, class_310 client, int width, int height) {
        if (!this.field_18219) {
            Bootstrap.getMods().values().forEach(EMCMod::postInit);
            client.field_1755.method_25423(client, width, height);
        }
    }
}

