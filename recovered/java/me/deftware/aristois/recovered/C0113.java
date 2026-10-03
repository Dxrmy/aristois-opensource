package me.deftware.aristois.recovered;

import java.lang.reflect.Field;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.SliderWidget;
import me.deftware.client.framework.message.DefaultColors;

public class C0113 implements C0112<Number> {
   public C0113() {
   }

   public List<Class<? extends Number>> m_ed3004e1() {
      return C0114.bootstrap<"call",0,1>(new Class[]{double.class, float.class, int.class, long.class, Double.class, Float.class, Integer.class, Long.class});
   }

   public C0163 m_4b4fff9b(C0094<Number> var1, ContainerWidget var2, boolean var3) {
      final C0093 var4 = (C0093)var1;
      SliderWidget var5 = new SliderWidget(var2.m_0826645c()) {
         @Override
         public void apply(double var1, boolean var3) {
            var1 = this.m_7d5098c0(var1);
            if (!var4.m_85a82009() || !var4.m_b8a51a80() || var3) {
               var4.m_e73922d0(C0114.bootstrap<"call",0,1>(var1));
            }

            if (var3 || !var4.m_b8a51a80()) {
               var4.m_9e9565ce();
            }

            if (var3) {
               this.m_3158fa62();
            }
         }

         protected void m_3158fa62() {
            this.value = this.normalize(((Number)var4.m_c0a289a4()).doubleValue());
            this.updateLabel();
         }

         public void m_9cd8951e() {
            this.m_3158fa62();
            super.m_3a84e561();
         }

         @Override
         public void updateLabel() {
            DefaultColors var1 = DefaultColors.WHITE;
            this.setLabel(
               C0114.bootstrap<"call",0,1>(var4.m_294add70() + C0252.bootstrap<"get",70>() + this.getValueText()).style(C0114.bootstrap<"call",1,1>(var1))
            );
         }

         @Override
         public String getValueText() {
            return var4.m_a4a5f1c9().percentage()
               ? C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884902017>(), new Object[]{C0114.bootstrap<"call",0,1>(this.percentage())})
               : C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",17179869184>(), new Object[]{C0114.bootstrap<"call",0,1>(this.m_7d5098c0(this.value))});
         }

         @Override
         protected void onClick(int var1) {
            super.onClick(var1);
            if (var1 == 2) {
               var4.m_8390977c();
               this.m_9cd8951e();
            }
         }

         @Override
         public double normalize(double var1) {
            var1 = C0114.bootstrap<"call",0,1>(var4.m_c8046c49().doubleValue(), var4.m_0f5966d8().doubleValue(), var1);
            double var3 = var4.m_c8046c49().doubleValue();
            return (var1 - var3) / (var4.m_0f5966d8().doubleValue() - var3);
         }

         public double m_7d5098c0(double var1) {
            double var3 = var4.m_c8046c49().doubleValue();
            return var3 + var1 * (var4.m_0f5966d8().doubleValue() - var3);
         }
      };
      var5.setPercentageMode(var4.m_a4a5f1c9().percentage());
      var5.m_4a1a14a9(new C0426[]{C0426.f_974a55e6});
      return var5;
   }

   public C0094<Number> m_78ba1f27(Field var1, Object var2) throws Exception {
      return new C0093<>(var1, var2, this);
   }
}
