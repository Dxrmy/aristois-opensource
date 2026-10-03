package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;

public class C0184 extends GuiScreen {
   private final List<C0184.anonymousimport> f_51fd520c = new ArrayList<>();
   private final QuadRenderStack f_bfa7dce0 = new QuadRenderStack();

   public C0184(GenericScreen var1) {
      super(var1);
   }

   protected void onInitGui() {
      if (this.f_51fd520c.isEmpty()) {
         this.f_51fd520c.add(new C0184.anonymousimport(null, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836537>())) {
            protected void m_6666a17c() {
               C0114.bootstrap<"call",0,1>().openScreen(new C0052(C0184.this));
            }

            protected void m_b9ceceee(int var1, int var2) {
               int var3 = this.f_91d41639 / 2;
               byte var4 = 3;
               int var5 = 2 * var3 + var4;
               C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0184.this), var1 - var5 / 2, var2 - var5 / 2, var3);
            }
         });
         this.f_51fd520c.add(new C0184.anonymousimport(C0228.f_70b24af3, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836538>())) {
            protected void m_e8c1fd70() {
               Object var1 = new C0180(C0184.this);
               if (!C0114.bootstrap<"call",0,1>().hasKey(C0252.bootstrap<"get",21474836505>())) {
                  var1 = new C0179(C0184.this);
               }

               C0114.bootstrap<"call",1,1>().openScreen((GenericScreen)var1);
            }
         });
         this.f_51fd520c.add((new C0184.anonymousimport(C0049.f_81193085, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836539>())) {
            protected void m_5c02aa3a() {
               C0114.bootstrap<"call",0,1>().openScreen(new C0183(C0184.this));
            }
         }).m_4302634f(24));
      }

      this.addComponent(new C0154(5, 5, 40, 20, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>())) {
         public boolean m_39cde428(int var1) {
            return C0114.bootstrap<"call",0,1>(C0184.this);
         }
      });
   }

   protected void onDraw(int var1, int var2, float var3) {
      byte var4 = 10;
      int var5 = C0114.bootstrap<"call",0,1>() / 2;
      int var6 = C0114.bootstrap<"call",1,1>() / 2 - 40;
      C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",21474836540>()), var5, 40, 16777215);
      C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",21474836541>()), var5, 50, 16777215);
      C0114.bootstrap<"call",3,1>(
         C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",21474836542>()).style(C0114.bootstrap<"call",4,1>(DefaultColors.GRAY)),
         var5,
         C0114.bootstrap<"call",1,1>() - 11,
         16777215
      );
      C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",21474836543>() + C0114.bootstrap<"call",5,1>()), var5, 185, 16777215);
      C0114.bootstrap<"call",3,1>(
         C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",6,1>()).style(C0114.bootstrap<"call",4,1>(DefaultColors.GRAY)), var5, 195, 16777215
      );
      var5 -= (this.f_51fd520c.size() * 80 + (this.f_51fd520c.size() - 1) * var4) / 2;

      for (C0184.anonymousimport var8 : this.f_51fd520c) {
         var8.m_5f88fece(var5, var6, var1, var2, var3);
         var5 += var4 + 80;
      }
   }

   public boolean onMouseClicked(int var1, int var2, int var3) {
      for (C0184.anonymousimport var5 : this.f_51fd520c) {
         if (var5.m_2771d932(var1, var2)) {
            return true;
         }
      }

      return super.onMouseClicked(var1, var2, var3);
   }

   private abstract class anonymousimport {
      private final GlTexture f_843f617b;
      private final Message f_036a54a6;
      public static final int f_1f8354b1 = 80;
      public static final int f_151b4b18 = 80;
      public int f_abb52916 = 40;
      private boolean f_7d0801e7 = false;

      public void m_5f88fece(int var1, int var2, int var3, int var4, float var5) {
         int var6 = var1 + 80;
         int var7 = var2 + 80;
         this.f_7d0801e7 = var3 > var1 && var3 < var6 && var4 > var2 && var4 < var7;
         if (this.f_7d0801e7) {
            C0114.bootstrap<"call",0,1>();
            ((QuadRenderStack)C0114.bootstrap<"call",1,1>(C0184.this).glColor(Color.GRAY, 50.0F))
               .begin()
               .drawRect((float)var1, (float)var2, (float)var6, (float)var7)
               .end();
            C0114.bootstrap<"call",2,1>();
         }

         byte var8 = 6;
         C0114.bootstrap<"call",4,1>(this.f_036a54a6, var1 + 40, var2 + 80 - C0114.bootstrap<"call",3,1>() - var8, 16777215);
         this.m_60027408(var1 + 40, var2 + 40 - var8);
      }

      public boolean m_2771d932(int var1, int var2) {
         if (this.f_7d0801e7) {
            this.m_ba91782c();
         }

         return this.f_7d0801e7;
      }

      protected void m_60027408(int var1, int var2) {
         if (this.f_843f617b != null && this.f_843f617b.isReady()) {
            C0114.bootstrap<"call",5,1>();
            this.f_843f617b.bind();
            if (this.f_843f617b instanceof C0224) {
               C0224 var3 = (C0224)this.f_843f617b;
               double var4 = 1.7;
               GLX.INSTANCE.push();
               GLX.INSTANCE.translate((float)var1, (float)var2, 1.0F);
               GLX.INSTANCE.scale(var4, var4, 1.0);
               var3.m_f3bb274c(-(this.f_abb52916 / 2), -(this.f_abb52916 / 2), this.f_abb52916, this.f_abb52916, C0230.anonymouscatch.f_b4b41867);
               GLX.INSTANCE.pop();
            } else {
               this.f_843f617b.draw(var1 - this.f_abb52916 / 2, var2 - this.f_abb52916 / 2, this.f_abb52916, this.f_abb52916).unbind();
            }

            C0114.bootstrap<"call",6,1>();
         }
      }

      public C0184.anonymousimport m_fff4f52f(int var1) {
         this.f_abb52916 = var1;
         return this;
      }

      protected abstract void m_ba91782c();

      public anonymousimport(GlTexture var2, Message var3) {
         this.f_843f617b = var2;
         this.f_036a54a6 = var3;
      }
   }
}
