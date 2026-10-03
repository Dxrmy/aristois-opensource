package me.deftware.aristois.recovered;

import java.io.File;
import me.deftware.aristois.modules.AbstractMod;

@C0420
public class C0296 extends AbstractMod {
   @C0098(
      value = "Main Menu",
      description = {"Use the custom Aristois main menu"}
   )
   public boolean f_40b4fd42 = true;
   @C0098(
      value = "ESC Button",
      description = {"If the Aristois options should be shown in the ESC menu"}
   )
   private boolean f_99e39983 = true;
   @C0098(
      value = "Marketplace",
      description = {"If the Addons marketplace should be shown in the ESC menu"}
   )
   private boolean f_9bdae21c = true;
   @C0098(
      value = "Key Up",
      description = {"Open chat with the last sent message", "when arrow up is pressed.", "Requires TabUI to be disabled"}
   )
   private boolean f_0d4745bd = false;
   @C0098(
      value = "Chat Overlay",
      description = {"Enable/disable the chat overlay for instructions with IRC | .help"}
   )
   private boolean f_6beaa382 = true;
   @C0097(
      title = "Select menu background",
      description = "Image files",
      filters = {"*.gif", "*.png", "*.jpg", "*.jpeg"}
   )
   @C0098(
      value = "Background",
      id = 18,
      description = {"Select image/gif for the background"}
   )
   private File f_2f46efbf = new File("");

   public C0296() {
      super(C0252.bootstrap<"get",38>(), C0290.f_5fe5d165, C0252.bootstrap<"get",42949672975>());
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() == 18
         && (
            this.f_2f46efbf.getAbsolutePath().endsWith(C0252.bootstrap<"get",42949672976>())
               || this.f_2f46efbf.getAbsolutePath().endsWith(C0252.bootstrap<"get",4294967315>())
               || this.f_2f46efbf.getAbsolutePath().endsWith(C0252.bootstrap<"get",42949672977>())
               || this.f_2f46efbf.getAbsolutePath().endsWith(C0252.bootstrap<"get",42949672978>())
         )) {
         if (this.f_2f46efbf.getAbsolutePath().endsWith(C0252.bootstrap<"get",42949672976>()) && !C0241.f_7826e715) {
            C0114.bootstrap<"call",0,1>().m_77a7bc18(C0252.bootstrap<"get",42949672979>()).m_66e721c0();
            this.f_2f46efbf = new File("");
            return;
         }

         C0223.f_7c6d0315.m_b8fdf5b9();
      }
   }

   public boolean m_859a7265() {
      return this.f_40b4fd42;
   }

   public boolean m_2b3e6d6e() {
      return this.f_99e39983;
   }

   public boolean m_4bd179de() {
      return this.f_9bdae21c;
   }

   public boolean m_45e0418b() {
      return this.f_0d4745bd;
   }

   public boolean m_a818a537() {
      return this.f_6beaa382;
   }

   public File m_b3cfdea7() {
      return this.f_2f46efbf;
   }

   public void m_a6cf6621(File var1) {
      this.f_2f46efbf = var1;
   }
}
