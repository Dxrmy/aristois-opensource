package me.deftware.aristois.recovered;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.menu.widgets.TextBoxWidget;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;
import me.deftware.client.framework.util.path.OSUtils;

public class C0180 extends C0150 {
   private final FontRenderStack f_8e9676ee = new FontRenderStack(C0231.f_4a6d43a5);
   private final FontRenderStack f_3ec7a8de = new FontRenderStack(C0231.f_33373362);
   private C0230 f_eccdb9d8 = C0229.f_60968b94;
   private final C0236 f_a6b6ea4a = C0236.f_758a0b10;
   private Message f_9c79be83;
   private Message f_cee7a9f4;
   private final C0441 f_7e2788d0 = new C0181();
   private boolean f_4ef22d0a = true;
   private final C0165 f_5fe8be68 = new C0165();
   private final RectTooltip f_5ef45a27;
   private final QuadRenderStack f_f3ec4716 = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private final int f_a18fa943 = 415;
   private final int f_8b8450ee = 130;
   private TextBoxWidget f_94708dc8;
   private ButtonWidget f_dcfa3cad;
   private long f_0482efc3 = 0L;

   public C0180(GenericScreen var1) {
      super(var1);
      this.m_d6ac7420(true);
      this.m_c037c5e2(new C0170(C0170.anonymousthis.f_f2dd6320));
      C0239 var2 = this.f_a6b6ea4a.m_52ce40dc();
      String var3 = C0254.m_813e3509();
      if (var2 != null) {
         var3 = C0217.m_d46f830f(var2.m_d32ebe65());
      }

      this.f_9c79be83 = new Builder().append(C0254.m_3855be80()).append(C0254.m_a9247108(), Appearance.of(DefaultColors.GREEN)).append(var3).build();
      if (var2 != null) {
         Date var4 = Date.from(OffsetDateTime.parse(var2.m_3855be80() + C0253.m_17d51275()).toInstant());
         String var5 = new SimpleDateFormat(C0257.m_1672ac4d(), Locale.US).format(var4);
         this.f_cee7a9f4 = Message.of(var2.m_3d3a8736() + C0254.m_4626ac74() + var5);
      }

      Message var6 = Message.of(C0254.m_c688f8ca());
      if (OSUtils.isMac()) {
         var6 = Message.of(C0254.m_35cdaa1a());
      }

      this.f_5ef45a27 = new RectTooltip(this.f_5fe8be68, this.f_7e2788d0, Message.of(C0254.m_624b40d8()), var6).withScale(false);
   }

   @Override
   protected void m_1058ed9a() {
      if (this.f_a6b6ea4a.m_3e35aa0d() != null) {
         this.f_eccdb9d8 = this.f_a6b6ea4a.m_3e35aa0d().m_7b315cdd();
      }

      double var1 = 10.0;
      double var3 = 375.0;
      double var5 = (double)this.f_3ec7a8de.getFontHeight() + var1 * 2.0;
      double var7 = (double)getDisplayWidth() / 2.0 - var3 / 2.0;
      double var9 = (double)getDisplayHeight() / 2.0 - var5 / 2.0 - 20.0;
      this.m_b9be37c7(var7, var9, this.f_94708dc8 = (new TextBoxWidget(var3, this.f_7e2788d0) {
         @Override
         protected void apply(String var1) {
         }
      }).setShadowText(C0254.m_8d7dbe31()));
      this.m_fe83fb4d(
         true,
         var7 + var3,
         var9 + var5 + 2.0,
         2.0,
         (new ButtonWidget(Message.of(C0254.m_1d87ef21()), this.f_7e2788d0) {
            @Override
            protected void onClick(int var1) {
               String var2 = C0180.this.f_94708dc8.getText();
               if (var2.endsWith(C0261.m_65d43991())) {
                  this.setLoading(true);
                  CompletableFuture.runAsync(() -> {
                     try {
                        C0238.m_256015fc(var2);
                        C0238 var2x = C0180.this.m_05bc17dc(var2);
                        C0236.f_758a0b10.m_92447ea7(var2x);
                     } catch (Exception var3) {
                        var3.printStackTrace();
                     }

                     this.setLoading(false);
                  });
                  C0180.this.f_94708dc8.setText("");
               }
            }
         }).<ButtonWidget>autoWidth().setTextAlign(C0427.f_b1ff7fe9),
         this.f_dcfa3cad = (new ButtonWidget(Message.of(this.f_a6b6ea4a.m_efa7610e() ? C0254.m_c42f1c7e() : C0254.m_6f1f396d()), this.f_7e2788d0) {
            @Override
            protected void onClick(int var1) {
               if (C0180.this.f_a6b6ea4a.m_efa7610e()) {
                  C0180.this.m_c8867c99(this);
               } else {
                  Keyboard.openLink(C0261.m_0d6ae39b());
               }
            }
         }).<ButtonWidget>autoWidth().setTextAlign(C0427.f_b1ff7fe9)
      );
      this.m_fe83fb4d(
         true,
         (double)(getDisplayWidth() - 2),
         2.0,
         2.0,
         (new ButtonWidget(Message.of(this.f_a6b6ea4a.m_efa7610e() ? C0254.m_8ced16bd() : C0254.m_15ef1a0d()), this.f_7e2788d0) {
            @Override
            protected void onClick(int var1) {
               C0180.this.f_a6b6ea4a.m_8b8c9021("", null);
               Minecraft.getMinecraftGame().openScreen(new C0182(C0180.this.parent));
            }
         }).<ButtonWidget>autoWidth().setTextAlign(C0427.f_b1ff7fe9)
      );
      if (this.f_a6b6ea4a.m_9362a920()) {
         C0151 var11 = new C0151(Message.of(C0254.m_9793dfe2()), this.f_3ec7a8de) {
            @Override
            protected void m_b728afce() {
               Minecraft.getMinecraftGame()
                  .openScreen(new C0178<>(C0180.this, C0180.this.f_a6b6ea4a.m_8db15fc6(), C0238.class, C0261.m_c6614274()).m_91e3b8ed(false));
            }
         };
         C0151 var12 = new C0151(Message.of(C0254.m_1635bc47()), this.f_3ec7a8de) {
            @Override
            protected void m_b728afce() {
               Minecraft.getMinecraftGame().openScreen((new C0178<C0238>(C0180.this, C0180.this.f_a6b6ea4a.m_b984ce9c(), C0238.class, C0254.m_44418b5d()) {
                  @Override
                  protected C0155[] m_da527608() {
                     return new C0155[0];
                  }
               }).m_91e3b8ed(false));
            }
         };
         this.m_b9be37c7(
            (double)getDisplayWidth() / 2.0 - var11.m_44bb072f().m_4388ac29() - 5.0, (double)getDisplayHeight() - var11.m_44bb072f().m_d42f3372() - 4.0, var11
         );
         this.m_b9be37c7((double)getDisplayWidth() / 2.0 + 5.0, (double)getDisplayHeight() - var12.m_44bb072f().m_d42f3372() - 4.0, var12);
      }

      this.m_fe83fb4d(false, 2.0, 2.0, 2.0, (new ButtonWidget(Message.of(C0257.m_c42f1c7e()), this.f_7e2788d0) {
         @Override
         protected void onClick(int var1) {
            Minecraft.getMinecraftGame().openScreen(C0180.this.parent);
         }
      }).<ButtonWidget>autoWidth().setTextAlign(C0427.f_b1ff7fe9));
   }

   private void m_c8867c99(ButtonWidget var1) {
      var1.setLoading(true);
      C0217.m_abf59b51(this.f_a6b6ea4a::m_702aae34).thenAccept(var2 -> {
         try {
            var2.m_f1ec3ae8();
            this.f_eccdb9d8 = var2.m_7b315cdd();
         } catch (Exception var4) {
            var4.printStackTrace();
         }

         var1.setLoading(false);
      });
   }

   private C0238 m_05bc17dc(String var1) {
      C0238 var2 = new C0238();
      if (this.f_a6b6ea4a.m_efa7610e()) {
         C0237 var3 = this.f_a6b6ea4a.m_27701ec3(var1);
         var2.m_333019c8(var3.m_e07cee76());
         var2.m_4404c3bc(var3.m_3d3a8736());
      } else {
         var2.m_333019c8(SessionHelper.getPlayerUsername());
         var2.m_4404c3bc(SessionHelper.getPlayerUUID());
         C0238.f_a9549f9a.put(var2.m_c254a253(), new C0226(var2.m_c254a253()));
      }

      this.f_eccdb9d8 = var2.m_7b315cdd();
      return var2;
   }

   @SafeVarargs
   private final <T extends C0163> void m_b9be37c7(double var1, double var3, T... var5) {
      this.m_0ad1282e(var1, var3, 0.0, var5);
   }

   @SafeVarargs
   private final <T extends C0163> void m_0ad1282e(double var1, double var3, double var5, T... var7) {
      this.m_fe83fb4d(false, var1, var3, var5, var7);
   }

   @SafeVarargs
   private final <T extends C0163> void m_fe83fb4d(boolean var1, double var2, double var4, double var6, T... var8) {
      for (int var9 = 0; var9 < var8.length; var9++) {
         C0163 var10 = var8[var9];
         double var11 = var10.m_44bb072f().m_4388ac29() + var6;
         if (var1) {
            if (var9 == 0) {
               var11 -= var6;
            }

            var11 *= -1.0;
         }

         if (var1 || var9 != 0) {
            var2 += var11;
         }

         var10.m_44bb072f().m_f8b16cfb(var2, var4);
         this.m_4f7d4126(new C0163[]{var10});
      }
   }

   @Override
   protected boolean onMouseClicked(int var1, int var2, int var3) {
      if (this.f_eccdb9d8 != null && this.f_a6b6ea4a.m_9362a920() && this.f_a6b6ea4a.m_3e35aa0d() != null) {
         var1 = (int)this.m_d945de47((double)var1);
         var2 = (int)this.m_461db524((double)var2);
         int var4 = this.f_eccdb9d8.m_79bbc2da();
         int var5 = getDisplayWidth() / 2 - 207 - var4 - 50;
         int var6 = this.f_eccdb9d8.m_037208cc();
         int var7 = getDisplayHeight() / 2 - var6 / 2;
         if (var1 > var5 && var1 < var5 + var4 && var2 > var7 && var2 < var7 + var6) {
            if (System.currentTimeMillis() - this.f_0482efc3 < 250L) {
               this.f_4ef22d0a = false;
               C0238 var8 = this.f_a6b6ea4a.m_3e35aa0d();
               if (var3 == 0) {
                  var8.m_46be67d3(System.out::println, !var8.m_85f6d0f6());
               } else if (var3 == 1 || Keyboard.isCtrlPressed()) {
                  var8.m_b8138d4a(System.out::println, !var8.m_d68ce734());
               }

               return true;
            }

            this.f_0482efc3 = System.currentTimeMillis();
         }
      }

      return super.onMouseClicked(var1, var2, var3);
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      C0228.f_f4f5578f.bind().draw(0, 0, getScaledWidth(), getScaledHeight()).unbind();
      RenderStack.reloadCustomMatrix();
      RenderStack.setupGl();
      super.onDraw(var1, var2, var3);
      RenderStack.restoreGl();
      Object var4 = this.f_eccdb9d8;
      boolean var5 = ((C0230)var4).m_c0b2fa8c(C0230.anonymouscatch.f_431eb11f);
      if (var4 != C0229.f_60968b94 && !var5) {
         var4 = C0229.f_60968b94;
         var5 = C0229.f_60968b94.m_c0b2fa8c(C0230.anonymouscatch.f_431eb11f);
      }

      int var6 = var5 ? ((C0230)var4).m_79bbc2da() : 120;
      int var7 = getDisplayWidth() / 2 - 207 - var6 - 50;
      int var8 = var5 ? ((C0230)var4).m_037208cc() : 270;
      int var9 = getDisplayHeight() / 2 - var8 / 2;
      if (var5) {
         this.f_5fe8be68.m_f8b16cfb((double)var7, (double)var9);
         this.f_5fe8be68.m_3ad45185((double)var6, (double)var8);
         ((C0230)var4).m_d4d15bd2(var7, var9, var6, var8, C0230.anonymouscatch.f_431eb11f);
      }

      RenderStack.setupGl();
      if (this.f_eccdb9d8 != null && this.f_a6b6ea4a.m_9362a920() && this.f_a6b6ea4a.m_3e35aa0d() != null && this.f_4ef22d0a) {
         this.f_5ef45a27.m_572d14e6(this.m_d945de47((double)var1), this.m_461db524((double)var2), var3, false);
      }

      byte var10 = 20;
      byte var11 = 2;
      int var12 = getDisplayWidth() / 2 - 207;
      int var13 = getDisplayHeight() / 2 - 65;
      ((QuadRenderStack)this.f_f3ec4716.begin().glColor(Color.white))
         .drawRect((float)var12, (float)var13, (float)(var12 + var10), (float)(var13 + var11))
         .drawRect((float)var12, (float)var13, (float)(var12 + var11), (float)(var13 + var10))
         .drawRect((float)(var12 + 415 - var10), (float)(var13 + 130 - var11), (float)(var12 + 415), (float)(var13 + 130))
         .drawRect((float)(var12 + 415 - var11), (float)(var13 + 130 - var10), (float)(var12 + 415), (float)(var13 + 130))
         .end();
      this.f_8e9676ee.begin().drawString(getDisplayWidth() / 2 - this.f_8e9676ee.getStringWidth(this.f_9c79be83) / 2, 40, this.f_9c79be83).end();
      this.f_3ec7a8de.begin().glColor(Color.white);
      if (this.f_cee7a9f4 != null) {
         this.f_3ec7a8de
            .drawString(getDisplayWidth() / 2 - this.f_3ec7a8de.getStringWidth(this.f_cee7a9f4) / 2, 40 + this.f_8e9676ee.getFontHeight(), this.f_cee7a9f4);
      }

      String var14 = SessionHelper.getPlayerUsername();
      int var15 = var9 + var8 + 10;
      this.f_3ec7a8de.drawString(var7 + var6 / 2 - this.f_3ec7a8de.getStringWidth(var14) / 2, var15, var14);
      Message var16 = this.f_a6b6ea4a.m_3e35aa0d() != null ? this.f_a6b6ea4a.m_3e35aa0d().m_11f0095b() : null;
      if (var16 != null) {
         this.f_3ec7a8de.drawString(var7 + var6 / 2 - this.f_3ec7a8de.getStringWidth(var16) / 2, var15 + this.f_3ec7a8de.getFontHeight(), var16);
      }

      this.f_3ec7a8de.end();
      RenderStack.restoreGl();
      RenderStack.reloadMinecraftMatrix();
   }

   @Override
   protected boolean onKeyReleased(int var1, int var2, int var3) {
      if (var1 == 82 && this.f_a6b6ea4a.m_efa7610e()) {
         this.m_c8867c99(this.f_dcfa3cad);
         return true;
      } else {
         return super.onKeyReleased(var1, var2, var3);
      }
   }
}
