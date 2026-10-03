package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class C0128 implements C0131<C0249> {
   public C0128() {
   }

   public void m_dd00f4bc(JsonWriter var1, C0249 var2) throws IOException {
      var1.name(C0266.m_e9a52709());
      var1.value(var2.m_8d7dbe31());
   }

   public C0249 m_607daaf8(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return new C0249(var1.nextString());
   }

   @Override
   public List<Class<? extends C0249>> m_350b5ae0() {
      return Collections.singletonList(C0249.class);
   }
}
