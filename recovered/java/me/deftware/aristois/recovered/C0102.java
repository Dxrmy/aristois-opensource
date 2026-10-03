package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class C0102<T extends Enum<T>> {
   private final List<T> f_14094854 = new ArrayList<>();
   private T f_8ace1eb8;
   private T f_998108d3;
   private int f_0c2bfe4d;
   private Function<T, String> f_083d2d4b;

   public C0102(T var1) {
      this((T)var1, var0 -> true);
   }

   public C0102(T var1, Predicate<T> var2) {
      Arrays.stream(var1.getDeclaringClass().getEnumConstants()).filter(var2).forEach(this.f_14094854::add);
      this.m_5b9845c3((T)var1);
   }

   public C0102<T> m_0b0d54ca(Function<T, String> var1) {
      this.f_083d2d4b = var1;
      return this;
   }

   public String[] m_61857e58() {
      return this.f_998108d3 instanceof C0102.anonymousthis ? ((C0102.anonymousthis)this.f_998108d3).m_8e56a473() : null;
   }

   public void m_b728afce() {
      this.m_39d849e1(this.f_8ace1eb8);
   }

   public void m_5b9845c3(T var1) {
      this.m_39d849e1(this.f_8ace1eb8 = (T)var1);
   }

   public void m_39d849e1(T var1) {
      this.f_998108d3 = (T)var1;
      this.f_0c2bfe4d = var1.ordinal();
   }

   public int m_f16981ce(String var1) {
      for (int var2 = 0; var2 < this.f_14094854.size(); var2++) {
         if (this.m_324eb983(this.f_14094854.get(var2)).equalsIgnoreCase(var1)) {
            return var2;
         }
      }

      return -1;
   }

   public void m_0e265701() {
      if (this.f_0c2bfe4d == this.f_14094854.size() - 1) {
         this.m_46938bdb(this.f_0c2bfe4d = 0);
      } else {
         this.m_46938bdb(++this.f_0c2bfe4d);
      }
   }

   public boolean m_d161e31b(T var1) {
      return this.m_284992ec() == var1;
   }

   private String m_324eb983(T var1) {
      return this.f_083d2d4b != null ? this.f_083d2d4b.apply((T)var1) : var1.toString();
   }

   public String m_d32ebe65() {
      return this.m_324eb983(this.f_998108d3);
   }

   @Override
   public String toString() {
      return this.m_d32ebe65();
   }

   public void m_46938bdb(int var1) {
      if (var1 >= this.f_14094854.size() || var1 < 0) {
         var1 = 0;
      }

      this.f_0c2bfe4d = var1;
      this.f_998108d3 = this.f_14094854.get(var1);
   }

   public Stream<String> m_cb07f77b() {
      return this.f_14094854.stream().map(this::m_324eb983);
   }

   public List<T> m_b720541d() {
      return this.f_14094854;
   }

   public T m_242ecab0() {
      return this.f_8ace1eb8;
   }

   public T m_284992ec() {
      return this.f_998108d3;
   }

   public int m_597f2e14() {
      return this.f_0c2bfe4d;
   }

   public Function<T, String> m_38a30746() {
      return this.f_083d2d4b;
   }

   public interface anonymousthis {
      String[] m_8e56a473();
   }
}
