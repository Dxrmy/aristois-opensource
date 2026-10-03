/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.chunk.WorldChunk
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package me.deftware.mixin.mixins.world;

import java.util.HashMap;
import me.deftware.client.framework.world.World;
import net.minecraft.world.World;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2818.class})
public class MixinWorldChunk {
    @Shadow
    @Final
    class_1937 field_12858;

    @Inject(method={"updateTicker"}, at={@At(value="HEAD")})
    private <T extends class_2586> void test(T blockEntity, CallbackInfo ci) {
        class_2680 blockState = blockEntity.method_11010();
        if (blockState.method_31708(this.field_12858, blockEntity.method_11017()) != null) {
            long pos = blockEntity.method_11016().method_10063();
            HashMap<Long, class_2586> entities = ((World)this.field_12858).getInternalLongToBlockEntity();
            entities.put(pos, blockEntity);
        }
    }
}

