package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;
import me.deftware.client.framework.render.gl.GLX;

public class C0193 extends C0150 {
   private final FontRenderStack f_181e2c1b = new FontRenderStack(C0231.f_bf1e7885);
   private final FontRenderStack f_e697cc20 = new FontRenderStack(C0231.f_e63e664b);
   private final FontRenderStack f_8b89b862 = new FontRenderStack(C0231.f_eda958c4);
   private boolean f_852f7bf6 = false;
   private final QuadRenderStack f_405182e9 = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private double f_cf8b081a = 0.0;

   public C0193() {
      super((GuiScreen)null);
      this.m_a13655a2(new C0170(C0170.anonymousthis.f_4b51c068));
      this.m_9192995e(true);
   }

   protected void m_88fea5fa() {
      double var1 = 5.0;
      double var3 = (double)this.f_181e2c1b.getFontHeight();
      double var5 = 50.0;
      double var7 = (double)(C0114.bootstrap<"call",0,1>() - 50) - var3 * var1;
      Message var9 = C0114.bootstrap<"call",1,1>(C0241.f_7826e715 ? C0252.bootstrap<"get",25769803806>() : C0252.bootstrap<"get",25769803807>())
         .style(C0114.bootstrap<"call",2,1>(DefaultColors.GOLD));
      Message var10 = C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",25769803808>());
      this.m_1a949b70(
         new C0163[]{
            new C0151(var9, (double)(C0114.bootstrap<"call",3,1>() - this.f_e697cc20.getStringWidth(var9) - 6), 2.0, this.f_e697cc20) {
               protected void m_ecd399d9() {
                  C0114.bootstrap<"call",0,1>(
                     C0252.bootstrap<"get",25769803803>() + (C0241.f_7826e715 ? C0252.bootstrap<"get",8589934655>() : C0252.bootstrap<"get",25769803789>())
                  );
               }
            },
            new C0151(
               var10,
               (double)C0114.bootstrap<"call",3,1>() / 2.0 - (double)this.f_e697cc20.getStringWidth(var10) / 2.0,
               (double)(C0114.bootstrap<"call",0,1>() - this.f_e697cc20.getFontHeight() - 2),
               this.f_e697cc20
            ) {
               protected void m_6ea644d3() {
                  C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803803>());
               }
            },
            new C0156(var5, var7, this).m_a411e7ce(this.f_852f7bf6 ? this.m_11ea1aad() : this.m_96cfcc31())
         }
      );
      var1 = 4.0;
      var3 = (double)this.f_8b89b862.getFontHeight();
      var5 = (double)(C0114.bootstrap<"call",3,1>() - 6);
      var7 = (double)(C0114.bootstrap<"call",0,1>() - 6) - var3 * var1;
      this.m_1a949b70(new C0163[]{new C0156(var5, var7, this).m_a411e7ce(this.m_19d45a28()).m_af550b13().m_8391599b(0.0F)});
   }

   @Override
   protected boolean onKeyReleased(int var1, int var2, int var3) {
      C0297 var4 = (C0297)C0114.bootstrap<"call",0,1>(C0297.class);
      if (var1 == var4.getKeybind().m_6978c604()) {
         var4.m_b76ad674();
      } else if (var1 == 84) {
         if (C0114.bootstrap<"call",1,1>()) {
            C0114.bootstrap<"call",2,1>().openScreen(new C0180(this));
            return true;
         }
      } else if (var1 == 67) {
         try {
            C0189 var5 = C0114.bootstrap<"call",3,1>(null);
            C0114.bootstrap<"call",2,1>().openScreen(var5);
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      return super.onKeyReleased(var1, var2, var3);
   }

   private void m_a6f67b99() {
      this.f_ff268974.add(() -> {
         this.f_852f7bf6 = !this.f_852f7bf6;
         this.onInitGui();
      });
   }

   protected boolean goBack() {
      if (this.f_852f7bf6) {
         this.m_a6f67b99();
      }

      return true;
   }

   private C0163[] m_96cfcc31() {
      return new C0163[]{(new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803809>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_e79b9d3b() {
            ScreenRegistry.WorldSelection.open(new Object[]{C0193.this});
         }
      }).m_f6186156(83), (new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803810>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_67ebb45b() {
            ScreenRegistry.Multiplayer.open(new Object[]{C0193.this});
         }
      }).m_00c45274(77), (new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803811>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_5055fcca() {
            C0114.bootstrap<"call",0,1>(C0193.this);
         }
      }).m_ab6ad298(79), (new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803812>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_54337d38() {
            ScreenRegistry.Realms.open(new Object[]{C0193.this});
         }
      }).m_53a36a47(82), new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803813>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_44c3bca5() {
            C0114.bootstrap<"call",0,1>().shutdown();
         }
      }};
   }

   private C0163[] m_11ea1aad() {
      return new C0163[]{new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803814>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_d0673aaa() {
            C0149.f_27db095d.m_48c6b1ee();
         }
      }, new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803815>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_8d33d01e() {
            ScreenRegistry.Options.open(new Object[]{C0193.this});
         }
      }, (new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803816>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_114e1f8f() {
            C0114.bootstrap<"call",0,1>().openScreen(new C0184(C0193.this));
         }
      }).m_6bd47ef3(65), new C0151(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>()), 0.0, 0.0, this.f_181e2c1b) {
         protected void m_065593ad() {
            C0114.bootstrap<"call",0,1>(C0193.this);
         }
      }};
   }

   private C0163[] m_19d45a28() {
      return new C0163[]{
         (new C0151(
               C0114.bootstrap<"call",3,1>(
                  C0114.bootstrap<"call",2,1>(
                     C0252.bootstrap<"get",25769803817>(),
                     new Object[]{C0114.bootstrap<"call",0,1>(FrameworkConstants.VERSION), C0114.bootstrap<"call",1,1>(FrameworkConstants.PATCH)}
                  )
               ),
               0.0,
               0.0,
               this.f_8b89b862
            ) {
               protected void m_4c6f5daf() {
                  C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803804>());
               }
            })
            .m_e43fbc04(),
         (new C0151(
               C0114.bootstrap<"call",3,1>(
                  C0114.bootstrap<"call",2,1>(
                     C0252.bootstrap<"get",25769803818>(), new Object[]{C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",4,1>().getMeta().getVersion())}
                  )
               ),
               0.0,
               0.0,
               this.f_8b89b862
            ) {
               protected void m_83d47e83() {
                  C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803803>());
               }
            })
            .m_877f27e5(),
         (new C0151(C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",25769803819>()), 0.0, 0.0, this.f_8b89b862) {
            protected void m_3af4293b() {
               C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803805>());
            }
         }).m_a39f1c72(),
         (new C0151(
               C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",25769803820>(), new Object[]{C0241.f_737be508})),
               0.0,
               0.0,
               this.f_8b89b862
            ) {
               protected void m_8f38a5ef() {
               }
            })
            .m_71fa1c20()
      };
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      C0223.f_7c6d0315.m_9f85df3c(C0114.bootstrap<"call",0,1>(), C0114.bootstrap<"call",1,1>());
      if (C0114.bootstrap<"call",2,1>().m_ad827dd3().m_8634fea8()) {
         C0114.bootstrap<"call",3,1>();
         ((QuadRenderStack)this.f_405182e9.begin().glColor(Color.red, (float)(100.0 * ((C0114.bootstrap<"call",4,1>(this.f_cf8b081a += 0.1) + 1.0) / 2.0))))
            .drawRect(0.0F, 0.0F, (float)C0114.bootstrap<"call",0,1>(), (float)C0114.bootstrap<"call",1,1>())
            .end();
      }

      C0114.bootstrap<"call",5,1>();
      C0228.f_50a5ed91.bind().draw(12, 10, 80, 80).unbind();
      C0114.bootstrap<"call",6,1>();
      C0114.bootstrap<"call",7,1>();
      boolean var4 = false;

      for (C0163 var6 : this.f_a4217fa1) {
         var4 = var6.m_2f338522(this.m_4b8a1ad0((double)var1), this.m_2361450f((double)var2), var3, var4);
      }

      C0269.f_13431579.m_a51c6c94(new EventMatrixRender(0.0F));
      C0114.bootstrap<"call",8,1>();
      C0114.bootstrap<"call",9,1>();
   }

   private void m_8d76603a(String var1, String... var2) {
      short var3 = 400;
      int var4 = this.f_181e2c1b.getFontHeight() + this.f_e697cc20.getFontHeight() * var2.length + 5;
      int var5 = C0114.bootstrap<"call",3,1>() - var3;
      int var6 = (int)((double)C0114.bootstrap<"call",0,1>() / 1.5 - (double)(var4 / 2)) - 20;
      ((QuadRenderStack)this.f_405182e9.begin().glColor(Color.black, 150.0F))
         .drawRect((float)var5, (float)var6, (float)(var5 + var3), (float)(var6 + var4))
         .end();
      this.f_181e2c1b.begin().drawString(var5 + var3 / 2 - this.f_181e2c1b.getStringWidth(var1) / 2, var6 + 2, var1).end();
      var6 += this.f_181e2c1b.getFontHeight();
      this.f_e697cc20.begin();

      for (String var10 : var2) {
         this.f_e697cc20.drawString(var5 + var3 / 2 - this.f_e697cc20.getStringWidth(var10) / 2, var6, var10);
         var6 += this.f_e697cc20.getFontHeight();
      }

      this.f_e697cc20.end();
   }
}
