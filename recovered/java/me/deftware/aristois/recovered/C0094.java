package me.deftware.aristois.recovered;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.message.Message;

public class C0094<T> implements C0092, C0217.anonymousthis, C0105<T> {
   private final List<Consumer<T>> f_000243ee = new ArrayList<>();
   protected final Object f_4d8294b9;
   protected T f_a8fa8611;
   protected C0112<T> f_6db95558;
   protected final Field f_ad82d5cd;
   protected C0105<T> f_aea412d5;
   protected Message[] f_e78b8be9;
   protected C0098 f_3f0cb667;

   public C0094(Field var1, Object var2, C0112<T> var3) throws IllegalAccessException {
      this.f_ad82d5cd = var1;
      this.f_4d8294b9 = var2;
      this.f_6db95558 = var3;
      if (var1 != null) {
         this.f_3f0cb667 = (C0098)C0114.bootstrap<"call",0,1>(C0098.class, var1);
         if (C0114.bootstrap<"call",1,1>(var1.getType(), C0105.class)) {
            this.f_aea412d5 = (C0105<T>)var1.get(var2);
         }

         this.f_e78b8be9 = C0114.bootstrap<"call",2,1>(this.m_371c3bfa().description()).map(Message::of).toArray(Message[]::new);
      }

      if (!this.m_d1f323bd()) {
         this.f_a8fa8611 = this.m_48b16e97();
      }
   }

   public boolean m_85532ff5() {
      return this.f_aea412d5 != null;
   }

   public boolean m_4cebb9f7() {
      return this.m_85532ff5() ? this.f_aea412d5.m_e34f112f() : true;
   }

   public boolean m_d1f323bd() {
      return this.f_ad82d5cd != null && this.f_6db95558.m_6f890b01(this.f_ad82d5cd);
   }

   public Message m_4e85e8f7() {
      if (this.m_d1f323bd()) {
         return C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869185>());
      } else {
         this.m_a8634ed3(this.f_a8fa8611);
         String var1 = this.f_a8fa8611.toString();
         if (this.m_30ee2f8a()) {
            var1 = ((C0102)this.f_a8fa8611).m_27694bb2();
         }

         if (var1.trim().isEmpty()) {
            var1 = C0252.bootstrap<"get",8589934601>();
         }

         return C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869186>() + this.m_b5ae4ee3() + C0252.bootstrap<"get",12884901918>() + var1);
      }
   }

   public boolean m_d24c1726() {
      return this.m_371c3bfa().triggerPostChanged();
   }

   public String m_b5ae4ee3() {
      return this.m_371c3bfa().value();
   }

   public void m_a8634ed3(Object var1) {
      this.m_dfb23874(var1, true);
   }

   public boolean m_dfb23874(Object var1, boolean var2) {
      try {
         this.m_58254efd(var1.getClass());
         this.m_ceb6473c(var1);
         if (var2) {
            this.m_50c1fe8b();
         }

         return true;
      } catch (Exception var4) {
         var4.printStackTrace();
         return false;
      }
   }

   public boolean m_fe66bb90() {
      return this.f_3f0cb667 != null ? this.f_3f0cb667.display() : true;
   }

   protected void m_ceb6473c(Object var1) throws Exception {
      if (this.m_85532ff5()) {
         ((C0105)this.f_ad82d5cd.get(this.f_4d8294b9)).m_bc5354a6(var1);
      } else {
         this.f_ad82d5cd.set(this.f_4d8294b9, var1);
      }
   }

   public boolean m_05b0bd0d() {
      return this.m_85532ff5() ? this.f_aea412d5.m_445afd0f() : true;
   }

   public void m_58254efd(Class<?> var1) throws Exception {
      if (this.f_a8fa8611 != null && !this.f_a8fa8611.getClass().isAssignableFrom(var1)) {
         throw new Exception(C0252.bootstrap<"get",17179869187>() + this.f_a8fa8611.getClass() + C0252.bootstrap<"get",17179869188>() + var1);
      }
   }

   public <E extends Annotation> E m_d69df528(Class<E> var1) {
      return (E)C0114.bootstrap<"call",0,1>(var1, this.f_ad82d5cd);
   }

   public void m_50c1fe8b() {
      this.f_000243ee.forEach(var1 -> var1.accept(this.m_48b16e97()));
      if (this.f_4d8294b9 instanceof AbstractMod) {
         ((AbstractMod)this.f_4d8294b9).onSettingUpdate(this.m_371c3bfa());
      }
   }

   public Class<? extends BiFunction<String, String, String>> m_604f0940() {
      return this.m_371c3bfa().textProcessor();
   }

   public boolean m_027da45d(String var1) throws Exception {
      if (this.m_30ee2f8a()) {
         int var3 = ((C0102)this.m_48b16e97()).m_8c9089bc(var1);
         if (var3 == -1) {
            throw new Exception(C0252.bootstrap<"get",17179869189>() + var1);
         } else {
            ((C0102)this.m_48b16e97()).m_d2d71c50(var3);
            this.m_50c1fe8b();
            return true;
         }
      } else {
         Object var2 = this.f_6db95558.m_e0edf214(var1);
         if (var2 == null) {
            throw new Exception(C0252.bootstrap<"get",17179869190>() + this.m_48b16e97().getClass().getSimpleName());
         } else {
            return this.m_dfb23874(var2, true);
         }
      }
   }

   public T m_48b16e97() {
      try {
         return (T)(this.f_aea412d5 != null ? ((C0105)this.f_ad82d5cd.get(this.f_4d8294b9)).m_d4606028() : this.f_ad82d5cd.get(this.f_4d8294b9));
      } catch (Exception var2) {
         throw new RuntimeException(C0252.bootstrap<"get",17179869191>(), var2);
      }
   }

   public Class<?> m_3ed0dd7b() {
      return this.f_aea412d5 != null ? this.m_48b16e97().getClass() : this.f_ad82d5cd.getType();
   }

   @Override
   public String toString() {
      return this.m_48b16e97().toString();
   }

   public boolean m_30ee2f8a() {
      return this.m_3ed0dd7b() == C0102.class;
   }

   public String m_087ac7a8() {
      return this.m_b5ae4ee3().replaceAll(C0252.bootstrap<"get",17179869192>(), C0252.bootstrap<"get",4294967381>()).toLowerCase();
   }

   public String m_6ed5c5e9() {
      return new StringJoiner(C0252.bootstrap<"get",4294967393>())
         .add(C0252.bootstrap<"get",17179869193>() + this.m_3ed0dd7b().toString())
         .add(C0252.bootstrap<"get",17179869194>() + this.f_a8fa8611.getClass())
         .add(C0252.bootstrap<"get",17179869195>() + this.m_85532ff5())
         .add(C0252.bootstrap<"get",17179869196>() + this.m_30ee2f8a())
         .add(C0252.bootstrap<"get",17179869197>() + this.m_087ac7a8())
         .add(C0252.bootstrap<"get",17179869198>() + this.f_a8fa8611)
         .add(C0252.bootstrap<"get",17179869199>() + this.m_604f0940())
         .toString();
   }

   public List<Consumer<T>> m_08b68c9c() {
      return this.f_000243ee;
   }

   public Object m_ab7c4ba2() {
      return this.f_4d8294b9;
   }

   public T m_344adc77() {
      return this.f_a8fa8611;
   }

   public C0112<T> m_fb21cd76() {
      return this.f_6db95558;
   }

   public Field m_e4eb6c5d() {
      return this.f_ad82d5cd;
   }

   public C0105<T> m_578fc03f() {
      return this.f_aea412d5;
   }

   public Message[] m_50eeaf3d() {
      return this.f_e78b8be9;
   }

   public C0098 m_371c3bfa() {
      return this.f_3f0cb667;
   }

   public void m_a10f27b4(T var1) {
      this.f_a8fa8611 = (T)var1;
   }

   public void m_76bf74a3(C0112<T> var1) {
      this.f_6db95558 = var1;
   }

   public void m_55378405(C0105<T> var1) {
      this.f_aea412d5 = var1;
   }

   public void m_e78ae8de(Message[] var1) {
      this.f_e78b8be9 = var1;
   }

   public void m_6cd0a48c(C0098 var1) {
      this.f_3f0cb667 = var1;
   }
}
