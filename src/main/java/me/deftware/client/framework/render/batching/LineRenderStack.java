/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package me.deftware.client.framework.render.batching;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.block.TileEntity;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.class_243;

public class LineRenderStack
extends RenderStack<LineRenderStack> {
    private class_243 eyes;

    @Override
    public LineRenderStack begin(GLX context) {
        return this.begin(context, 1);
    }

    @Override
    public LineRenderStack begin(GLX context, int mode) {
        this.eyes = new class_243(0.0, 0.0, 1.0);
        if (Minecraft.getMinecraftGame().getCamera() != null) {
            this.eyes = this.eyes.method_1037(-((float)Math.toRadians(Minecraft.getMinecraftGame().getCamera()._getRotationPitch()))).method_1024(-((float)Math.toRadians(Minecraft.getMinecraftGame().getCamera()._getRotationYaw())));
        }
        return (LineRenderStack)super.begin(context, mode);
    }

    public LineRenderStack drawLine(float x1, float y1, float x2, float y2) {
        if (this.scaled) {
            x1 *= LineRenderStack.getScale();
            y1 *= LineRenderStack.getScale();
            x2 *= LineRenderStack.getScale();
            y2 *= LineRenderStack.getScale();
        }
        this.vertex(x1, y1, 0.0).next();
        this.vertex(x2, y2, 0.0).next();
        return this;
    }

    public void vertex(double x, double y) {
        this.vertex(x, y, 0.0).next();
    }

    public LineRenderStack lineToBlockPosition(BlockPosition pos) {
        return this.drawLine((double)((Integer)pos.getX()).intValue() - Minecraft.getMinecraftGame().getCamera()._getRenderPosX(), (double)((float)((Integer)pos.getY()).intValue() + 0.5f) - Minecraft.getMinecraftGame().getCamera()._getRenderPosY(), (double)((Integer)pos.getZ()).intValue() - Minecraft.getMinecraftGame().getCamera()._getRenderPosZ());
    }

    public LineRenderStack lineToEntity(TileEntity entity) {
        return this.lineToBlockPosition(entity.getBlockPosition());
    }

    public LineRenderStack lineToEntity(Entity entity) {
        return this.drawLine((double)((Integer)entity.getBlockPosition().getX()).intValue() - Minecraft.getMinecraftGame().getCamera()._getRenderPosX(), (double)((float)((Integer)entity.getBlockPosition().getY()).intValue() + entity.getHeight() / 2.0f) - Minecraft.getMinecraftGame().getCamera()._getRenderPosY(), (double)((Integer)entity.getBlockPosition().getZ()).intValue() - Minecraft.getMinecraftGame().getCamera()._getRenderPosZ());
    }

    public LineRenderStack drawPoint(double x, double y, double z) {
        this.vertex(x, y, z).next();
        return this;
    }

    public LineRenderStack drawLine(double x, double y, double z) {
        return this.drawPoint(this.eyes.field_1352, this.eyes.field_1351, this.eyes.field_1350).drawPoint(x, y, z);
    }
}

