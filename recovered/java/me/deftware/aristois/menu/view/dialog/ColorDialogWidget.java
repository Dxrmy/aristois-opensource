package me.deftware.aristois.menu.view.dialog;

import java.awt.Color;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0228;
import me.deftware.aristois.recovered.C0263;
import me.deftware.aristois.recovered.C0436;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.input.Keyboard;
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
      int var2 = (int)(this.f_7fd3d7b7.m_d42f3372() - this.title.m_44bb072f().m_d42f3372());
      this.colorPicker = new C0436(
         0.0,
         (double)((int)this.title.m_44bb072f().m_d42f3372()),
         (double)((int)this.f_7fd3d7b7.m_4388ac29()),
         (double)var2,
         this.getColor(),
         brightness,
         hue,
         opacity
      ) {
         @Override
         protected void m_e4529f30(Color var1, boolean var2) {
            if (!ColorDialogWidget.this.postChanged || !var2) {
               ColorDialogWidget.this.apply(var1);
            }
         }
      };
      this.colorPicker.m_44bb072f().m_8d8487f4(this.m_44bb072f());
      this.m_cb54a800(new C0163[]{this.colorPicker});
      return this;
   }

   @Override
   public boolean m_82e0832a(int var1, int var2, int var3) {
      if (var3 == 2) {
         if (var1 == 67) {
            Color var7 = this.colorPicker.m_ac758c94();
            String var8 = String.format(C0263.m_4626ac74(), var7.getRed(), var7.getGreen(), var7.getBlue());
            Keyboard.setClipboardString(var8);
            return true;
         }

         if (var1 == 86) {
            String var4 = Keyboard.getClipboardString();
            if (var4.matches(C0263.m_c688f8ca())) {
               try {
                  Color var5 = Color.decode(var4);
                  this.colorPicker.m_6e0baed2(var5);
                  this.colorPicker.m_b728afce();
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
            var1.f_1b6ae1d0[1] = (float)var2;
            var1.f_1b6ae1d0[2] = (float)var4;
            var1.m_394ecb95(true);
         }
      };
      hue = new C0228.anonymouscatch<C0436>(var0 - var4, var4) {
         public void onMouseMove(C0436 var1, double var2, double var4) {
            var1.f_1b6ae1d0[0] = (float)var2;
            var1.m_b728afce();
            var1.m_394ecb95(true);
         }
      };
      opacity = new C0228.anonymouscatch<C0436>(var4, var2) {
         public void onMouseMove(C0436 var1, double var2, double var4) {
            var1.f_fdb582bf = (int)(255.0 * var4);
            var1.m_394ecb95(true);
         }
      };
   }
}
