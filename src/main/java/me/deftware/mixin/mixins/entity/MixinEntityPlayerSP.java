/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.attribute.EntityAttribute
 *  net.minecraft.entity.player.HungerManager
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.client.network.ClientPlayerEntity
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.entity;

import me.deftware.client.framework.event.events.EventChatSend;
import me.deftware.client.framework.event.events.EventGuiContainerClose;
import me.deftware.client.framework.event.events.EventPlayerWalking;
import me.deftware.client.framework.event.events.EventSlowdown;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Chat;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import me.deftware.mixin.imp.IMixinEntityPlayerSP;
import me.deftware.mixin.mixins.entity.MixinEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_746.class})
public abstract class MixinEntityPlayerSP
extends MixinEntity
implements IMixinEntityPlayerSP,
Chat {
    @Shadow
    @Final
    protected class_310 field_3937;
    @Shadow
    private float field_3922;
    @Shadow
    @Final
    public class_634 field_3944;
    @Unique
    private final EventSlowdown eventSlowdown = new EventSlowdown();
    @Unique
    private final EventUpdate eventUpdate = new EventUpdate();
    @Unique
    private final EventPlayerWalking eventPlayerWalking = new EventPlayerWalking();
    @Unique
    private final EventPlayerWalking.PostEvent postEvent = new EventPlayerWalking.PostEvent();

    @Shadow
    public abstract boolean method_6115();

    @Inject(method={"closeHandledScreen"}, at={@At(value="HEAD")})
    private void onCloseHandledScreen(CallbackInfo ci) {
        new EventGuiContainerClose().broadcast();
    }

    @Inject(at={@At(value="HEAD")}, cancellable=true, method={"isCamera"})
    public void isCamera(CallbackInfoReturnable<Boolean> info) {
        if (CameraEntityMan.isActive()) {
            info.setReturnValue((Object)true);
            info.cancel();
        }
    }

    @Redirect(method={"tickMovement"}, at=@At(value="INVOKE", target="net/minecraft/client/network/ClientPlayerEntity.isUsingItem()Z", ordinal=0))
    private boolean itemUseSlowdownEvent(class_746 self) {
        this.eventSlowdown.create(EventSlowdown.SlowdownType.Item_Use, 1.0f);
        this.eventSlowdown.broadcast();
        if (this.eventSlowdown.isCanceled()) {
            return false;
        }
        return this.method_6115();
    }

    @Redirect(method={"canSprint"}, at=@At(value="INVOKE", target="net/minecraft/entity/player/HungerManager.getFoodLevel()I"))
    private int hungerSlowdownEvent(class_1702 self) {
        this.eventSlowdown.create(EventSlowdown.SlowdownType.Hunger, 1.0f);
        this.eventSlowdown.broadcast();
        if (this.eventSlowdown.isCanceled()) {
            return 7;
        }
        return self.method_7586();
    }

    @Redirect(method={"canStartSprinting"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;hasStatusEffect(Lnet/minecraft/registry/entry/RegistryEntry;)Z"))
    private boolean onBlindnessSlowdown(class_746 self, class_6880<class_1291> effect) {
        this.eventSlowdown.create(EventSlowdown.SlowdownType.Blindness, 1.0f);
        this.eventSlowdown.broadcast();
        if (this.eventSlowdown.isCanceled()) {
            return false;
        }
        return self.method_6059(effect);
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")}, cancellable=true)
    private void tick(CallbackInfo ci) {
        if (class_310.method_1551().field_1687 != null && class_310.method_1551().field_1724 != null) {
            this.eventUpdate.create(((class_746)this).method_23317(), ((class_746)this).method_23318(), ((class_746)this).method_23321(), this.method_36454(), this.method_36455(), ((class_1297)this).method_24828());
            this.eventUpdate.broadcast();
            if (this.eventUpdate.isCanceled()) {
                ci.cancel();
            }
        }
    }

    @Override
    public void setHorseJumpPower(float height) {
        this.field_3922 = height;
    }

    @Inject(method={"sendMovementPackets"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendMovementPackets(CallbackInfo ci) {
        class_746 entity = (class_746)this;
        this.eventPlayerWalking.create(entity.method_23317(), entity.method_23318(), entity.method_23321(), this.method_36454(), this.method_36455(), ((class_1297)this).method_24828());
        this.eventPlayerWalking.broadcast();
        if (this.eventPlayerWalking.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"sendMovementPackets"}, at={@At(value="TAIL")}, cancellable=true)
    private void onSendMovementPacketsTail(CallbackInfo ci) {
        class_746 entity = (class_746)this;
        this.postEvent.create(entity.method_23317(), entity.method_23318(), entity.method_23321(), this.method_36454(), this.method_36455(), ((class_1297)this).method_24828());
        this.postEvent.broadcast();
        if (this.postEvent.isCanceled()) {
            ci.cancel();
        }
    }

    @Override
    @Unique
    public void message(String text, Class<?> sender) {
        Chat.send(arg_0 -> ((class_634)this.field_3944).method_45729(arg_0), text, sender, EventChatSend.Type.Message);
    }

    @Override
    @Unique
    public void command(String text, Class<?> sender) {
        Chat.send(arg_0 -> ((class_634)this.field_3944).method_45730(arg_0), text, sender, EventChatSend.Type.Command);
    }

    @Redirect(method={"tickMovement"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getAttributeValue(Lnet/minecraft/registry/entry/RegistryEntry;)D"))
    private double onTickMovement$SlowdownMP(class_746 instance, class_6880<class_1320> registryEntry) {
        double value = instance.method_45325(registryEntry);
        this.eventSlowdown.create(EventSlowdown.SlowdownType.Sneak, (float)value);
        this.eventSlowdown.broadcast();
        if (this.eventSlowdown.isCanceled()) {
            return 1.0;
        }
        return value;
    }
}

