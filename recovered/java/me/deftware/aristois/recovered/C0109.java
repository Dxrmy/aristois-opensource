package me.deftware.aristois.recovered;

import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.dialog.ColorDialogWidget;
import me.deftware.aristois.menu.widgets.ColorSelectionButton;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0109 implements C0112<Color> {
   public C0109() {
   }

   @Override
   public List<Class<? extends Color>> m_350b5ae0() {
      return Collections.singletonList(Color.class);
   }

   @Override
   public C0163 m_5f0a4ee5(final C0094<Color> var1, ContainerWidget var2, boolean var3) {
      final ColorDialogWidget var4 = new ColorDialogWidget(400.0, 200.0, var2.m_519f75ae()) {
         @Override
         protected Color getColor() {
            return (Color)var1.m_50ca8f08();
         }

         @Override
         protected void apply(Color var1x) {
            var1.m_a32b61ee(var1x);
         }
      };
      var4.setupComponents(Message.of(C0266.m_3c19a819()));
      var4.setPostChanged(var1.m_efa7610e());
      ColorSelectionButton var5 = new ColorSelectionButton(Message.of(var1.m_6f1f396d()), var2.m_519f75ae()) {
         private boolean f_4b2b0e55 = false;

         @Override
         protected Color getColor() {
            return (Color)var1.m_50ca8f08();
         }

         @Override
         protected void onClick(int var1x) {
            this.f_4b2b0e55 = true;
            if (var1x == 2) {
               var1.m_6fc98322();
            }
         }

         @Override
         public boolean m_a2722fba(double var1x, double var3, int var5) {
            if (this.f_4b2b0e55) {
               this.f_4b2b0e55 = false;
               if (var5 == 0 && this.f_7fd3d7b7.m_a58797d6(var1x, var3)) {
                  var4.getColorPicker().m_6e0baed2(this.getColor());
                  var4.getColorPicker().m_b728afce();
                  var4.open((C0446)Minecraft.getMinecraftGame().getScreen());
               }

               return true;
            } else {
               return false;
            }
         }
      };
      var5.m_ec141b95(new C0426[]{C0426.f_c285454f});
      if (var1.m_b3e55a9d().length != 0) {
         var5.m_c7a3618c(new RectTooltip(var5, C0289.m_c3a8b502(C0432.class), var1.m_b3e55a9d()));
      }

      return var5;
   }

   public Color m_d717c2e7(String var1) {
      if (var1.startsWith(C0266.m_f599ae93())) {
         return Color.decode(var1);
      } else if (var1.matches(C0266.m_5b2d5cb2())) {
         Integer[] var2 = Arrays.stream(var1.split(C0266.m_56cd5284())).map(Integer::parseInt).toArray(Integer[]::new);
         return new Color(var2[0], var2[1], var2[2]);
      } else {
         return null;
      }
   }

   @Override
   public void m_44a89f72(SuggestionsBuilder var1) {
      String var2 = "";
      if (var1.getRemaining().startsWith(C0266.m_f599ae93())) {
         var2 = C0266.m_62895921();
      } else if (var1.getRemaining().matches(C0266.m_ec4ef19a())) {
         var2 = C0266.m_83f6dd00();
      }

      if (!var2.isEmpty() && var2.length() >= var1.getRemaining().length()) {
         var1.suggest(var1.getRemaining() + var2.substring(var1.getRemaining().length()));
      }

      var1.suggest(C0266.m_83f6dd00()).suggest(C0266.m_62895921());
   }
}
