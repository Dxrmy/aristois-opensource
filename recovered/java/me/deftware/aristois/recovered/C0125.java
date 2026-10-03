package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Primitives;

public final class C0125 {
   public static final C0125 f_94eb86f7 = new C0125(m_cde2d310());
   public final Gson f_a49c1fcb;

   public C0125(GsonBuilder var1) {
      this.f_a49c1fcb = var1.create();
   }

   public Object m_b3b664ad(JsonElement var1, Class<?> var2) throws Exception {
      return var1 == null ? var2.getDeclaredConstructor().newInstance() : this.f_a49c1fcb.fromJson(var1, var2);
   }

   public JsonElement m_a7c6d791(Object var1, Class<?> var2) {
      String var3 = this.f_a49c1fcb.toJson(var1, var2);
      if (var3.equalsIgnoreCase(C0266.m_733bff3d())) {
         throw new RuntimeException(C0266.m_76700429() + var1.toString());
      } else {
         return (JsonElement)this.f_a49c1fcb.fromJson(this.f_a49c1fcb.toJson(var1, var2), m_210285cc(var2) ? JsonPrimitive.class : JsonObject.class);
      }
   }

   public static boolean m_210285cc(Class<?> var0) {
      return var0 == String.class ? true : var0.isPrimitive() || Primitives.isWrapperType(var0);
   }

   public static GsonBuilder m_cde2d310() {
      GsonBuilder var0 = C0198.m_cde2d310();
      C0088 var1 = C0088.f_3316b995;

      for (C0131 var3 : var1.m_ed46fa58()) {
         for (Class var5 : var3.m_350b5ae0()) {
            var0.registerTypeAdapter(var5, var3.m_0d09ee39());
         }
      }

      return var0;
   }

   public Gson m_faa7cd25() {
      return this.f_a49c1fcb;
   }
}
