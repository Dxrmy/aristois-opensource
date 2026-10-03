package me.deftware.aristois.recovered;

import java.util.Objects;
import java.util.Random;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0384 extends AbstractMod {
   @C0098(
      value = "Walk range",
      number = @C0096(
         max = 10.0
      )
   )
   private int f_86718de6 = 3;
   @C0098(
      value = "Delay",
      number = @C0096(
         max = 10.0
      )
   )
   private int f_53d3c2f3 = 3;
   private long f_2f29078b = -1L;
   private BlockPosition f_980ad42c;
   private BlockPosition f_0297259e;
   private Random f_7c2cfe48 = new Random();

   public C0384() {
      super(C0259.m_df6e621c(), C0290.f_829d9b20, C0259.m_56242a84());
   }

   @Override
   public void onEnable() {
      if (Minecraft.getMinecraftGame()._getPlayer() != null) {
         this.f_980ad42c = Minecraft.getMinecraftGame()._getPlayer().getBlockPosition();
      }
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.FORWARD.setPressed(false);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (System.currentTimeMillis() >= this.f_2f29078b + (long)(this.f_53d3c2f3 * 1000) || this.f_0297259e == null) {
         if (this.f_980ad42c == null) {
            this.f_980ad42c = var2.getBlockPosition();
         }

         this.f_0297259e = this.f_980ad42c
            .offset((double)(this.f_7c2cfe48.nextInt(this.f_86718de6) - 1), 0.0, (double)(this.f_7c2cfe48.nextInt(this.f_86718de6) - 1));
         this.f_2f29078b = System.currentTimeMillis();
      }

      this.m_f7ff4849(this.f_0297259e, var2);
      MinecraftKeyBind.FORWARD.setPressed((double)this.m_22cf550a(this.f_0297259e, var2) > 0.75);
   }

   private void m_f7ff4849(BlockPosition var1, MainEntityPlayer var2) {
      double var3 = var1.getX() + 0.5 - var2.getPosX();
      double var5 = var1.getZ() + 0.5 - var2.getPosZ();
      float var7 = (float)(Math.atan2(var5, var3) * 180.0 / 3.141592653589793) - 90.0F;
      var2.setRotationYaw(var2.getRotationYaw() + this.m_9036e749(var7 - var2.getRotationYaw()));
   }

   private float m_22cf550a(BlockPosition var1, MainEntityPlayer var2) {
      float var3 = (float)(var2.getPosX() - var1.getX());
      float var4 = (float)(var2.getPosZ() - var1.getZ());
      return (float)Math.sqrt((double)((var3 - 0.5F) * (var3 - 0.5F) + (var4 - 0.5F) * (var4 - 0.5F)));
   }

   private float m_9036e749(float var1) {
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
