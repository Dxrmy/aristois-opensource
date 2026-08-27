/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.render.batching;

import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;

public class CircleRenderStack
extends RenderStack<CircleRenderStack> {
    @Override
    public CircleRenderStack begin(GLX context) {
        return (CircleRenderStack)this.begin(context, 6);
    }

    public CircleRenderStack drawFilledCircle(float xx, float yy, float radius) {
        if (this.scaled) {
            xx *= CircleRenderStack.getScale();
            yy *= CircleRenderStack.getScale();
            radius *= CircleRenderStack.getScale();
        }
        for (int i = 0; i < 50; ++i) {
            float x = (float)((double)radius * Math.sin((double)i * 0.12566370614359174));
            float y = (float)((double)radius * Math.cos((double)i * 0.12566370614359174));
            this.vertex(xx + x, yy + y, 0.0).next();
        }
        return this;
    }
}

