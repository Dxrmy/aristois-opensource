/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_2248
 *  net.minecraft.class_2386
 *  net.minecraft.class_2492
 *  net.minecraft.class_4622
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_7923
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.block;

import me.deftware.client.framework.event.events.EventSlowdown;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.class_2386;
import net.minecraft.class_2492;
import net.minecraft.class_4622;
import net.minecraft.class_4970;
import net.minecraft.class_7923;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2248.class})
public abstract class MixinBlock
extends class_4970
implements Block {
    @Unique
    private final EventSlowdown eventSlowdown = new EventSlowdown();

    public MixinBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    @Inject(method={"getSlipperiness"}, at={@At(value="TAIL")}, cancellable=true)
    public void getSlipperiness(CallbackInfoReturnable<Float> cir) {
        if (this.field_23163 != 0.6f) {
            class_2248 block = class_2248.method_9503((class_1792)this.method_8389());
            boolean flag = false;
            if (block instanceof class_2386 || block.method_63499().contains("blue_ice") || block.method_63499().contains("packed_ice")) {
                flag = true;
                this.eventSlowdown.create(EventSlowdown.SlowdownType.Slipperiness, 0.6f);
            }
            if (flag) {
                this.eventSlowdown.broadcast();
                if (this.eventSlowdown.isCanceled()) {
                    cir.setReturnValue((Object)Float.valueOf(this.eventSlowdown.getMultiplier()));
                }
            }
        }
    }

    @Inject(method={"getVelocityMultiplier"}, at={@At(value="TAIL")}, cancellable=true)
    private void onGetVelocityMultiplier(CallbackInfoReturnable<Float> cir) {
        if (this.field_23164 != 1.0f) {
            class_2248 block = class_2248.method_9503((class_1792)this.method_8389());
            boolean flag = false;
            if (block instanceof class_4622) {
                flag = true;
                this.eventSlowdown.create(EventSlowdown.SlowdownType.Honey, 1.0f);
            } else if (block instanceof class_2492) {
                flag = true;
                this.eventSlowdown.create(EventSlowdown.SlowdownType.Soulsand, 1.0f);
            }
            if (flag) {
                this.eventSlowdown.broadcast();
                if (this.eventSlowdown.isCanceled()) {
                    cir.setReturnValue((Object)Float.valueOf(this.eventSlowdown.getMultiplier()));
                }
            }
        }
    }

    @Override
    @Unique
    public String getIdentifierKey() {
        return class_7923.field_41175.method_10221((Object)((class_2248)this)).method_12832();
    }

    @Override
    @Unique
    public Item getItem() {
        return (Item)this.method_8389();
    }

    @Override
    @Unique
    public int getID() {
        return class_7923.field_41175.method_10206((Object)((class_2248)this));
    }

    @Override
    @Unique
    public Message getName() {
        return (Message)((class_2248)this).method_9518();
    }
}

