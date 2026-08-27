/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager
 *  net.minecraft.class_276
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package me.deftware.mixin.mixins.render;

import com.mojang.blaze3d.platform.GlStateManager;
import java.nio.IntBuffer;
import net.minecraft.class_276;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_276.class})
public abstract class MixinFrameBuffer {
    @Shadow
    public int field_1482;
    @Shadow
    public int field_1481;
    @Shadow
    private int field_1474;

    @Redirect(method={"initFbo"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/platform/GlStateManager;_texImage2D(IIIIIIIILjava/nio/IntBuffer;)V", remap=false, ordinal=0))
    private void texImage2D(int target, int level, int internalFormat, int width, int height, int border, int format, int type, IntBuffer pixels) {
        GlStateManager._texImage2D((int)3553, (int)0, (int)35056, (int)this.field_1482, (int)this.field_1481, (int)0, (int)34041, (int)34042, null);
    }

    @Redirect(method={"initFbo"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/platform/GlStateManager;_glFramebufferTexture2D(IIIII)V", remap=false, ordinal=1))
    private void framebufferTexture2D(int target, int attachment, int textureTarget, int texture, int level) {
        GlStateManager._glFramebufferTexture2D((int)target, (int)33306, (int)3553, (int)this.field_1474, (int)0);
    }
}

