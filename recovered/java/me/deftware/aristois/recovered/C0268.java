package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.ItemRenderer;

public class C0268 implements Runnable, ListItem {
   private static final C0219<C0268> f_36609bec = new C0219<>(C0268.class, C0256.m_b526dd3b());
   @SerializedName("data")
   private String f_157c7efc = "";
   @SerializedName("keyBind")
   private int f_9703edad = -1;
   @SerializedName("modifier")
   private int f_3792e36f = -1;
   @SerializedName("delay")
   private long f_7c009c5d = 1000L;

   public C0268() {
   }

   @Override
   public void run() {
      try {
         String var1 = this.f_157c7efc;
         if (var1.contains(C0256.m_9e27f038())) {
            for (String var5 : var1.split(C0256.m_af41331f())) {
               this.f_157c7efc = this.f_157c7efc.replace(var5, String.valueOf((int)(Math.random() * 9000.0) + 1000));
            }
         }

         if (var1.contains(C0256.m_f257bcca())) {
            new Thread(() -> {
               Thread.currentThread().setName(C0256.m_ecb46027());

               for (String var5x : var1.split(C0256.m_f257bcca())) {
                  this.m_256015fc(var5x);

                  try {
                     Thread.sleep(this.f_7c009c5d);
                  } catch (InterruptedException var7) {
                  }
               }
            }).start();
         } else {
            this.m_256015fc(var1);
         }
      } catch (Exception var6) {
         var6.printStackTrace();
         C0064.m_b79f2e94().m_ee04ba1b(C0256.m_d9b37a36()).m_b728afce();
      }
   }

   private void m_256015fc(String var1) {
      Minecraft var2 = Minecraft.getMinecraftGame();
      MainEntityPlayer var3 = var2._getPlayer();
      if (var3 != null) {
         String var4 = CommandRegister.getCommandTrigger();
         var2.runOnRenderThread(() -> {
            if (var1.startsWith(var4)) {
               try {
                  CommandRegister.getDispatcher().execute(var1.substring(var4.length()), null);
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
      ItemRenderer.drawBlock(var2, var3 + 5, C0071.f_83bc8b61);
      var2 += 28;
      String var9 = this.m_8d7dbe31();
      var9 = var9.length() > 25 ? var9.substring(0, 25) + C0254.m_a004d745() : var9;
      FontRenderer.drawString(Message.of(C0256.m_15737526() + var9), var2, var3 + 3, 10526880);
      FontRenderer.drawString(Message.of(String.format(C0256.m_6cf615ba(), var1, Keyboard.getKeyName(this.m_79bbc2da()))), var2, var3 + 15, 10526880);
   }

   public String m_8d7dbe31() {
      return this.f_157c7efc;
   }

   public int m_79bbc2da() {
      return this.f_9703edad;
   }

   public int m_037208cc() {
      return this.f_3792e36f;
   }

   public long m_59010ffc() {
      return this.f_7c009c5d;
   }

   public void m_a11708c5(String var1) {
      this.f_157c7efc = var1;
   }

   public void m_46938bdb(int var1) {
      this.f_9703edad = var1;
   }

   public void m_7c7fe86a(int var1) {
      this.f_3792e36f = var1;
   }

   public void m_ad6c7e6f(long var1) {
      this.f_7c009c5d = var1;
   }

   public static C0219<C0268> m_ea54feba() {
      return f_36609bec;
   }
}
