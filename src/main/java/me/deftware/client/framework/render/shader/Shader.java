/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_276
 *  net.minecraft.class_279
 *  net.minecraft.class_279$class_9961
 *  net.minecraft.class_283
 *  net.minecraft.class_284
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_6367
 *  net.minecraft.class_9925
 *  net.minecraft.class_9960
 */
package me.deftware.client.framework.render.shader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Generated;
import me.deftware.client.framework.render.shader.Framebuffer;
import me.deftware.client.framework.resource.ModResourceManager;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;
import me.deftware.mixin.mixins.shader.PostEffectProcessorAccessor;
import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_283;
import net.minecraft.class_284;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_6367;
import net.minecraft.class_9925;
import net.minecraft.class_9960;

public class Shader {
    private class_279 shaderEffect;
    private Framebuffer framebuffer;
    private final MinecraftIdentifier identifier;
    private final ModResourceManager resourceManager;
    private final ShaderFramebufferSet framebufferSet = new ShaderFramebufferSet();
    private final Map<String, float[]> uniformsF = new HashMap<String, float[]>();

    public Shader(MinecraftIdentifier identifier, ModResourceManager resourceManager) {
        this.identifier = identifier;
        this.resourceManager = resourceManager;
    }

    public void init() {
        if (this.isLoaded()) {
            throw new RuntimeException("Shader already initialized");
        }
        class_310 client = class_310.method_1551();
        class_6367 internalBuffer = new class_6367(client.method_22683().method_4489(), client.method_22683().method_4506(), true);
        internalBuffer.method_1236(0.0f, 0.0f, 0.0f, 0.0f);
        internalBuffer.method_1230();
        this.framebuffer = new Framebuffer((class_276)internalBuffer);
        Set<class_2960> frameSet = Set.of(class_9960.field_53083, ShaderFramebufferSet.FINAL);
        this.shaderEffect = this.resourceManager.getShaderLoader().method_62941((class_2960)this.identifier, frameSet);
    }

    public void close() {
        this.framebuffer.close();
        this.framebuffer = null;
        this.shaderEffect = null;
    }

    public void resize(int width, int height) {
        this.framebuffer.resize(width, height);
    }

    public void setUniform(String name, float ... values) {
        this.uniformsF.put(name, values);
    }

    public void applyUniforms() {
        List<class_283> passes = ((PostEffectProcessorAccessor)this.shaderEffect).getPasses();
        for (Map.Entry<String, float[]> entry : this.uniformsF.entrySet()) {
            String name = entry.getKey();
            float[] values = entry.getValue();
            for (class_283 pass : passes) {
                class_284 uniform = pass.method_62922().method_34582(name);
                if (uniform == null) continue;
                if (values.length == 4) {
                    uniform.method_35657(values[0], values[1], values[2], values[3]);
                    continue;
                }
                if (values.length == 3) {
                    uniform.method_1249(values[0], values[1], values[2]);
                    continue;
                }
                if (values.length == 2) {
                    uniform.method_1255(values[0], values[1]);
                    continue;
                }
                if (values.length != 1) continue;
                uniform.method_1251(values[0]);
            }
        }
    }

    public boolean isLoaded() {
        return this.shaderEffect != null && this.framebuffer != null;
    }

    public class_279 getShaderEffect() {
        return this.shaderEffect;
    }

    public Framebuffer getFramebuffer() {
        return this.framebuffer;
    }

    @Generated
    public ShaderFramebufferSet getFramebufferSet() {
        return this.framebufferSet;
    }

    public static class ShaderFramebufferSet
    implements class_279.class_9961 {
        public static final class_2960 FINAL = class_2960.method_60654((String)"emc:final");
        private final Map<class_2960, class_9925<class_276>> handles = new HashMap<class_2960, class_9925<class_276>>();

        public void method_62225(class_2960 id, class_9925<class_276> framebuffer) {
            this.handles.put(id, framebuffer);
        }

        public class_9925<class_276> method_62224(class_2960 id) {
            if (!this.handles.containsKey(id)) {
                throw new RuntimeException("Requested framebuffer " + String.valueOf(id) + " does not exist in set");
            }
            return this.handles.get(id);
        }
    }
}

