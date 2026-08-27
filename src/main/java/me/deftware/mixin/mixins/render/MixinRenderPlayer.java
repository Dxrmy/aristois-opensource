/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1007
 *  net.minecraft.class_742
 *  net.minecraft.class_8685
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.render;

import me.deftware.client.framework.event.events.EventSetModelVisibilities;
import me.deftware.mixin.imp.IMixinAbstractClientPlayer;
import net.minecraft.class_1007;
import net.minecraft.class_742;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_1007.class})
public class MixinRenderPlayer {
    @Redirect(method={"updateRenderState(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;F)V"}, at=@At(value="INVOKE", target="net/minecraft/client/network/AbstractClientPlayerEntity.isSpectator()Z", opcode=180))
    private boolean setModelVisibilities_isSpectator(class_742 self) {
        EventSetModelVisibilities event = new EventSetModelVisibilities(self.method_7325());
        event.broadcast();
        return event.isSpectator();
    }

    @Redirect(method={"updateRenderState(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;F)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/AbstractClientPlayerEntity;getSkinTextures()Lnet/minecraft/client/util/SkinTextures;"))
    private class_8685 onUpdateRenderState(class_742 instance) {
        class_8685 texture = ((IMixinAbstractClientPlayer)instance).getCustomSkinTexture();
        if (texture != null) {
            return texture;
        }
        return instance.method_52814();
    }
}

