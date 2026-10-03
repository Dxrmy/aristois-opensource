package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.session.AccountSession;

public class C0183 extends C0150 {
   private C0157 f_d798c171;

   public C0183(GenericScreen var1) {
      super(var1);
   }

   protected void m_990b5ab0() {
      short var1 = 300;
      this.f_d798c171 = new C0157(C0114.bootstrap<"call",0,1>() / 2 - var1 / 2, 80, var1, 20);
      this.f_d798c171.m_6944db4d(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836544>()));
      this.m_b490b0b2(new C0163[]{this.f_d798c171});
      short var2 = 160;
      byte var3 = 120;
      this.m_b490b0b2(
         new C0163[]{
            new C0154(C0114.bootstrap<"call",0,1>() / 2 - var3 - 2, var2, var3, 20, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",17179869310>())) {
               public boolean m_ce42163c(int var1) {
                  C0114.bootstrap<"call",0,1>(C0183.this);
                  return true;
               }
            }
         }
      );
      this.m_b490b0b2(new C0163[]{(new C0154(C0114.bootstrap<"call",0,1>() / 2 + 2, var2, var3, 20, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4>())) {
         public boolean m_30d7844d(int var1) {
            AccountSession var2 = new AccountSession(null);
            var2.withOfflineUsername(C0114.bootstrap<"call",0,1>(C0183.this).m_55cc55cf());
            var2.setSession();
            C0114.bootstrap<"call",1,1>(C0183.this);
            return true;
         }
      }).m_11261e7b(() -> C0114.bootstrap<"call",0,1>(!this.f_d798c171.m_55cc55cf().isEmpty()))});
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      int var4 = C0114.bootstrap<"call",0,1>() / 2;
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836545>()), var4, 40, 16777215);
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836546>()), var4, 50, 16777215);
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836547>()), var4, 120, 16777215);
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836548>()), var4, 130, 16777215);
   }
}
