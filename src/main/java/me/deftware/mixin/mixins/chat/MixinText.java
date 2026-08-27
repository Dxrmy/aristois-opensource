/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.mixin.mixins.chat;

import me.deftware.client.framework.message.Message;
import net.minecraft.class_2561;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_2561.class})
public interface MixinText
extends Message {
}

