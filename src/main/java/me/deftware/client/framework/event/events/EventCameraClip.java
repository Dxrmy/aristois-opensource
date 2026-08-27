/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package me.deftware.client.framework.event.events;

import lombok.Generated;
import me.deftware.client.framework.event.Event;

public class EventCameraClip
extends Event {
    private double distance;

    public EventCameraClip create(double desiredDistance) {
        this.setCanceled(false);
        this.distance = desiredDistance;
        return this;
    }

    @Generated
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Generated
    public double getDistance() {
        return this.distance;
    }
}

