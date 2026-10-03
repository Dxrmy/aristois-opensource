package me.deftware.aristois.recovered;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.SliderWidget;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0113 implements C0112<Number> {
   public C0113() {
   }

   @Override
   public List<Class<? extends Number>> m_350b5ae0() {
      return Arrays.asList(double.class, float.class, int.class, long.class, Double.class, Float.class, Integer.class, Long.class);
   }

   @Override
   public C0163 m_5f0a4ee5(C0094<Number> var1, ContainerWidget var2, boolean var3) {
      final C0093 var4 = (C0093)var1;
      SliderWidget var5 = new SliderWidget(var2.m_519f75ae()) {
         @Override
         public void apply(double var1, boolean var3) {
            var1 = this.m_d945de47(var1);
            if (!var4.m_89e0519f() || !var4.m_efa7610e() || var3) {
               var4.m_8bc24312(var1);
            }

            if (var3 || !var4.m_efa7610e()) {
               var4.m_0e389a72();
            }

            if (var3) {
               this.m_b728afce();
            }
         }

         protected void m_b728afce() {
            this.value = this.normalize(((Number)var4.m_50ca8f08()).doubleValue());
            this.updateLabel();
         }

         @Override
         public void m_1058ed9a() {
            this.m_b728afce();
            super.m_1058ed9a();
         }

         @Override
         public void updateLabel() {
            DefaultColors var1 = DefaultColors.WHITE;
            this.setLabel(Message.of(var4.m_6f1f396d() + C0257.m_593ecbab() + this.getValueText()).style(Appearance.of(var1)));
         }

         @Override
         public String getValueText() {
            return var4.m_caad6a91().percentage()
               ? String.format(C0266.m_c6614274(), this.percentage())
               : String.format(C0261.m_44418b5d(), this.m_d945de47(this.value));
         }

         @Override
         protected void onClick(int var1) {
            super.onClick(var1);
            if (var1 == 2) {
               var4.m_6fc98322();
               this.m_1058ed9a();
            }
         }

         @Override
         public double normalize(double var1) {
            var1 = clamp(var4.m_0ce362af().doubleValue(), var4.m_67f0fc00().doubleValue(), var1);
            double var3 = var4.m_0ce362af().doubleValue();
            return (var1 - var3) / (var4.m_67f0fc00().doubleValue() - var3);
         }

         public double m_d945de47(double var1) {
            double var3 = var4.m_0ce362af().doubleValue();
            return var3 + var1 * (var4.m_67f0fc00().doubleValue() - var3);
         }
      };
      var5.setPercentageMode(var4.m_caad6a91().percentage());
      var5.m_ec141b95(new C0426[]{C0426.f_c285454f});
      return var5;
   }

   @Override
   public C0094<Number> m_6ba94131(Field var1, Object var2) throws Exception {
      return new C0093<>(var1, var2, this);
   }
}
