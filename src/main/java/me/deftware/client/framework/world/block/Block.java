/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.block.Block
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.resource.Resource
 *  net.minecraft.registry.Registries
 */
package me.deftware.client.framework.world.block;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.Itemizable;
import me.deftware.client.framework.item.items.BlockItem;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.ItemRendering;
import me.deftware.client.framework.render.gl.GLX;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.registry.Registries;

public interface Block
extends Itemizable,
SelectableList.ListItem {
    public int getID();

    public Message getName();

    default public InputStream getAsset() throws IOException {
        class_2960 blockResource = class_7923.field_41175.method_10221((Object)((class_2248)this));
        class_2960 blockTexture = class_2960.method_60655((String)blockResource.method_12836(), (String)("textures/block/" + blockResource.method_12832() + ".png"));
        Optional resource = class_310.method_1551().method_1478().method_14486(blockTexture);
        return ((class_3298)resource.orElseThrow(() -> new IOException("Unable to find resource"))).method_14482();
    }

    @Override
    default public void render(GLX context, int index, int x, int y, int entryWidth, int entryHeight, int mouseX, int mouseY, float tickDelta) {
        ItemRendering.getInstance().drawBlock(context, x, y + 5, this);
        FontRenderer.drawString(context, this.getName(), x + 28, y + (entryHeight / 2 - FontRenderer.getFontHeight() / 2) - 3, 0xFFFFFF);
    }

    public static Block of(Item item) {
        if (!(item instanceof BlockItem)) {
            throw new IllegalArgumentException("Supplied item must be a block item");
        }
        return (Block)class_2248.method_9503((class_1792)((class_1792)item));
    }

    @Override
    default public String getTranslationKey() {
        return ((class_2248)this).method_8389().method_7876();
    }
}

