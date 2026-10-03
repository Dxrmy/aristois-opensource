package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0287 extends C0274<C0287> {
   private final FontRenderStack f_32b753a4 = new FontRenderStack(C0231.f_bf1e7885);
   private final QuadRenderStack f_5bd4eacf = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private boolean f_e85eb7dd;
   private boolean f_2735bb16;
   private final Message[] f_cc05a538;
   private final Message f_47128321;
   private final double f_9a59aee6;
   private final double f_3561d02e;
   private final double f_0da0eed3 = 1.0;
   private double f_2a069e4d = 0.0;
   private double f_9e95ce7d;
   private double f_753a201c;
   private long f_18c9c863 = 3000L;
   private boolean f_e7e798c1 = false;
   private final C0233 f_39ca9142 = new C0233(140.0F, 60.0) {
      protected void m_e7000d1c(double var1) {
         double var3 = C0114.bootstrap<"call",0,1>(C0287.this) ? 1.0 - var1 : var1;
         C0114.bootstrap<"call",2,1>(C0287.this, C0114.bootstrap<"call",1,1>(C0287.this) * var3);
      }

      protected void m_e06f3682() {
         if (C0114.bootstrap<"call",0,1>(C0287.this)) {
            C0114.bootstrap<"call",1,1>(C0287.this, true);
         } else {
            C0114.bootstrap<"call",2,1>(C0287.this, true);
            C0114.bootstrap<"call",5,1>(C0287.this, C0114.bootstrap<"call",3,1>() + C0114.bootstrap<"call",4,1>(C0287.this));
         }
      }
   };

   public C0287(Message var1, Message... var2) {
      this.f_39ca9142.m_fae54ac4(C0233.anonymousdefault.f_805d07d6);
      this.f_47128321 = var1;
      this.f_cc05a538 = var2;
      this.f_32b753a4.setScaled(false);
      this.f_3561d02e = (double)(this.f_32b753a4.getFontHeight() + this.f_32b753a4.getFontHeight() * var2.length + 5);
      this.f_9a59aee6 = (double)(
         this.f_32b753a4
               .getStringWidth(
                  (Message)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>(var2), C0114.bootstrap<"call",1,1>(var1))
                     .max(C0114.bootstrap<"call",3,1>(this.f_32b753a4::getStringWidth))
                     .orElseThrow(() -> new RuntimeException(C0252.bootstrap<"get",25769803892>()))
               )
            + 15
      );
   }

   public void m_2246a05a() {
      this.f_753a201c = (double)(C0114.bootstrap<"call",0,1>() - 155) - this.f_3561d02e;
      boolean var1 = false;

      for (C0288 var3 : C0114.bootstrap<"call",1,1>(C0269.f_13431579.m_970934e1())) {
         if (var3 instanceof C0287) {
            var1 = var3 == this;
            break;
         }
      }

      for (C0288 var6 : C0269.f_13431579.m_970934e1()) {
         if (var6 instanceof C0287 && var6 != this && var1) {
            C0287 var4 = (C0287)var6;
            var4.m_72e378ba(var4.m_26da7a81() - this.f_3561d02e - 10.0);
         }
      }
   }

   public C0287 m_b0c3e4c1() {
      this.f_e85eb7dd = true;
      return this;
   }

   public C0287 m_48761c0f() {
      this.f_28d0476c = C0114.bootstrap<"call",0,1>();
      this.f_2735bb16 = true;
      this.f_39ca9142.m_bb3577b4();
      return this;
   }

   protected boolean m_c79ec61f() {
      return this.f_18c9c863 < C0114.bootstrap<"call",0,1>();
   }

   public C0287 m_7f36d956(float var1) {
      this.f_39ca9142.m_61a5f120(var1);
      this.f_9e95ce7d = (double)C0114.bootstrap<"call",0,1>() - this.f_2a069e4d;
      ((QuadRenderStack)((QuadRenderStack)this.f_5bd4eacf.begin().glColor(Color.black, 150.0F))
            .drawRect(this.f_9e95ce7d, this.f_753a201c, this.f_9e95ce7d + this.f_2a069e4d, this.f_753a201c + this.f_3561d02e)
            .glColor(((C0432)C0114.bootstrap<"call",1,1>(C0432.class)).m_604f8702(), 255.0F))
         .drawRect(this.f_9e95ce7d + 1.0, this.f_753a201c, this.f_9e95ce7d + this.f_9a59aee6 - 1.0, this.f_753a201c + 1.0)
         .drawRect(this.f_9e95ce7d + 1.0, this.f_753a201c + this.f_3561d02e - 1.0, this.f_9e95ce7d + this.f_9a59aee6 - 1.0, this.f_753a201c + this.f_3561d02e)
         .drawRect(this.f_9e95ce7d, this.f_753a201c, this.f_9e95ce7d + 1.0, this.f_753a201c + this.f_3561d02e)
         .end();
      this.f_32b753a4.begin().drawString((int)(this.f_9e95ce7d + 8.0), (int)(this.f_753a201c + 5.0), this.f_47128321);
      double var2 = this.f_753a201c;

      for (Message var7 : this.f_cc05a538) {
         this.f_32b753a4.drawString((int)(this.f_9e95ce7d + 8.0), (int)(var2 += (double)(this.f_32b753a4.getFontHeight() + 2)), var7);
      }

      this.f_32b753a4.end();
      if (this.f_39ca9142.m_f6c24736() && this.m_c79ec61f()) {
         this.f_39ca9142.m_bb3577b4();
      }

      return this;
   }

   public boolean m_e47ea6ac() {
      return this.f_e85eb7dd;
   }

   public boolean m_c2e142b5() {
      return this.f_2735bb16;
   }

   public double m_38ae168c() {
      return this.f_9a59aee6;
   }

   public double m_2692646e() {
      return this.f_3561d02e;
   }

   public double m_7b0452a7() {
      return 1.0;
   }

   public void m_c752c611(double var1) {
      this.f_2a069e4d = var1;
   }

   public void m_693ddad4(double var1) {
      this.f_9e95ce7d = var1;
   }

   public void m_72e378ba(double var1) {
      this.f_753a201c = var1;
   }

   public double m_5dc03286() {
      return this.f_2a069e4d;
   }

   public double m_4c383568() {
      return this.f_9e95ce7d;
   }

   public double m_26da7a81() {
      return this.f_753a201c;
   }

   public C0233 m_e8e8d672() {
      return this.f_39ca9142;
   }
}
