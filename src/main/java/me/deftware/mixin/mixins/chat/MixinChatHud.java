/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.gui.hud.ChatHudLine$Visible
 *  net.minecraft.client.gui.hud.ChatHud
 *  net.minecraft.network.message.MessageSignatureData
 *  net.minecraft.client.gui.hud.MessageIndicator
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 */
package me.deftware.mixin.mixins.chat;

import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.message.GameChat;
import me.deftware.client.framework.message.Message;
import net.minecraft.text.Text;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.client.gui.hud.MessageIndicator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_338.class})
public abstract class MixinChatHud
implements GameChat {
    @Shadow
    @Final
    private List<class_303.class_7590> field_2064;

    @Shadow
    public abstract void method_44811(class_2561 var1, class_7469 var2, class_7591 var3);

    @Override
    @Unique
    public void remove(Function<String, Boolean> visitor) {
        this.field_2064.removeIf(line -> {
            StringBuilder text = new StringBuilder();
            line.comp_896().accept((index, style, point) -> {
                text.appendCodePoint(point);
                return true;
            });
            return (Boolean)visitor.apply(text.toString());
        });
    }

    @Override
    @Unique
    public void append(Message message) {
        this.method_44811((class_2561)message, null, null);
    }

    @Override
    @Unique
    public void remove(int index) {
        this.field_2064.remove(index);
    }
}

