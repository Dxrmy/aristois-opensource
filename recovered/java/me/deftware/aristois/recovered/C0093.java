package me.deftware.aristois.recovered;

import java.lang.reflect.Field;

public class C0093<T extends Number> extends C0094<T> {
   public C0093(Field var1, Object var2, C0112<T> var3) throws Exception {
      super(var1, var2, var3);
   }

   public Number m_0ce362af() {
      return this.m_caad6a91().min();
   }

   public Number m_67f0fc00() {
      return this.m_caad6a91().max();
   }

   public void m_8bc24312(Number var1) {
      super.m_9660fce8(this.m_3f371aae(this.m_794d615c(var1)), false);
   }

   public boolean m_8aace8bc(String var1) {
      Number var2 = this.m_50ca8f08();

      try {
         double var3 = Double.parseDouble(var1);
         this.m_8bc24312(var3);
         this.m_0e389a72();
         return true;
      } catch (Exception var5) {
         this.m_8bc24312(var2);
         return false;
      }
   }

   @Override
   public boolean m_1a28c037(String var1) throws Exception {
      return this.m_8aace8bc(var1);
   }

   public Number m_3f371aae(Number var1) {
      if (this.m_01d9ec36() == int.class || this.m_01d9ec36() == Integer.class) {
         return var1.intValue();
      } else if (this.m_01d9ec36() == float.class || this.m_01d9ec36() == Float.class) {
         return var1.floatValue();
      } else {
         return (Number)(this.m_01d9ec36() != long.class && this.m_01d9ec36() != Long.class ? var1.doubleValue() : var1.longValue());
      }
   }

   @Override
   public String toString() {
      return this.m_01d9ec36() == int.class ? String.valueOf(this.m_50ca8f08().intValue()) : String.format(C0261.m_d597c122(), this.m_50ca8f08().doubleValue());
   }

   public Number m_794d615c(Number var1) {
      return Math.max(this.m_0ce362af().doubleValue(), Math.min(this.m_67f0fc00().doubleValue(), var1.doubleValue()));
   }

   public C0096 m_caad6a91() {
      return this.m_347620b9().number();
   }

   public boolean m_0e2aa5ef() {
      return this.m_50ca8f08().doubleValue() == this.m_67f0fc00().doubleValue();
   }

   public void m_8fd51513() {
      this.m_8bc24312(this.m_0ce362af());
   }

   public void m_1d41ca9a() {
      this.m_8bc24312(this.m_67f0fc00());
   }
}
