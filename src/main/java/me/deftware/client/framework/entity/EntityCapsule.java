/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1937
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3730
 *  net.minecraft.class_7923
 */
package me.deftware.client.framework.entity;

import java.util.Objects;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.Identifiable;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3730;
import net.minecraft.class_7923;

public class EntityCapsule
implements SelectableList.ListItem,
Identifiable {
    private final class_1299<? extends class_1297> entityType;
    private class_2960 texture;
    private final String id;

    public <T extends class_1297> EntityCapsule(String id, class_1299<T> entityType) {
        this.entityType = entityType;
        this.id = id;
    }

    public Entity create() {
        return Entity.newInstance(this.entityType.method_5883((class_1937)Objects.requireNonNull(class_310.method_1551().field_1687), class_3730.field_16459));
    }

    public String getId() {
        return this.id;
    }

    public class_1299<? extends class_1297> getRaw() {
        return this.entityType;
    }

    public Message getName() {
        return (Message)this.entityType.method_5897();
    }

    public void setTexture(class_2960 identifier) {
        this.texture = identifier;
    }

    public MinecraftIdentifier getTexture() {
        if (this.texture == null) {
            return null;
        }
        return new MinecraftIdentifier(this.texture);
    }

    public MinecraftIdentifier getIdentifier() {
        return new MinecraftIdentifier(class_7923.field_41177.method_10221(this.entityType));
    }

    @Override
    public String getIdentifierKey() {
        return class_7923.field_41177.method_10221(this.entityType).method_12832();
    }

    @Override
    public String getTranslationKey() {
        return this.entityType.method_5882();
    }

    @Override
    public void render(GLX context, int index, int x, int y, int entryWidth, int entryHeight, int mouseX, int mouseY, float tickDelta) {
        FontRenderer.drawString(context, this.getName(), x + 28, y + (entryHeight / 2 - FontRenderer.getFontHeight() / 2) - 3, 0xFFFFFF);
    }
}

