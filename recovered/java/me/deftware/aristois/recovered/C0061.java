package me.deftware.aristois.recovered;

import java.util.function.Predicate;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

@C0420
public class C0061 extends AbstractMod implements C0062 {
   private Predicate<LivingEntity> f_9d8828c9 = var0 -> false;
   @C0098(
      value = "Sleeping",
      description = {"Attack sleeping players"}
   )
   private boolean f_58013ef6 = false;
   @C0098(
      value = "Behind Wall",
      description = {"Attack entities behind walls"}
   )
   private boolean f_7d65e34f = true;
   @C0098(
      value = "Hostile Only",
      description = {"Only attack hostile entities"}
   )
   private boolean f_01b2dfdc = false;
   @C0098(
      value = "Invisible",
      description = {"Attack invisible entities"}
   )
   private boolean f_7ff0d5da = false;
   @C0098(
      value = "Friends",
      description = {"Attack added friends"}
   )
   private boolean f_11e5f428 = false;
   @C0098(
      value = "Fov",
      description = {"The fov to attack entities within"},
      number = @C0096(
         min = 20.0,
         max = 360.0
      )
   )
   private float f_01140f2a = 360.0F;
   @C0098("Attack Mode")
   private C0102<C0062.anonymousthis> f_f1eea95a = new C0102<>(C0062.anonymousthis.f_a322abf0);

   public C0061() {
      super(C0252.bootstrap<"get",4294967350>(), C0290.f_e2483c18, C0252.bootstrap<"get",4294967351>(), C0252.bootstrap<"get",4294967352>());
   }

   public float m_f1b1ea31() {
      return C0114.bootstrap<"call",0,1>(C0310.class)
         ? (Float)GameMap.INSTANCE.get(GameKeys.BLOCK_REACH_DISTANCE, C0114.bootstrap<"call",1,1>(4.5F))
         : C0062.super.m_b0df3e6f();
   }

   public Predicate<LivingEntity> m_136271a4() {
      return var1 -> !this.f_9d8828c9.test(var1);
   }

   public Predicate<LivingEntity> m_4bc53a9e() {
      return this.f_9d8828c9;
   }

   public boolean m_898464a0() {
      return this.f_58013ef6;
   }

   public boolean m_ef900f07() {
      return this.f_7d65e34f;
   }

   public boolean m_5b50483c() {
      return this.f_01b2dfdc;
   }

   public boolean m_42b67dca() {
      return this.f_7ff0d5da;
   }

   public boolean m_dda7a73e() {
      return this.f_11e5f428;
   }

   public float m_7bc5de3e() {
      return this.f_01140f2a;
   }

   public C0102<C0062.anonymousthis> m_b07d0fa3() {
      return this.f_f1eea95a;
   }

   public void m_4e2c6cfd(Predicate<LivingEntity> var1) {
      this.f_9d8828c9 = var1;
   }
}
