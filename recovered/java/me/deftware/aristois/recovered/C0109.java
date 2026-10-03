package me.deftware.aristois.recovered;

import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.awt.Color;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.dialog.ColorDialogWidget;
import me.deftware.aristois.menu.widgets.ColorSelectionButton;

public class C0109 implements C0112<Color> {
   public C0109() {
   }

   public List<Class<? extends Color>> m_e768e081() {
      return C0114.bootstrap<"call",0,1>(Color.class);
   }

   public C0163 m_99b4ba96(final C0094<Color> var1, ContainerWidget var2, boolean var3) {
      final ColorDialogWidget var4 = new ColorDialogWidget(400.0, 200.0, var2.m_0826645c()) {
         @Override
         protected Color getColor() {
            return (Color)var1.m_48b16e97();
         }

         @Override
         protected void apply(Color var1x) {
            var1.m_a8634ed3(var1x);
         }
      };
      var4.setupComponents(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884902007>()));
      var4.setPostChanged(var1.m_d24c1726());
      ColorSelectionButton var5 = new ColorSelectionButton(C0114.bootstrap<"call",1,1>(var1.m_b5ae4ee3()), var2.m_0826645c()) {
         private boolean f_7eee0dbd = false;

         @Override
         protected Color getColor() {
            return (Color)var1.m_48b16e97();
         }

         @Override
         protected void onClick(int var1x) {
            this.f_7eee0dbd = true;
            if (var1x == 2) {
               var1.m_4e85e8f7();
            }
         }

         public boolean m_fced1f38(double var1x, double var3, int var5) {
            if (this.f_7eee0dbd) {
               this.f_7eee0dbd = false;
               if (var5 == 0 && this.f_f64673d5.m_263d91ea(var1x, var3)) {
                  var4.getColorPicker().m_994d92a8(this.getColor());
                  var4.getColorPicker().m_69f94f95();
                  var4.open((C0446)C0114.bootstrap<"call",0,1>().getScreen());
               }

               return true;
            } else {
               return false;
            }
         }
      };
      var5.m_4f77418b(new C0426[]{C0426.f_974a55e6});
      if (var1.m_50eeaf3d().length != 0) {
         var5.m_47c44902(new RectTooltip(var5, (C0441)C0114.bootstrap<"call",2,1>(C0432.class), var1.m_50eeaf3d()));
      }

      return var5;
   }

   public Color m_92c56062(String var1) {
      if (var1.startsWith(C0252.bootstrap<"get",12884902008>())) {
         return C0114.bootstrap<"call",3,1>(var1);
      } else if (var1.matches(C0252.bootstrap<"get",12884902009>())) {
         Integer[] var2 = C0114.bootstrap<"call",4,1>(var1.split(C0252.bootstrap<"get",12884902010>())).map(Integer::parseInt).toArray(Integer[]::new);
         return new Color(var2[0], var2[1], var2[2]);
      } else {
         return null;
      }
   }

   public void m_5b129dfd(SuggestionsBuilder var1) {
      String var2 = "";
      if (var1.getRemaining().startsWith(C0252.bootstrap<"get",12884902008>())) {
         var2 = C0252.bootstrap<"get",12884902011>();
      } else if (var1.getRemaining().matches(C0252.bootstrap<"get",12884902012>())) {
         var2 = C0252.bootstrap<"get",12884902013>();
      }

      if (!var2.isEmpty() && var2.length() >= var1.getRemaining().length()) {
         var1.suggest(var1.getRemaining() + var2.substring(var1.getRemaining().length()));
      }

      var1.suggest(C0252.bootstrap<"get",12884902013>()).suggest(C0252.bootstrap<"get",12884902011>());
   }
}
