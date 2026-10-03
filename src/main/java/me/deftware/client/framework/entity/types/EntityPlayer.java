/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 */
package me.deftware.client.framework.entity.types;

import java.util.Objects;
import java.util.UUID;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.objects.ClonedPlayerMP;
import me.deftware.client.framework.inventory.EntityInventory;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.mixin.imp.IMixinEntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;

public class EntityPlayer
extends LivingEntity {
    public static final double PLAYER_WIDTH = 49.0;
    public static final double PLAYER_HEIGHT = 70.0;
    public static final double DEFAULT_SIZE = 30.0;
    public static double PLAYER_WIDTH_MP = 1.6333333333333333;
    public static double PLAYER_HEIGHT_MP = 2.3333333333333335;

    public EntityPlayer(class_1657 entity) {
        super((class_1297)entity);
    }

    public boolean isUsingItem() {
        return this.getMinecraftEntity().method_6115();
    }

    public boolean isCreative() {
        return this.getMinecraftEntity().method_7337();
    }

    public boolean isSleeping() {
        return this.getMinecraftEntity().method_6113();
    }

    public boolean isFlying() {
        return this.getMinecraftEntity().method_31549().field_7479;
    }

    public void setFlying(boolean flag) {
        this.getMinecraftEntity().method_31549().field_7479 = flag;
    }

    public EntityInventory getInventory() {
        return (EntityInventory)this.getMinecraftEntity().method_31548();
    }

    public float getSaturationLevel() {
        return this.getMinecraftEntity().method_7344().method_7589();
    }

    public UUID getUUID() {
        return ((class_1657)this.entity).method_7334().getId();
    }

    public float getRotationHeadYaw() {
        return this.getMinecraftEntity().field_6241;
    }

    public String getUsername() {
        return ((class_1657)this.entity).method_7334().getName();
    }

    public class_1657 getMinecraftEntity() {
        return (class_1657)this.entity;
    }

    public float getCooldown() {
        return this.getMinecraftEntity().method_7261(0.0f);
    }

    public boolean isAtEdge() {
        Iterable iterable = Objects.requireNonNull(class_310.method_1551().field_1687).method_8600((class_1297)this.getMinecraftEntity(), this.getMinecraftEntity().method_5829().method_989(0.0, -0.5, 0.0).method_1009(-0.001, 0.0, -0.001));
        return !iterable.iterator().hasNext();
    }

    public void openInventory() {
        Minecraft.getMinecraftGame().runOnRenderThread(() -> class_310.method_1551().method_1507((class_437)new class_490(this.getMinecraftEntity())));
    }

    public int getFoodLevel() {
        return this.getMinecraftEntity().method_7344().method_7586();
    }

    public void respawn() {
        this.getMinecraftEntity().method_7331();
    }

    public int getItemInUseCount() {
        return ((IMixinEntityLivingBase)this.getMinecraftEntity()).getActiveItemStackUseCount();
    }

    public void doJump() {
        this.getMinecraftEntity().method_6043();
    }

    public int getItemInUseMaxCount() {
        return this.getMinecraftEntity().method_6014();
    }

    public void drawPlayer(GLX context, int posX, int posY, int size) {
        int width = (int)((double)size * PLAYER_WIDTH_MP);
        int height = (int)((double)size * PLAYER_HEIGHT_MP);
        class_490.method_2486((class_332)context.getContext(), (int)posX, (int)posY, (int)(posX + width), (int)(posY + height), (int)size, (float)0.0625f, (float)((float)posX + (float)width / 2.0f), (float)((float)posY + (float)height / 2.0f), (class_1309)this.getMinecraftEntity());
    }

    public Entity clone() {
        return Entity.newInstance((class_1297)new ClonedPlayerMP(this.getMinecraftEntity()));
    }

    public float getFlySpeed() {
        return this.getMinecraftEntity().method_31549().method_7252();
    }

    public void setFlySpeed(float speed) {
        this.getMinecraftEntity().method_31549().method_7248(speed);
    }

    public float getWalkSpeed() {
        return this.getMinecraftEntity().method_31549().method_7253();
    }

    public void setWalkSpeed(float speed) {
        this.getMinecraftEntity().method_31549().method_7250(speed);
    }
}

