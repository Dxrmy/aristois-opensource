package me.deftware.aristois.recovered;

import java.util.HashMap;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Message;

public class C0160 extends C0154 {
   private int f_2ac0ff26 = -1;
   private int f_21379aa1 = -1;
   private boolean f_588ea0a8 = false;
   private boolean f_410506e0 = false;
   private final HashMap<Integer, Integer> f_f3fb4c69 = C0217.m_5f8a4d99(342, 4, 346, 4, 340, 1, 344, 1, 341, 2, 345, 2);

   public C0160(int var1, int var2, int var3, int var4) {
      super(var1, var2, var3, var4, Message.of(C0267.m_16315846()));
   }

   public void m_394ecb95(boolean var1) {
      this.f_410506e0 = var1;
      this.m_b1b94a23().setComponentLabel(this.m_2d348094());
   }

   public C0160 m_e190ec3a(int var1) {
      this.f_2ac0ff26 = this.f_21379aa1 = var1;
      this.m_b1b94a23().setComponentLabel(this.m_2d348094());
      return this;
   }

   private Message m_2d348094() {
      return Message.of(
         this.f_588ea0a8
            ? C0267.m_e8fd0250() + (this.f_410506e0 ? C0267.m_d0da63e8() : C0267.m_0425f2ec())
            : (this.f_2ac0ff26 == -1 ? C0266.m_5f1ab561() + (this.f_410506e0 ? C0267.m_d0da63e8() : C0267.m_1b17f04f()) : Keyboard.getKeyName(this.f_21379aa1))
      );
   }

   @Override
   public boolean m_82e0832a(int var1, int var2, int var3) {
      if (this.f_588ea0a8) {
         this.f_588ea0a8 = false;
         this.f_21379aa1 = var1;
         this.f_2ac0ff26 = this.f_410506e0 ? this.f_f3fb4c69.getOrDefault(var1, -1) : var1;
         this.m_b1b94a23().setComponentLabel(this.m_2d348094());
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      this.m_82e0832a(var5, 1, 0);
      return false;
   }

   @Override
   public boolean m_1521b1fa(int var1) {
      this.f_588ea0a8 = !this.f_588ea0a8;
      this.m_b1b94a23().setComponentLabel(this.m_2d348094());
      return true;
   }

   public int m_2ac34870() {
      return this.f_2ac0ff26;
   }

   public int m_597f2e14() {
      return this.f_21379aa1;
   }

   public boolean m_f0e7dcaa() {
      return this.f_588ea0a8;
   }

   public boolean m_5d7ada2f() {
      return this.f_410506e0;
   }

   public HashMap<Integer, Integer> m_fa23cd75() {
      return this.f_f3fb4c69;
   }
}
