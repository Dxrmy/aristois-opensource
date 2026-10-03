package me.deftware.aristois.recovered;

import java.util.Random;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.math.position.BlockPosition;

public class C0384 extends AbstractMod {
   @C0098(
      value = "Walk range",
      number = @C0096(
         max = 10.0
      )
   )
   private int f_299fb9d1 = 3;
   @C0098(
      value = "Delay",
      number = @C0096(
         max = 10.0
      )
   )
   private int f_63e803af = 3;
   private long f_755fb0a9 = -1L;
   private BlockPosition f_4512e1cc;
   private BlockPosition f_e61975e1;
   private Random f_0377baf9 = new Random();

   public C0384() {
      super(C0252.bootstrap<"get",42949673017>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673018>());
   }

   @Override
   public void onEnable() {
      if (C0114.bootstrap<"call",0,1>()._getPlayer() != null) {
         this.f_4512e1cc = C0114.bootstrap<"call",0,1>()._getPlayer().getBlockPosition();
      }
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.FORWARD.setPressed(false);
   }

   @EventHandler
   public void m_8accf054(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (C0114.bootstrap<"call",2,1>() >= this.f_755fb0a9 + (long)(this.f_63e803af * 1000) || this.f_e61975e1 == null) {
         if (this.f_4512e1cc == null) {
            this.f_4512e1cc = var2.getBlockPosition();
         }

         this.f_e61975e1 = this.f_4512e1cc
            .offset((double)(this.f_0377baf9.nextInt(this.f_299fb9d1) - 1), 0.0, (double)(this.f_0377baf9.nextInt(this.f_299fb9d1) - 1));
         this.f_755fb0a9 = C0114.bootstrap<"call",2,1>();
      }

      this.m_8979a62a(this.f_e61975e1, var2);
      MinecraftKeyBind.FORWARD.setPressed((double)this.m_a0cb8bf1(this.f_e61975e1, var2) > 0.75);
   }

   private void m_8979a62a(BlockPosition var1, MainEntityPlayer var2) {
      double var3 = var1.getX() + 0.5 - var2.getPosX();
      double var5 = var1.getZ() + 0.5 - var2.getPosZ();
      float var7 = (float)(C0114.bootstrap<"call",3,1>(var5, var3) * 180.0 / 3.141592653589793) - 90.0F;
      var2.setRotationYaw(var2.getRotationYaw() + this.m_6dd54a16(var7 - var2.getRotationYaw()));
   }

   private float m_a0cb8bf1(BlockPosition var1, MainEntityPlayer var2) {
      float var3 = (float)(var2.getPosX() - var1.getX());
      float var4 = (float)(var2.getPosZ() - var1.getZ());
      return (float)C0114.bootstrap<"call",0,1>((double)((var3 - 0.5F) * (var3 - 0.5F) + (var4 - 0.5F) * (var4 - 0.5F)));
   }

   private float m_6dd54a16(float var1) {
      float var2 = var1 % 360.0F;
      if (var2 >= 180.0F) {
         var2 -= 360.0F;
      }

      if (var2 < -180.0F) {
         var2 += 360.0F;
      }

      return var2;
   }

   @Override
   public void onShutdown() {
      if (this.isEnabled()) {
         this.toggle();
      }
   }
}
