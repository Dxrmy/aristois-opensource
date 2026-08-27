/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_4267$class_4270
 *  net.minecraft.class_642
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.network;

import me.deftware.client.framework.event.events.EventServerPinged;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_4267;
import net.minecraft.class_642;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_4267.class_4270.class})
public class MixinServerListEntryNormal {
    private boolean sentEvent = false;
    @Final
    @Shadow
    private class_642 field_19120;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    public void render(class_332 context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta, CallbackInfo ci) {
        if (this.field_19120.field_3758 > 1L && !this.sentEvent) {
            this.sentEvent = true;
            EventServerPinged event = new EventServerPinged((Message)this.field_19120.field_3757, (Message)this.field_19120.field_3753, (Message)this.field_19120.field_3760, this.field_19120.field_3756, this.field_19120.field_3758);
            event.broadcast();
            this.field_19120.field_3757 = (class_2561)event.getServerMOTD();
            this.field_19120.field_3760 = (class_2561)event.getGameVersion();
            this.field_19120.field_3753 = (class_2561)event.getPlayerList();
            this.field_19120.field_3756 = event.getVersion();
            this.field_19120.field_3758 = event.getPingToServer();
        }
    }
}

