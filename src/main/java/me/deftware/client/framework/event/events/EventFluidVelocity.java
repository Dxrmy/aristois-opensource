/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package me.deftware.client.framework.event.events;

import lombok.Generated;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.math.Vector3;

public class EventFluidVelocity
extends Event {
    private Vector3<Double> vector3d;

    @Generated
    public EventFluidVelocity(Vector3<Double> vector3d) {
        this.vector3d = vector3d;
    }

    @Generated
    public Vector3<Double> getVector3d() {
        return this.vector3d;
    }

    @Generated
    public void setVector3d(Vector3<Double> vector3d) {
        this.vector3d = vector3d;
    }
}

