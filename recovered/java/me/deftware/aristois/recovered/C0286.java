package me.deftware.aristois.recovered;

import java.util.function.Supplier;
import me.deftware.client.framework.message.Message;

public class C0286 extends C0287 {
   private final Supplier<Boolean> f_17bd195f;

   public C0286(Supplier<Boolean> var1, Message var2, Message... var3) {
      super(var2, var3);
      this.f_17bd195f = var1;
   }

   @Override
   protected boolean m_f0e7dcaa() {
      return this.f_17bd195f.get();
   }
}
