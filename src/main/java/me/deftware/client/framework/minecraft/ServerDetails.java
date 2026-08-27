/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.minecraft;

import me.deftware.client.framework.message.Message;

public interface ServerDetails {
    public String _getName();

    public String _getAddress();

    public Message _getMotd();

    public Message _getPlayers();

    public boolean _isOnline();

    public boolean _isLan();
}

