/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_4068
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
 */
package me.deftware.client.framework.gui.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Generated;
import me.deftware.client.framework.gui.widgets.GenericComponent;
import me.deftware.client.framework.gui.widgets.properties.Tooltipable;
import me.deftware.client.framework.message.Message;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_4068;
import net.minecraft.class_5348;
import net.minecraft.class_5481;

public class Label
implements class_4068,
class_364,
GenericComponent,
Tooltipable {
    private List<class_2561> text;
    private final class_327 textRenderer;
    private int width;
    private int height;
    private int x;
    private int y;
    private final List<class_5481> tooltipComponents;

    public Label(int x, int y, Message ... text) {
        this.textRenderer = class_310.method_1551().field_1772;
        this.tooltipComponents = new ArrayList<class_5481>();
        this.setText(text);
        this.x = x;
        this.y = y;
    }

    public void setText(Message ... text) {
        this.text = Arrays.stream(text).map(class_2561.class::cast).collect(Collectors.toList());
        this.width = this.text.stream().map(arg_0 -> ((class_327)this.textRenderer).method_27525(arg_0)).max(Comparator.naturalOrder()).orElseThrow(() -> new RuntimeException("Found no text, this shouldn't happen!"));
        int n = text.length;
        Objects.requireNonNull(this.textRenderer);
        this.height = n * 9;
    }

    public void method_25394(class_332 matrices, int mouseX, int mouseY, float delta) {
        int x = this.x;
        int y = this.y;
        for (class_2561 line : this.text) {
            int center = x + this.width / 2 - this.textRenderer.method_27525((class_5348)line) / 2;
            matrices.method_27535(this.textRenderer, line, center, y, 0xFFFFFF);
            Objects.requireNonNull(this.textRenderer);
            y += 9;
        }
    }

    @Override
    public List<class_5481> getTooltipComponents(int mouseX, int mouseY) {
        return this.tooltipComponents;
    }

    @Override
    public boolean isMouseOverComponent(int mouseX, int mouseY) {
        return mouseX > this.x && mouseX < this.x + this.width && mouseY > this.y && mouseY < this.y + this.height;
    }

    public void method_25365(boolean focused) {
    }

    public boolean method_25370() {
        return false;
    }

    @Generated
    public int getWidth() {
        return this.width;
    }

    @Generated
    public int getHeight() {
        return this.height;
    }

    @Generated
    public int getX() {
        return this.x;
    }

    @Generated
    public int getY() {
        return this.y;
    }
}

