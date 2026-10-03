package me.deftware.aristois.recovered;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.TextBoxWidget;

public class C0111 implements C0112<String> {
   public C0111() {
   }

   @Override
   public List<Class<? extends String>> m_350b5ae0() {
      return Collections.singletonList(String.class);
   }

   @Override
   public C0163 m_5f0a4ee5(final C0094<String> var1, ContainerWidget var2, boolean var3) {
      TextBoxWidget var4 = new TextBoxWidget(0.0, 0.0, var2.m_44bb072f().m_4388ac29(), var2.m_519f75ae()) {
         @Override
         protected void apply(String var1x) {
            var1.m_9660fce8(var1x, true);
         }

         @Override
         public void m_1058ed9a() {
            this.setText((String)var1.m_50ca8f08());
         }

         @Override
         protected void onClick(int var1x) {
            super.onClick(var1x);
            if (var1x == 2) {
               var1.m_6fc98322();
               this.m_1058ed9a();
            }
         }
      };
      var4.setTextAlign(C0427.f_26bd24ae);
      var4.setShadowText(var1.m_6f1f396d());
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      if (var1.m_4e33612f() != C0098.anonymouscatch.class) {
         try {
            var4.setProcessor((BiFunction<String, String, String>)var1.m_4e33612f().newInstance());
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      return var4;
   }

   public String m_866a453e(String var1) {
      return var1;
   }
}
