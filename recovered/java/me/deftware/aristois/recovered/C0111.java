package me.deftware.aristois.recovered;

import java.util.List;
import java.util.function.BiFunction;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.TextBoxWidget;

public class C0111 implements C0112<String> {
   public C0111() {
   }

   public List<Class<? extends String>> m_7f6d561b() {
      return C0114.bootstrap<"call",0,1>(String.class);
   }

   public C0163 m_0f8e1b84(final C0094<String> var1, ContainerWidget var2, boolean var3) {
      TextBoxWidget var4 = new TextBoxWidget(0.0, 0.0, var2.m_908f7f94().m_830cb294(), var2.m_0826645c()) {
         @Override
         protected void apply(String var1x) {
            var1.m_dfb23874(var1x, true);
         }

         public void m_34251e80() {
            this.setText((String)var1.m_48b16e97());
         }

         @Override
         protected void onClick(int var1x) {
            super.onClick(var1x);
            if (var1x == 2) {
               var1.m_4e85e8f7();
               this.m_34251e80();
            }
         }
      };
      var4.setTextAlign(C0427.f_f7cee513);
      var4.setShadowText(var1.m_b5ae4ee3());
      var4.m_4103fcee(new C0426[]{C0426.f_974a55e6});
      if (var1.m_604f0940() != C0098.anonymouscatch.class) {
         try {
            var4.setProcessor((BiFunction<String, String, String>)var1.m_604f0940().newInstance());
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      return var4;
   }

   public String m_dc7d8b03(String var1) {
      return var1;
   }
}
