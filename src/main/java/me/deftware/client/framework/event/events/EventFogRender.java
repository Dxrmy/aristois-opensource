/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.BackgroundRenderer$FogType
 */
package me.deftware.client.framework.event.events;

import lombok.Generated;
import me.deftware.client.framework.event.Event;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.BackgroundRenderer;

public class EventFogRender
extends Event {
    private class_4184 camera;
    private class_758.class_4596 fogType;
    private float viewDistance;
    private boolean thickFog;

    public EventFogRender create(class_4184 camera, class_758.class_4596 fogType, float viewDistance, boolean thickFog) {
        this.setCanceled(false);
        this.camera = camera;
        this.fogType = fogType;
        this.viewDistance = viewDistance;
        this.thickFog = thickFog;
        return this;
    }

    @Generated
    public class_4184 getCamera() {
        return this.camera;
    }

    @Generated
    public void setCamera(class_4184 camera) {
        this.camera = camera;
    }

    @Generated
    public class_758.class_4596 getFogType() {
        return this.fogType;
    }

    @Generated
    public void setFogType(class_758.class_4596 fogType) {
        this.fogType = fogType;
    }

    @Generated
    public float getViewDistance() {
        return this.viewDistance;
    }

    @Generated
    public void setViewDistance(float viewDistance) {
        this.viewDistance = viewDistance;
    }

    @Generated
    public boolean isThickFog() {
        return this.thickFog;
    }

    @Generated
    public void setThickFog(boolean thickFog) {
        this.thickFog = thickFog;
    }
}

