package me.deftware.aristois.recovered;

import java.util.Objects;
import java.util.function.Predicate;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRayTrace;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0308 extends C0307<C0308> {
   public C0308() {
      super(C0263.m_ec329d2e(), C0290.f_4b7b2d37, C0263.m_edf5fb69());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.getCooldown() >= this.f_bc2c3069 && Minecraft.getMinecraftGame().isMouseOver()) {
         Entity var3 = Minecraft.getMinecraftGame().getHitEntity();
         Predicate var4 = this.f_9ac547b8.m_c8fd13b8();
         if (var3 instanceof LivingEntity) {
            LivingEntity var5 = (LivingEntity)var3;
            if (var4.test(var5) && this.f_9ac547b8.m_f4c8f1db(var2, var5)) {
               this.f_3f4fa077 = System.currentTimeMillis();
               var2.attackEntity(var3);
            }
         }
      }
   }

   @EventHandler
   public void m_db5c41bd(EventRayTrace var1) {
      if (var1.getEntity().canBeSeenBy(Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()))) {
         var1.setCanceled(true);
      }
   }
}
