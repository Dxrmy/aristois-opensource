package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import me.deftware.aristois.menu.widgets.TextBoxWidget;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;
import me.deftware.client.framework.render.shader.Shader;

public class C0429 extends C0446 {
   private TextBoxWidget f_3a42e108;
   private final C0295 f_a86a4114 = C0289.m_c3a8b502(C0295.class);
   private final int f_2a5c02a0 = this.f_a86a4114.m_597f2e14();
   private String f_2e47b13f = "";
   private boolean f_1afa7068 = false;
   private float f_7188a0a6 = 0.0F;

   public C0429() {
      super(null);
      this.f_b48b1555 = C0289.m_c3a8b502(C0432.class);
      C0289.m_c3a8b502(C0297.class).m_c7e6be95().m_ac6eac3b();
   }

   public void m_41e83f88() {
      this.f_7188a0a6 = 0.0F;
      if (C0289.m_c3a8b502(C0297.class).m_6c9f39f9() && !this.f_1afa7068) {
         WindowHelper.loadShader(C0242.m_fc1b642c().m_e77ae4a1());
         C0289.m_c3a8b502(C0297.class).m_d881d3e3(0.0F);
         this.f_1afa7068 = true;
      }
   }

   @Override
   public void onUpdate() {
      super.onUpdate();
      if (this.f_1afa7068) {
         C0297 var1 = C0289.m_c3a8b502(C0297.class);
         float var2 = var1.m_14287929();
         if (this.f_7188a0a6 < var2) {
            this.f_7188a0a6 += var2 / 4.0F;
            var1.m_d881d3e3(this.f_7188a0a6);
         }
      }
   }

   @Override
   protected void onGuiClose() {
      super.onGuiClose();
      if (this.f_1afa7068) {
         WindowHelper.loadShader((Shader)null);
      }

      this.f_1afa7068 = false;
   }

   @Override
   protected void m_1058ed9a() {
      this.m_41e83f88();
      float var1 = 500.0F;
      final float var2 = (float)GuiScreen.getDisplayWidth() / RenderStack.getScale() / 2.0F - var1 / 2.0F;
      final float var3 = (float)GuiScreen.getDisplayHeight() / RenderStack.getScale() * 0.25F;
      this.f_3a42e108 = (new TextBoxWidget((double)var2, (double)var3, (double)var1, this.f_b48b1555) {
            private double f_5fe1a9b0;
            private double f_9403d139;
            private double f_a600a7b7;
            private int f_bd9acd27;
            private int f_c97f5361 = 0;
            private List<C0429.anonymousgoto> f_2c31c607 = new ArrayList<>();
            private final FontRenderStack f_ebc6112b = new FontRenderStack(C0231.f_9e490562);

            @Override
            protected void apply(String var1) {
            }

            @Override
            public void deFocus() {
            }

            @Override
            public boolean m_8407b1bf(double var1, double var3x, int var5) {
               if (var1 > this.f_7fd3d7b7.m_a005efae()
                  && var1 < this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29()
                  && var3x > this.f_7fd3d7b7.m_84808068()
                  && var3x < this.f_7fd3d7b7.m_84808068() + (double)(this.f_bd9acd27 + 1) * this.f_a600a7b7) {
                  this.m_37118aff();
               } else {
                  Minecraft.getMinecraftGame().openScreen(null);
               }

               return true;
            }

            @Override
            protected void drawBackground(double var1, double var3x, float var5) {
               this.f_a600a7b7 = this.f_7fd3d7b7.m_d42f3372() + 7.0;
               ((QuadRenderStack)this.quadRenderStack.glColor(this.f_02ea293d.m_d812cfb6()))
                  .begin()
                  .drawRect(
                     this.f_7fd3d7b7.m_a005efae(),
                     this.f_7fd3d7b7.m_84808068(),
                     this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29(),
                     this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372()
                  );
               if (!this.f_2c31c607.isEmpty()) {
                  this.f_bd9acd27 = Math.min(C0429.this.f_2a5c02a0, this.f_2c31c607.size());
                  boolean var6 = this.f_5fe1a9b0 != var1 || this.f_9403d139 != var3x;

                  for (int var7 = 0; var7 < this.f_bd9acd27; var7++) {
                     double var8 = this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372() + (double)var7 * this.f_a600a7b7;
                     if (var6
                        && var1 > this.f_7fd3d7b7.m_a005efae()
                        && var1 < this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29()
                        && var3x > var8
                        && var3x < var8 + this.f_a600a7b7) {
                        this.f_c97f5361 = var7;
                     }

                     if (var7 == this.f_c97f5361) {
                        this.quadRenderStack.glColor(this.f_02ea293d.m_98b03f4f());
                     } else {
                        this.quadRenderStack.glColor(this.f_02ea293d.m_d812cfb6());
                     }

                     this.quadRenderStack
                        .drawRect(this.f_7fd3d7b7.m_a005efae(), var8, this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29(), var8 + this.f_a600a7b7);
                  }
               }

               this.f_5fe1a9b0 = var1;
               this.f_9403d139 = var3x;
               this.quadRenderStack.end();
               this.m_e4dddc57();
            }

            private void m_37118aff() {
               if (!this.f_2c31c607.isEmpty() && this.f_c97f5361 < this.f_2c31c607.size()) {
                  this.f_2c31c607.get(this.f_c97f5361).m_8efdcf9d().run();
                  if (C0429.this.f_a86a4114.m_e0f7c666()) {
                     Minecraft.getMinecraftGame().openScreen(null);
                  } else {
                     this.m_333019c8(this.text);
                  }
               }
            }

            @Override
            protected void process() {
               super.process();
               this.m_333019c8(this.text);
            }

            @Override
            public boolean m_82e0832a(int var1, int var2x, int var3x) {
               if (var1 == 265 || var1 == 264) {
                  this.m_46938bdb(var1 == 264 ? 1 : -1);
                  return true;
               } else if (var1 == 258) {
                  this.m_46938bdb(var3x == 1 ? -1 : 1);
                  return true;
               } else if ((var1 == 257 || var1 == 335) && !this.f_2c31c607.isEmpty()) {
                  this.m_37118aff();
                  return true;
               } else {
                  return super.m_82e0832a(var1, var2x, var3x);
               }
            }

            private void m_46938bdb(int var1) {
               int var2x = this.f_c97f5361 + var1;
               int var3x = Math.min(C0429.this.f_2a5c02a0, this.f_2c31c607.size());
               if (var2x >= var3x) {
                  this.f_c97f5361 = 0;
               } else if (var2x < 0) {
                  this.f_c97f5361 = var3x - 1;
               } else {
                  this.f_c97f5361 = var2x;
               }
            }

            private void m_333019c8(String var1) {
               C0429.this.f_2e47b13f = var1;
               if (var1.isEmpty()) {
                  this.f_c97f5361 = 0;
                  this.f_2c31c607.clear();
               } else {
                  this.f_2c31c607 = C0289.f_85a7343f
                     .m_918b7b9e()
                     .filter(var0 -> !var0.isSettingOnlyMod())
                     .filter(var0 -> !(var0 instanceof C0295) && !(var0 instanceof C0297))
                     .filter(var1x -> var1x.getDisplayName().toLowerCase().contains(var1.toLowerCase()))
                     .map(
                        var2xxx -> {
                           Color var3x = var2xxx.isEnabled() ? this.f_02ea293d.m_0a0c8c22() : Color.white;
                           Message var4 = C0217.m_f2d473b9(var2xxx.getDisplayName(), var1, FormattingColor.ofRGB(var3x.getRGB()));
                           Message var5 = Message.of(var2xxx.getCategory().name());
                           byte var6 = 10;
                           return new C0429.anonymousgoto(
                              () -> {
                                 var2xxx.toggle();
                                 if (C0429.this.f_a86a4114.m_275ab222()) {
                                    C0064.m_13c9ffeb()
                                       .m_ee04ba1b(
                                          (var2xxx.isEnabled() ? C0266.m_afb31f66() : C0266.m_c254a253()) + C0257.m_593ecbab() + var2xxx.getDisplayName()
                                       )
                                       .m_1058ed9a();
                                 }
                              },
                              (var4x, var5x) -> {
                                 this.f_360de984.drawString(var4x, var5x - (double)var6, var4).end();
                                 this.f_ebc6112b.begin().drawString(var4x, var5x - (double)var6 + (double)this.f_360de984.getFontHeight(), var5).end();
                                 this.f_360de984.begin();
                              }
                           );
                        }
                     )
                     .collect(Collectors.toList());
                  int var2x = Math.min(C0429.this.f_2a5c02a0, this.f_2c31c607.size());
                  if (this.f_c97f5361 >= var2x) {
                     this.f_c97f5361 = var2x - 1;
                  }

                  if (this.f_2c31c607.isEmpty()) {
                     this.f_c97f5361 = 0;
                  }
               }
            }

            private void m_e4dddc57() {
               if (!this.f_2c31c607.isEmpty()) {
                  double var1 = (double)var3 + this.f_7fd3d7b7.m_d42f3372();
                  this.f_360de984.begin();

                  for (int var3x = 0; var3x < this.f_2c31c607.size() && var3x < C0429.this.f_2a5c02a0; var3x++) {
                     C0429.anonymousgoto var4 = this.f_2c31c607.get(var3x);
                     var4.m_a51a0a51().accept((double)var2 + 5.0, var1 + this.f_a600a7b7 / 2.0 - (double)this.f_360de984.getFontHeight() / 2.0);
                     var1 += this.f_a600a7b7;
                  }

                  this.f_360de984.end();
               }
            }
         })
         .setShadowText(C0262.m_edf5fb69())
         .setTextAlign(C0427.f_26bd24ae);
      this.f_3a42e108.m_b3d7bc43(new FontRenderStack(C0231.f_99d3962b));
      this.f_3a42e108.init();
      this.f_3a42e108.setFocused(true);
      this.f_3a42e108.setText(this.f_2e47b13f);
      this.m_4f7d4126(new C0163[]{this.f_3a42e108});
   }

   private static class anonymousgoto {
      public Runnable f_fc48833f;
      public BiConsumer<Double, Double> f_c5fb850a;

      public Runnable m_8efdcf9d() {
         return this.f_fc48833f;
      }

      public BiConsumer<Double, Double> m_a51a0a51() {
         return this.f_c5fb850a;
      }

      public anonymousgoto(Runnable var1, BiConsumer<Double, Double> var2) {
         this.f_fc48833f = var1;
         this.f_c5fb850a = var2;
      }
   }

   private static class anonymousimplements {
      private AbstractMod f_f41f783b;
      private C0094<?> f_e8cd33ee;
      private boolean f_f3cf7c83;

      public AbstractMod m_3afd25b8() {
         return this.f_f41f783b;
      }

      public C0094<?> m_e32d9d89() {
         return this.f_e8cd33ee;
      }

      public boolean m_89e0519f() {
         return this.f_f3cf7c83;
      }

      public anonymousimplements(AbstractMod var1, C0094<?> var2, boolean var3) {
         this.f_f41f783b = var1;
         this.f_e8cd33ee = var2;
         this.f_f3cf7c83 = var3;
      }
   }
}
