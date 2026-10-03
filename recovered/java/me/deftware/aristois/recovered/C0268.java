package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0268 implements Runnable, ListItem {
   private static final C0219<C0268> f_9b62eebc = new C0219<>(C0268.class, C0252.bootstrap<"get",55834574914>());
   @SerializedName("data")
   private String f_78b8cead = "";
   @SerializedName("keyBind")
   private int f_27a07cab = -1;
   @SerializedName("modifier")
   private int f_b390aafa = -1;
   @SerializedName("delay")
   private long f_8603a302 = 1000L;

   public C0268() {
   }

   @Override
   public void run() {
      try {
         String var1 = this.f_78b8cead;
         if (var1.contains(C0252.bootstrap<"get",55834574907>())) {
            for (String var5 : var1.split(C0252.bootstrap<"get",55834574908>())) {
               this.f_78b8cead = this.f_78b8cead.replace(var5, C0114.bootstrap<"call",1,1>((int)(C0114.bootstrap<"call",0,1>() * 9000.0) + 1000));
            }
         }

         if (var1.contains(C0252.bootstrap<"get",55834574909>())) {
            new Thread(() -> {
               C0114.bootstrap<"call",0,1>().setName(C0252.bootstrap<"get",55834574913>());

               for (String var5x : var1.split(C0252.bootstrap<"get",55834574909>())) {
                  this.m_ee72d792(var5x);

                  try {
                     C0114.bootstrap<"call",1,1>(this.f_8603a302);
                  } catch (InterruptedException var7) {
                  }
               }
            }).start();
         } else {
            this.m_ee72d792(var1);
         }
      } catch (Exception var6) {
         var6.printStackTrace();
         C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",55834574910>()).m_9d59fbe9();
      }
   }

   private void m_ee72d792(String var1) {
      Minecraft var2 = C0114.bootstrap<"call",0,1>();
      MainEntityPlayer var3 = var2._getPlayer();
      if (var3 != null) {
         String var4 = C0114.bootstrap<"call",1,1>();
         var2.runOnRenderThread(() -> {
            if (var1.startsWith(var4)) {
               try {
                  C0114.bootstrap<"call",2,1>().execute(var1.substring(var4.length()), null);
               } catch (Exception var4x) {
                  var4x.printStackTrace();
               }
            } else {
               var3.sendMessage(var1, C0268.class);
            }
         });
      }
   }

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      C0114.bootstrap<"call",0,1>(var2, var3 + 5, C0071.f_a29f3429);
      var2 += 28;
      String var9 = this.m_8ccabf49();
      var9 = var9.length() > 25 ? var9.substring(0, 25) + C0252.bootstrap<"get",21474836598>() : var9;
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",55834574911>() + var9), var2, var3 + 3, 10526880);
      C0114.bootstrap<"call",2,1>(
         C0114.bootstrap<"call",1,1>(
            C0114.bootstrap<"call",5,1>(
               C0252.bootstrap<"get",55834574912>(), new Object[]{C0114.bootstrap<"call",3,1>(var1), C0114.bootstrap<"call",4,1>(this.m_9d73c835())}
            )
         ),
         var2,
         var3 + 15,
         10526880
      );
   }

   public String m_8ccabf49() {
      return this.f_78b8cead;
   }

   public int m_9d73c835() {
      return this.f_27a07cab;
   }

   public int m_1921cf88() {
      return this.f_b390aafa;
   }

   public long m_0efcb4f6() {
      return this.f_8603a302;
   }

   public void m_3e620f34(String var1) {
      this.f_78b8cead = var1;
   }

   public void m_2faedb85(int var1) {
      this.f_27a07cab = var1;
   }

   public void m_5dc61818(int var1) {
      this.f_b390aafa = var1;
   }

   public void m_570ad382(long var1) {
      this.f_8603a302 = var1;
   }

   public static C0219<C0268> m_a6e50331() {
      return f_9b62eebc;
   }
}
