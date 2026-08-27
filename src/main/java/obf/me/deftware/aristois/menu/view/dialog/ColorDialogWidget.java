/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 */
package me.deftware.aristois.menu.view.dialog;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.synchronized;
import \u0000nunyaboolean.catch.for.int.do.synchronized;
import \u0000nunyaboolean.catch.for.private.s.Dispatcher;
import \u0000nunyaboolean.catch.for.super.enum;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import java.awt.Color;
import java.lang.invoke.CallSite;
import me.deftware.aristois.menu.view.dialog.DialogWidget;
import me.deftware.client.framework.message.Message;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class ColorDialogWidget
extends DialogWidget {
    public static synchronized.catch<enum> brightness;
    public static synchronized.catch<enum> hue;
    public static synchronized.catch<enum> opacity;
    private enum colorPicker;
    private boolean postChanged = false;

    public ColorDialogWidget(double d, double d2, interface interface_) {
        this(0.0, 0.0, d, d2, interface_);
    }

    public ColorDialogWidget(double d, double d2, double d3, double d4, interface interface_) {
        super(d, d2, d3, d4, interface_);
    }

    @Override
    public DialogWidget setupComponents(Message message) {
        super.setupComponents(message);
        int n = (int)(this.volatile\u00a0short.static() - this.title.static().static());
        this.colorPicker = new enum(0.0, (int)this.title.static().static(), (int)this.volatile\u00a0short.switch(), n, this.getColor(), brightness, hue, opacity){

            @Override
            protected void implements(Color color, boolean bl) {
                if (Dispatcher\ufe0f.bootstrap("call", 0L, 1, ColorDialogWidget.this) == false || !bl) {
                    ColorDialogWidget.this.apply(color);
                }
            }
        };
        this.colorPicker.static().long(this.static());
        this.implements(new synchronized[]{this.colorPicker});
        return this;
    }

    @Override
    public boolean long(int n, int n2, int n3) {
        if (n3 == 2) {
            CallSite callSite;
            if (n == 67) {
                Color color = this.colorPicker.byte();
                CallSite callSite2 = Dispatcher\ufe0f.bootstrap("call", 1L, 1, Dispatcher.bootstrap("get", 0x900000004L), new Object[]{Dispatcher\ufe0f.bootstrap("call", 0L, 1, color.getRed()), Dispatcher\ufe0f.bootstrap("call", 0L, 1, color.getGreen()), Dispatcher\ufe0f.bootstrap("call", 0L, 1, color.getBlue())});
                Dispatcher\ufe0f.bootstrap("call", 2L, 1, callSite2);
                return true;
            }
            if (n == 86 && ((String)((Object)(callSite = Dispatcher\ufe0f.bootstrap("call", 3L, 1)))).matches((String)((Object)Dispatcher.bootstrap("get", 0x900000005L)))) {
                try {
                    CallSite callSite3 = Dispatcher\ufe0f.bootstrap("call", 4L, 1, callSite);
                    this.colorPicker.implements((Color)((Object)callSite3));
                    this.colorPicker.long();
                    return true;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        return false;
    }

    protected abstract Color getColor();

    protected abstract void apply(Color var1);

    public enum getColorPicker() {
        return this.colorPicker;
    }

    public void setPostChanged(boolean bl) {
        this.postChanged = bl;
    }

    public static boolean access$000(ColorDialogWidget colorDialogWidget) {
        return colorDialogWidget.postChanged;
    }

    static {
        double d = 200.0;
        double d2 = 100.0;
        double d3 = d2 * 0.15;
        brightness = new synchronized.catch<enum>(d - d3, d2 - d3){

            public void onMouseMove(enum enum_, double d, double d2) {
                enum_.volatile\u00a0true[1] = (float)d;
                enum_.volatile\u00a0true[2] = (float)d2;
                enum_.long(true);
            }

            @Override
            public void long(Object object, double d, double d2) {
                this.onMouseMove((enum)object, d, d2);
            }
        };
        hue = new synchronized.catch<enum>(d - d3, d3){

            public void onMouseMove(enum enum_, double d, double d2) {
                enum_.volatile\u00a0true[0] = (float)d;
                enum_.long();
                enum_.long(true);
            }

            @Override
            public void long(Object object, double d, double d2) {
                this.onMouseMove((enum)object, d, d2);
            }
        };
        opacity = new synchronized.catch<enum>(d3, d2){

            public void onMouseMove(enum enum_, double d, double d2) {
                enum_.volatile\u00a0case = (int)(255.0 * d2);
                enum_.long(true);
            }

            @Override
            public void long(Object object, double d, double d2) {
                this.onMouseMove((enum)object, d, d2);
            }
        };
    }
}

