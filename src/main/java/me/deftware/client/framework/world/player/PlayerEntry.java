/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.world.player;

import java.util.UUID;
import me.deftware.client.framework.message.Message;

public interface PlayerEntry {
    public UUID _getProfileID();

    public String _getName();

    public Message _getDisplayName();
}

