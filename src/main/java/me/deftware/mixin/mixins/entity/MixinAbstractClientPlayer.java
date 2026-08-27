/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_2960
 *  net.minecraft.class_638
 *  net.minecraft.class_640
 *  net.minecraft.class_742
 *  net.minecraft.class_8685
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.entity;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import me.deftware.client.framework.cosmetics.CosmeticProvider;
import me.deftware.client.framework.cosmetics.PlayerTexture;
import me.deftware.client.framework.event.events.EventFovModifier;
import me.deftware.client.framework.event.events.EventSpectator;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;
import me.deftware.mixin.imp.IMixinAbstractClientPlayer;
import net.minecraft.class_2960;
import net.minecraft.class_638;
import net.minecraft.class_640;
import net.minecraft.class_742;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_742.class})
public abstract class MixinAbstractClientPlayer
implements IMixinAbstractClientPlayer {
    @Shadow
    private class_640 field_3901;
    @Unique
    private class_8685 customSkinTexture;

    @Inject(method={"isSpectator"}, at={@At(value="TAIL")}, cancellable=true)
    private void onIsSpectator(CallbackInfoReturnable<Boolean> cir) {
        EventSpectator event = new EventSpectator((Boolean)cir.getReturnValue());
        cir.setReturnValue((Object)event.isSpectator());
    }

    @ModifyVariable(method={"getFovMultiplier"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/AbstractClientPlayerEntity;getAttributeValue(Lnet/minecraft/entity/attribute/EntityAttribute;)D"))
    private float onGetSpeed(float fov) {
        EventFovModifier event = new EventFovModifier(fov);
        event.broadcast();
        return event.getFov();
    }

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void onInit(class_638 world, GameProfile profile, CallbackInfo ci) {
        UUID id = profile.getId();
        for (CosmeticProvider provider : CosmeticProvider.PROVIDERS) {
            provider.load(id, () -> {
                PlayerTexture texture = provider.getPlayerTexture(id);
                if (texture != null && this.field_3901 != null) {
                    class_8685 playerTexture = this.field_3901.method_52810();
                    MinecraftIdentifier cape = texture.getCapeTexture();
                    this.customSkinTexture = new class_8685(playerTexture.comp_1626(), playerTexture.comp_1911(), (class_2960)cape, (class_2960)cape, playerTexture.comp_1629(), playerTexture.comp_1630());
                }
            });
        }
    }

    @Override
    @Unique
    public class_640 getPlayerNetworkInfo() {
        return this.field_3901;
    }

    @Override
    @Unique
    public class_8685 getCustomSkinTexture() {
        return this.customSkinTexture;
    }
}

