/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerModelPart
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket$Action
 *  net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.input.Input
 *  net.minecraft.client.network.ClientPlayerEntity
 */
package me.deftware.client.framework.entity.types.main;

import java.util.Objects;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.mixin.imp.IMixinEntityPlayerSP;
import me.deftware.mixin.imp.IMixinEntityRenderer;
import me.deftware.mixin.imp.IMixinPlayerControllerMP;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;

public class MainEntityPlayer
extends EntityPlayer {
    public MainEntityPlayer(class_1657 entity) {
        super(entity);
    }

    public class_746 getMinecraftEntity() {
        return (class_746)this.entity;
    }

    public boolean processRightClickBlock(BlockPosition pos, EnumFacing facing, Vector3<Double> vector3d) {
        return this.processRightClickBlock(pos, facing, vector3d, EntityHand.MainHand);
    }

    public boolean processRightClickBlock(BlockPosition pos, EnumFacing facing, Vector3<Double> vector3d, EntityHand hand) {
        class_3965 customHitResult = new class_3965((class_243)vector3d, facing.getFacing(), (class_2338)pos, false);
        return Objects.requireNonNull(class_310.method_1551().field_1761).method_2896(class_310.method_1551().field_1724, hand.getMinecraftHand(), customHitResult) == class_1269.field_5812;
    }

    public void swapHands() {
        Objects.requireNonNull(class_310.method_1551().field_1724).field_3944.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12969, class_2338.field_10980, class_2350.field_11033));
    }

    public void processRightClick(boolean offhand) {
        Objects.requireNonNull(class_310.method_1551().field_1761).method_2919((class_1657)class_310.method_1551().field_1724, offhand ? class_1268.field_5810 : class_1268.field_5808);
    }

    public void resetBlockRemoving() {
        Objects.requireNonNull(class_310.method_1551().field_1761).method_2925();
    }

    public void setPlayerHittingBlock(boolean state) {
        ((IMixinPlayerControllerMP)Objects.requireNonNull(class_310.method_1551().field_1761)).setPlayerHittingBlock(state);
    }

    public float getPlayerFovMultiplier() {
        return ((IMixinEntityRenderer)class_310.method_1551().field_1773).getFovMultiplier();
    }

    public void updatePlayerFovMultiplier(float newValue) {
        ((IMixinEntityRenderer)class_310.method_1551().field_1773).updateFovMultiplier(newValue);
    }

    public void swingArmClientSide() {
        this.swingArmClientSide(EntityHand.MainHand);
    }

    public void swingArmClientSide(EntityHand hand) {
        this.getMinecraftEntity().method_6104(hand.getMinecraftHand());
    }

    public void attackEntity(Entity entity) {
        Objects.requireNonNull(class_310.method_1551().field_1761).method_2918((class_1657)this.getMinecraftEntity(), entity.getMinecraftEntity());
        this.swingArmClientSide();
    }

    public void setHorseJumpPower(float f) {
        Objects.requireNonNull((IMixinEntityPlayerSP)class_310.method_1551().field_1724).setHorseJumpPower(f);
    }

    public void sendMessage(String text, Class<?> sender) {
        Minecraft.getMinecraftGame().getChatSender().send(text, sender);
    }

    public void sendMessage(String text) {
        class_634 networkHandler = this.getMinecraftEntity().field_3944;
        if (text.startsWith("/")) {
            text = text.substring(1);
            networkHandler.method_45730(text);
        } else {
            networkHandler.method_45729(text);
        }
    }

    private class_744 getInput() {
        return this.getMinecraftEntity().field_3913;
    }

    public double getForward() {
        return this.getInput().field_3905;
    }

    public double getStrafe() {
        return this.getInput().field_3907;
    }

    public void toggleSkinLayers() {
        for (class_1664 class_16642 : class_1664.values()) {
        }
    }

    public void closeHandledScreen() {
        this.getMinecraftEntity().method_7346();
    }

    public void moveToHotBar(int slot, int hotbar, int windowId) {
        Objects.requireNonNull(class_310.method_1551().field_1761).method_2906(windowId, slot, hotbar, class_1713.field_7791, (class_1657)class_310.method_1551().field_1724);
        Objects.requireNonNull(class_310.method_1551().field_1761).method_2927();
    }

    public boolean placeStackInHotbar(ItemStack stack) {
        for (int index = 0; index < 9; ++index) {
            if (!Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).getInventory().getStackInSlot(index).isEmpty()) continue;
            Objects.requireNonNull(class_310.method_1551().field_1724).field_3944.method_52787((class_2596)new class_2873(36 + index, (class_1799)stack));
            return true;
        }
        return false;
    }

    public void windowClick(int id, int next, WindowClickAction type) {
        this.windowClick(0, id, next, type);
    }

    public void windowClick(int windowID, int id, int next, WindowClickAction type) {
        Objects.requireNonNull(class_310.method_1551().field_1761).method_2906(windowID, id, next, type.getMinecraftActionType(), (class_1657)class_310.method_1551().field_1724);
    }
}

