/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.render.batching;

import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;

public class QuadRenderStack
extends RenderStack<QuadRenderStack> {
    @Override
    public QuadRenderStack begin(GLX context) {
        return (QuadRenderStack)this.begin(context, 7);
    }

    public QuadRenderStack drawRect(double x, double y, double xx, double yy) {
        return this.drawRect((float)x, (float)y, (float)xx, (float)yy);
    }

    public QuadRenderStack drawRect(float x, float y, float xx, float yy) {
        if (this.scaled) {
            x *= QuadRenderStack.getScale();
            y *= QuadRenderStack.getScale();
            xx *= QuadRenderStack.getScale();
            yy *= QuadRenderStack.getScale();
        }
        this.vertex(xx, y, 0.0).next();
        this.vertex(x, y, 0.0).next();
        this.vertex(x, yy, 0.0).next();
        this.vertex(xx, yy, 0.0).next();
        return this;
    }
}

