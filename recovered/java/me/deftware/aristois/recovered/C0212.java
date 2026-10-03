package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.util.minecraft.EntitySwingResult;
import me.deftware.client.framework.world.ray.EntityRayTrace;
import me.deftware.client.framework.world.ray.RayProfile;

public class C0212 {
   public C0212() {
   }

   public static Entity m_a89ff977(Vector3d var0, Vector3d var1, Vector3d var2, Entity var3, float var4) {
      EntitySwingResult var5 = new EntityRayTrace(var0, var1, var2, (double)var4, RayProfile.Block).run(var3);
      return var5 != null ? var5.getEntity() : null;
   }
}
