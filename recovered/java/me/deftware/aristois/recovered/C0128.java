package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

public class C0128 implements C0131<C0249> {
   public C0128() {
   }

   public void m_927172e0(JsonWriter var1, C0249 var2) throws IOException {
      var1.name(C0252.bootstrap<"get",12884901996>());
      var1.value(var2.m_d7d9ac58());
   }

   public C0249 m_9ee4f0a1(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return new C0249(var1.nextString());
   }

   public List<Class<? extends C0249>> m_e8903c9d() {
      return C0114.bootstrap<"call",0,1>(C0249.class);
   }
}
