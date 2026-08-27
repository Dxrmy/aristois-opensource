/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_640
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.mixin.mixins.network;

import java.util.UUID;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.world.player.PlayerEntry;
import net.minecraft.class_640;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_640.class})
public class MixinPlayerListEntry
implements PlayerEntry {
    @Override
    public UUID _getProfileID() {
        return ((class_640)this).method_2966().getId();
    }

    @Override
    public String _getName() {
        return ((class_640)this).method_2966().getName();
    }

    @Override
    public Message _getDisplayName() {
        return (Message)((class_640)this).method_2971();
    }
}

