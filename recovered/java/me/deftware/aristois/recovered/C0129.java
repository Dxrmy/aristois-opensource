package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import me.deftware.client.framework.entity.EntityCapsule;
import me.deftware.client.framework.registry.EntityRegistry;

public class C0129 implements C0131<EntityCapsule> {
   public C0129() {
   }

   public void m_f16adb01(JsonWriter var1, EntityCapsule var2) throws IOException {
      var1.name(C0266.m_c04d8f6e());
      var1.value(var2.getIdentifierKey());
   }

   public EntityCapsule m_93e7a759(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return (EntityCapsule)EntityRegistry.INSTANCE.find(var1.nextString()).orElseThrow(() -> new IOException(C0266.m_37c08c9d() + var2));
   }

   @Override
   public List<Class<? extends EntityCapsule>> m_350b5ae0() {
      return Collections.singletonList(EntityCapsule.class);
   }
}
