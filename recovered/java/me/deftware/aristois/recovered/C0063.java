package me.deftware.aristois.recovered;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.minecraft.Minecraft;

public enum C0063 implements C0102.anonymousthis {
   f_ed26b309((var0, var1) -> Float.compare(var0.getHealth(), var1.getHealth()), true, C0264.m_56242a84()),
   f_0c3cee95((var0, var1) -> Float.compare(var0.getHealth(), var1.getHealth()), false, C0264.m_af41331f()),
   f_e2135a92(
      (var0, var1) -> Float.compare(
            Minecraft.getMinecraftGame()._getPlayer().distanceToEntity(var0), Minecraft.getMinecraftGame()._getPlayer().distanceToEntity(var1)
         ),
      false,
      C0264.m_d9b37a36()
   ),
   f_c537e13d(
      (var0, var1) -> Float.compare(
            Minecraft.getMinecraftGame()._getPlayer().distanceToEntity(var0), Minecraft.getMinecraftGame()._getPlayer().distanceToEntity(var1)
         ),
      true,
      C0264.m_6cf615ba()
   ),
   f_745912bd(
      (var0, var1) -> Float.compare(
            Minecraft.getMinecraftGame()._getPlayer().getAngleToServerRotation(var0), Minecraft.getMinecraftGame()._getPlayer().getAngleToServerRotation(var1)
         ),
      false,
      C0264.m_b526dd3b()
   ),
   f_d1e19fab((var0, var1) -> 0, false, C0264.m_87c16989());

   private final Comparator<LivingEntity> f_2b34e1f4;
   private final String[] f_9772ac15;
   private final boolean f_da2f9177;

   private C0063(Comparator<LivingEntity> var3, boolean var4, String... var5) {
      this.f_2b34e1f4 = var3;
      this.f_9772ac15 = var5;
      this.f_da2f9177 = var4;
   }

   public Optional<LivingEntity> m_9d947410(Stream<LivingEntity> var1) {
      Comparator var2 = this.m_1394c22d();
      if (this == f_d1e19fab) {
         var2 = f_745912bd.m_1394c22d();
         var1 = var1.filter(C0060.f_4818213b.m_350b5ae0()::contains);
      }

      return this.f_da2f9177 ? var1.max(var2) : var1.min(var2);
   }

   public Comparator<LivingEntity> m_1394c22d() {
      return this.f_2b34e1f4;
   }

   @Override
   public String[] m_8e56a473() {
      return this.f_9772ac15;
   }
}
