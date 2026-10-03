package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0182 extends GuiScreen {
   private final C0236 f_1e2658af = C0236.f_758a0b10;
   private C0157 f_30150756;
   private Runnable f_b74c566c;

   public C0182(GenericScreen var1) {
      super(var1);
   }

   protected void onInitGui() {
      this.f_30150756 = new C0157(this.getGuiScreenWidth() / 2 - 100, this.getGuiScreenHeight() / 2 - 25, 200, 20);
      this.f_30150756.m_6909040f()._setPasswordMode(true);
      this.addComponent(this.f_30150756);
      this.addComponent(new C0154(this.getGuiScreenWidth() / 2 - 100, this.getGuiScreenHeight() / 2 + 50, 200, 20, Message.of(C0257.m_4626ac74())) {
         @Override
         public boolean m_1521b1fa(int var1) {
            this.m_b1b94a23().setComponentLabel(Message.of(C0254.m_7b0db73e()));
            C0182.this.f_1e2658af.m_8b8c9021(C0182.this.f_30150756.m_e9914bd3(), var1x -> {
               if (var1x) {
                  C0182.this.f_b74c566c = () -> Minecraft.getMinecraftGame().openScreen(new C0180(C0182.this.parent));
               } else {
                  this.m_b1b94a23().setComponentLabel(Message.of(C0254.m_056a389d()).style(Appearance.of(DefaultColors.RED)));
               }
            });
            return true;
         }
      });
      this.addComponent(new C0154(this.getGuiScreenWidth() / 2 - 100, this.getGuiScreenHeight() / 2 + 75, 97, 20, Message.of(C0257.m_c42f1c7e())) {
         @Override
         public boolean m_1521b1fa(int var1) {
            Minecraft.getMinecraftGame().openScreen(null);
            return true;
         }
      });
      this.addComponent(new C0154(this.getGuiScreenWidth() / 2 + 3, this.getGuiScreenHeight() / 2 + 75, 97, 20, Message.of(C0254.m_5fa6dd07())) {
         @Override
         public boolean m_1521b1fa(int var1) {
            Minecraft.getMinecraftGame().openScreen(new C0180(C0182.this.parent));
            return true;
         }
      });
      Message var1 = new Builder()
         .append(C0254.m_3855be80(), Appearance.of(DefaultColors.WHITE))
         .append(C0254.m_5f1ab561(), Appearance.of(DefaultColors.GREEN))
         .build();
      this.addCenteredText(this.getGuiScreenWidth() / 2, this.getGuiScreenHeight() / 2 - 45, Message.of(C0254.m_28b2c020()));
      this.addCenteredText(this.getGuiScreenWidth() / 2, 35, new Builder().append(C0254.m_45aaaba8(), Appearance.of(DefaultColors.GRAY)).append(var1).build());
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 + 10,
         new Builder()
            .append(C0254.m_88937f2b(), Appearance.of(DefaultColors.GRAY))
            .append(var1)
            .append(C0254.m_396f9431(), Appearance.of(DefaultColors.GRAY))
            .build()
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 + 20,
         new Builder()
            .append(C0254.m_e9914bd3(), Appearance.of(DefaultColors.GRAY))
            .append(C0254.m_8631f87f(), Appearance.of(8, DefaultColors.GREEN))
            .append(C0254.m_818e6498(), Appearance.of(DefaultColors.GRAY))
            .build()
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 + 30,
         new Builder()
            .append(C0254.m_56d4c1c7(), Appearance.of(DefaultColors.GRAY))
            .append(C0254.m_d32ebe65(), Appearance.of(DefaultColors.GREEN))
            .append(C0254.m_afb31f66(), Appearance.of(DefaultColors.GRAY))
            .build()
      );
   }

   protected void onDraw(int var1, int var2, float var3) {
      if (this.f_b74c566c != null) {
         this.f_b74c566c.run();
         this.f_b74c566c = null;
      }
   }

   protected void onUpdate() {
      ((Button)this.getMinecraftScreen().getFirstOfType(Button.class))
         .setActive(this.f_30150756.m_e9914bd3().length() != 0 && this.f_30150756.m_e9914bd3().startsWith(C0254.m_c254a253()));
   }
}
