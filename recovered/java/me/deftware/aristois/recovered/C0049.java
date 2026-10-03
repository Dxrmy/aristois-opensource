package me.deftware.aristois.recovered;

import java.util.UUID;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public interface C0049 extends ListItem {
   C0224 f_bd2f3d48 = C0224.m_3d9368ca(UUID.fromString(C0257.m_44418b5d()));
   int f_3a1e3bed = 20;

   static UUID m_144ca0fc() {
      String var0 = SessionHelper.getPlayerUUID();
      int var1 = var0.length();
      return var1 != 32 && var1 != 36 ? null : C0217.m_edf212e5(var0);
   }

   String m_c42f1c7e();

   UUID m_e3947f34();

   default String m_d32ebe65() {
      return this.m_c42f1c7e();
   }

   default C0230 m_7b315cdd() {
      return f_bd2f3d48;
   }

   default boolean m_e0f7c666() {
      UUID var1 = m_144ca0fc();
      return var1 != null && var1.equals(this.m_e3947f34());
   }

   void m_fd4438d8();

   void m_f1ec3ae8() throws Exception;

   default void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      FontRenderer.drawString(
         Message.of(this.m_d32ebe65()).style(Appearance.of(this.m_e0f7c666() ? DefaultColors.GREEN : DefaultColors.WHITE)), var2 + 20, var3 + 3, 16777215
      );
      C0230 var9 = this.m_7b315cdd();
      if (var9.m_c0b2fa8c(C0230.anonymouscatch.f_bce9cc23)) {
         var9.m_d4d15bd2(var2 - 8, var3 + 1, 24, 24, C0230.anonymouscatch.f_bce9cc23);
      }
   }
}
