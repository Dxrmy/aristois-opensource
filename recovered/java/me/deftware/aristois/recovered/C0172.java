package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0172 extends C0188<C0268> {
   public C0172(GenericScreen var1) {
      super(var1, C0268.m_ea54feba());
   }

   @Override
   protected void m_1058ed9a() {
      this.f_3dd96e1d = C0254.m_b2dd5137();
      this.f_15585be0 = 400;
      this.m_d6ac7420(true);
      super.m_1058ed9a();
   }

   @Override
   protected C0155[] m_da527608() {
      short var1 = 130;
      short var2 = 130;
      return new C0155[]{
         new C0155((float)var1, this)
            .m_2ee4da8d(
               this.m_7b83f958(0, 0, (float)var1, Message.of(C0254.m_6dc2a812()), () -> new C0171(this)),
               this.m_5a1fbc03(0, 0, (float)var1, Message.of(C0254.m_e7934778()), this::m_1764cd79).m_798462fc(this::m_51ce03a5),
               this.m_79273652(0, 0, (float)var2, Message.of(C0257.m_c42f1c7e()), this::goBack)
            ),
         new C0155((float)var2, this)
            .m_2ee4da8d(
               this.m_5a1fbc03(0, 0, (float)var2, Message.of(C0254.m_9bf0a29a()), var1x -> {
                  Keyboard.setClipboardString(this.m_cee5fd5a().m_8d7dbe31());
                  ((Button)var1x.m_b1b94a23().setComponentLabel(Message.of(C0254.m_03430357()))).resetToAfter(2000, Message.of(C0254.m_9bf0a29a()));
               }).m_798462fc(this::m_51ce03a5),
               this.m_5a1fbc03(0, 0, (float)var2, Message.of(C0254.m_85cd13b4()), var1x -> {
                  MainEntityPlayer var2x = Minecraft.getMinecraftGame()._getPlayer();
                  String var3 = "";
                  if (var2x == null) {
                     var3 = C0254.m_65c7e6e6();
                  } else {
                     this.m_cee5fd5a().run();
                     var3 = C0254.m_a19a564f();
                  }

                  ((Button)var1x.m_b1b94a23().setComponentLabel(Message.of(var3))).resetToAfter(2000, Message.of(C0254.m_85cd13b4()));
               }).m_798462fc(this::m_51ce03a5),
               this.m_79273652(
                     0, 0, (float)var1, Message.of(C0254.m_d0e43f69()), () -> Minecraft.getMinecraftGame().openScreen(new C0173(this, this.m_cee5fd5a()))
                  )
                  .m_798462fc(this::m_51ce03a5)
            )
      };
   }
}
