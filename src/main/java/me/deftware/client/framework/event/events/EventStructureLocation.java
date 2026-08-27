/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.event.events;

import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.math.Vector3;

public class EventStructureLocation
extends Event {
    private final Vector3<Double> pos;
    private final StructureType type;

    public EventStructureLocation(double posX, double posY, double posZ, StructureType type) {
        this.pos = Vector3.ofDouble(posX, posY, posZ);
        this.type = type;
    }

    public EventStructureLocation(double posX, double posY, double posZ) {
        this.pos = Vector3.ofDouble(posX, posY, posZ);
        this.type = StructureType.Stronghold;
    }

    public EventStructureLocation(Vector3<Double> pos, StructureType type) {
        this.pos = pos;
        this.type = type;
    }

    public EventStructureLocation(Vector3<Double> pos) {
        this.pos = pos;
        this.type = StructureType.Stronghold;
    }

    public Vector3<Double> getPos() {
        return this.pos;
    }

    public StructureType getType() {
        return this.type;
    }

    public static enum StructureType {
        Stronghold,
        BuriedTreasure,
        OceanMonument,
        WoodlandMansion,
        OtherMapIcon;

    }
}

