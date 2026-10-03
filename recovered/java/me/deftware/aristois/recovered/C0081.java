package me.deftware.aristois.recovered;

import java.util.stream.Stream;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;

@C0422
@C0099
public class C0081 extends C0086 {
   @C0098(
      value = "Degrees",
      description = {"Show degrees in the direction"},
      id = 40
   )
   private boolean f_c57e6491 = false;
   @C0098("Nether Coords")
   private boolean f_abfd3cd2 = false;
   private final C0086.anonymousdefault f_b2409763 = new C0086.anonymousdefault();
   private Vector3d f_f67ebd5e = Vector3d.ZERO;
   private double f_5dc78e09 = 0.0;

   public C0081() {
      super(C0252.bootstrap<"get",30064771074>(), C0087.f_a33cc72e, C0252.bootstrap<"get",30064771075>());
      this.f_ef980046 = false;
   }

   @Override
   public void onPostLoad() {
      if (this.f_c57e6491) {
         this.f_b2409763
            .m_25e003cb(C0252.bootstrap<"get",25769803897>(), C0252.bootstrap<"get",25769803897>())
            .m_a514188a(C0081.anonymouscatch::m_2f3adde5, C0081.anonymouscatch::m_71f641e7);
      } else {
         this.f_b2409763.m_25e003cb(C0252.bootstrap<"get",30064771076>(), C0252.bootstrap<"get",25769803897>()).m_a514188a(C0081.anonymouscatch::m_2f3adde5);
      }
   }

   protected Stream<C0086.anonymousdefault> m_554f36fc() {
      return C0114.bootstrap<"call",0,1>(
         new C0086.anonymousdefault[]{
            new C0086.anonymousdefault().m_25e003cb(C0252.bootstrap<"get",30064771077>(), C0252.bootstrap<"get",25769803897>()).m_a514188a(this::m_ffa29346),
            this.f_b2409763,
            new C0086.anonymousdefault().m_25e003cb(C0252.bootstrap<"get",30064771078>(), C0252.bootstrap<"get",30064771079>()).m_a514188a(this::m_b9afa5e8)
         }
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
   public void m_bf4be8e0(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      this.f_5dc78e09 = new Vector3d(var2.getPosX(), var2.getPosY(), var2.getPosZ()).subtract(this.f_f67ebd5e).getMagnitude() * 20.0;
      this.f_f67ebd5e = new Vector3d(var2.getPosX(), var2.getPosY(), var2.getPosZ());
   }

   public String m_ffa29346() {
      Entity var1 = (Entity)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getCameraEntity());
      String var2 = C0114.bootstrap<"call",4,1>(
         C0252.bootstrap<"get",30064771080>(),
         new Object[]{
            C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>()._getDimension() == -1 ? var1.getPosX() * 8.0 : var1.getPosX() / 8.0),
            C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>()._getDimension() == -1 ? var1.getPosZ() * 8.0 : var1.getPosZ() / 8.0)
         }
      );
      String var3 = C0114.bootstrap<"call",4,1>(
         C0252.bootstrap<"get",30064771081>(),
         new Object[]{C0114.bootstrap<"call",3,1>(var1.getPosX()), C0114.bootstrap<"call",3,1>(var1.getPosY()), C0114.bootstrap<"call",3,1>(var1.getPosZ())}
      );
      return var3 + (this.f_abfd3cd2 ? var2 : "");
   }

   public static double m_9c0d6024(double var0) {
      var0 %= 360.0;
      if (var0 >= 180.0) {
         var0 -= 360.0;
      }

      if (var0 < -180.0) {
         var0 += 360.0;
      }

      return var0;
   }

   public double m_b9afa5e8() {
      return this.f_5dc78e09;
   }

   public static class anonymouscatch {
      public anonymouscatch() {
      }

      public static String m_2f3adde5() {
         return C0114.bootstrap<"call",2,1>((EntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).m_b1cbbc00();
      }

      public static String m_71f641e7() {
         MainEntityPlayer var0 = C0114.bootstrap<"call",0,1>()._getPlayer();
         return C0114.bootstrap<"call",4,1>(
            C0252.bootstrap<"get",30064771073>(),
            new Object[]{
               C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>((double)var0.getRotationYaw())), C0114.bootstrap<"call",3,1>(var0.getRotationPitch())
            }
         );
      }
   }
}
