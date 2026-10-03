package me.deftware.aristois.recovered;

import java.util.function.Supplier;
import me.deftware.client.framework.message.Message;

public class C0286 extends C0287 {
   private final Supplier<Boolean> f_7c0739b7;

   public C0286(Supplier<Boolean> var1, Message var2, Message... var3) {
      super(var2, var3);
      this.f_7c0739b7 = var1;
   }

   protected boolean m_fb3b0412() {
      return this.f_7c0739b7.get();
   }
}
