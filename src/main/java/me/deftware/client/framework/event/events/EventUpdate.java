/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;

public class EventUpdate
extends Event {
    protected double posX;
    protected double posY;
    protected double posZ;
    protected float rotationYaw;
    protected float rotationPitch;
    protected boolean onGround;

    public EventUpdate() {
    }

    public EventUpdate(double posX, double posY, double posZ, float rotationYaw, float rotationPitch, boolean onGround) {
        this.create(posX, posY, posZ, rotationYaw, rotationPitch, onGround);
    }

    public EventUpdate create(double posX, double posY, double posZ, float rotationYaw, float rotationPitch, boolean onGround) {
        this.setCanceled(false);
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.rotationYaw = rotationYaw;
        this.rotationPitch = rotationPitch;
        this.onGround = onGround;
        return this;
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public double getPosZ() {
        return this.posZ;
    }

    public float getRotationYaw() {
        return this.rotationYaw;
    }

    public float getRotationPitch() {
        return this.rotationPitch;
    }

    public boolean isOnGround() {
        return this.onGround;
    }
}

