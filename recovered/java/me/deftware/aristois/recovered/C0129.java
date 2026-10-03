package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;
import me.deftware.client.framework.entity.EntityCapsule;
import me.deftware.client.framework.registry.EntityRegistry;

public class C0129 implements C0131<EntityCapsule> {
   public C0129() {
   }

   public void m_fb95ced3(JsonWriter var1, EntityCapsule var2) throws IOException {
      var1.name(C0252.bootstrap<"get",12884901991>());
      var1.value(var2.getIdentifierKey());
   }

   public EntityCapsule m_824a99d1(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return (EntityCapsule)EntityRegistry.INSTANCE.find(var1.nextString()).orElseThrow(() -> new IOException(C0252.bootstrap<"get",12884901997>() + var2));
   }

   public List<Class<? extends EntityCapsule>> m_38a53611() {
      return C0114.bootstrap<"call",0,1>(EntityCapsule.class);
   }
}
