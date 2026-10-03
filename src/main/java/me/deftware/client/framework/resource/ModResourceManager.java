/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  lombok.Generated
 *  net.minecraft.client.gl.ShaderLoader
 *  net.minecraft.client.texture.TextureManager
 *  net.minecraft.util.Util
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.resource.ResourcePack
 *  net.minecraft.resource.Resource
 *  net.minecraft.resource.ResourceManager
 */
package me.deftware.client.framework.resource;

import com.mojang.blaze3d.systems.RenderSystem;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import lombok.Generated;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.resource.ModResource;
import net.minecraft.client.gl.ShaderLoader;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.util.Util;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;

public class ModResourceManager
implements class_3300 {
    private final ZipFile zipFile;
    private final String type;
    private BiFunction<String, InputStream, InputStream> transformer = (path, stream) -> stream;
    private final class_1060 textureManager;
    private final class_10151 shaderLoader;
    private final String namespace;

    public ModResourceManager(EMCMod mod, String type) throws IOException {
        this.zipFile = this.getZipFile(mod);
        this.namespace = mod.getMeta().getName().toLowerCase();
        this.type = type;
        this.textureManager = new class_1060((class_3300)this);
        this.shaderLoader = new class_10151(this.textureManager, ex -> ex.printStackTrace());
        RenderSystem.recordRenderCall(this::reload);
    }

    private void reload() {
        this.shaderLoader.method_25931(CompletableFuture::completedFuture, (class_3300)this, (Executor)class_156.method_18349(), (Executor)class_310.method_1551());
    }

    public void setTransformer(BiFunction<String, InputStream, InputStream> transformer) {
        this.transformer = transformer;
    }

    public ZipFile getZipFile(EMCMod mod) throws IOException {
        return new ZipFile(mod.physicalFile);
    }

    public ZipEntry getEntry(String name) {
        return this.zipFile.getEntry(this.type + "/" + name);
    }

    private InputStream getResourceStream(ZipEntry entry) throws Exception {
        return this.zipFile.getInputStream(entry);
    }

    public Set<String> method_14487() {
        return Set.of(this.namespace);
    }

    public List<class_3298> method_14489(class_2960 id) {
        return Collections.emptyList();
    }

    public Optional<class_3298> method_14486(class_2960 id) {
        ZipEntry entry = this.getEntry(id.method_12832());
        if (entry == null) {
            return class_310.method_1551().method_1478().method_14486(id);
        }
        try {
            return Optional.of(new ModResource(this.transformer.apply(id.method_12832(), this.getResourceStream(entry)), id));
        }
        catch (Exception ex) {
            return Optional.empty();
        }
    }

    public Map<class_2960, class_3298> method_14488(String startingPath, Predicate<class_2960> allowedPathPredicate) {
        HashMap<class_2960, class_3298> map = new HashMap<class_2960, class_3298>();
        String root = this.type + "/" + startingPath;
        Enumeration<? extends ZipEntry> entries = this.zipFile.entries();
        while (entries.hasMoreElements()) {
            class_2960 identifier;
            ZipEntry entry = entries.nextElement();
            String name = entry.getName();
            if (!name.startsWith(root) || !allowedPathPredicate.test(identifier = class_2960.method_60655((String)this.namespace, (String)name.substring(this.type.length() + 1)))) continue;
            try {
                InputStream stream = this.getResourceStream(entry);
                ModResource resource = new ModResource(stream, identifier);
                map.put(identifier, resource);
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        class_3300 manager = class_310.method_1551().method_1478();
        Map result = manager.method_14488(startingPath, allowedPathPredicate);
        map.putAll(result);
        return map;
    }

    public Map<class_2960, List<class_3298>> method_41265(String startingPath, Predicate<class_2960> allowedPathPredicate) {
        return null;
    }

    public Stream<class_3262> method_29213() {
        return null;
    }

    @Generated
    public class_1060 getTextureManager() {
        return this.textureManager;
    }

    @Generated
    public class_10151 getShaderLoader() {
        return this.shaderLoader;
    }
}

