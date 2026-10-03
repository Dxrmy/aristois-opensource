/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ServerInfo
 *  net.minecraft.client.network.ServerInfo$Status
 *  org.spongepowered.asm.mixin.Mixin
 */
package me.deftware.mixin.mixins.network;

import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.ServerDetails;
import net.minecraft.client.network.ServerInfo;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_642.class})
public class MixinServerInfo
implements ServerDetails {
    @Override
    public String _getName() {
        return ((class_642)this).field_3752;
    }

    @Override
    public String _getAddress() {
        return ((class_642)this).field_3761;
    }

    @Override
    public Message _getMotd() {
        return (Message)((class_642)this).field_3757;
    }

    @Override
    public Message _getPlayers() {
        return (Message)((class_642)this).field_3753;
    }

    @Override
    public boolean _isOnline() {
        return ((class_642)this).method_55825() == class_642.class_9083.field_47884;
    }

    @Override
    public boolean _isLan() {
        return ((class_642)this).method_2994();
    }
}

