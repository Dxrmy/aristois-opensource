/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemUsageContext
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.block.BlockState
 *  net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.ClientPlayerInteractionManager
 *  org.apache.commons.lang3.mutable.MutableObject
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package me.deftware.mixin.mixins.entity;

import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.event.events.EventAttackEntity;
import me.deftware.client.framework.event.events.EventBlockBreakingCooldown;
import me.deftware.client.framework.event.events.EventBlockUpdate;
import me.deftware.client.framework.event.events.EventItemUse;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.network.packets.CPacketUseEntity;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import me.deftware.client.framework.world.block.Block;
import me.deftware.mixin.imp.IMixinPlayerControllerMP;
import me.deftware.mixin.imp.IMixinPlayerInteractEntityC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.packet.Packet;
import net.minecraft.block.BlockState;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.apache.commons.lang3.mutable.MutableObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_636.class})
public class MixinPlayerControllerMP
implements IMixinPlayerControllerMP {
    @Shadow
    private boolean field_3717;
    @Shadow
    private int field_3716;

    @Redirect(method={"attackEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayNetworkHandler;sendPacket(Lnet/minecraft/network/packet/Packet;)V"))
    private void onSendAttackEntityPacket(class_634 clientPlayNetworkHandler, class_2596<?> packet) {
        ((IMixinPlayerInteractEntityC2SPacket)packet).setActionType(CPacketUseEntity.Type.ATTACK);
        clientPlayNetworkHandler.method_52787(packet);
    }

    @Inject(method={"attackEntity"}, at={@At(value="HEAD")}, cancellable=true)
    public void attackEntity(class_1657 player, class_1297 target, CallbackInfo ci) {
        if (target == null || target == player || CameraEntityMan.isActive() && target == CameraEntityMan.fakePlayer) {
            ci.cancel();
        } else {
            EventAttackEntity event = (EventAttackEntity)new EventAttackEntity((class_1297)player, target).broadcast();
            if (event.isCanceled()) {
                ci.cancel();
            }
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"interactEntity"}, cancellable=true)
    private void interactEntity(class_1657 player, class_1297 target, class_1268 hand, CallbackInfoReturnable<class_1269> info) {
        if (target == null || target == player) {
            info.setReturnValue((Object)class_1269.field_5814);
            info.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"interactEntityAtLocation"}, cancellable=true)
    public void interactEntityAtLocation(class_1657 player, class_1297 entity, class_3966 hitResult, class_1268 hand, CallbackInfoReturnable<class_1269> ci) {
        if (entity == null || entity == player) {
            ci.setReturnValue((Object)class_1269.field_5814);
            ci.cancel();
        }
    }

    @Redirect(method={"updateBlockBreakingProgress"}, at=@At(value="FIELD", target="Lnet/minecraft/client/network/ClientPlayerInteractionManager;blockBreakingCooldown:I", opcode=181))
    private void onUpdateBlockBreaking(class_636 clientPlayerInteractionManager, int value) {
        EventBlockBreakingCooldown event = (EventBlockBreakingCooldown)new EventBlockBreakingCooldown(value).broadcast();
        this.field_3716 = event.getCooldown();
    }

    @Override
    public void setPlayerHittingBlock(boolean state) {
        this.field_3717 = state;
    }

    @Inject(method={"method_41929"}, at={@At(value="INVOKE", target="Lnet/minecraft/item/ItemStack;use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;")})
    private void onItemUse(class_1268 hand, class_1657 player, MutableObject<class_1269> mutableObject, int sequence, CallbackInfoReturnable<class_2886> cir) {
        class_1799 stack = player.method_5998(hand);
        class_1792 item = stack.method_7909();
        new EventItemUse((Item)item, EntityHand.of(hand)).broadcast();
    }

    @Redirect(method={"breakBlock"}, at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;onBreak(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/player/PlayerEntity;)Lnet/minecraft/block/BlockState;"))
    private class_2680 onBlockBreak(class_2248 block, class_1937 world, class_2338 pos, class_2680 state, class_1657 player) {
        class_2680 result = block.method_9576(world, pos, state, player);
        new EventBlockUpdate(EventBlockUpdate.State.Break, (BlockPosition)pos, (Block)block, EntityHand.MainHand).broadcast();
        return result;
    }

    @Redirect(method={"interactBlockInternal"}, at=@At(value="INVOKE", target="Lnet/minecraft/item/ItemStack;useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;"))
    private class_1269 onBlockPlace(class_1799 instance, class_1838 context) {
        class_1792 item = instance.method_7909();
        class_1269 result = instance.method_7981(context);
        if (result.method_23665()) {
            if (item instanceof class_1747) {
                class_1747 blockItem = (class_1747)item;
                class_2248 block = blockItem.method_7711();
                class_2338 pos = context.method_8037().method_10093(context.method_8038());
                new EventBlockUpdate(EventBlockUpdate.State.Place, (BlockPosition)pos, (Block)block, EntityHand.of(context.method_20287())).broadcast();
            } else {
                new EventItemUse((Item)item, EntityHand.of(context.method_20287())).broadcast();
            }
        }
        return result;
    }
}

