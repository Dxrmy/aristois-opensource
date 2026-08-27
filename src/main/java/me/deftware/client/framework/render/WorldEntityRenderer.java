/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package me.deftware.client.framework.render;

import java.util.List;
import lombok.Generated;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.Vector3;

public interface WorldEntityRenderer {
    public List<Statue> getStatues();

    public static class Statue {
        protected Entity entity;
        protected Vector3<Double> position;

        @Generated
        public Entity getEntity() {
            return this.entity;
        }

        @Generated
        public Vector3<Double> getPosition() {
            return this.position;
        }

        @Generated
        public Statue(Entity entity, Vector3<Double> position) {
            this.entity = entity;
            this.position = position;
        }
    }
}

