/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.message.Message;

public class EventServerPinged
extends Event {
    private Message serverMOTD;
    private Message playerList;
    private Message gameVersion;
    private int version;
    private long pingToServer;

    public EventServerPinged(Message serverMOTD, Message playerList, Message gameVersion, int version, long pingToServer) {
        this.serverMOTD = serverMOTD;
        this.playerList = playerList;
        this.gameVersion = gameVersion;
        this.version = version;
        this.pingToServer = pingToServer;
    }

    public Message getServerMOTD() {
        return this.serverMOTD;
    }

    public Message getPlayerList() {
        return this.playerList;
    }

    public Message getGameVersion() {
        return this.gameVersion;
    }

    public int getVersion() {
        return this.version;
    }

    public long getPingToServer() {
        return this.pingToServer;
    }

    public void setServerMOTD(Message serverMOTD) {
        this.serverMOTD = serverMOTD;
    }

    public void setPlayerList(Message playerList) {
        this.playerList = playerList;
    }

    public void setGameVersion(Message gameVersion) {
        this.gameVersion = gameVersion;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setPingToServer(long pingToServer) {
        this.pingToServer = pingToServer;
    }
}

