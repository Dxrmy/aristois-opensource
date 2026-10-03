package me.deftware.aristois.recovered;

import java.util.List;
import java.util.Optional;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0306 extends C0307<C0306> {
   @C0098(
      value = "AutoWeapon",
      description = {"Automatically chooses the best weapon before attacking"}
   )
   protected boolean f_9ecc9c0d = true;
   @C0098(
      value = "Hit While Eating",
      description = {"Hit entities whilst eating"}
   )
   protected boolean f_eb82a3c8 = true;
   @C0098("Mode")
   private C0102<C0306.anonymousabstract> f_9454cf77 = new C0102<>(C0306.anonymousabstract.f_b8129365);
   @C0098(
      value = "CPS",
      description = {"Clicks per second"},
      number = @C0096(
         max = 15.0
      )
   )
   private C0106<Integer> f_b40a5c9b = new C0106<>(C0114.bootstrap<"call",0,1>(5)).m_10caee7d(this.f_9454cf77, C0306.anonymousabstract.f_3d3d085e);
   @C0098(
      value = "Random",
      description = {"Add random delays to the CPS"}
   )
   private C0106<Boolean> f_d1f2ce58 = new C0106<>(C0114.bootstrap<"call",1,1>(true)).m_10caee7d(this.f_9454cf77, C0306.anonymousabstract.f_3d3d085e);
   private long f_0cb8c369 = (long)(1000 / this.f_b40a5c9b.m_95af3326());

   public C0306(String var1, C0290 var2, String... var3) {
      super(var1, var2, var3);
      this.setMode(this.f_9454cf77);
   }

   public C0306() {
      this(C0252.bootstrap<"get",38654705760>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705761>());
   }

   @EventHandler
   public void m_5bd07927(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      C0408 var3 = (C0408)C0114.bootstrap<"call",2,1>(C0408.class);
      boolean var4 = var2.getCooldown() >= this.f_181405c9;
      if (this.f_9454cf77.m_e2691446() == C0306.anonymousabstract.f_3d3d085e) {
         long var5 = this.f_0cb8c369;
         if (this.f_d1f2ce58.get()) {
            this.f_0cb8c369 = this.f_0cb8c369 + C0114.bootstrap<"call",3,1>(0L, 300L);
         }

         if (this.f_a675e1c6 + var5 < C0114.bootstrap<"call",4,1>()) {
            var4 = true;
         }
      }

      if (var4 && (this.f_eb82a3c8 || !var3.m_a0240561())) {
         List var8 = this.m_3bf3ab6a(var2);
         if (!var8.isEmpty()) {
            this.m_bc9c681d();
            if (this.f_9ecc9c0d && !var3.m_a0240561() && ((C0417)C0114.bootstrap<"call",2,1>(C0417.class)).m_2d7ed8a8()) {
               return;
            }

            for (Entity var7 : var8) {
               this.m_822424f2(var2, var7);
            }
         }
      }
   }

   protected List<Entity> m_3bf3ab6a(MainEntityPlayer var1) {
      Optional var2 = this.f_dba292fc.m_ebb8b79c(var1);
      return var2.isPresent() ? C0114.bootstrap<"call",5,1>(var2.get()) : C0114.bootstrap<"call",6,1>();
   }

   @Override
   public void onPostLoad() {
      this.onSettingUpdate(null);
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      this.f_0cb8c369 = (long)(1000 / this.f_b40a5c9b.get());
   }

   public static enum anonymousabstract implements C0102.anonymousthis {
      f_3d3d085e(C0252.bootstrap<"get",38654705757>()),
      f_b8129365(C0252.bootstrap<"get",38654705759>());

      private final String[] f_9ab6a29f;

      private anonymousabstract(String... var3) {
         this.f_9ab6a29f = var3;
      }

      public String[] m_d2391beb() {
         return this.f_9ab6a29f;
      }
   }
}
