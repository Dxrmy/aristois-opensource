package me.deftware.aristois.recovered;

import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Arrays;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.BooleanWidget;
import me.deftware.client.framework.message.Message;

public class C0118 implements C0112<Boolean> {
   public C0118() {
   }

   @Override
   public List<Class<? extends Boolean>> m_350b5ae0() {
      return Arrays.asList(boolean.class, Boolean.class);
   }

   @Override
   public C0163 m_5f0a4ee5(C0094<Boolean> var1, ContainerWidget var2, boolean var3) {
      return m_bea0fb4e(Message.of(var1.m_6f1f396d()), var1, var2.m_519f75ae(), var3);
   }

   public static C0163 m_bea0fb4e(Message var0, final C0105<Boolean> var1, C0441 var2, boolean var3) {
      BooleanWidget var4 = new BooleanWidget(var0, var2) {
         @Override
         protected void apply(boolean var1x) {
            var1.m_a32b61ee(var1x);
         }

         @Override
         public void m_1058ed9a() {
            this.enabled = (Boolean)var1.m_50ca8f08();
            this.getAnimation().m_41e83f88();
         }

         @Override
         protected void onClick(int var1x) {
            super.onClick(var1x);
            if (var1x == 2 && var1 instanceof C0094) {
               ((C0094)var1).m_6fc98322();
               this.m_1058ed9a();
            }
         }
      };
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      if (var3) {
         var4.updatePadding(C0110.m_4388ac29());
      }

      return var4;
   }

   public Boolean m_2f090fa8(String var1) {
      return Boolean.parseBoolean(var1);
   }

   @Override
   public void m_44a89f72(SuggestionsBuilder var1) {
      var1.suggest(C0266.m_8870d2c1()).suggest(C0266.m_a004d745());
   }
}
