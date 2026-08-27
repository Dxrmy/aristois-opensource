/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventParticle
extends Event {
    private String id;
    private double x;
    private double y;
    private double z;
    private double velocityX;
    private double velocityZ;
    private double velocityY;

    public EventParticle(String id, double x, double y, double z, double velocityX, double velocityZ, double velocityY) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.velocityX = velocityX;
        this.velocityZ = velocityZ;
        this.velocityY = velocityY;
    }

    public String getId() {
        return this.id;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getVelocityX() {
        return this.velocityX;
    }

    public double getVelocityZ() {
        return this.velocityZ;
    }

    public double getVelocityY() {
        return this.velocityY;
    }
}

