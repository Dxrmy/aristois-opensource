/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.mixin.imp;

import me.deftware.client.framework.render.shader.Shader;

public interface IMixinEntityRenderer {
    public void loadShader(Shader var1);

    public float getFovMultiplier();

    public void updateFovMultiplier(float var1);
}

