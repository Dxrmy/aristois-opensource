package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.minecraft.Minecraft;

@C0422
@C0099
public class C0349 extends AbstractMod {
   @C0098(
      value = "Open Keybind",
      description = {"Keybind to open the chat window with the emc prefix already typed"},
      keybind = true
   )
   private C0245 f_67cf33d8 = new C0245(46);

   public C0349() {
      super(C0260.m_d597c122(), C0290.f_99d080af, C0260.m_18204724());
   }

   @EventHandler
   public void m_1e0a909c(EventKeyAction var1) {
      if (var1.getKeyCode() == this.f_67cf33d8.m_36ffc578()) {
         Minecraft.getMinecraftGame().runOnRenderThread(() -> ScreenRegistry.Chat.open(new Object[]{CommandRegister.getCommandTrigger()}));
      }
   }
}
