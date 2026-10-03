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
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityType;
import me.deftware.client.framework.util.ResourceUtils;

public final class C0227 {
   public static final C0227 f_51234e0c = new C0227();
   private final HashMap<EntityType, C0225> f_e3481e80 = new HashMap<>();

   private C0227() {
      try {
         this.m_1058ed9a();
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public Optional<C0225> m_4e136603(EntityType var1) {
      return Optional.ofNullable(this.f_e3481e80.getOrDefault(var1, null));
   }

   public Optional<C0225> m_34db4d3b(Entity var1) {
      Optional var2 = this.f_e3481e80.entrySet().stream().filter(var1x -> var1.instanceOf(var1x.getKey())).findFirst();
      return var2.map(Entry::getValue);
   }

   private void m_1058ed9a() throws Exception {
      InputStream var1 = ResourceUtils.getStreamFromModResources(Main.getInstance(), C0261.m_8ccfdf29());
      if (var1 == null) {
         throw new IOException(C0261.m_0223faff());
      } else {
         try (InputStreamReader var2 = new InputStreamReader(var1)) {
            for (JsonElement var6 : (JsonArray)new Gson().fromJson(var2, JsonArray.class)) {
               C0225 var7 = (C0225)C0125.f_94eb86f7.m_b3b664ad(var6, C0225.class);
               EntityType var8 = EntityType.valueOf(var7.m_3d3a8736());
               this.f_e3481e80.put(var8, var7);
            }
         }
      }
   }

   public HashMap<EntityType, C0225> m_0bde49b6() {
      return this.f_e3481e80;
   }
}
