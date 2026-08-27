/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.global.types;

import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.global.types.PropertyManager;

public class BlockPropertyManager
extends PropertyManager<BlockProperty> {
    private boolean exposedOnly = false;
    private boolean disableCaveRendering = false;
    private boolean opacityMode = true;
    private float opacity = 100.0f;

    public boolean isExposedOnly() {
        return this.exposedOnly;
    }

    public void setExposedOnly(boolean exposedOnly) {
        this.exposedOnly = exposedOnly;
    }

    public boolean isDisableCaveRendering() {
        return this.disableCaveRendering;
    }

    public void setDisableCaveRendering(boolean disableCaveRendering) {
        this.disableCaveRendering = disableCaveRendering;
    }

    public boolean isOpacityMode() {
        return this.opacityMode;
    }

    public void setOpacityMode(boolean opacityMode) {
        this.opacityMode = opacityMode;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }
}

