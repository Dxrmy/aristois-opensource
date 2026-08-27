/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.render.camera;

import me.deftware.client.framework.math.Vector3;

public interface GameCamera {
    public Vector3<Double> getCameraPosition();

    public float _getRotationPitch();

    public float _getRotationYaw();

    public double _getRenderPosX();

    public double _getRenderPosY();

    public double _getRenderPosZ();
}

