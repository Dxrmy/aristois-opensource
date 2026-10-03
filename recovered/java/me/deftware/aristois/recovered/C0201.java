package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityCapsule;

public class C0201 extends C0219<EntityCapsule> implements C0200<Entity> {
   public C0201(String var1) {
      super(EntityCapsule.class, var1);
   }

   public boolean m_97a0a4cb(Entity var1) {
      return this.m_828a75ae(var1.getEntityTypeName());
   }

   public boolean m_828a75ae(String var1) {
      for (EntityCapsule var3 : this.f_2acc0bd9) {
         if (var3.getName().string().equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }
}
