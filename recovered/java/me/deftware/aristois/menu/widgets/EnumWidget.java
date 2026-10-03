package me.deftware.aristois.menu.widgets;

import me.deftware.aristois.recovered.C0102;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;

public abstract class EnumWidget extends ButtonWidget {
   protected final C0102<?> boxedEnum;

   public EnumWidget(C0102<?> var1, C0441 var2) {
      this(0.0, 0.0, 0.0, var1, var2);
   }

   public EnumWidget(double var1, double var3, double var5, C0102<?> var7, C0441 var8) {
      super(var1, var3, var5, Message.of(var7.m_d32ebe65()), var8);
      this.boxedEnum = var7;
   }

   @Override
   protected void onClick(int var1) {
      if (var1 == 0) {
         this.boxedEnum.m_0e265701();
         this.m_1058ed9a();
         this.apply(this.boxedEnum.m_d32ebe65(), this.boxedEnum.m_597f2e14());
      }
   }

   protected abstract void apply(String var1, int var2);

   public C0102<?> getBoxedEnum() {
      return this.boxedEnum;
   }
}
