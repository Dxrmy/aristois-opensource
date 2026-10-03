package me.deftware.aristois.menu.widgets;

import java.awt.Color;
import java.util.function.BiFunction;
import me.deftware.aristois.recovered.C0165;
import me.deftware.aristois.recovered.C0197;
import me.deftware.aristois.recovered.C0233;
import me.deftware.aristois.recovered.C0437;
import me.deftware.aristois.recovered.C0438;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public abstract class TextBoxWidget extends ButtonWidget implements C0438, C0437 {
   protected String text = "";
   protected String shadowText = "";
   protected final C0165 textBounds = new C0165();
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
   private final C0233 animation = new C0233(140.0F, 16.0) {
      @Override
      protected void m_560d077c(double var1) {
         TextBoxWidget.this.textOffset = var1 * 5.0;
      }
   };

   public TextBoxWidget(C0441 var1) {
      this(0.0, 0.0, 0.0, var1);
   }

   public TextBoxWidget(double var1, C0441 var3) {
      this(0.0, 0.0, var1, var3);
   }

   public TextBoxWidget(double var1, double var3, double var5, C0441 var7) {
      super(var1, var3, var5, C0197.f_9607505d, var7);
      this.initTextbox();
   }

   public void initTextbox() {
      this.textBounds.m_f8b16cfb(this.padding, 0.0);
      this.textBounds.m_61ade8f3(this.f_7fd3d7b7.m_d42f3372());
      this.textBounds.m_8d8487f4(this.f_7fd3d7b7);
      this.animation.m_d6ac7420(true);
      this.setTextBounds();
   }

   public TextBoxWidget setShadowText(String var1) {
      this.shadowText = var1;
      return this;
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      this.animation.m_d881d3e3(var5);
      this.setTextBounds();
      boolean var7 = super.m_572d14e6(var1, var3, var5, var6);
      this.drawCaret();
      return var7;
   }

   protected void setTextBounds() {
      this.textBounds.m_6fd9bdae(this.f_7fd3d7b7.m_4388ac29() - this.padding * 3.0);
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      if (!this.f_7fd3d7b7.m_a58797d6(var1, var3)) {
         this.deFocus();
      }

      return super.m_a2722fba(var1, var3, var5);
   }

   public void deFocus() {
      if (this.focused) {
         this.apply(this.text);
      }

      this.focused = false;
   }

   @Override
   public boolean m_82e0832a(int var1, int var2, int var3) {
      if (this.focused) {
         switch (var1) {
            case 67:
            case 88:
               if (!this.text.isEmpty() && var3 == 2) {
                  Keyboard.setClipboardString(this.text);
                  if (var1 == 88) {
                     this.amend(2);
                  } else {
                     this.animation.m_41e83f88();
                  }

                  return true;
               }
               break;
            case 86:
               if (var3 == 2) {
                  this.append(Keyboard.getClipboardString());
                  return true;
               }
               break;
            case 257:
            case 335:
               this.deFocus();
               return true;
            case 259:
               this.amend(var3);
               return true;
            case 262:
            case 263:
               this.renderCaret = true;
               if (var3 != 2) {
                  this.moveCaret(var1 == 263 ? -1 : 1);
               }

               return true;
         }
      }

      return false;
   }

   public void setText(String var1) {
      this.text = var1;
      this.caretIndex = var1.length();
      this.lastCharacterIndex = var1.length();
      this.firstCharacterIndex = this.trimEnd();
      this.process();
   }

   protected void drawCaret() {
      if (this.renderCaret && this.focused) {
         double var1 = 1.0 + this.textOffset;
         ((QuadRenderStack)this.quadRenderStack.glColor(Color.white))
            .begin()
            .drawRect(
               this.textBounds.m_a005efae() + this.caretPosition + var1,
               this.fontBounds.m_84808068(),
               this.textBounds.m_a005efae() + this.caretPosition + this.caretWidth + var1,
               this.fontBounds.m_84808068() + this.fontBounds.m_d42f3372()
            )
            .end();
      }
   }

   @Override
   public void m_0e265701() {
      if (++this.ticks / 6.0 % 2.0 == 0.0) {
         this.renderCaret = !this.renderCaret;
      }
   }

   @Override
   public void m_7c7fe86a(int var1) {
      String var2 = String.valueOf((char)var1);
      if (this.focused) {
         this.append(var2);
      }
   }

   @Override
   protected void drawText(double var1, double var3, Message var5) {
      this.f_360de984.glColor(this.text.isEmpty() ? Color.GRAY : Color.white);
      String var6 = this.shadowText;
      if (!this.text.isEmpty()) {
         var6 = this.text.substring(this.firstCharacterIndex, this.lastCharacterIndex);
         if (!this.focused) {
            var6 = this.text.substring(0, this.trim(0));
         }
      }

      this.f_360de984.begin().drawString((int)(var1 + this.textOffset), (int)var3, var6).end();
   }

   @Override
   protected void onClick(int var1) {
      if (var1 == 0) {
         this.focused = true;
      }
   }

   public double clamp(double var1, double var3, double var5) {
      return Math.min(Math.max(var1, var5), var3);
   }

   public void append(String var1) {
      if (this.processor != null) {
         var1 = this.processor.apply(this.text, var1);
      }

      this.text = this.text.substring(0, this.caretIndex) + var1 + this.text.substring(this.caretIndex);
      this.setCaretIndex(this.caretIndex + var1.length());
      if (this.getStringWidth(this.text) > this.textBounds.m_4388ac29()) {
         this.setFirstCharacterIndex(this.firstCharacterIndex + var1.length());
         if (this.caretIndex >= var1.length()) {
            this.firstCharacterIndex = this.trimEnd();
         }
      }

      this.setLastCharacterIndex(this.lastCharacterIndex + var1.length());
      this.process();
   }

   public void amend(int var1) {
      if (!this.text.isEmpty()) {
         this.setFirstCharacterIndex(this.firstCharacterIndex - 1);
         this.setLastCharacterIndex(this.lastCharacterIndex - 1);
         this.text = this.text.substring(0, this.caretIndex - 1) + this.text.substring(this.caretIndex);
         this.setCaretIndex(this.caretIndex - 1);
         if (var1 == 2) {
            this.setCaretIndex(0);
            this.text = "";
            this.setFirstCharacterIndex(0);
            this.setLastCharacterIndex(0);
         }

         this.process();
      }
   }

   public void moveCaret(int var1) {
      if (this.caretIndex > 0 && var1 < 0 || this.caretIndex < this.text.length() && var1 > 0) {
         this.setCaretIndex(this.caretIndex + var1);
         if (this.caretIndex < this.firstCharacterIndex || this.caretIndex > this.lastCharacterIndex) {
            this.setFirstCharacterIndex(this.firstCharacterIndex + var1);
            this.setLastCharacterIndex(this.lastCharacterIndex + var1);
         }

         this.process();
      }
   }

   public int trim(int var1) {
      int var2 = 0;

      for (int var3 = var1; var3 <= this.text.length(); var3++) {
         var2 = var3;
         if (this.getStringWidth(this.text.substring(var1, var3)) > this.textBounds.m_4388ac29()) {
            break;
         }
      }

      return var2;
   }

   public int trimEnd() {
      if (this.getStringWidth(this.text) < this.textBounds.m_4388ac29()) {
         return 0;
      } else {
         int var1 = 0;

         for (int var2 = this.text.length(); var2 >= 0; var2--) {
            var1 = var2;
            if (this.getStringWidth(this.text.substring(var2)) > this.textBounds.m_4388ac29()) {
               break;
            }
         }

         return var1;
      }
   }

   public void setFirstCharacterIndex(int var1) {
      this.firstCharacterIndex = (int)this.clamp(0.0, (double)this.text.length(), (double)var1);
   }

   public void setLastCharacterIndex(int var1) {
      this.lastCharacterIndex = (int)this.clamp(0.0, (double)this.text.length(), (double)var1);
   }

   public void setCaretIndex(int var1) {
      this.caretIndex = (int)this.clamp(0.0, (double)this.text.length(), (double)var1);
   }

   protected void process() {
      this.caretPosition = this.calculateCaretPosition(this.caretIndex);
   }

   public double getStringWidth(String var1) {
      return (double)this.f_360de984.getStringWidth(var1);
   }

   public double calculateCaretPosition(int var1) {
      return this.text.isEmpty() ? 0.0 : this.getStringWidth(this.text.substring(this.firstCharacterIndex, var1));
   }

   protected abstract void apply(String var1);

   @Override
   public int m_3abf02d1(double var1, double var3) {
      return this.textBounds.m_a58797d6(var1, var3) ? 221186 : -1;
   }

   public String getText() {
      return this.text;
   }

   public String getShadowText() {
      return this.shadowText;
   }

   public C0165 getTextBounds() {
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

   public void setCaretWidth(double var1) {
      this.caretWidth = var1;
   }

   public BiFunction<String, String, String> getProcessor() {
      return this.processor;
   }

   public void setProcessor(BiFunction<String, String, String> var1) {
      this.processor = var1;
   }

   public boolean isRenderCaret() {
      return this.renderCaret;
   }

   public boolean isFocused() {
      return this.focused;
   }

   public void setRenderCaret(boolean var1) {
      this.renderCaret = var1;
   }

   public void setFocused(boolean var1) {
      this.focused = var1;
   }

   public C0233 getAnimation() {
      return this.animation;
   }
}
