/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.gui;

import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.message.Message;
import me.deftware.mixin.mixins.gui.MixinGuiScreen;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_465.class})
public abstract class MixinGuiContainer<T extends class_1703>
extends MixinGuiScreen
implements ContainerScreen {
    @Shadow
    protected class_1735 field_2787;
    @Shadow
    @Final
    protected T field_2797;

    @Override
    public class_1735 getMinecraftSlot() {
        return this.field_2787;
    }

    @Override
    public class_1703 getScreenHandler() {
        return this.field_2797;
    }

    @Override
    public Inventory getContainerInventory() {
        return (Inventory)this.getHandlerInventory();
    }

    @Override
    public Message getInventoryName() {
        return (Message)((class_437)this).method_25440();
    }

    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void onPostDraw(class_332 context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        this.onPostDrawEvent(context, mouseX, mouseY, delta);
    }
}

