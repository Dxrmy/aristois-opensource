package me.deftware.aristois.recovered;

import java.lang.reflect.Field;

public class C0093<T extends Number> extends C0094<T> {
   public C0093(Field var1, Object var2, C0112<T> var3) throws Exception {
      super(var1, var2, var3);
   }

   public Number m_c8046c49() {
      return C0114.bootstrap<"call",0,1>(this.m_a4a5f1c9().min());
   }

   public Number m_0f5966d8() {
      return C0114.bootstrap<"call",0,1>(this.m_a4a5f1c9().max());
   }

   public void m_e73922d0(Number var1) {
      super.m_dfb23874(this.m_19cf1dd7(this.m_c3c19c52(var1)), false);
   }

   public boolean m_a0f7f587(String var1) {
      Number var2 = (Number)this.m_c0a289a4();

      try {
         double var3 = C0114.bootstrap<"call",0,1>(var1);
         this.m_e73922d0(C0114.bootstrap<"call",1,1>(var3));
         this.m_9e9565ce();
         return true;
      } catch (Exception var5) {
         this.m_e73922d0(var2);
         return false;
      }
   }

   public boolean m_00a17ba4(String var1) throws Exception {
      return this.m_a0f7f587(var1);
   }

   public Number m_19cf1dd7(Number var1) {
      if (this.m_6cb19ca6() == int.class || this.m_6cb19ca6() == Integer.class) {
         return C0114.bootstrap<"call",2,1>(var1.intValue());
      } else if (this.m_6cb19ca6() == float.class || this.m_6cb19ca6() == Float.class) {
         return C0114.bootstrap<"call",3,1>(var1.floatValue());
      } else {
         return (Number)(this.m_6cb19ca6() != long.class && this.m_6cb19ca6() != Long.class
            ? C0114.bootstrap<"call",1,1>(var1.doubleValue())
            : C0114.bootstrap<"call",4,1>(var1.longValue()));
      }
   }

   @Override
   public String toString() {
      return this.m_6cb19ca6() == int.class
         ? C0114.bootstrap<"call",0,1>(((Number)this.m_c0a289a4()).intValue())
         : C0114.bootstrap<"call",2,1>(
            C0252.bootstrap<"get",17179869200>(), new Object[]{C0114.bootstrap<"call",1,1>(((Number)this.m_c0a289a4()).doubleValue())}
         );
   }

   public Number m_c3c19c52(Number var1) {
      return C0114.bootstrap<"call",2,1>(
         C0114.bootstrap<"call",1,1>(this.m_c8046c49().doubleValue(), C0114.bootstrap<"call",0,1>(this.m_0f5966d8().doubleValue(), var1.doubleValue()))
      );
   }

   public C0096 m_a4a5f1c9() {
      return this.m_d1fcdae9().number();
   }

   public boolean m_f8464f93() {
      return ((Number)this.m_c0a289a4()).doubleValue() == this.m_0f5966d8().doubleValue();
   }

   public void m_66bc207a() {
      this.m_e73922d0(this.m_c8046c49());
   }

   public void m_283e0c89() {
      this.m_e73922d0(this.m_0f5966d8());
   }
}
