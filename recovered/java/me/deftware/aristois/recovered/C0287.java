package me.deftware.aristois.recovered;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0287 extends C0274<C0287> {
   private final FontRenderStack f_9afcb9a7 = new FontRenderStack(C0231.f_4a6d43a5);
   private final QuadRenderStack f_403b153e = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private boolean f_46056295;
   private boolean f_581825e5;
   private final Message[] f_9de9a1a6;
   private final Message f_f2897f16;
   private final double f_acf081ac;
   private final double f_186ba59b;
   private final double f_60212834 = 1.0;
   private double f_089e9eb7 = 0.0;
   private double f_17b9b679;
   private double f_d52d8ac1;
   private long f_12d58579 = 3000L;
   private boolean f_9bf9032a = false;
   private final C0233 f_206b33ae = new C0233(140.0F, 60.0) {
      @Override
      protected void m_560d077c(double var1) {
         double var3 = C0287.this.f_9bf9032a ? 1.0 - var1 : var1;
         C0287.this.f_089e9eb7 = C0287.this.f_acf081ac * var3;
      }

      @Override
      protected void m_e02771ba() {
         if (C0287.this.f_9bf9032a) {
            C0287.this.f_46056295 = true;
         } else {
            C0287.this.f_9bf9032a = true;
            C0287.this.f_12d58579 = System.currentTimeMillis() + C0287.this.f_12d58579;
         }
      }
   };

   public C0287(Message var1, Message... var2) {
      this.f_206b33ae.m_e83888e2(C0233.anonymousdefault.f_c8bd7ffc);
      this.f_f2897f16 = var1;
      this.f_9de9a1a6 = var2;
      this.f_9afcb9a7.setScaled(false);
      this.f_186ba59b = (double)(this.f_9afcb9a7.getFontHeight() + this.f_9afcb9a7.getFontHeight() * var2.length + 5);
      this.f_acf081ac = (double)(
         this.f_9afcb9a7
               .getStringWidth(
                  Stream.concat(Arrays.stream(var2), Stream.of(var1))
                     .max(Comparator.comparingDouble(this.f_9afcb9a7::getStringWidth))
                     .orElseThrow(() -> new RuntimeException(C0267.m_76700429()))
               )
            + 15
      );
   }

   @Override
   public void m_547191bb() {
      this.f_d52d8ac1 = (double)(GuiScreen.getDisplayHeight() - 155) - this.f_186ba59b;
      boolean var1 = false;

      for (C0288 var3 : Lists.reverse(C0269.f_44d31626.m_94a15833())) {
         if (var3 instanceof C0287) {
            var1 = var3 == this;
            break;
         }
      }

      for (C0288 var6 : C0269.f_44d31626.m_94a15833()) {
         if (var6 instanceof C0287 && var6 != this && var1) {
            C0287 var4 = (C0287)var6;
            var4.m_ddfd9367(var4.m_44e4959f() - this.f_186ba59b - 10.0);
         }
      }
   }

   public C0287 m_bd4977f9() {
      this.f_46056295 = true;
      return this;
   }

   public C0287 m_6a1b300a() {
      this.f_ae2cc37b = System.currentTimeMillis();
      this.f_581825e5 = true;
      this.f_206b33ae.m_41e83f88();
      return this;
   }

   protected boolean m_f0e7dcaa() {
      return this.f_12d58579 < System.currentTimeMillis();
   }

   public C0287 m_dd00adfe(float var1) {
      this.f_206b33ae.m_d881d3e3(var1);
      this.f_17b9b679 = (double)GuiScreen.getDisplayWidth() - this.f_089e9eb7;
      ((QuadRenderStack)((QuadRenderStack)this.f_403b153e.begin().glColor(Color.black, 150.0F))
            .drawRect(this.f_17b9b679, this.f_d52d8ac1, this.f_17b9b679 + this.f_089e9eb7, this.f_d52d8ac1 + this.f_186ba59b)
            .glColor(C0289.m_c3a8b502(C0432.class).m_e1729432(), 255.0F))
         .drawRect(this.f_17b9b679 + 1.0, this.f_d52d8ac1, this.f_17b9b679 + this.f_acf081ac - 1.0, this.f_d52d8ac1 + 1.0)
         .drawRect(this.f_17b9b679 + 1.0, this.f_d52d8ac1 + this.f_186ba59b - 1.0, this.f_17b9b679 + this.f_acf081ac - 1.0, this.f_d52d8ac1 + this.f_186ba59b)
         .drawRect(this.f_17b9b679, this.f_d52d8ac1, this.f_17b9b679 + 1.0, this.f_d52d8ac1 + this.f_186ba59b)
         .end();
      this.f_9afcb9a7.begin().drawString((int)(this.f_17b9b679 + 8.0), (int)(this.f_d52d8ac1 + 5.0), this.f_f2897f16);
      double var2 = this.f_d52d8ac1;

      for (Message var7 : this.f_9de9a1a6) {
         this.f_9afcb9a7.drawString((int)(this.f_17b9b679 + 8.0), (int)(var2 += (double)(this.f_9afcb9a7.getFontHeight() + 2)), var7);
      }

      this.f_9afcb9a7.end();
      if (this.f_206b33ae.m_e606d819() && this.m_f0e7dcaa()) {
         this.f_206b33ae.m_41e83f88();
      }

      return this;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_46056295;
   }

   @Override
   public boolean m_9362a920() {
      return this.f_581825e5;
   }

   public double m_4388ac29() {
      return this.f_acf081ac;
   }

   public double m_73c7a4b4() {
      return this.f_186ba59b;
   }

   public double m_207293d2() {
      return 1.0;
   }

   public void m_4b04f920(double var1) {
      this.f_089e9eb7 = var1;
   }

   public void m_7c9e279f(double var1) {
      this.f_17b9b679 = var1;
   }

   public void m_ddfd9367(double var1) {
      this.f_d52d8ac1 = var1;
   }

   public double m_106745cd() {
      return this.f_089e9eb7;
   }

   public double m_8aacb726() {
      return this.f_17b9b679;
   }

   public double m_44e4959f() {
      return this.f_d52d8ac1;
   }

   public C0233 m_8d9d3e1f() {
      return this.f_206b33ae;
   }
}
