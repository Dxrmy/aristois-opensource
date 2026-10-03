package me.deftware.aristois.menu.view.dialog;

import java.awt.Color;
import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0228;
import me.deftware.aristois.recovered.C0252;
import me.deftware.aristois.recovered.C0436;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;

public abstract class ColorDialogWidget extends DialogWidget {
   public static C0228.anonymouscatch<C0436> brightness;
   public static C0228.anonymouscatch<C0436> hue;
   public static C0228.anonymouscatch<C0436> opacity;
   private C0436 colorPicker;
   private boolean postChanged = false;

   public ColorDialogWidget(double var1, double var3, C0441 var5) {
      this(0.0, 0.0, var1, var3, var5);
   }

   public ColorDialogWidget(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
   }

   @Override
   public DialogWidget setupComponents(Message var1) {
      super.setupComponents(var1);
      int var2 = (int)(this.f_a59692fd.m_fc7f45bc() - this.title.m_cb4e693c().m_fc7f45bc());
      this.colorPicker = new C0436(
         0.0,
         (double)((int)this.title.m_cb4e693c().m_fc7f45bc()),
         (double)((int)this.f_a59692fd.m_830cb294()),
         (double)var2,
         this.getColor(),
         brightness,
         hue,
         opacity
      ) {
         protected void m_e29924ba(Color var1, boolean var2) {
            if (!C0114.bootstrap<"call",0,1>(ColorDialogWidget.this) || !var2) {
               ColorDialogWidget.this.apply(var1);
            }
         }
      };
      this.colorPicker.m_abf2d8ea().m_b772f454(this.m_b0f508c8());
      this.m_5df11de2(new C0163[]{this.colorPicker});
      return this;
   }

   public boolean m_1328d9cc(int var1, int var2, int var3) {
      if (var3 == 2) {
         if (var1 == 67) {
            Color var7 = this.colorPicker.m_6af97ed1();
            String var8 = C0114.bootstrap<"call",1,1>(
               C0252.bootstrap<"get",38654705668>(),
               new Object[]{
                  C0114.bootstrap<"call",0,1>(var7.getRed()), C0114.bootstrap<"call",0,1>(var7.getGreen()), C0114.bootstrap<"call",0,1>(var7.getBlue())
               }
            );
            C0114.bootstrap<"call",2,1>(var8);
            return true;
         }

         if (var1 == 86) {
            String var4 = C0114.bootstrap<"call",3,1>();
            if (var4.matches(C0252.bootstrap<"get",38654705669>())) {
               try {
                  Color var5 = C0114.bootstrap<"call",4,1>(var4);
                  this.colorPicker.m_994d92a8(var5);
                  this.colorPicker.m_69f94f95();
                  return true;
               } catch (Exception var6) {
               }
            }
         }
      }

      return false;
   }

   protected abstract Color getColor();

   protected abstract void apply(Color var1);

   public C0436 getColorPicker() {
      return this.colorPicker;
   }

   public void setPostChanged(boolean var1) {
      this.postChanged = var1;
   }

   static {
      double var0 = 200.0;
      double var2 = 100.0;
      double var4 = var2 * 0.15;
      brightness = new C0228.anonymouscatch<C0436>(var0 - var4, var2 - var4) {
         public void onMouseMove(C0436 var1, double var2, double var4) {
            var1.f_9da0be27[1] = (float)var2;
            var1.f_9da0be27[2] = (float)var4;
            var1.m_4ffcde4c(true);
         }
      };
      hue = new C0228.anonymouscatch<C0436>(var0 - var4, var4) {
         public void onMouseMove(C0436 var1, double var2, double var4) {
            var1.f_9da0be27[0] = (float)var2;
            var1.m_69f94f95();
            var1.m_4ffcde4c(true);
         }
      };
      opacity = new C0228.anonymouscatch<C0436>(var4, var2) {
         public void onMouseMove(C0436 var1, double var2, double var4) {
            var1.f_c4c9313f = (int)(255.0 * var4);
            var1.m_4ffcde4c(true);
         }
      };
   }
}
