/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.render.batching;

public interface VertexConstructor {
    public VertexConstructor vertex(double var1, double var3, double var5);

    public VertexConstructor texture(float var1, float var2);

    public VertexConstructor color(float var1, float var2, float var3, float var4);

    public VertexConstructor normal(float var1, float var2, float var3);

    public void next();
}

