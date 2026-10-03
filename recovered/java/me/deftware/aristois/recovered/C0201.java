package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityCapsule;

public class C0201 extends C0219<EntityCapsule> implements C0200<Entity> {
   public C0201(String var1) {
      super(EntityCapsule.class, var1);
   }

   public boolean m_4fb0d5ef(Entity var1) {
      return this.m_cf9d272b(var1.getEntityTypeName());
   }

   public boolean m_cf9d272b(String var1) {
      for (EntityCapsule var3 : this.f_3ca3db1e) {
         if (var3.getName().string().equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }
}
