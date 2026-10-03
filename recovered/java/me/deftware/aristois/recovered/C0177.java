package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.GuiScreen.BackgroundType;
import me.deftware.client.framework.gui.screens.GenericScreen;

public class C0177 extends C0150 {
   public C0177(GenericScreen var1) {
      super(var1);
      this.setBackgroundType(BackgroundType.TexturedOrTransparent);
   }

   protected void m_b3591abd() {
      this.addCenteredText(C0114.bootstrap<"call",0,1>() / 2, 30, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",17179869243>()));
      float var1 = 230.0F;
      float var2 = 110.0F;
      this.m_7de20993(
         new C0163[]{
            new C0156((double)((float)C0114.bootstrap<"call",0,1>() / 2.0F), (double)((float)C0114.bootstrap<"call",2,1>() / 2.0F), this)
               .m_9df446d7()
               .m_a411e7ce(
                  new C0155(0, 0, var1, var2, this)
                     .m_5d3ed1f2(
                        this.m_c4c7a7f5(
                           0,
                           0,
                           var2,
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836549>()),
                           () -> ((C0150)C0114.bootstrap<"call",0,1>()).m_8d846d1c(this)
                        ),
                        this.m_c4c7a7f5(
                           0,
                           0,
                           var2,
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836550>()),
                           () -> ((C0150)C0114.bootstrap<"call",0,1>()).m_8d846d1c(this)
                        )
                     ),
                  new C0155(0, 0, var1, var2, this)
                     .m_5d3ed1f2(
                        this.m_c4c7a7f5(
                           0,
                           0,
                           var2,
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836551>()),
                           () -> ((C0150)C0114.bootstrap<"call",0,1>()).m_8d846d1c(this)
                        ),
                        this.m_c4c7a7f5(
                           0,
                           0,
                           var2,
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836552>()),
                           () -> ((C0150)C0114.bootstrap<"call",0,1>()).m_8d846d1c(this)
                        )
                     ),
                  new C0155(0, 0, var1, var2, this)
                     .m_5d3ed1f2(
                        this.m_c4c7a7f5(
                           0,
                           0,
                           var2,
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836553>()),
                           () -> ((C0150)C0114.bootstrap<"call",0,1>()).m_8d846d1c(this)
                        ),
                        this.m_7709a717(
                           0,
                           0,
                           var2,
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836554>()),
                           () -> C0114.bootstrap<"call",0,1>(C0146.f_c02c60c3 + C0252.bootstrap<"get",21474836557>())
                        )
                     ),
                  new C0155(0, 0, var1, var2, this)
                     .m_5d3ed1f2(
                        this.m_c4c7a7f5(0, 0, var2, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836555>()), () -> new C0172(this)),
                        this.m_c4c7a7f5(0, 0, var2, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836556>()), () -> new C0186(this))
                     )
               )
         }
      );
      this.m_7de20993(
         new C0163[]{
            this.m_7709a717(
               (int)((float)(C0114.bootstrap<"call",0,1>() / 2) - var2 / 2.0F),
               C0114.bootstrap<"call",2,1>() - 40,
               var2,
               C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",10>()),
               this::goBack
            )
         }
      );
   }
}
