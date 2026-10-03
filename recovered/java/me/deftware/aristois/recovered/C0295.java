package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;

@C0422(258)
public class C0295 extends AbstractMod {
   @C0098(
      value = "Auto Close",
      description = {"Automatically close the quick menu", "after selecting an item"}
   )
   private boolean f_c54344d4 = true;
   @C0098(
      value = "Notification",
      description = {"Send a toast when an action is performed"}
   )
   private boolean f_15c76960 = true;
   @C0098(
      value = "Max Results",
      description = {"The amount of results to display for a search"},
      number = @C0096(
         min = 2.0,
         max = 10.0
      )
   )
   private int f_e04ff5d6 = 5;

   public C0295() {
      super(
         C0252.bootstrap<"get",42949672980>(),
         C0290.f_5fe5d165,
         C0252.bootstrap<"get",42949672981>(),
         C0252.bootstrap<"get",42949672982>(),
         "",
         C0252.bootstrap<"get",42949672983>(),
         C0252.bootstrap<"get",42949672984>()
      );
   }

   @Override
   public void onEnable() {
      if (!(C0114.bootstrap<"call",0,1>().getScreen() instanceof C0429)) {
         C0114.bootstrap<"call",0,1>().openScreen(new C0429());
      }

      this.toggle();
   }

   public boolean m_cae89c8a() {
      return this.f_c54344d4;
   }

   public boolean m_6a3a5697() {
      return this.f_15c76960;
   }

   public int m_fb253b03() {
      return this.f_e04ff5d6;
   }
}
