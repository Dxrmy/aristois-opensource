/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.screen.ShulkerBoxScreenHandler
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package me.deftware.mixin.mixins.gui;

import me.deftware.mixin.imp.IMixinShulkerBoxScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ShulkerBoxScreenHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={class_1733.class})
public class MixinShulkerBoxScreenHandler
implements IMixinShulkerBoxScreenHandler {
    @Shadow
    @Final
    private class_1263 field_7867;

    @Override
    public class_1263 getInventory() {
        return this.field_7867;
    }
}

