/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.VertexConsumerProvider$Immediate
 *  net.minecraft.client.render.OutlineVertexConsumerProvider
 */
package me.deftware.client.framework.render.shader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import me.deftware.client.framework.render.shader.Shader;
import me.deftware.client.framework.resource.ModResourceManager;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OutlineVertexConsumerProvider;

public class EntityShader
extends Shader {
    public static final List<EntityShader> SHADERS = new ArrayList<EntityShader>();
    private boolean render = false;
    private boolean enabled = false;
    private Predicate<Object> targetPredicate = obj -> true;
    private class_4618 outlineVertexConsumerProvider;

    public EntityShader(MinecraftIdentifier identifier, ModResourceManager resourceManager) {
        super(identifier, resourceManager);
    }

    public void init(class_4597.class_4598 entityVertexConsumers) {
        if (!this.isLoaded()) {
            super.init();
        }
        if (entityVertexConsumers != null) {
            this.outlineVertexConsumerProvider = new class_4618(entityVertexConsumers);
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setTargetPredicate(Predicate<Object> targetPredicate) {
        this.targetPredicate = targetPredicate;
    }

    public Predicate<Object> getTargetPredicate() {
        return this.targetPredicate;
    }

    public class_4618 getOutlineVertexConsumerProvider() {
        return this.outlineVertexConsumerProvider;
    }
}

