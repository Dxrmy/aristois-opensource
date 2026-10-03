/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  net.minecraft.item.ItemStack
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider$Immediate
 */
package me.deftware.client.framework.render;

import com.google.common.base.Suppliers;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.world.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;

public class ItemRendering {
    private static final ItemRendering INSTANCE = new ItemRendering();
    private final HashMap<Block, ItemStack> blockToStack = new HashMap();
    private final HashMap<Item, ItemStack> itemToStack = new HashMap();
    private final Supplier<class_332> context = Suppliers.memoize(() -> {
        class_310 mc = class_310.method_1551();
        class_4597.class_4598 consumers = mc.method_22940().method_23000();
        return new class_332(mc, consumers);
    });

    public static ItemRendering getInstance() {
        return INSTANCE;
    }

    public void drawBlock(GLX context, int x, int y, Block block) {
        this.drawBlock(context, x, y, 0, block);
    }

    public void drawBlock(GLX context, int x, int y, int z, Block block) {
        this.drawItemStack(context, this.blockToStack.computeIfAbsent(block, k -> ItemStack.of(k, 1)), x, y, z);
    }

    public void drawItem(GLX context, int x, int y, Item item) {
        this.drawItem(context, x, y, 0, item);
    }

    public void drawItem(GLX context, int x, int y, int z, Item item) {
        this.drawItemStack(context, this.itemToStack.computeIfAbsent(item, k -> ItemStack.of(k, 1)), x, y, z);
    }

    public void drawItemStack(GLX context, ItemStack stack, int x, int y) {
        this.drawItemStack(context, stack, x, y, 0);
    }

    public void drawItemStack(GLX context, ItemStack stack, int x, int y, int z) {
        this.render(context, z, ctx -> ctx.method_51445((class_1799)stack, x, y));
    }

    public void drawStackLabel(GLX context, ItemStack stack, int x, int y, String count) {
        this.drawStackLabel(context, stack, x, y, 0, count);
    }

    public void drawStackLabel(GLX context, ItemStack stack, int x, int y, int z, String count) {
        this.render(context, z, ctx -> ctx.method_51432(class_310.method_1551().field_1772, (class_1799)stack, x, y, count));
    }

    private void render(GLX ctx, int zOffset, Consumer<class_332> runnable) {
        ctx.modelViewStack(s -> {
            class_332 drawContext = this.context.get();
            class_4587 stack = drawContext.method_51448();
            stack.method_22903();
            stack.method_46416(0.0f, 0.0f, (float)zOffset);
            runnable.accept(drawContext);
            stack.method_22909();
        });
    }
}

