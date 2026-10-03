package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.minecraft.Minecraft;

@C0422(258)
public class C0295 extends AbstractMod {
   @C0098(
      value = "Auto Close",
      description = {"Automatically close the quick menu", "after selecting an item"}
   )
   private boolean f_b7de55d5 = true;
   @C0098(
      value = "Notification",
      description = {"Send a toast when an action is performed"}
   )
   private boolean f_9cf4528e = true;
   @C0098(
      value = "Max Results",
      description = {"The amount of results to display for a search"},
      number = @C0096(
         min = 2.0,
         max = 10.0
      )
   )
   private int f_0c6f7780 = 5;

   public C0295() {
      super(C0259.m_b48a8bc4(), C0290.f_020f9141, C0259.m_b886ae1c(), C0259.m_bec91365(), "", C0259.m_79bfaec2(), C0259.m_2e834348());
   }

   @Override
   public void onEnable() {
      if (!(Minecraft.getMinecraftGame().getScreen() instanceof C0429)) {
         Minecraft.getMinecraftGame().openScreen(new C0429());
      }

      this.toggle();
   }

   public boolean m_e0f7c666() {
      return this.f_b7de55d5;
   }

   public boolean m_275ab222() {
      return this.f_9cf4528e;
   }

   public int m_597f2e14() {
      return this.f_0c6f7780;
   }
}
