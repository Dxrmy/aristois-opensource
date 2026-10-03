package me.deftware.aristois.recovered;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.message.Message;

public class C0094<T> implements C0092, C0217.anonymousthis, C0105<T> {
   private final List<Consumer<T>> f_b23f6e03 = new ArrayList<>();
   protected final Object f_43392e8c;
   protected T f_b5a9f475;
   protected C0112<T> f_e23b1adc;
   protected final Field f_d56925c7;
   protected C0105<T> f_5297a69e;
   protected Message[] f_6461be97;
   protected C0098 f_7d2ca29b;

   public C0094(Field var1, Object var2, C0112<T> var3) throws IllegalAccessException {
      this.f_d56925c7 = var1;
      this.f_43392e8c = var2;
      this.f_e23b1adc = var3;
      if (var1 != null) {
         this.f_7d2ca29b = C0095.m_0ec79f25(C0098.class, var1);
         if (C0088.m_b74c7673(var1.getType(), C0105.class)) {
            this.f_5297a69e = (C0105<T>)var1.get(var2);
         }

         this.f_6461be97 = Arrays.stream(this.m_347620b9().description()).map(Message::of).toArray(Message[]::new);
      }

      if (!this.m_e606d819()) {
         this.f_b5a9f475 = this.m_50ca8f08();
      }
   }

   public boolean m_89e0519f() {
      return this.f_5297a69e != null;
   }

   @Override
   public boolean m_e0f7c666() {
      return this.m_89e0519f() ? this.f_5297a69e.m_e0f7c666() : true;
   }

   public boolean m_e606d819() {
      return this.f_d56925c7 != null && this.f_e23b1adc.m_986d2323(this.f_d56925c7);
   }

   @Override
   public Message m_6fc98322() {
      if (this.m_e606d819()) {
         return Message.of(C0261.m_813e3509());
      } else {
         this.m_a32b61ee(this.f_b5a9f475);
         String var1 = this.f_b5a9f475.toString();
         if (this.m_c70eae42()) {
            var1 = ((C0102)this.f_b5a9f475).m_d32ebe65();
         }

         if (var1.trim().isEmpty()) {
            var1 = C0253.m_1d87ef21();
         }

         return Message.of(C0261.m_3855be80() + this.m_6f1f396d() + C0266.m_28b2c020() + var1);
      }
   }

   public boolean m_efa7610e() {
      return this.m_347620b9().triggerPostChanged();
   }

   @Override
   public String m_6f1f396d() {
      return this.m_347620b9().value();
   }

   @Override
   public void m_a32b61ee(Object var1) {
      this.m_9660fce8(var1, true);
   }

   public boolean m_9660fce8(Object var1, boolean var2) {
      try {
         this.m_8c0dae8a(var1.getClass());
         this.m_360c09fa(var1);
         if (var2) {
            this.m_0e389a72();
         }

         return true;
      } catch (Exception var4) {
         var4.printStackTrace();
         return false;
      }
   }

   public boolean m_297cfef6() {
      return this.f_7d2ca29b != null ? this.f_7d2ca29b.display() : true;
   }

   protected void m_360c09fa(Object var1) throws Exception {
      if (this.m_89e0519f()) {
         ((C0105)this.f_d56925c7.get(this.f_43392e8c)).m_a32b61ee(var1);
      } else {
         this.f_d56925c7.set(this.f_43392e8c, var1);
      }
   }

   @Override
   public boolean m_9362a920() {
      return this.m_89e0519f() ? this.f_5297a69e.m_9362a920() : true;
   }

   public void m_8c0dae8a(Class<?> var1) throws Exception {
      if (this.f_b5a9f475 != null && !this.f_b5a9f475.getClass().isAssignableFrom(var1)) {
         throw new Exception(C0261.m_a9247108() + this.f_b5a9f475.getClass() + C0261.m_4626ac74() + var1);
      }
   }

   public <E extends Annotation> E m_04b86251(Class<E> var1) {
      return C0095.m_0ec79f25(var1, this.f_d56925c7);
   }

   public void m_0e389a72() {
      this.f_b23f6e03.forEach(var1 -> var1.accept(this.m_50ca8f08()));
      if (this.f_43392e8c instanceof AbstractMod) {
         ((AbstractMod)this.f_43392e8c).onSettingUpdate(this.m_347620b9());
      }
   }

   public Class<? extends BiFunction<String, String, String>> m_4e33612f() {
      return this.m_347620b9().textProcessor();
   }

   public boolean m_1a28c037(String var1) throws Exception {
      if (this.m_c70eae42()) {
         int var3 = ((C0102)this.m_50ca8f08()).m_f16981ce(var1);
         if (var3 == -1) {
            throw new Exception(C0261.m_c688f8ca() + var1);
         } else {
            ((C0102)this.m_50ca8f08()).m_46938bdb(var3);
            this.m_0e389a72();
            return true;
         }
      } else {
         Object var2 = this.f_e23b1adc.m_b612bf41(var1);
         if (var2 == null) {
            throw new Exception(C0261.m_35cdaa1a() + this.m_50ca8f08().getClass().getSimpleName());
         } else {
            return this.m_9660fce8(var2, true);
         }
      }
   }

   @Override
   public T m_50ca8f08() {
      try {
         return (T)(this.f_5297a69e != null ? ((C0105)this.f_d56925c7.get(this.f_43392e8c)).m_50ca8f08() : this.f_d56925c7.get(this.f_43392e8c));
      } catch (Exception var2) {
         throw new RuntimeException(C0261.m_624b40d8(), var2);
      }
   }

   public Class<?> m_01d9ec36() {
      return this.f_5297a69e != null ? this.m_50ca8f08().getClass() : this.f_d56925c7.getType();
   }

   @Override
   public String toString() {
      return this.m_50ca8f08().toString();
   }

   public boolean m_c70eae42() {
      return this.m_01d9ec36() == C0102.class;
   }

   public String m_c254a253() {
      return this.m_6f1f396d().replaceAll(C0261.m_8d7dbe31(), C0264.m_16315846()).toLowerCase();
   }

   public String m_b48a8bc4() {
      return new StringJoiner(C0264.m_03430357())
         .add(C0261.m_1d87ef21() + this.m_01d9ec36().toString())
         .add(C0261.m_c42f1c7e() + this.f_b5a9f475.getClass())
         .add(C0261.m_6f1f396d() + this.m_89e0519f())
         .add(C0261.m_8ced16bd() + this.m_c70eae42())
         .add(C0261.m_15ef1a0d() + this.m_c254a253())
         .add(C0261.m_9793dfe2() + this.f_b5a9f475)
         .add(C0261.m_1635bc47() + this.m_4e33612f())
         .toString();
   }

   public List<Consumer<T>> m_8bd194b1() {
      return this.f_b23f6e03;
   }

   public Object m_d959b7cf() {
      return this.f_43392e8c;
   }

   public T m_af4f9e86() {
      return this.f_b5a9f475;
   }

   public C0112<T> m_a4e51be1() {
      return this.f_e23b1adc;
   }

   public Field m_c7d412eb() {
      return this.f_d56925c7;
   }

   public C0105<T> m_eec36546() {
      return this.f_5297a69e;
   }

   public Message[] m_b3e55a9d() {
      return this.f_6461be97;
   }

   public C0098 m_347620b9() {
      return this.f_7d2ca29b;
   }

   public void m_7114e377(T var1) {
      this.f_b5a9f475 = (T)var1;
   }

   public void m_3857490e(C0112<T> var1) {
      this.f_e23b1adc = var1;
   }

   public void m_64761dca(C0105<T> var1) {
      this.f_5297a69e = var1;
   }

   public void m_eb5ceeb6(Message[] var1) {
      this.f_6461be97 = var1;
   }

   public void m_2009f19a(C0098 var1) {
      this.f_7d2ca29b = var1;
   }
}
