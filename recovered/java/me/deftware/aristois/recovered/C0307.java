package me.deftware.aristois.recovered;

import java.util.List;
import java.util.function.Predicate;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.aristois.services.IStateController;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.gui.GuiScreen;

public class C0307<T extends AbstractMod> extends AbstractMod {
   protected long f_c369a341 = C0114.bootstrap<"call",0,1>();
   private final C0201 f_cc994701;
   @C0098(
      value = "Cooldown",
      description = {"Cooldown threshold before attacking again"},
      number = @C0096(
         min = 0.6,
         max = 1.0
      )
   )
   protected float f_da2056d1 = 0.9F;
   @C0098("Attack Mode")
   public C0102<C0121> f_4cea9760 = new C0102<>(C0121.f_46c8b4fe);
   @C0098("Priority")
   public C0102<C0063> f_08980ed0 = new C0102<>(C0063.f_73d66f71);
   @C0098(
      value = "Entities",
      description = {"Selected entities for the attack mode"}
   )
   public final GuiScreen f_c6eb79d3;
   protected final C0062 f_f023a337;

   public C0307(String var1, C0290 var2, String... var3) {
      super(var1, var2, var3);
      this.f_cc994701 = new C0201(this.getModID() + C0252.bootstrap<"get",38654705753>());
      this.f_c6eb79d3 = C0114.bootstrap<"call",1,1>(null, this.f_cc994701);
      this.f_f023a337 = this.m_c4696a38();
   }

   protected C0062 m_c4696a38() {
      return new C0059() {
         public C0102<C0063> m_3e496b19() {
            return C0307.this.f_08980ed0;
         }

         public Predicate<LivingEntity> m_d445ea61() {
            return C0307.this.m_6bd0987e(super.m_4dabd50c());
         }
      };
   }

   protected Predicate<LivingEntity> m_6bd0987e(Predicate<LivingEntity> var1) {
      return var2 -> !var1.test(var2) ? false : this.f_4cea9760.m_e2691446().m_4644494d(var2, this.f_cc994701::m_4fb0d5ef);
   }

   protected void m_e7f92e44() {
      List var1 = C0114.bootstrap<"call",0,1>(
         new String[]{C0252.bootstrap<"get",38654705754>(), C0252.bootstrap<"get",38654705755>(), C0252.bootstrap<"get",4294967365>()}
      );
      this.getFields().removeIf(var1x -> var1.contains(var1x.m_b5ae4ee3()));
   }

   @Override
   public void onEnable() {
      C0289.f_c22b8d7e.m_6c8ca60d(this);
   }

   protected void m_6a9d16ea() {
      IStateController var1 = C0114.bootstrap<"call",0,1>();
      if (var1 != null && var1.isControlling()) {
         var1.interrupt();
      }
   }

   protected void m_06c94b87(MainEntityPlayer var1, Entity var2) {
      this.f_c369a341 = C0114.bootstrap<"call",0,1>();
      C0114.bootstrap<"call",1,1>(var1, var2, () -> var1.attackEntity(var2));
   }

   public boolean m_d28c3a6b() {
      return this.f_c369a341 + 500L < C0114.bootstrap<"call",0,1>();
   }

   public long m_a5cab9c7() {
      return this.f_c369a341;
   }

   public C0201 m_f113dbc9() {
      return this.f_cc994701;
   }

   public C0062 m_13ffd4aa() {
      return this.f_f023a337;
   }
}
