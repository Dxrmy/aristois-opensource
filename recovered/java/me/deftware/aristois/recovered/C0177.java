package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.GuiScreen.BackgroundType;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Message;

public class C0177 extends C0150 {
   public C0177(GenericScreen var1) {
      super(var1);
      this.setBackgroundType(BackgroundType.TexturedOrTransparent);
   }

   @Override
   protected void m_1058ed9a() {
      this.addCenteredText(getScaledWidth() / 2, 30, Message.of(C0261.m_9e27f038()));
      float var1 = 230.0F;
      float var2 = 110.0F;
      this.m_4f7d4126(
         new C0163[]{
            new C0156((double)((float)getScaledWidth() / 2.0F), (double)((float)getScaledHeight() / 2.0F), this)
               .m_4dd9e5a9()
               .m_482c862d(
                  new C0155(0, 0, var1, var2, this)
                     .m_2ee4da8d(
                        this.m_7b83f958(0, 0, var2, Message.of(C0254.m_b0896de7()), () -> ((C0150)C0313.m_1ebb9a23()).m_772dbb91(this)),
                        this.m_7b83f958(0, 0, var2, Message.of(C0254.m_593ecbab()), () -> ((C0150)C0367.m_921ecdb2()).m_772dbb91(this))
                     ),
                  new C0155(0, 0, var1, var2, this)
                     .m_2ee4da8d(
                        this.m_7b83f958(0, 0, var2, Message.of(C0254.m_17d51275()), () -> ((C0150)C0326.m_0d5f1fc3()).m_772dbb91(this)),
                        this.m_7b83f958(0, 0, var2, Message.of(C0254.m_00ba16c2()), () -> ((C0150)C0405.m_1ebb9a23()).m_772dbb91(this))
                     ),
                  new C0155(0, 0, var1, var2, this)
                     .m_2ee4da8d(
                        this.m_7b83f958(0, 0, var2, Message.of(C0254.m_d1f7b79f()), () -> ((C0150)C0338.m_921ecdb2()).m_772dbb91(this)),
                        this.m_79273652(0, 0, var2, Message.of(C0254.m_a29090eb()), () -> Keyboard.openLink(C0146.f_36f829be + C0254.m_1616e137()))
                     ),
                  new C0155(0, 0, var1, var2, this)
                     .m_2ee4da8d(
                        this.m_7b83f958(0, 0, var2, Message.of(C0254.m_b2dd5137()), () -> new C0172(this)),
                        this.m_7b83f958(0, 0, var2, Message.of(C0254.m_91e95cb4()), () -> new C0186(this))
                     )
               )
         }
      );
      this.m_4f7d4126(
         new C0163[]{
            this.m_79273652((int)((float)(getScaledWidth() / 2) - var2 / 2.0F), getScaledHeight() - 40, var2, Message.of(C0257.m_c42f1c7e()), this::goBack)
         }
      );
   }
}
