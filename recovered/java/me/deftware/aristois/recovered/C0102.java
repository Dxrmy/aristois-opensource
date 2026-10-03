package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class C0102<T extends Enum<T>> {
   private final List<T> f_05e1755b = new ArrayList<>();
   private T f_8c36517d;
   private T f_825a6199;
   private int f_59127cc6;
   private Function<T, String> f_99399171;

   public C0102(T var1) {
      this((T)var1, var0 -> true);
   }

   public C0102(T var1, Predicate<T> var2) {
      C0114.bootstrap<"call",0,1>(var1.getDeclaringClass().getEnumConstants()).filter(var2).forEach(this.f_05e1755b::add);
      this.m_8725a94b((T)var1);
   }

   public C0102<T> m_9cf7c1de(Function<T, String> var1) {
      this.f_99399171 = var1;
      return this;
   }

   public String[] m_39d671cb() {
      return this.f_825a6199 instanceof C0102.anonymousthis ? ((C0102.anonymousthis)this.f_825a6199).m_b4200e09() : null;
   }

   public void m_322bf07c() {
      this.m_58aaf1a4(this.f_8c36517d);
   }

   public void m_8725a94b(T var1) {
      this.m_58aaf1a4(this.f_8c36517d = (T)var1);
   }

   public void m_58aaf1a4(T var1) {
      this.f_825a6199 = (T)var1;
      this.f_59127cc6 = var1.ordinal();
   }

   public int m_8c9089bc(String var1) {
      for (int var2 = 0; var2 < this.f_05e1755b.size(); var2++) {
         if (this.m_073c96f8(this.f_05e1755b.get(var2)).equalsIgnoreCase(var1)) {
            return var2;
         }
      }

      return -1;
   }

   public void m_a6872081() {
      if (this.f_59127cc6 == this.f_05e1755b.size() - 1) {
         this.m_d2d71c50(this.f_59127cc6 = 0);
      } else {
         this.m_d2d71c50(++this.f_59127cc6);
      }
   }

   public boolean m_4c8d9085(T var1) {
      return this.m_e2691446() == var1;
   }

   private String m_073c96f8(T var1) {
      return this.f_99399171 != null ? this.f_99399171.apply((T)var1) : var1.toString();
   }

   public String m_27694bb2() {
      return this.m_073c96f8(this.f_825a6199);
   }

   @Override
   public String toString() {
      return this.m_27694bb2();
   }

   public void m_d2d71c50(int var1) {
      if (var1 >= this.f_05e1755b.size() || var1 < 0) {
         var1 = 0;
      }

      this.f_59127cc6 = var1;
      this.f_825a6199 = this.f_05e1755b.get(var1);
   }

   public Stream<String> m_e2c7ae30() {
      return this.f_05e1755b.stream().map(this::m_073c96f8);
   }

   public List<T> m_1aa04df6() {
      return this.f_05e1755b;
   }

   public T m_3fc90dd6() {
      return this.f_8c36517d;
   }

   public T m_e2691446() {
      return this.f_825a6199;
   }

   public int m_36cf9409() {
      return this.f_59127cc6;
   }

   public Function<T, String> m_162206df() {
      return this.f_99399171;
   }

   public interface anonymousthis {
      String[] m_b4200e09();
   }
}
