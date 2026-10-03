package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public final class C0125 {
   public static final C0125 f_70947d4f = new C0125(C0114.bootstrap<"call",0,1>());
   public final Gson f_b0ad05cf;

   public C0125(GsonBuilder var1) {
      this.f_b0ad05cf = var1.create();
   }

   public Object m_5f630fc1(JsonElement var1, Class<?> var2) throws Exception {
      return var1 == null ? var2.getDeclaredConstructor().newInstance() : this.f_b0ad05cf.fromJson(var1, var2);
   }

   public JsonElement m_77b61bf9(Object var1, Class<?> var2) {
      String var3 = this.f_b0ad05cf.toJson(var1, var2);
      if (var3.equalsIgnoreCase(C0252.bootstrap<"get",12884902003>())) {
         throw new RuntimeException(C0252.bootstrap<"get",12884902004>() + var1.toString());
      } else {
         return (JsonElement)this.f_b0ad05cf
            .fromJson(this.f_b0ad05cf.toJson(var1, var2), C0114.bootstrap<"call",0,1>(var2) ? JsonPrimitive.class : JsonObject.class);
      }
   }

   public static boolean m_2b7d433a(Class<?> var0) {
      return var0 == String.class ? true : var0.isPrimitive() || C0114.bootstrap<"call",1,1>(var0);
   }

   public static GsonBuilder m_ee89b75c() {
      GsonBuilder var0 = C0114.bootstrap<"call",2,1>();
      C0088 var1 = C0088.f_748211cf;

      for (C0131 var3 : var1.m_87d5ded6()) {
         for (Class var5 : var3.m_7c29270c()) {
            var0.registerTypeAdapter(var5, var3.m_526c0d89());
         }
      }

      return var0;
   }

   public Gson m_7fdab0ba() {
      return this.f_b0ad05cf;
   }
}
