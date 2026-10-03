package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import me.deftware.aristois.menu.widgets.TextBoxWidget;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;
import me.deftware.client.framework.render.shader.Shader;

public class C0429 extends C0446 {
   private TextBoxWidget f_9696915e;
   private final C0295 f_7798b24e = (C0295)C0114.bootstrap<"call",0,1>(C0295.class);
   private final int f_88736fee = this.f_7798b24e.m_fb253b03();
   private String f_b032284b = "";
   private boolean f_b7f35e0e = false;
   private float f_7f137d53 = 0.0F;

   public C0429() {
      super(null);
      this.f_8139a0a7 = (C0441)C0114.bootstrap<"call",0,1>(C0432.class);
      ((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_bd86fc72().m_1c30b0a8();
   }

   public void m_7407cf10() {
      this.f_7f137d53 = 0.0F;
      if (((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_0f9961eb() && !this.f_b7f35e0e) {
         C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>().m_26765a8c());
         ((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_1a27cacf(0.0F);
         this.f_b7f35e0e = true;
      }
   }

   @Override
   public void onUpdate() {
      super.onUpdate();
      if (this.f_b7f35e0e) {
         C0297 var1 = (C0297)C0114.bootstrap<"call",0,1>(C0297.class);
         float var2 = var1.m_653e01c1();
         if (this.f_7f137d53 < var2) {
            this.f_7f137d53 += var2 / 4.0F;
            var1.m_1a27cacf(this.f_7f137d53);
         }
      }
   }

   @Override
   protected void onGuiClose() {
      super.onGuiClose();
      if (this.f_b7f35e0e) {
         C0114.bootstrap<"call",0,1>((Shader)null);
      }

      this.f_b7f35e0e = false;
   }

   protected void m_8c847290() {
      this.m_7407cf10();
      float var1 = 500.0F;
      final float var2 = (float)C0114.bootstrap<"call",0,1>() / C0114.bootstrap<"call",1,1>() / 2.0F - var1 / 2.0F;
      final float var3 = (float)C0114.bootstrap<"call",2,1>() / C0114.bootstrap<"call",1,1>() * 0.25F;
      this.f_9696915e = (new TextBoxWidget((double)var2, (double)var3, (double)var1, this.f_8139a0a7) {
            private double f_9cb599d4;
            private double f_db936d77;
            private double f_09f52779;
            private int f_18e9f3d1;
            private int f_c21dd84d = 0;
            private List<C0429.anonymousgoto> f_3a8c94c8 = new ArrayList<>();
            private final FontRenderStack f_5ad43563 = new FontRenderStack(C0231.f_70d0cf33);

            @Override
            protected void apply(String var1) {
            }

            @Override
            public void deFocus() {
            }

            public boolean m_9120bf8f(double var1, double var3x, int var5) {
               if (var1 > this.f_e3d79c89.m_14f8bc2c()
                  && var1 < this.f_e3d79c89.m_14f8bc2c() + this.f_e3d79c89.m_830cb294()
                  && var3x > this.f_e3d79c89.m_5a998971()
                  && var3x < this.f_e3d79c89.m_5a998971() + (double)(this.f_18e9f3d1 + 1) * this.f_09f52779) {
                  this.m_2dcd5f86();
               } else {
                  C0114.bootstrap<"call",0,1>().openScreen(null);
               }

               return true;
            }

            @Override
            protected void drawBackground(double var1, double var3x, float var5) {
               this.f_09f52779 = this.f_e3d79c89.m_fc7f45bc() + 7.0;
               ((QuadRenderStack)this.quadRenderStack.glColor(this.f_7ef46c70.m_dee103ad()))
                  .begin()
                  .drawRect(
                     this.f_e3d79c89.m_14f8bc2c(),
                     this.f_e3d79c89.m_5a998971(),
                     this.f_e3d79c89.m_14f8bc2c() + this.f_e3d79c89.m_830cb294(),
                     this.f_e3d79c89.m_5a998971() + this.f_e3d79c89.m_fc7f45bc()
                  );
               if (!this.f_3a8c94c8.isEmpty()) {
                  this.f_18e9f3d1 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0429.this), this.f_3a8c94c8.size());
                  boolean var6 = this.f_9cb599d4 != var1 || this.f_db936d77 != var3x;

                  for (int var7 = 0; var7 < this.f_18e9f3d1; var7++) {
                     double var8 = this.f_e3d79c89.m_5a998971() + this.f_e3d79c89.m_fc7f45bc() + (double)var7 * this.f_09f52779;
                     if (var6
                        && var1 > this.f_e3d79c89.m_14f8bc2c()
                        && var1 < this.f_e3d79c89.m_14f8bc2c() + this.f_e3d79c89.m_830cb294()
                        && var3x > var8
                        && var3x < var8 + this.f_09f52779) {
                        this.f_c21dd84d = var7;
                     }

                     if (var7 == this.f_c21dd84d) {
                        this.quadRenderStack.glColor(this.f_7ef46c70.m_cfebe9f1());
                     } else {
                        this.quadRenderStack.glColor(this.f_7ef46c70.m_dee103ad());
                     }

                     this.quadRenderStack
                        .drawRect(this.f_e3d79c89.m_14f8bc2c(), var8, this.f_e3d79c89.m_14f8bc2c() + this.f_e3d79c89.m_830cb294(), var8 + this.f_09f52779);
                  }
               }

               this.f_9cb599d4 = var1;
               this.f_db936d77 = var3x;
               this.quadRenderStack.end();
               this.m_79d9cfb3();
            }

            private void m_2dcd5f86() {
               if (!this.f_3a8c94c8.isEmpty() && this.f_c21dd84d < this.f_3a8c94c8.size()) {
                  this.f_3a8c94c8.get(this.f_c21dd84d).m_d7f14ba9().run();
                  if (C0114.bootstrap<"call",0,1>(C0429.this).m_cae89c8a()) {
                     C0114.bootstrap<"call",1,1>().openScreen(null);
                  } else {
                     this.m_f32addc2(this.text);
                  }
               }
            }

            @Override
            protected void process() {
               super.process();
               this.m_f32addc2(this.text);
            }

            public boolean m_3c1699f1(int var1, int var2x, int var3x) {
               if (var1 == 265 || var1 == 264) {
                  this.m_a1862f19(var1 == 264 ? 1 : -1);
                  return true;
               } else if (var1 == 258) {
                  this.m_a1862f19(var3x == 1 ? -1 : 1);
                  return true;
               } else if ((var1 == 257 || var1 == 335) && !this.f_3a8c94c8.isEmpty()) {
                  this.m_2dcd5f86();
                  return true;
               } else {
                  return super.m_f030b790(var1, var2x, var3x);
               }
            }

            private void m_a1862f19(int var1) {
               int var2x = this.f_c21dd84d + var1;
               int var3x = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0429.this), this.f_3a8c94c8.size());
               if (var2x >= var3x) {
                  this.f_c21dd84d = 0;
               } else if (var2x < 0) {
                  this.f_c21dd84d = var3x - 1;
               } else {
                  this.f_c21dd84d = var2x;
               }
            }

            private void m_f32addc2(String var1) {
               C0114.bootstrap<"call",0,1>(C0429.this, var1);
               if (var1.isEmpty()) {
                  this.f_c21dd84d = 0;
                  this.f_3a8c94c8.clear();
               } else {
                  this.f_3a8c94c8 = C0289.f_c22b8d7e
                     .m_ea73e1f0()
                     .filter(var0 -> !var0.isSettingOnlyMod())
                     .filter(var0 -> !(var0 instanceof C0295) && !(var0 instanceof C0297))
                     .filter(var1x -> var1x.getDisplayName().toLowerCase().contains(var1.toLowerCase()))
                     .map(
                        var2xxx -> {
                           Color var3x = var2xxx.isEnabled() ? this.f_7ef46c70.m_a29c6d84() : Color.white;
                           Message var4 = C0114.bootstrap<"call",3,1>(var2xxx.getDisplayName(), var1, C0114.bootstrap<"call",2,1>(var3x.getRGB()));
                           Message var5 = C0114.bootstrap<"call",4,1>(var2xxx.getCategory().name());
                           byte var6 = 10;
                           return new C0429.anonymousgoto(
                              () -> {
                                 var2xxx.toggle();
                                 if (C0114.bootstrap<"call",5,1>(C0429.this).m_6a3a5697()) {
                                    C0114.bootstrap<"call",6,1>()
                                       .m_77a7bc18(
                                          (var2xxx.isEnabled() ? C0252.bootstrap<"get",12884901927>() : C0252.bootstrap<"get",12884901928>())
                                             + C0252.bootstrap<"get",70>()
                                             + var2xxx.getDisplayName()
                                       )
                                       .m_66e721c0();
                                 }
                              },
                              (var4x, var5x) -> {
                                 this.f_cdb105dc.drawString(var4x, var5x - (double)var6, var4).end();
                                 this.f_5ad43563.begin().drawString(var4x, var5x - (double)var6 + (double)this.f_cdb105dc.getFontHeight(), var5).end();
                                 this.f_cdb105dc.begin();
                              }
                           );
                        }
                     )
                     .collect(C0114.bootstrap<"call",1,1>());
                  int var2x = C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(C0429.this), this.f_3a8c94c8.size());
                  if (this.f_c21dd84d >= var2x) {
                     this.f_c21dd84d = var2x - 1;
                  }

                  if (this.f_3a8c94c8.isEmpty()) {
                     this.f_c21dd84d = 0;
                  }
               }
            }

            private void m_79d9cfb3() {
               if (!this.f_3a8c94c8.isEmpty()) {
                  double var1 = (double)var3 + this.f_e3d79c89.m_fc7f45bc();
                  this.f_cdb105dc.begin();

                  for (int var3x = 0; var3x < this.f_3a8c94c8.size() && var3x < C0114.bootstrap<"call",0,1>(C0429.this); var3x++) {
                     C0429.anonymousgoto var4 = this.f_3a8c94c8.get(var3x);
                     var4.m_87c487c4()
                        .accept(
                           C0114.bootstrap<"call",1,1>((double)var2 + 5.0),
                           C0114.bootstrap<"call",1,1>(var1 + this.f_09f52779 / 2.0 - (double)this.f_cdb105dc.getFontHeight() / 2.0)
                        );
                     var1 += this.f_09f52779;
                  }

                  this.f_cdb105dc.end();
               }
            }
         })
         .setShadowText(C0252.bootstrap<"get",34359738467>())
         .setTextAlign(C0427.f_f7cee513);
      this.f_9696915e.m_a2615314(new FontRenderStack(C0231.f_c2e9ce7e));
      this.f_9696915e.init();
      this.f_9696915e.setFocused(true);
      this.f_9696915e.setText(this.f_b032284b);
      this.m_bca6c289(new C0163[]{this.f_9696915e});
   }

   private static class anonymousgoto {
      public Runnable f_b671ab56;
      public BiConsumer<Double, Double> f_f11c4177;

      public Runnable m_d7f14ba9() {
         return this.f_b671ab56;
      }

      public BiConsumer<Double, Double> m_87c487c4() {
         return this.f_f11c4177;
      }

      public anonymousgoto(Runnable var1, BiConsumer<Double, Double> var2) {
         this.f_b671ab56 = var1;
         this.f_f11c4177 = var2;
      }
   }

   private static class anonymousimplements {
      private AbstractMod f_64245921;
      private C0094<?> f_af6af0ce;
      private boolean f_bf4f1750;

      public AbstractMod m_13545bbc() {
         return this.f_64245921;
      }

      public C0094<?> m_e9a2cde2() {
         return this.f_af6af0ce;
      }

      public boolean m_34d7ff8b() {
         return this.f_bf4f1750;
      }

      public anonymousimplements(AbstractMod var1, C0094<?> var2, boolean var3) {
         this.f_64245921 = var1;
         this.f_af6af0ce = var2;
         this.f_bf4f1750 = var3;
      }
   }
}
