/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package me.deftware.client.framework.gui.screens;

import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.Message;
import me.deftware.mixin.imp.IMixinShulkerBoxScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.jetbrains.annotations.ApiStatus;

public interface ContainerScreen
extends MinecraftScreen {
    public class_1735 getMinecraftSlot();

    public class_1703 getScreenHandler();

    public Inventory getContainerInventory();

    public Message getInventoryName();

    default public int getSlotId() {
        return this.getMinecraftSlot().field_7874;
    }

    default public boolean isHovered() {
        return this.getMinecraftSlot() != null;
    }

    default public int getHoveredIndex() {
        return this.getMinecraftSlot().method_34266();
    }

    default public ItemStack getHoveredItemStack() {
        return (ItemStack)this.getMinecraftSlot().method_7677();
    }

    default public boolean isPlayerInventory() {
        return this instanceof class_490 || this instanceof class_481;
    }

    default public int getContainerID() {
        return this.getScreenHandler().field_7763;
    }

    default public int getMaxSlots() {
        return this.getScreenHandler().field_7761.size();
    }

    @ApiStatus.Internal
    default public class_1263 getHandlerInventory() {
        class_1703 class_17032 = this.getScreenHandler();
        if (class_17032 instanceof IMixinShulkerBoxScreenHandler) {
            IMixinShulkerBoxScreenHandler screenHandler = (IMixinShulkerBoxScreenHandler)class_17032;
            return screenHandler.getInventory();
        }
        class_17032 = this.getScreenHandler();
        if (class_17032 instanceof class_1707) {
            class_1707 screenHandler = (class_1707)class_17032;
            return screenHandler.method_7629();
        }
        return null;
    }

    @Override
    default public void close() {
        if (this.getScreenHandler() != null) {
            class_310.method_1551().field_1724.method_7346();
            return;
        }
        MinecraftScreen.super.close();
    }
}

