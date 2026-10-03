package me.deftware.aristois.recovered;

import java.io.File;
import me.deftware.aristois.modules.AbstractMod;

@C0420
public class C0296 extends AbstractMod {
   @C0098(
      value = "Main Menu",
      description = {"Use the custom Aristois main menu"}
   )
   public boolean f_bb79bd62 = true;
   @C0098(
      value = "ESC Button",
      description = {"If the Aristois options should be shown in the ESC menu"}
   )
   private boolean f_8c4ed3d5 = true;
   @C0098(
      value = "Marketplace",
      description = {"If the Addons marketplace should be shown in the ESC menu"}
   )
   private boolean f_131e40e1 = true;
   @C0098(
      value = "Key Up",
      description = {"Open chat with the last sent message", "when arrow up is pressed.", "Requires TabUI to be disabled"}
   )
   private boolean f_3820bf0a = false;
   @C0098(
      value = "Chat Overlay",
      description = {"Enable/disable the chat overlay for instructions with IRC | .help"}
   )
   private boolean f_fe7b643d = true;
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
   private File f_1f0b7c2c = new File("");

   public C0296() {
      super(C0257.m_d32ebe65(), C0290.f_020f9141, C0259.m_1635bc47());
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() == 18
         && (
            this.f_1f0b7c2c.getAbsolutePath().endsWith(C0259.m_d597c122())
               || this.f_1f0b7c2c.getAbsolutePath().endsWith(C0264.m_b251ca51())
               || this.f_1f0b7c2c.getAbsolutePath().endsWith(C0259.m_18204724())
               || this.f_1f0b7c2c.getAbsolutePath().endsWith(C0259.m_cf4f91f1())
         )) {
         if (this.f_1f0b7c2c.getAbsolutePath().endsWith(C0259.m_d597c122()) && !C0241.f_f6e3d33b) {
            C0064.m_7853c016().m_ee04ba1b(C0259.m_b251ca51()).m_1058ed9a();
            this.f_1f0b7c2c = new File("");
            return;
         }

         C0223.f_a04019fa.m_1058ed9a();
      }
   }

   public boolean m_e0f7c666() {
      return this.f_bb79bd62;
   }

   public boolean m_275ab222() {
      return this.f_8c4ed3d5;
   }

   public boolean m_f21a055b() {
      return this.f_131e40e1;
   }

   public boolean m_6c9f39f9() {
      return this.f_3820bf0a;
   }

   public boolean m_78cbd705() {
      return this.f_fe7b643d;
   }

   public File m_4e58adf5() {
      return this.f_1f0b7c2c;
   }

   public void m_1acc8b38(File var1) {
      this.f_1f0b7c2c = var1;
   }
}
