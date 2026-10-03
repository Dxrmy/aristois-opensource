package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.aristois.services.IStateController;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.gui.GuiScreen;

public class C0307<T extends AbstractMod> extends AbstractMod {
   protected long f_3f4fa077 = System.currentTimeMillis();
   private final C0201 f_6be43f0a;
   @C0098(
      value = "Cooldown",
      description = {"Cooldown threshold before attacking again"},
      number = @C0096(
         min = 0.6,
         max = 1.0
      )
   )
   protected float f_bc2c3069 = 0.9F;
   @C0098("Attack Mode")
   public C0102<C0121> f_a495fe5a = new C0102<>(C0121.f_56c93dc6);
   @C0098("Priority")
   public C0102<C0063> f_a15fb4a4 = new C0102<>(C0063.f_0c3cee95);
   @C0098(
      value = "Entities",
      description = {"Selected entities for the attack mode"}
   )
   public final GuiScreen f_519d7e39;
   protected final C0062 f_9ac547b8;

   public C0307(String var1, C0290 var2, String... var3) {
      super(var1, var2, var3);
      this.f_6be43f0a = new C0201(this.getModID() + C0263.m_1b17f04f());
      this.f_519d7e39 = C0217.m_c1fb6c03(null, this.f_6be43f0a);
      this.f_9ac547b8 = this.m_87bbe7cf();
   }

   protected C0062 m_87bbe7cf() {
      return new C0059() {
         @Override
         public C0102<C0063> m_0098dd70() {
            return C0307.this.f_a15fb4a4;
         }

         @Override
         public Predicate<LivingEntity> m_c8fd13b8() {
            return C0307.this.m_c93f572c(super.m_c8fd13b8());
         }
      };
   }

   protected Predicate<LivingEntity> m_c93f572c(Predicate<LivingEntity> var1) {
      return var2 -> !var1.test(var2) ? false : this.f_a495fe5a.m_284992ec().m_26101566(var2, this.f_6be43f0a::m_97a0a4cb);
   }

   protected void m_0e389a72() {
      List var1 = Arrays.asList(C0263.m_bcef2112(), C0263.m_114677c2(), C0264.m_b0896de7());
      this.getFields().removeIf(var1x -> var1.contains(var1x.m_6f1f396d()));
   }

   @Override
   public void onEnable() {
      C0289.f_85a7343f.m_7a6da287(this);
   }

   protected void m_58b14343() {
      IStateController var1 = IStateController.getInstance();
      if (var1 != null && var1.isControlling()) {
         var1.interrupt();
      }
   }

   protected void m_06f12a65(MainEntityPlayer var1, Entity var2) {
      this.f_3f4fa077 = System.currentTimeMillis();
      C0218.m_1878c38f(var1, var2, () -> var1.attackEntity(var2));
   }

   public boolean m_6c9f39f9() {
      return this.f_3f4fa077 + 500L < System.currentTimeMillis();
   }

   public long m_685c7a4a() {
      return this.f_3f4fa077;
   }

   public C0201 m_b77b00c6() {
      return this.f_6be43f0a;
   }

   public C0062 m_2c2bde24() {
      return this.f_9ac547b8;
   }
}
