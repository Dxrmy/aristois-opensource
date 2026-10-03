/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.widget.TextFieldWidget
 */
package me.deftware.client.framework.gui.widgets;

import java.util.function.Predicate;
import me.deftware.client.framework.gui.widgets.Component;
import me.deftware.client.framework.gui.widgets.properties.Tooltipable;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.TextFieldWidget;

public interface TextField
extends Component,
Tooltipable {
    public static TextField create(int x, int y, int width, int height) {
        return (TextField)new class_342(class_310.method_1551().field_1772, x, y, width, height, (class_2561)class_2561.method_43470((String)""));
    }

    public void _setText(String var1);

    public String _getText();

    public void _setPasswordMode(boolean var1);

    public void _setMaxLength(int var1);

    public void _setOverlay(String var1);

    public void _setPredicate(Predicate<String> var1);
}

