package me.deftware.aristois.recovered;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0306 extends C0307<C0306> {
   @C0098(
      value = "AutoWeapon",
      description = {"Automatically chooses the best weapon before attacking"}
   )
   protected boolean f_1a302c81 = true;
   @C0098(
      value = "Hit While Eating",
      description = {"Hit entities whilst eating"}
   )
   protected boolean f_e878f8c8 = true;
   @C0098("Mode")
   private C0102<C0306.anonymousabstract> f_d7bceaf0 = new C0102<>(C0306.anonymousabstract.f_037f1d2f);
   @C0098(
      value = "CPS",
      description = {"Clicks per second"},
      number = @C0096(
         max = 15.0
      )
   )
   private C0106<Integer> f_938931d7 = new C0106<>(5).m_2d6ca2bd(this.f_d7bceaf0, C0306.anonymousabstract.f_13306efa);
   @C0098(
      value = "Random",
      description = {"Add random delays to the CPS"}
   )
   private C0106<Boolean> f_3ab742ee = new C0106<>(true).m_2d6ca2bd(this.f_d7bceaf0, C0306.anonymousabstract.f_13306efa);
   private long f_801cc878 = (long)(1000 / this.f_938931d7.m_50ca8f08());

   public C0306(String var1, C0290 var2, String... var3) {
      super(var1, var2, var3);
      this.setMode(this.f_d7bceaf0);
   }

   public C0306() {
      this(C0263.m_a19a564f(), C0290.f_4b7b2d37, C0263.m_03430357());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      C0408 var3 = C0289.m_c3a8b502(C0408.class);
      boolean var4 = var2.getCooldown() >= this.f_bc2c3069;
      if (this.f_d7bceaf0.m_284992ec() == C0306.anonymousabstract.f_13306efa) {
         long var5 = this.f_801cc878;
         if (this.f_3ab742ee.get()) {
            this.f_801cc878 = this.f_801cc878 + C0217.m_46bbaa2a(0L, 300L);
         }

         if (this.f_3f4fa077 + var5 < System.currentTimeMillis()) {
            var4 = true;
         }
      }

      if (var4 && (this.f_e878f8c8 || !var3.m_275ab222())) {
         List var8 = this.m_475037d3(var2);
         if (!var8.isEmpty()) {
            this.m_58b14343();
            if (this.f_1a302c81 && !var3.m_275ab222() && C0289.m_c3a8b502(C0417.class).m_275ab222()) {
               return;
            }

            for (Entity var7 : var8) {
               this.m_06f12a65(var2, var7);
            }
         }
      }
   }

   protected List<Entity> m_475037d3(MainEntityPlayer var1) {
      Optional var2 = this.f_9ac547b8.m_c8468b40(var1);
      return var2.isPresent() ? Collections.singletonList((Entity)var2.get()) : Collections.emptyList();
   }

   @Override
   public void onPostLoad() {
      this.onSettingUpdate(null);
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      this.f_801cc878 = (long)(1000 / this.f_938931d7.get());
   }

   public static enum anonymousabstract implements C0102.anonymousthis {
      f_13306efa(C0263.m_9bf0a29a()),
      f_037f1d2f(C0263.m_65c7e6e6());

      private final String[] f_380018b6;

      private anonymousabstract(String... var3) {
         this.f_380018b6 = var3;
      }

      @Override
      public String[] m_8e56a473() {
         return this.f_380018b6;
      }
   }
}
