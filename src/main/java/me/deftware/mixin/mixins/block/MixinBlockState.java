/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_3726
 *  net.minecraft.class_3830
 *  net.minecraft.class_4970$class_4971
 *  net.minecraft.class_7923
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.block;

import me.deftware.client.framework.event.events.EventCollideCheck;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.global.types.BlockPropertyManager;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.BlockState;
import net.minecraft.class_10;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_3726;
import net.minecraft.class_3830;
import net.minecraft.class_4970;
import net.minecraft.class_7923;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_4970.class_4971.class})
public class MixinBlockState
implements BlockState {
    @Inject(method={"getOutlineShape(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/ShapeContext;)Lnet/minecraft/util/shape/VoxelShape;"}, at={@At(value="HEAD")}, cancellable=true)
    public void getOutlineShape(class_1922 world, class_2338 pos, class_3726 context, CallbackInfoReturnable<class_265> ci) {
        EventCollideCheck event = (EventCollideCheck)new EventCollideCheck(this.getBlock(), (BlockPosition)pos).broadcast();
        if (event.updated && event.canCollide) {
            ci.setReturnValue((Object)class_259.method_1073());
        }
    }

    @Inject(method={"getLuminance"}, at={@At(value="HEAD")}, cancellable=true)
    public void getLuminance(CallbackInfoReturnable<Integer> callback) {
        int id;
        BlockPropertyManager blockProperties = Bootstrap.blockProperties;
        if (blockProperties.isActive() && blockProperties.contains(id = class_7923.field_41175.method_10206((Object)((class_4970.class_4971)this).method_26204()))) {
            callback.setReturnValue((Object)((BlockProperty)blockProperties.get(id)).getLuminance());
        }
    }

    @Inject(method={"getCollisionShape(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/ShapeContext;)Lnet/minecraft/util/shape/VoxelShape;"}, at={@At(value="HEAD")}, cancellable=true)
    public void getCollisionShape(class_1922 world, class_2338 pos, class_3726 context, CallbackInfoReturnable<class_265> ci) {
        BlockProperty property;
        BlockPropertyManager blockProperties = Bootstrap.blockProperties;
        int id = class_7923.field_41175.method_10206((Object)((class_4970.class_4971)this).method_26204());
        if (blockProperties.contains(id) && (property = (BlockProperty)blockProperties.get(id)).getVoxelShape() != null) {
            ci.setReturnValue((Object)((class_265)property.getVoxelShape()));
            return;
        }
        if (this.getBlock() instanceof class_3830 && GameMap.INSTANCE.get(GameKeys.FULL_BERRY_VOXEL, false).booleanValue()) {
            ci.setReturnValue((Object)class_259.method_1077());
        }
    }

    @Override
    @Unique
    public Block getBlock() {
        return (Block)((class_4970.class_4971)this).method_26204();
    }

    @Override
    @Unique
    public boolean isPathFindable() {
        return ((class_4970.class_4971)this).method_26171(class_10.field_50);
    }
}

