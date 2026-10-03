package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0174<T extends ListItem> extends C0188<T> {
   private final Class<T> f_dc84a17b;

   public C0174(GenericScreen var1, C0219<T> var2, String var3) {
      this(var1, var2, var2.m_5ce6615d(), var3);
   }

   public C0174(GenericScreen var1, List<T> var2, Class<T> var3, String var4) {
      super(var1, var2);
      this.f_3dd96e1d = var4;
      this.f_dc84a17b = var3;
   }

   @Override
   protected void m_1058ed9a() {
      this.f_15585be0 = 400;
      super.m_1058ed9a();
   }

   protected void m_0e265701() {
      Minecraft.getMinecraftGame().openScreen(new C0176<T>(this, this.f_dc84a17b));
   }

   protected void m_f1ec3ae8() {
      Minecraft.getMinecraftGame().openScreen(new C0175<T>(this, this.m_cee5fd5a()));
   }

   public List<T> m_46440a1c() {
      return this.f_18c6e06f;
   }

   public C0174<T> m_91e3b8ed(boolean var1) {
      this.f_a451d159 = var1;
      return this;
   }

   @Override
   protected C0155[] m_da527608() {
      byte var1 = 95;
      return new C0155[]{
         new C0155((float)var1, this)
            .m_2ee4da8d(
               this.m_79273652(0, 0, (float)var1, Message.of(C0254.m_6dc2a812()), this::m_0e265701),
               this.m_5a1fbc03(0, 0, (float)var1, Message.of(C0254.m_e7934778()), this::m_1764cd79).m_798462fc(this::m_51ce03a5),
               this.m_79273652(0, 0, (float)var1, Message.of(C0254.m_d0e43f69()), this::m_f1ec3ae8).m_798462fc(this::m_51ce03a5),
               this.m_79273652(0, 0, (float)var1, Message.of(C0257.m_c42f1c7e()), this::goBack)
            )
      };
   }
}
