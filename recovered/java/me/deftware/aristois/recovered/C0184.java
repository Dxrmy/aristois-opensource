package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0184 extends GuiScreen {
   private final List<C0184.anonymousimport> f_e2dccaa2 = new ArrayList<>();
   private final QuadRenderStack f_f54af896 = new QuadRenderStack();

   public C0184(GenericScreen var1) {
      super(var1);
   }

   protected void onInitGui() {
      if (this.f_e2dccaa2.isEmpty()) {
         this.f_e2dccaa2.add(new C0184.anonymousimport(null, Message.of(C0254.m_df6e621c())) {
            @Override
            protected void m_1058ed9a() {
               Minecraft.getMinecraftGame().openScreen(new C0052(C0184.this));
            }

            @Override
            protected void m_885a0920(int var1, int var2) {
               int var3 = this.f_fdd52a4e / 2;
               byte var4 = 3;
               int var5 = 2 * var3 + var4;
               C0052.m_a5827fbf(C0184.this.f_f54af896, var1 - var5 / 2, var2 - var5 / 2, var3);
            }
         });
         this.f_e2dccaa2.add(new C0184.anonymousimport(C0228.f_fb45c3fb, Message.of(C0254.m_56242a84())) {
            @Override
            protected void m_1058ed9a() {
               Object var1 = new C0180(C0184.this);
               if (!Main.getConfig().hasKey(C0254.m_e07cee76())) {
                  var1 = new C0179(C0184.this);
               }

               Minecraft.getMinecraftGame().openScreen((GenericScreen)var1);
            }
         });
         this.f_e2dccaa2.add((new C0184.anonymousimport(C0049.f_bd2f3d48, Message.of(C0254.m_9e27f038())) {
            @Override
            protected void m_1058ed9a() {
               Minecraft.getMinecraftGame().openScreen(new C0183(C0184.this));
            }
         }).m_8bef06a3(24));
      }

      this.addComponent(new C0154(5, 5, 40, 20, Message.of(C0257.m_c42f1c7e())) {
         @Override
         public boolean m_1521b1fa(int var1) {
            return C0184.this.goBack();
         }
      });
   }

   protected void onDraw(int var1, int var2, float var3) {
      byte var4 = 10;
      int var5 = getScaledWidth() / 2;
      int var6 = getScaledHeight() / 2 - 40;
      FontRenderer.drawCenteredString(Message.of(C0254.m_af41331f()), var5, 40, 16777215);
      FontRenderer.drawCenteredString(Message.of(C0254.m_f257bcca()), var5, 50, 16777215);
      FontRenderer.drawCenteredString(Message.of(C0254.m_d9b37a36()).style(Appearance.of(DefaultColors.GRAY)), var5, getScaledHeight() - 11, 16777215);
      FontRenderer.drawCenteredString(Message.of(C0254.m_15737526() + SessionHelper.getPlayerUsername()), var5, 185, 16777215);
      FontRenderer.drawCenteredString(Message.of(SessionHelper.getPlayerUUID()).style(Appearance.of(DefaultColors.GRAY)), var5, 195, 16777215);
      var5 -= (this.f_e2dccaa2.size() * 80 + (this.f_e2dccaa2.size() - 1) * var4) / 2;

      for (C0184.anonymousimport var8 : this.f_e2dccaa2) {
         var8.m_f60c99b7(var5, var6, var1, var2, var3);
         var5 += var4 + 80;
      }
   }

   public boolean onMouseClicked(int var1, int var2, int var3) {
      for (C0184.anonymousimport var5 : this.f_e2dccaa2) {
         if (var5.m_27066322(var1, var2)) {
            return true;
         }
      }

      return super.onMouseClicked(var1, var2, var3);
   }

   private abstract class anonymousimport {
      private final GlTexture f_6df1a2ee;
      private final Message f_13ff7975;
      public static final int f_e66cf9c6 = 80;
      public static final int f_48cbbea6 = 80;
      public int f_fdd52a4e = 40;
      private boolean f_590ae3f7 = false;

      public void m_f60c99b7(int var1, int var2, int var3, int var4, float var5) {
         int var6 = var1 + 80;
         int var7 = var2 + 80;
         this.f_590ae3f7 = var3 > var1 && var3 < var6 && var4 > var2 && var4 < var7;
         if (this.f_590ae3f7) {
            GlStateHelper.enableBlend();
            ((QuadRenderStack)C0184.this.f_f54af896.glColor(Color.GRAY, 50.0F)).begin().drawRect((float)var1, (float)var2, (float)var6, (float)var7).end();
            GlStateHelper.disableAlpha();
         }

         byte var8 = 6;
         FontRenderer.drawCenteredString(this.f_13ff7975, var1 + 40, var2 + 80 - FontRenderer.getFontHeight() - var8, 16777215);
         this.m_885a0920(var1 + 40, var2 + 40 - var8);
      }

      public boolean m_27066322(int var1, int var2) {
         if (this.f_590ae3f7) {
            this.m_1058ed9a();
         }

         return this.f_590ae3f7;
      }

      protected void m_885a0920(int var1, int var2) {
         if (this.f_6df1a2ee != null && this.f_6df1a2ee.isReady()) {
            GlStateHelper.enableTexture2D();
            this.f_6df1a2ee.bind();
            if (this.f_6df1a2ee instanceof C0224) {
               C0224 var3 = (C0224)this.f_6df1a2ee;
               double var4 = 1.7;
               GLX.INSTANCE.push();
               GLX.INSTANCE.translate((float)var1, (float)var2, 1.0F);
               GLX.INSTANCE.scale(var4, var4, 1.0);
               var3.m_d4d15bd2(-(this.f_fdd52a4e / 2), -(this.f_fdd52a4e / 2), this.f_fdd52a4e, this.f_fdd52a4e, C0230.anonymouscatch.f_bce9cc23);
               GLX.INSTANCE.pop();
            } else {
               this.f_6df1a2ee.draw(var1 - this.f_fdd52a4e / 2, var2 - this.f_fdd52a4e / 2, this.f_fdd52a4e, this.f_fdd52a4e).unbind();
            }

            GlStateHelper.disableTexture2D();
         }
      }

      public C0184.anonymousimport m_8bef06a3(int var1) {
         this.f_fdd52a4e = var1;
         return this;
      }

      protected abstract void m_1058ed9a();

      public anonymousimport(GlTexture var2, Message var3) {
         this.f_6df1a2ee = var2;
         this.f_13ff7975 = var3;
      }
   }
}
