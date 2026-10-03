package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Optional;
import java.util.Map.Entry;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityType;

public final class C0227 {
   public static final C0227 f_8791eb78 = new C0227();
   private final HashMap<EntityType, C0225> f_9222b089 = new HashMap<>();

   private C0227() {
      try {
         this.m_a44f76c9();
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public Optional<C0225> m_0ed6b7e7(EntityType var1) {
      return C0114.bootstrap<"call",0,1>(this.f_9222b089.getOrDefault(var1, null));
   }

   public Optional<C0225> m_6e45aa74(Entity var1) {
      Optional var2 = this.f_9222b089.entrySet().stream().filter(var1x -> var1.instanceOf(var1x.getKey())).findFirst();
      return var2.map(Entry::getValue);
   }

   private void m_a44f76c9() throws Exception {
      InputStream var1 = C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(), C0252.bootstrap<"get",17179869284>());
      if (var1 == null) {
         throw new IOException(C0252.bootstrap<"get",17179869285>());
      } else {
         try (InputStreamReader var2 = new InputStreamReader(var1)) {
            for (JsonElement var6 : (JsonArray)new Gson().fromJson(var2, JsonArray.class)) {
               C0225 var7 = (C0225)C0125.f_70947d4f.m_5f630fc1(var6, C0225.class);
               EntityType var8 = C0114.bootstrap<"call",3,1>(var7.m_9b1475ad());
               this.f_9222b089.put(var8, var7);
            }
         }
      }
   }

   public HashMap<EntityType, C0225> m_68460d97() {
      return this.f_9222b089;
   }
}
