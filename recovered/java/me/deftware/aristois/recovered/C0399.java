package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0399 extends AbstractMod {
   public C0399() {
      super(C0263.m_4e02e7a9(), C0290.f_dbc16475, C0263.m_7f74d855());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      EntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.isOnGround()
         && !var2.isSneaking()
         && !MinecraftKeyBind.SNEAK.isPressed()
         && !MinecraftKeyBind.JUMP.isPressed()
         && !var2.isInLiquid()
         && var2.isAtEdge()) {
         var2.doJump();
      }
   }
}
