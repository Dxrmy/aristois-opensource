package me.deftware.aristois.recovered;

import me.deftware.client.framework.minecraft.Minecraft;

public enum C0213 {
   f_3c75609d(107),
   f_c4accb9e(315),
   f_c129c8d4(340),
   f_e71f2438(477),
   f_203f1aa7(573),
   f_b3451857(575),
   f_7f1f73ce(578),
   f_cb39f22f(735),
   f_118eb6a4(736),
   f_89a83e18(751),
   f_1d2705de(753),
   f_93b47f2c(754),
   f_4cee6cd0(754),
   f_17e12451(755),
   f_80937a7a(756),
   f_0f606095(757),
   f_c4662ff3(759),
   f_6fbcfa9c(762),
   f_c90e7d2e(Minecraft.getMinecraftProtocolVersion());

   private final int f_7f838077;

   private C0213(int var3) {
      this.f_7f838077 = var3;
   }

   public boolean m_efa7610e() {
      return Minecraft.getMinecraftProtocolVersion() >= this.f_7f838077;
   }

   public boolean m_9362a920() {
      return Minecraft.getMinecraftProtocolVersion() == this.f_7f838077;
   }

   public int m_037208cc() {
      return this.f_7f838077;
   }
}
