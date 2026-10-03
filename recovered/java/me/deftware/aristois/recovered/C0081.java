package me.deftware.aristois.recovered;

import java.util.Objects;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;

@C0422
@C0099
public class C0081 extends C0086 {
   @C0098(
      value = "Degrees",
      description = {"Show degrees in the direction"},
      id = 40
   )
   private boolean f_be49500d = false;
   @C0098("Nether Coords")
   private boolean f_bd2185ff = false;
   private final C0086.anonymousdefault f_b655bfe0 = new C0086.anonymousdefault();
   private Vector3d f_7bd01342 = Vector3d.ZERO;
   private double f_04bde5e1 = 0.0;

   public C0081() {
      super(C0265.m_3855be80(), C0087.f_a96599e0, C0265.m_a9247108());
      this.f_676ae6d0 = false;
   }

   @Override
   public void onPostLoad() {
      if (this.f_be49500d) {
         this.f_b655bfe0.m_42140133(C0267.m_5b2d5cb2(), C0267.m_5b2d5cb2()).m_b4a5d70c(C0081.anonymouscatch::m_8d7dbe31, C0081.anonymouscatch::m_3d3a8736);
      } else {
         this.f_b655bfe0.m_42140133(C0265.m_4626ac74(), C0267.m_5b2d5cb2()).m_b4a5d70c(C0081.anonymouscatch::m_8d7dbe31);
      }
   }

   @Override
   protected Stream<C0086.anonymousdefault> m_cb07f77b() {
      return Stream.of(
         new C0086.anonymousdefault().m_42140133(C0265.m_c688f8ca(), C0267.m_5b2d5cb2()).m_b4a5d70c(this::m_3d3a8736),
         this.f_b655bfe0,
         new C0086.anonymousdefault().m_42140133(C0265.m_35cdaa1a(), C0265.m_624b40d8()).m_b4a5d70c(this::m_68ec50d9)
      );
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() == 40) {
         this.onPostLoad();
      } else {
         super.onSettingUpdate(var1);
      }
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      this.f_04bde5e1 = new Vector3d(var2.getPosX(), var2.getPosY(), var2.getPosZ()).subtract(this.f_7bd01342).getMagnitude() * 20.0;
      this.f_7bd01342 = new Vector3d(var2.getPosX(), var2.getPosY(), var2.getPosZ());
   }

   public String m_3d3a8736() {
      Entity var1 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getCameraEntity());
      String var2 = String.format(
         C0265.m_8d7dbe31(),
         ClientWorld.getClientWorld()._getDimension() == -1 ? var1.getPosX() * 8.0 : var1.getPosX() / 8.0,
         ClientWorld.getClientWorld()._getDimension() == -1 ? var1.getPosZ() * 8.0 : var1.getPosZ() / 8.0
      );
      String var3 = String.format(C0265.m_1d87ef21(), var1.getPosX(), var1.getPosY(), var1.getPosZ());
      return var3 + (this.f_bd2185ff ? var2 : "");
   }

   public static double m_d945de47(double var0) {
      var0 %= 360.0;
      if (var0 >= 180.0) {
         var0 -= 360.0;
      }

      if (var0 < -180.0) {
         var0 += 360.0;
      }

      return var0;
   }

   public double m_68ec50d9() {
      return this.f_04bde5e1;
   }

   public static class anonymouscatch {
      public anonymouscatch() {
      }

      public static String m_8d7dbe31() {
         return C0215.m_a3f5650c(Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer())).m_8ced16bd();
      }

      public static String m_3d3a8736() {
         MainEntityPlayer var0 = Minecraft.getMinecraftGame()._getPlayer();
         return String.format(C0265.m_813e3509(), C0081.m_d945de47((double)var0.getRotationYaw()), var0.getRotationPitch());
      }
   }
}
