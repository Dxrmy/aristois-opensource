package me.deftware.aristois.recovered;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.menu.widgets.TextBoxWidget;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0180 extends C0150 {
   private final FontRenderStack f_940a028a = new FontRenderStack(C0231.f_bf1e7885);
   private final FontRenderStack f_1aef76f4 = new FontRenderStack(C0231.f_eda958c4);
   private C0230 f_4804b732 = C0229.f_91d70760;
   private final C0236 f_36892ac3 = C0236.f_8b0448cf;
   private Message f_452b8de7;
   private Message f_561d50c8;
   private final C0441 f_e499aa5d = new C0181();
   private boolean f_e349dfa0 = true;
   private final C0165 f_f9bbd94c = new C0165();
   private final RectTooltip f_5905920d;
   private final QuadRenderStack f_6d2e121e = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private final int f_eb5617ec = 415;
   private final int f_7e481d1c = 130;
   private TextBoxWidget f_7deaeee5;
   private ButtonWidget f_e8981737;
   private long f_404c0ce7 = 0L;

   public C0180(GenericScreen var1) {
      super(var1);
      this.m_6024c330(true);
      this.m_98a9baf1(new C0170(C0170.anonymousthis.f_4b51c068));
      C0239 var2 = this.f_36892ac3.m_6d4cc4e9();
      String var3 = C0252.bootstrap<"get",21474836481>();
      if (var2 != null) {
         var3 = C0114.bootstrap<"call",0,1>(var2.m_44ec4e9e());
      }

      this.f_452b8de7 = new Builder()
         .append(C0252.bootstrap<"get",21474836482>())
         .append(C0252.bootstrap<"get",21474836483>(), C0114.bootstrap<"call",1,1>(DefaultColors.GREEN))
         .append(var3)
         .build();
      if (var2 != null) {
         Date var4 = C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(var2.m_69b1f5a8() + C0252.bootstrap<"get",8589934663>()).toInstant());
         String var5 = new SimpleDateFormat(C0252.bootstrap<"get",107>(), Locale.US).format(var4);
         this.f_561d50c8 = C0114.bootstrap<"call",4,1>(var2.m_ffde172f() + C0252.bootstrap<"get",21474836484>() + var5);
      }

      Message var6 = C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",21474836485>());
      if (C0114.bootstrap<"call",5,1>()) {
         var6 = C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",21474836486>());
      }

      this.f_5905920d = new RectTooltip(this.f_f9bbd94c, this.f_e499aa5d, C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",21474836487>()), var6)
         .withScale(false);
   }

   protected void m_56ae93a2() {
      if (this.f_36892ac3.m_558711f1() != null) {
         this.f_4804b732 = this.f_36892ac3.m_558711f1().m_b1574147();
      }

      double var1 = 10.0;
      double var3 = 375.0;
      double var5 = (double)this.f_1aef76f4.getFontHeight() + var1 * 2.0;
      double var7 = (double)C0114.bootstrap<"call",0,1>() / 2.0 - var3 / 2.0;
      double var9 = (double)C0114.bootstrap<"call",1,1>() / 2.0 - var5 / 2.0 - 20.0;
      this.m_95ad0508(var7, var9, this.f_7deaeee5 = (new TextBoxWidget(var3, this.f_e499aa5d) {
         @Override
         protected void apply(String var1) {
         }
      }).setShadowText(C0252.bootstrap<"get",21474836488>()));
      this.m_aa549c31(
         true,
         var7 + var3,
         var9 + var5 + 2.0,
         2.0,
         (new ButtonWidget(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",21474836489>()), this.f_e499aa5d) {
            @Override
            protected void onClick(int var1) {
               String var2 = C0114.bootstrap<"call",0,1>(C0180.this).getText();
               if (var2.endsWith(C0252.bootstrap<"get",17179869312>())) {
                  this.setLoading(true);
                  C0114.bootstrap<"call",1,1>(() -> {
                     try {
                        C0114.bootstrap<"call",0,1>(var2);
                        C0238 var2x = C0114.bootstrap<"call",1,1>(C0180.this, var2);
                        C0236.f_8b0448cf.m_4ef9abdf(var2x);
                     } catch (Exception var3) {
                        var3.printStackTrace();
                     }

                     this.setLoading(false);
                  });
                  C0114.bootstrap<"call",0,1>(C0180.this).setText("");
               }
            }
         }).<ButtonWidget>autoWidth().setTextAlign(C0427.f_2db8c19a),
         this.f_e8981737 = (new ButtonWidget(
               C0114.bootstrap<"call",2,1>(this.f_36892ac3.m_af69325d() ? C0252.bootstrap<"get",21474836490>() : C0252.bootstrap<"get",21474836491>()),
               this.f_e499aa5d
            ) {
               @Override
               protected void onClick(int var1) {
                  if (C0114.bootstrap<"call",0,1>(C0180.this).m_af69325d()) {
                     C0114.bootstrap<"call",1,1>(C0180.this, this);
                  } else {
                     C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",17179869311>());
                  }
               }
            })
            .<ButtonWidget>autoWidth()
            .setTextAlign(C0427.f_2db8c19a)
      );
      this.m_aa549c31(
         true,
         (double)(C0114.bootstrap<"call",0,1>() - 2),
         2.0,
         2.0,
         (new ButtonWidget(
               C0114.bootstrap<"call",2,1>(this.f_36892ac3.m_af69325d() ? C0252.bootstrap<"get",21474836492>() : C0252.bootstrap<"get",21474836493>()),
               this.f_e499aa5d
            ) {
               @Override
               protected void onClick(int var1) {
                  C0114.bootstrap<"call",0,1>(C0180.this).m_3cc0ac72("", null);
                  C0114.bootstrap<"call",1,1>().openScreen(new C0182(C0180.this.parent));
               }
            })
            .<ButtonWidget>autoWidth()
            .setTextAlign(C0427.f_2db8c19a)
      );
      if (this.f_36892ac3.m_71ecc75e()) {
         C0151 var11 = new C0151(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",21474836494>()), this.f_1aef76f4) {
            protected void m_2b6be6a8() {
               C0114.bootstrap<"call",0,1>()
                  .openScreen(
                     new C0178<>(C0180.this, C0114.bootstrap<"call",1,1>(C0180.this).m_29ca3911(), C0238.class, C0252.bootstrap<"get",17179869313>())
                        .m_15f9eb32(false)
                  );
            }
         };
         C0151 var12 = new C0151(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",21474836495>()), this.f_1aef76f4) {
            protected void m_80bd567b() {
               C0114.bootstrap<"call",0,1>()
                  .openScreen(
                     (new C0178<C0238>(C0180.this, C0114.bootstrap<"call",1,1>(C0180.this).m_818b0bed(), C0238.class, C0252.bootstrap<"get",21474836480>()) {
                        protected C0155[] m_149f96b0() {
                           return new C0155[0];
                        }
                     }).m_92e2dea8(false)
                  );
            }
         };
         this.m_95ad0508(
            (double)C0114.bootstrap<"call",0,1>() / 2.0 - var11.m_8cd045bb().m_830cb294() - 5.0,
            (double)C0114.bootstrap<"call",1,1>() - var11.m_8cd045bb().m_fc7f45bc() - 4.0,
            var11
         );
         this.m_95ad0508(
            (double)C0114.bootstrap<"call",0,1>() / 2.0 + 5.0, (double)C0114.bootstrap<"call",1,1>() - var12.m_8cd045bb().m_fc7f45bc() - 4.0, var12
         );
      }

      this.m_aa549c31(false, 2.0, 2.0, 2.0, (new ButtonWidget(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",10>()), this.f_e499aa5d) {
         @Override
         protected void onClick(int var1) {
            C0114.bootstrap<"call",0,1>().openScreen(C0180.this.parent);
         }
      }).<ButtonWidget>autoWidth().setTextAlign(C0427.f_2db8c19a));
   }

   private void m_e4a486fe(ButtonWidget var1) {
      var1.setLoading(true);
      C0114.bootstrap<"call",3,1>(this.f_36892ac3::m_d92a89b2).thenAccept(var2 -> {
         try {
            var2.m_2ca21399();
            this.f_4804b732 = var2.m_b1574147();
         } catch (Exception var4) {
            var4.printStackTrace();
         }

         var1.setLoading(false);
      });
   }

   private C0238 m_75a7a105(String var1) {
      C0238 var2 = new C0238();
      if (this.f_36892ac3.m_af69325d()) {
         C0237 var3 = this.f_36892ac3.m_ff4d2205(var1);
         var2.m_d726f6c2(var3.m_ee195e13());
         var2.m_f4885acf(var3.m_ce81b644());
      } else {
         var2.m_d726f6c2(C0114.bootstrap<"call",4,1>());
         var2.m_f4885acf(C0114.bootstrap<"call",5,1>());
         C0238.f_13a7c1e0.put(var2.m_ceded8ac(), new C0226(var2.m_ceded8ac()));
      }

      this.f_4804b732 = var2.m_b1574147();
      return var2;
   }

   @SafeVarargs
   private final <T extends C0163> void m_95ad0508(double var1, double var3, T... var5) {
      this.m_7f5182af(var1, var3, 0.0, var5);
   }

   @SafeVarargs
   private final <T extends C0163> void m_7f5182af(double var1, double var3, double var5, T... var7) {
      this.m_aa549c31(false, var1, var3, var5, var7);
   }

   @SafeVarargs
   private final <T extends C0163> void m_aa549c31(boolean var1, double var2, double var4, double var6, T... var8) {
      for (int var9 = 0; var9 < var8.length; var9++) {
         C0163 var10 = var8[var9];
         double var11 = var10.m_fd6ca281().m_830cb294() + var6;
         if (var1) {
            if (var9 == 0) {
               var11 -= var6;
            }

            var11 *= -1.0;
         }

         if (var1 || var9 != 0) {
            var2 += var11;
         }

         var10.m_fd6ca281().m_1e49f000(var2, var4);
         this.m_8d102983(new C0163[]{var10});
      }
   }

   @Override
   protected boolean onMouseClicked(int var1, int var2, int var3) {
      if (this.f_4804b732 != null && this.f_36892ac3.m_71ecc75e() && this.f_36892ac3.m_558711f1() != null) {
         var1 = (int)this.m_941619ed((double)var1);
         var2 = (int)this.m_694aa21c((double)var2);
         int var4 = this.f_4804b732.m_a0d47d18();
         int var5 = C0114.bootstrap<"call",0,1>() / 2 - 207 - var4 - 50;
         int var6 = this.f_4804b732.m_dae5d917();
         int var7 = C0114.bootstrap<"call",1,1>() / 2 - var6 / 2;
         if (var1 > var5 && var1 < var5 + var4 && var2 > var7 && var2 < var7 + var6) {
            if (C0114.bootstrap<"call",2,1>() - this.f_404c0ce7 < 250L) {
               this.f_e349dfa0 = false;
               C0238 var8 = this.f_36892ac3.m_558711f1();
               if (var3 == 0) {
                  var8.m_39b50c56(System.out::println, !var8.m_3a0223ce());
               } else if (var3 == 1 || C0114.bootstrap<"call",3,1>()) {
                  var8.m_2eced60d(System.out::println, !var8.m_73224595());
               }

               return true;
            }

            this.f_404c0ce7 = C0114.bootstrap<"call",2,1>();
         }
      }

      return super.onMouseClicked(var1, var2, var3);
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      C0228.f_c8a9acfa.bind().draw(0, 0, C0114.bootstrap<"call",0,1>(), C0114.bootstrap<"call",1,1>()).unbind();
      C0114.bootstrap<"call",2,1>();
      C0114.bootstrap<"call",3,1>();
      super.onDraw(var1, var2, var3);
      C0114.bootstrap<"call",4,1>();
      Object var4 = this.f_4804b732;
      boolean var5 = ((C0230)var4).m_63716b28(C0230.anonymouscatch.f_88d11990);
      if (var4 != C0229.f_91d70760 && !var5) {
         var4 = C0229.f_91d70760;
         var5 = C0229.f_91d70760.m_63716b28(C0230.anonymouscatch.f_88d11990);
      }

      int var6 = var5 ? ((C0230)var4).m_a0d47d18() : 120;
      int var7 = C0114.bootstrap<"call",5,1>() / 2 - 207 - var6 - 50;
      int var8 = var5 ? ((C0230)var4).m_dae5d917() : 270;
      int var9 = C0114.bootstrap<"call",6,1>() / 2 - var8 / 2;
      if (var5) {
         this.f_f9bbd94c.m_1e49f000((double)var7, (double)var9);
         this.f_f9bbd94c.m_d4d3794a((double)var6, (double)var8);
         ((C0230)var4).m_1d96e0fd(var7, var9, var6, var8, C0230.anonymouscatch.f_88d11990);
      }

      C0114.bootstrap<"call",3,1>();
      if (this.f_4804b732 != null && this.f_36892ac3.m_71ecc75e() && this.f_36892ac3.m_558711f1() != null && this.f_e349dfa0) {
         this.f_5905920d.m_a5d59c31(this.m_941619ed((double)var1), this.m_694aa21c((double)var2), var3, false);
      }

      byte var10 = 20;
      byte var11 = 2;
      int var12 = C0114.bootstrap<"call",5,1>() / 2 - 207;
      int var13 = C0114.bootstrap<"call",6,1>() / 2 - 65;
      ((QuadRenderStack)this.f_6d2e121e.begin().glColor(Color.white))
         .drawRect((float)var12, (float)var13, (float)(var12 + var10), (float)(var13 + var11))
         .drawRect((float)var12, (float)var13, (float)(var12 + var11), (float)(var13 + var10))
         .drawRect((float)(var12 + 415 - var10), (float)(var13 + 130 - var11), (float)(var12 + 415), (float)(var13 + 130))
         .drawRect((float)(var12 + 415 - var11), (float)(var13 + 130 - var10), (float)(var12 + 415), (float)(var13 + 130))
         .end();
      this.f_940a028a.begin().drawString(C0114.bootstrap<"call",5,1>() / 2 - this.f_940a028a.getStringWidth(this.f_452b8de7) / 2, 40, this.f_452b8de7).end();
      this.f_1aef76f4.begin().glColor(Color.white);
      if (this.f_561d50c8 != null) {
         this.f_1aef76f4
            .drawString(
               C0114.bootstrap<"call",5,1>() / 2 - this.f_1aef76f4.getStringWidth(this.f_561d50c8) / 2, 40 + this.f_940a028a.getFontHeight(), this.f_561d50c8
            );
      }

      String var14 = C0114.bootstrap<"call",7,1>();
      int var15 = var9 + var8 + 10;
      this.f_1aef76f4.drawString(var7 + var6 / 2 - this.f_1aef76f4.getStringWidth(var14) / 2, var15, var14);
      Message var16 = this.f_36892ac3.m_558711f1() != null ? this.f_36892ac3.m_558711f1().m_a12d1f40() : null;
      if (var16 != null) {
         this.f_1aef76f4.drawString(var7 + var6 / 2 - this.f_1aef76f4.getStringWidth(var16) / 2, var15 + this.f_1aef76f4.getFontHeight(), var16);
      }

      this.f_1aef76f4.end();
      C0114.bootstrap<"call",4,1>();
      C0114.bootstrap<"call",8,1>();
   }

   @Override
   protected boolean onKeyReleased(int var1, int var2, int var3) {
      if (var1 == 82 && this.f_36892ac3.m_af69325d()) {
         this.m_e4a486fe(this.f_e8981737);
         return true;
      } else {
         return super.onKeyReleased(var1, var2, var3);
      }
   }
}
