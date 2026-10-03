package me.deftware.aristois.recovered;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.LivingEntity;

public enum C0063 implements C0102.anonymousthis {
   f_b5ff831f((var0, var1) -> C0114.bootstrap<"call",0,1>(var0.getHealth(), var1.getHealth()), true, C0252.bootstrap<"get",4294967354>()),
   f_73d66f71((var0, var1) -> C0114.bootstrap<"call",0,1>(var0.getHealth(), var1.getHealth()), false, C0252.bootstrap<"get",4294967356>()),
   f_0922f8dd(
      (var0, var1) -> C0114.bootstrap<"call",1,1>(
            C0114.bootstrap<"call",0,1>()._getPlayer().distanceToEntity(var0), C0114.bootstrap<"call",0,1>()._getPlayer().distanceToEntity(var1)
         ),
      false,
      C0252.bootstrap<"get",4294967358>()
   ),
   f_6453fd30(
      (var0, var1) -> C0114.bootstrap<"call",1,1>(
            C0114.bootstrap<"call",0,1>()._getPlayer().distanceToEntity(var0), C0114.bootstrap<"call",0,1>()._getPlayer().distanceToEntity(var1)
         ),
      true,
      C0252.bootstrap<"get",4294967360>()
   ),
   f_81639652(
      (var0, var1) -> C0114.bootstrap<"call",1,1>(
            C0114.bootstrap<"call",0,1>()._getPlayer().getAngleToServerRotation(var0),
            C0114.bootstrap<"call",0,1>()._getPlayer().getAngleToServerRotation(var1)
         ),
      false,
      C0252.bootstrap<"get",4294967362>()
   ),
   f_58592444((var0, var1) -> 0, false, C0252.bootstrap<"get",4294967364>());

   private final Comparator<LivingEntity> f_4e79a006;
   private final String[] f_a7983b4d;
   private final boolean f_45c0340d;

   private C0063(Comparator<LivingEntity> var3, boolean var4, String... var5) {
      this.f_4e79a006 = var3;
      this.f_a7983b4d = var5;
      this.f_45c0340d = var4;
   }

   public Optional<LivingEntity> m_195ac10f(Stream<LivingEntity> var1) {
      Comparator var2 = this.m_b40d5a52();
      if (this == f_58592444) {
         var2 = f_81639652.m_b40d5a52();
         var1 = var1.filter(C0060.f_49cf413c.m_fa5df726()::contains);
      }

      return this.f_45c0340d ? var1.max(var2) : var1.min(var2);
   }

   public Comparator<LivingEntity> m_b40d5a52() {
      return this.f_4e79a006;
   }

   public String[] m_072b2f47() {
      return this.f_a7983b4d;
   }
}
