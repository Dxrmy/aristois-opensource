/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_239
 */
package me.deftware.client.framework.util.hitresult;

import me.deftware.client.framework.math.Vector3;
import net.minecraft.class_239;

public class CrosshairResult {
    protected class_239 hitResult;

    public CrosshairResult(class_239 hitResult) {
        this.hitResult = hitResult;
    }

    public Vector3<Double> getVector() {
        return (Vector3)this.hitResult.method_17784();
    }

    public class_239 getMinecraftHitResult() {
        return this.hitResult;
    }

    public CrosshairResult setReference(class_239 result) {
        this.hitResult = result;
        return this;
    }
}

