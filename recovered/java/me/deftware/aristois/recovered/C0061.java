package me.deftware.aristois.recovered;

import java.util.function.Predicate;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

@C0420
public class C0061 extends AbstractMod implements C0062 {
   private Predicate<LivingEntity> f_a6c12320 = var0 -> false;
   @C0098(
      value = "Sleeping",
      description = {"Attack sleeping players"}
   )
   private boolean f_3dfb2811 = false;
   @C0098(
      value = "Behind Wall",
      description = {"Attack entities behind walls"}
   )
   private boolean f_43662336 = true;
   @C0098(
      value = "Hostile Only",
      description = {"Only attack hostile entities"}
   )
   private boolean f_9d285978 = false;
   @C0098(
      value = "Invisible",
      description = {"Attack invisible entities"}
   )
   private boolean f_713c0228 = false;
   @C0098(
      value = "Friends",
      description = {"Attack added friends"}
   )
   private boolean f_3d3bcc6e = false;
   @C0098(
      value = "Fov",
      description = {"The fov to attack entities within"},
      number = @C0096(
         min = 20.0,
         max = 360.0
      )
   )
   private float f_3eeb2245 = 360.0F;
   @C0098("Attack Mode")
   private C0102<C0062.anonymousthis> f_ee8a241f = new C0102<>(C0062.anonymousthis.f_aaf1bb04);

   public C0061() {
      super(C0264.m_27479cfa(), C0290.f_4b7b2d37, C0264.m_23f794da(), C0264.m_cc27b633());
   }

   @Override
   public float m_796256b9() {
      return C0289.m_5caae0c3(C0310.class) ? (Float)GameMap.INSTANCE.get(GameKeys.BLOCK_REACH_DISTANCE, 4.5F) : C0062.super.m_796256b9();
   }

   @Override
   public Predicate<LivingEntity> m_c8fd13b8() {
      return var1 -> !this.f_a6c12320.test(var1);
   }

   public Predicate<LivingEntity> m_cba00437() {
      return this.f_a6c12320;
   }

   @Override
   public boolean m_51ce03a5() {
      return this.f_3dfb2811;
   }

   @Override
   public boolean m_e606d819() {
      return this.f_43662336;
   }

   @Override
   public boolean m_e0f7c666() {
      return this.f_9d285978;
   }

   @Override
   public boolean m_297cfef6() {
      return this.f_713c0228;
   }

   @Override
   public boolean m_275ab222() {
      return this.f_3d3bcc6e;
   }

   @Override
   public float m_b9b6635c() {
      return this.f_3eeb2245;
   }

   @Override
   public C0102<C0062.anonymousthis> m_430587bc() {
      return this.f_ee8a241f;
   }

   public void m_da1753cf(Predicate<LivingEntity> var1) {
      this.f_a6c12320 = var1;
   }
}
