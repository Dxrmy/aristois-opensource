/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.hit.BlockHitResult
 */
package me.deftware.client.framework.util.minecraft;

import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.util.hitresult.CrosshairResult;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.hit.BlockHitResult;

public class BlockSwingResult
extends CrosshairResult {
    public BlockSwingResult(Vector3<Double> vector3d, EnumFacing facing, BlockPosition position, boolean inBlock) {
        super((class_239)new class_3965((class_243)vector3d, facing.getFacing(), (class_2338)position, inBlock));
    }

    public BlockSwingResult(class_239 result) {
        super(result);
    }

    public Block getBlock() {
        return ClientWorld.getClientWorld()._getBlockFromPosition(this.getBlockPosition());
    }

    public BlockPosition getBlockPosition() {
        return (BlockPosition)this.getMinecraftHitResult().method_17777();
    }

    public EnumFacing getFacing() {
        return EnumFacing.fromMinecraft(this.getMinecraftHitResult().method_17780());
    }

    public class_3965 getMinecraftHitResult() {
        return (class_3965)this.hitResult;
    }
}

