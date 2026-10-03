package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0399 extends AbstractMod {
   public C0399() {
      super(C0252.bootstrap<"get",38654705711>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705712>());
   }

   @EventHandler
   public void m_c0ca05ef(EventUpdate var1) {
      EntityPlayer var2 = (EntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
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
