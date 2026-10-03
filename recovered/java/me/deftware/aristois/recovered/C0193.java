package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.batching.font.FontRenderStack;
import me.deftware.client.framework.render.gl.GLX;

public class C0193 extends C0150 {
   private final FontRenderStack f_4f9722e5 = new FontRenderStack(C0231.f_4a6d43a5);
   private final FontRenderStack f_a5df0fd7 = new FontRenderStack(C0231.f_6ea14e57);
   private final FontRenderStack f_e0454fe7 = new FontRenderStack(C0231.f_33373362);
   private boolean f_ce3827fb = false;
   private final QuadRenderStack f_7534d185 = (QuadRenderStack)new QuadRenderStack().setScaled(false);
   private double f_902d08a1 = 0.0;

   public C0193() {
      super((GuiScreen)null);
      this.m_c037c5e2(new C0170(C0170.anonymousthis.f_f2dd6320));
      this.m_d6ac7420(true);
   }

   @Override
   protected void m_1058ed9a() {
      double var1 = 5.0;
      double var3 = (double)this.f_4f9722e5.getFontHeight();
      double var5 = 50.0;
      double var7 = (double)(getDisplayHeight() - 50) - var3 * var1;
      Message var9 = Message.of(C0241.f_f6e3d33b ? C0267.m_28b2c020() : C0267.m_45aaaba8()).style(Appearance.of(DefaultColors.GOLD));
      Message var10 = Message.of(C0267.m_88937f2b());
      this.m_4f7d4126(
         new C0163[]{
            new C0151(var9, (double)(getDisplayWidth() - this.f_a5df0fd7.getStringWidth(var9) - 6), 2.0, this.f_a5df0fd7) {
               @Override
               protected void m_b728afce() {
                  Keyboard.openLink(C0267.m_056a389d() + (C0241.f_f6e3d33b ? C0253.m_15737526() : C0267.m_15ef1a0d()));
               }
            },
            new C0151(
               var10,
               (double)getDisplayWidth() / 2.0 - (double)this.f_a5df0fd7.getStringWidth(var10) / 2.0,
               (double)(getDisplayHeight() - this.f_a5df0fd7.getFontHeight() - 2),
               this.f_a5df0fd7
            ) {
               @Override
               protected void m_b728afce() {
                  Keyboard.openLink(C0267.m_056a389d());
               }
            },
            new C0156(var5, var7, this).m_482c862d(this.f_ce3827fb ? this.m_5b6f5d0e() : this.m_a178d1d9())
         }
      );
      var1 = 4.0;
      var3 = (double)this.f_e0454fe7.getFontHeight();
      var5 = (double)(getDisplayWidth() - 6);
      var7 = (double)(getDisplayHeight() - 6) - var3 * var1;
      this.m_4f7d4126(new C0163[]{new C0156(var5, var7, this).m_482c862d(this.m_7236280b()).m_46cac79a().m_6da7ba87(0.0F)});
   }

   @Override
   protected boolean onKeyReleased(int var1, int var2, int var3) {
      C0297 var4 = C0289.m_c3a8b502(C0297.class);
      if (var1 == var4.getKeybind().m_36ffc578()) {
         var4.m_23674f64();
      } else if (var1 == 84) {
         if (C0242.m_efa7610e()) {
            Minecraft.getMinecraftGame().openScreen(new C0180(this));
            return true;
         }
      } else if (var1 == 67) {
         try {
            C0189 var5 = C0189.m_e842fe9d(null);
            Minecraft.getMinecraftGame().openScreen(var5);
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      return super.onKeyReleased(var1, var2, var3);
   }

   private void m_0e265701() {
      this.f_37f92d3c.add(() -> {
         this.f_ce3827fb = !this.f_ce3827fb;
         this.onInitGui();
      });
   }

   protected boolean goBack() {
      if (this.f_ce3827fb) {
         this.m_0e265701();
      }

      return true;
   }

   private C0163[] m_a178d1d9() {
      return new C0163[]{(new C0151(Message.of(C0267.m_396f9431()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            ScreenRegistry.WorldSelection.open(new Object[]{C0193.this});
         }
      }).m_4ef3b726(83), (new C0151(Message.of(C0267.m_e9914bd3()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            ScreenRegistry.Multiplayer.open(new Object[]{C0193.this});
         }
      }).m_4ef3b726(77), (new C0151(Message.of(C0267.m_8631f87f()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            C0193.this.m_0e265701();
         }
      }).m_4ef3b726(79), (new C0151(Message.of(C0267.m_818e6498()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            ScreenRegistry.Realms.open(new Object[]{C0193.this});
         }
      }).m_4ef3b726(82), new C0151(Message.of(C0267.m_56d4c1c7()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            Minecraft.getMinecraftGame().shutdown();
         }
      }};
   }

   private C0163[] m_5b6f5d0e() {
      return new C0163[]{new C0151(Message.of(C0267.m_d32ebe65()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            C0149.f_9e30b55f.m_1058ed9a();
         }
      }, new C0151(Message.of(C0267.m_afb31f66()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            ScreenRegistry.Options.open(new Object[]{C0193.this});
         }
      }, (new C0151(Message.of(C0267.m_c254a253()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            Minecraft.getMinecraftGame().openScreen(new C0184(C0193.this));
         }
      }).m_4ef3b726(65), new C0151(Message.of(C0257.m_c42f1c7e()), 0.0, 0.0, this.f_4f9722e5) {
         @Override
         protected void m_b728afce() {
            C0193.this.m_0e265701();
         }
      }};
   }

   private C0163[] m_7236280b() {
      return new C0163[]{
         (new C0151(Message.of(String.format(C0267.m_3d3a8736(), FrameworkConstants.VERSION, FrameworkConstants.PATCH)), 0.0, 0.0, this.f_e0454fe7) {
            @Override
            protected void m_b728afce() {
               Keyboard.openLink(C0267.m_5fa6dd07());
            }
         }).m_5be40aea(), (new C0151(Message.of(String.format(C0267.m_94acbdac(), Main.getInstance().getMeta().getVersion())), 0.0, 0.0, this.f_e0454fe7) {
            @Override
            protected void m_b728afce() {
               Keyboard.openLink(C0267.m_056a389d());
            }
         }).m_5be40aea(), (new C0151(Message.of(C0267.m_022da1b4()), 0.0, 0.0, this.f_e0454fe7) {
            @Override
            protected void m_b728afce() {
               Keyboard.openLink(C0267.m_5f1ab561());
            }
         }).m_5be40aea(), (new C0151(Message.of(String.format(C0267.m_6e2d03c3(), C0241.f_152e7e4a)), 0.0, 0.0, this.f_e0454fe7) {
            @Override
            protected void m_b728afce() {
            }
         }).m_5be40aea()
      };
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      C0223.f_a04019fa.m_d7db8b4a(GuiScreen.getScaledWidth(), GuiScreen.getScaledHeight());
      if (C0242.m_fc1b642c().m_dc6b6d48().m_9362a920()) {
         RenderStack.blend();
         ((QuadRenderStack)this.f_7534d185.begin().glColor(Color.red, (float)(100.0 * ((Math.cos(this.f_902d08a1 += 0.1) + 1.0) / 2.0))))
            .drawRect(0.0F, 0.0F, (float)GuiScreen.getScaledWidth(), (float)GuiScreen.getScaledHeight())
            .end();
      }

      GlStateHelper.enableTexture2D();
      C0228.f_72c39893.bind().draw(12, 10, 80, 80).unbind();
      RenderStack.setupGl();
      RenderStack.reloadCustomMatrix();
      boolean var4 = false;

      for (C0163 var6 : this.f_3a3757f5) {
         var4 = var6.m_572d14e6(this.m_d945de47((double)var1), this.m_461db524((double)var2), var3, var4);
      }

      C0269.f_44d31626.m_5d3a4d80(new EventMatrixRender(0.0F));
      RenderStack.restoreGl();
      RenderStack.reloadMinecraftMatrix();
   }

   private void m_28c790f5(String var1, String... var2) {
      short var3 = 400;
      int var4 = this.f_4f9722e5.getFontHeight() + this.f_a5df0fd7.getFontHeight() * var2.length + 5;
      int var5 = getDisplayWidth() - var3;
      int var6 = (int)((double)getDisplayHeight() / 1.5 - (double)(var4 / 2)) - 20;
      ((QuadRenderStack)this.f_7534d185.begin().glColor(Color.black, 150.0F))
         .drawRect((float)var5, (float)var6, (float)(var5 + var3), (float)(var6 + var4))
         .end();
      this.f_4f9722e5.begin().drawString(var5 + var3 / 2 - this.f_4f9722e5.getStringWidth(var1) / 2, var6 + 2, var1).end();
      var6 += this.f_4f9722e5.getFontHeight();
      this.f_a5df0fd7.begin();

      for (String var10 : var2) {
         this.f_a5df0fd7.drawString(var5 + var3 / 2 - this.f_a5df0fd7.getStringWidth(var10) / 2, var6, var10);
         var6 += this.f_a5df0fd7.getFontHeight();
      }

      this.f_a5df0fd7.end();
   }
}
