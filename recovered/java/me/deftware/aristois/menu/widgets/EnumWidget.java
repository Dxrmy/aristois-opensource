package me.deftware.aristois.menu.widgets;

import me.deftware.aristois.recovered.C0102;
import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0441;

public abstract class EnumWidget extends ButtonWidget {
   protected final C0102<?> boxedEnum;

   public EnumWidget(C0102<?> var1, C0441 var2) {
      this(0.0, 0.0, 0.0, var1, var2);
   }

   public EnumWidget(double var1, double var3, double var5, C0102<?> var7, C0441 var8) {
      super(var1, var3, var5, C0114.bootstrap<"call",0,1>(var7.m_27694bb2()), var8);
      this.boxedEnum = var7;
   }

   @Override
   protected void onClick(int var1) {
      if (var1 == 0) {
         this.boxedEnum.m_a6872081();
         this.m_b17b50f7();
         this.apply(this.boxedEnum.m_27694bb2(), this.boxedEnum.m_36cf9409());
      }
   }

   protected abstract void apply(String var1, int var2);

   public C0102<?> getBoxedEnum() {
      return this.boxedEnum;
   }
}
