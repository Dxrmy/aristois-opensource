/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_238
 *  net.minecraft.class_286
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_9801
 */
package me.deftware.client.framework.render.batching;

import me.deftware.client.framework.math.BoundingBox;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.class_238;
import net.minecraft.class_286;
import net.minecraft.class_293;
import net.minecraft.class_9801;

public class CubeRenderStack
extends RenderStack<CubeRenderStack> {
    private boolean lines = false;

    @Override
    public CubeRenderStack begin(GLX context) {
        return this.begin(context, false);
    }

    public CubeRenderStack begin(GLX context, boolean lines) {
        this.lines = lines;
        return (CubeRenderStack)this.begin(context, this.lines ? 3 : 7);
    }

    public CubeRenderStack draw(BoundingBox box) {
        if (box == null) {
            return this;
        }
        class_238 minecraftBox = (class_238)box.offset(-Minecraft.getMinecraftGame().getCamera()._getRenderPosX(), -Minecraft.getMinecraftGame().getCamera()._getRenderPosY(), -Minecraft.getMinecraftGame().getCamera()._getRenderPosZ());
        if (this.lines) {
            this.drawSelectionBoundingBox(minecraftBox);
        } else {
            this.drawColorBox(minecraftBox);
        }
        return this;
    }

    private void drawColorBox(class_238 box) {
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1324).next();
    }

    private void drawSelectionBoundingBox(class_238 box) {
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        class_286.method_43433((class_9801)this.builder.method_60800());
        this.setBuilder(class_293.class_5596.field_29344, this.getFormat());
        this.vertex(box.field_1323, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1321).next();
        this.vertex(box.field_1320, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1320, box.field_1325, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1322, box.field_1324).next();
        this.vertex(box.field_1323, box.field_1325, box.field_1324).next();
    }
}

