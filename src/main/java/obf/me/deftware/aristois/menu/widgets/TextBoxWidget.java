/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.render.batching.QuadRenderStack
 */
package me.deftware.aristois.menu.widgets;

import \u0000nunyaboolean.catch.for.finally.float.m.Dispatcher\ufe0f;
import \u0000nunyaboolean.catch.for.if.break.this.catch;
import \u0000nunyaboolean.catch.for.int.float;
import \u0000nunyaboolean.catch.for.super.enum.boolean;
import \u0000nunyaboolean.catch.for.super.enum.default;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import java.awt.Color;
import java.lang.invoke.CallSite;
import java.util.function.BiFunction;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class TextBoxWidget
extends ButtonWidget
implements default,
boolean {
    protected String text = "";
    protected String shadowText = "";
    protected final catch textBounds = new catch();
    private int firstCharacterIndex = 0;
    private int lastCharacterIndex = 0;
    protected double caretWidth = 1.5;
    protected int caretIndex = 0;
    protected BiFunction<String, String, String> processor;
    private boolean renderCaret = false;
    private boolean focused = false;
    private double caretPosition = 0.0;
    private double ticks = 0.0;
    private double textOffset = 0.0;
    final private float animation = new float(140.0f, 16.0){

        @Override
        protected void static(double d) {
            Dispatcher\ufe0f.bootstrap("call", 0L, 1, TextBoxWidget.this, d * 5.0);
        }
    };

    public TextBoxWidget(interface interface_) {
        this(0.0, 0.0, 0.0, interface_);
    }

    public TextBoxWidget(double d, interface interface_) {
        this(0.0, 0.0, d, interface_);
    }

    public TextBoxWidget(double d, double d2, double d3, interface interface_) {
        super(d, d2, d3, \u0000nunyaboolean.catch.for.implements.boolean.assert\u00a0new, interface_);
        this.initTextbox();
    }

    public void initTextbox() {
        this.textBounds.implements(this.padding, 0.0);
        this.textBounds.for(this.volatile\u00a0short.static());
        this.textBounds.long(this.volatile\u00a0short);
        this.animation.implements(true);
        this.setTextBounds();
    }

    public TextBoxWidget setShadowText(String string) {
        this.shadowText = string;
        return this;
    }

    @Override
    public boolean implements(double d, double d2, float f, boolean bl) {
        this.animation.implements(f);
        this.setTextBounds();
        boolean bl2 = super.implements(d, d2, f, bl);
        this.drawCaret();
        return bl2;
    }

    protected void setTextBounds() {
        this.textBounds.if(this.volatile\u00a0short.switch() - this.padding * 3.0);
    }

    @Override
    public boolean implements(double d, double d2, int n) {
        if (!this.volatile\u00a0short.switch(d, d2)) {
            this.deFocus();
        }
        return super.implements(d, d2, n);
    }

    public void deFocus() {
        if (this.focused) {
            this.apply(this.text);
        }
        this.focused = false;
    }

    @Override
    public boolean long(int n, int n2, int n3) {
        if (this.focused) {
            switch (n) {
                case 259: {
                    this.amend(n3);
                    return true;
                }
                case 262: 
                case 263: {
                    this.renderCaret = true;
                    if (n3 != 2) {
                        this.moveCaret(n == 263 ? -1 : 1);
                    }
                    return true;
                }
                case 86: {
                    if (n3 != 2) break;
                    this.append((String)((Object)Dispatcher\ufe0f.bootstrap("call", 0L, 1)));
                    return true;
                }
                case 67: 
                case 88: {
                    if (this.text.isEmpty() || n3 != 2) break;
                    Dispatcher\ufe0f.bootstrap("call", 1L, 1, this.text);
                    if (n == 88) {
                        this.amend(2);
                    } else {
                        this.animation.static();
                    }
                    return true;
                }
                case 257: 
                case 335: {
                    this.deFocus();
                    return true;
                }
            }
        }
        return false;
    }

    public void setText(String string) {
        this.text = string;
        this.caretIndex = string.length();
        this.lastCharacterIndex = string.length();
        this.firstCharacterIndex = this.trimEnd();
        this.process();
    }

    protected void drawCaret() {
        if (this.renderCaret && this.focused) {
            double d = 1.0 + this.textOffset;
            ((QuadRenderStack)this.quadRenderStack.glColor(Color.white)).begin().drawRect(this.textBounds.implements() + this.caretPosition + d, this.fontBounds.long(), this.textBounds.implements() + this.caretPosition + this.caretWidth + d, this.fontBounds.long() + this.fontBounds.static()).end();
        }
    }

    @Override
    public void switch() {
        if ((this.ticks += 1.0) / 6.0 % 2.0 == 0.0) {
            this.renderCaret = !this.renderCaret;
        }
    }

    @Override
    public void long(int n) {
        CallSite callSite = Dispatcher\ufe0f.bootstrap("call", 2L, 1, (char)n);
        if (this.focused) {
            this.append((String)((Object)callSite));
        }
    }

    @Override
    protected void drawText(double d, double d2, Message message) {
        this.volatile\u00a0package.glColor(this.text.isEmpty() ? Color.GRAY : Color.white);
        String string = this.shadowText;
        if (!this.text.isEmpty()) {
            string = this.text.substring(this.firstCharacterIndex, this.lastCharacterIndex);
            if (!this.focused) {
                string = this.text.substring(0, this.trim(0));
            }
        }
        this.volatile\u00a0package.begin().drawString((int)(d + this.textOffset), (int)d2, string).end();
    }

    @Override
    protected void onClick(int n) {
        if (n == 0) {
            this.focused = true;
        }
    }

    public double clamp(double d, double d2, double d3) {
        return (double)Dispatcher\ufe0f.bootstrap("call", 1L, 1, Dispatcher\ufe0f.bootstrap("call", 0L, 1, d, d3), d2);
    }

    public void append(String string) {
        if (this.processor != null) {
            string = this.processor.apply(this.text, string);
        }
        this.text = this.text.substring(0, this.caretIndex) + string + this.text.substring(this.caretIndex);
        this.setCaretIndex(this.caretIndex + string.length());
        if (this.getStringWidth(this.text) > this.textBounds.switch()) {
            this.setFirstCharacterIndex(this.firstCharacterIndex + string.length());
            if (this.caretIndex >= string.length()) {
                this.firstCharacterIndex = this.trimEnd();
            }
        }
        this.setLastCharacterIndex(this.lastCharacterIndex + string.length());
        this.process();
    }

    public void amend(int n) {
        if (!this.text.isEmpty()) {
            this.setFirstCharacterIndex(this.firstCharacterIndex - 1);
            this.setLastCharacterIndex(this.lastCharacterIndex - 1);
            this.text = this.text.substring(0, this.caretIndex - 1) + this.text.substring(this.caretIndex);
            this.setCaretIndex(this.caretIndex - 1);
            if (n == 2) {
                this.setCaretIndex(0);
                this.text = "";
                this.setFirstCharacterIndex(0);
                this.setLastCharacterIndex(0);
            }
            this.process();
        }
    }

    public void moveCaret(int n) {
        if (this.caretIndex > 0 && n < 0 || this.caretIndex < this.text.length() && n > 0) {
            this.setCaretIndex(this.caretIndex + n);
            if (this.caretIndex < this.firstCharacterIndex || this.caretIndex > this.lastCharacterIndex) {
                this.setFirstCharacterIndex(this.firstCharacterIndex + n);
                this.setLastCharacterIndex(this.lastCharacterIndex + n);
            }
            this.process();
        }
    }

    public int trim(int n) {
        int n2 = 0;
        int n3 = n;
        while (n3 <= this.text.length()) {
            int n4;
            n2 = n3++;
            if (this.getStringWidth(this.text.substring(n, n4)) > this.textBounds.switch()) break;
        }
        return n2;
    }

    public int trimEnd() {
        if (this.getStringWidth(this.text) < this.textBounds.switch()) {
            return 0;
        }
        int n = 0;
        int n2 = this.text.length();
        while (n2 >= 0) {
            int n3;
            n = n2--;
            if (this.getStringWidth(this.text.substring(n3)) > this.textBounds.switch()) break;
        }
        return n;
    }

    public void setFirstCharacterIndex(int n) {
        this.firstCharacterIndex = (int)this.clamp(0.0, this.text.length(), n);
    }

    public void setLastCharacterIndex(int n) {
        this.lastCharacterIndex = (int)this.clamp(0.0, this.text.length(), n);
    }

    public void setCaretIndex(int n) {
        this.caretIndex = (int)this.clamp(0.0, this.text.length(), n);
    }

    protected void process() {
        this.caretPosition = this.calculateCaretPosition(this.caretIndex);
    }

    public double getStringWidth(String string) {
        return this.volatile\u00a0package.getStringWidth(string);
    }

    public double calculateCaretPosition(int n) {
        return this.text.isEmpty() ? 0.0 : this.getStringWidth(this.text.substring(this.firstCharacterIndex, n));
    }

    protected abstract void apply(String var1);

    @Override
    public int long(double d, double d2) {
        if (this.textBounds.switch(d, d2)) {
            return 221186;
        }
        return -1;
    }

    public String getText() {
        return this.text;
    }

    public String getShadowText() {
        return this.shadowText;
    }

    public catch getTextBounds() {
        return this.textBounds;
    }

    public int getFirstCharacterIndex() {
        return this.firstCharacterIndex;
    }

    public int getLastCharacterIndex() {
        return this.lastCharacterIndex;
    }

    public double getCaretWidth() {
        return this.caretWidth;
    }

    public void setCaretWidth(double d) {
        this.caretWidth = d;
    }

    public BiFunction<String, String, String> getProcessor() {
        return this.processor;
    }

    public void setProcessor(BiFunction<String, String, String> biFunction) {
        this.processor = biFunction;
    }

    public boolean isRenderCaret() {
        return this.renderCaret;
    }

    public boolean isFocused() {
        return this.focused;
    }

    public void setRenderCaret(boolean bl) {
        this.renderCaret = bl;
    }

    public void setFocused(boolean bl) {
        this.focused = bl;
    }

    public float getAnimation() {
        return this.animation;
    }

    public static double access$002(TextBoxWidget textBoxWidget, double d) {
        textBoxWidget.textOffset = d;
        return textBoxWidget.textOffset;
    }
}

