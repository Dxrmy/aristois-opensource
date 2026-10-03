package me.deftware.aristois.recovered;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.services.Registry;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.cosmetics.CosmeticProvider;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.helper.Logger;
import me.deftware.client.framework.render.shader.EntityShader;
import me.deftware.client.framework.render.shader.Shader;
import me.deftware.client.framework.resource.ModResourceManager;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public final class C0242 {
   private static C0242 f_b8dc1cc6 = null;
   private C0454 f_fdb16dbc;
   private final C0136 f_6d6feb33 = new C0136();
   private C0089 f_dae56610;
   private final Logger f_e8e8e498 = new Logger(C0252.bootstrap<"get",4294967324>());
   private EntityShader f_c919b03b;
   private EntityShader f_3ec730b1;
   private EntityShader f_9d1af6bb;
   private Shader f_31819e35;
   public static final Runnable f_dac0b94c = () -> {
      if (((C0296)C0114.bootstrap<"call",0,1>(C0296.class)).m_859a7265()) {
         C0114.bootstrap<"call",1,1>().openScreen(new C0193());
      } else {
         ScreenRegistry.MainMenu.open(new Object[]{(GenericScreen)null});
      }
   };
   private final List<GuiScreen> f_1fda51ee = new LinkedList<>();

   public C0242() {
      f_b8dc1cc6 = this;
      if (C0213.f_c979d8a5.m_093ae25a()) {
         C0048 var1 = new C0048();

         try {
            var1.m_2977064b();
         } catch (Exception var10) {
            this.f_e8e8e498.error(C0252.bootstrap<"get",17179869207>(), new Object[0]);
         }
      }

      ArrayList var12 = new ArrayList();
      var12.add(C0252.bootstrap<"get",17179869208>());
      var12.add(C0252.bootstrap<"get",17179869209>());
      CosmeticProvider.PROVIDERS.add(new C0135());

      try {
         C0141 var2 = C0141.f_f303b426;
         var2.m_2c34f216();

         for (String var4 : var12) {
            InputStream var5 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(), C0252.bootstrap<"get",17179869210>() + var4);
            if (var5 != null) {
               Certificate var6 = C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",17179869211>()).generateCertificate(var5);
               var2.m_507989c7(var4, var6);
               this.f_e8e8e498.debug(C0252.bootstrap<"get",17179869212>(), new Object[]{var4});
               var5.close();
            } else {
               this.f_e8e8e498.error(C0252.bootstrap<"get",17179869213>(), new Object[]{var4});
            }
         }

         var2.m_5ad9a929();
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      C0114.bootstrap<"call",3,1>(C0143::m_31e73578);
      C0044.f_35859108.run();

      try {
         this.f_dae56610 = new C0089();
      } catch (Exception var9) {
      }

      GameMap.INSTANCE.put(GameKeys.MARKETPLACE_ESC_BUTTON, C0114.bootstrap<"call",4,1>(false));
      C0114.bootstrap<"call",5,1>();
      C0114.bootstrap<"call",7,1>(C0114.bootstrap<"call",6,1>()).filter(var0 -> var0.getData().preRun()).forEach(Registry::run);
      this.m_d550f8fc();

      try {
         Attributes var13 = new Manifest(((URLClassLoader)this.getClass().getClassLoader()).findResource(C0252.bootstrap<"get",17179869214>()).openStream())
            .getMainAttributes();
         C0241.f_7826e715 = C0114.bootstrap<"call",8,1>(var13.getValue(C0252.bootstrap<"get",17179869215>()));
         C0241.f_737be508 = var13.getValue(C0252.bootstrap<"get",17179869216>());
      } catch (IOException | ClassCastException var8) {
      }

      C0149.f_27db095d.run();
      C0248.f_960164e1.run();
      C0289.f_c22b8d7e.m_3409fa8f(C0432.class, C0297.class, C0296.class, C0295.class);
      C0289.f_c22b8d7e.m_3409fa8f(C0061.class);
      C0114.bootstrap<"call",9,1>(C0060.class, C0060.f_49cf413c);
      if (C0241.f_7826e715) {
         try {
            Main.class.getClassLoader().loadClass(C0252.bootstrap<"get",17179869217>()).getDeclaredConstructor().newInstance();
         } catch (Exception var7) {
            this.f_e8e8e498.error(C0252.bootstrap<"get",17179869218>(), new Object[]{var7});
         }
      }

      C0114.bootstrap<"call",10,1>().getShutdownQueue().add(() -> C0289.f_c22b8d7e.m_ea73e1f0().forEach(var0 -> {
            var0.save();
            var0.onShutdown();
         }));
      if (C0114.bootstrap<"call",11,1>()) {
         C0236 var14 = C0236.f_8b0448cf;
      }

      C0014.f_70e27a90.run();
      C0289.f_c22b8d7e.run();
      C0114.bootstrap<"call",9,1>(C0451.class, C0451.f_6cf0f98d);
      C0074 var15 = C0074.f_c9f3a771;
      C0223.f_7c6d0315.m_b8fdf5b9();
      C0114.bootstrap<"call",12,1>(this.f_6d6feb33);
      if (C0241.f_7826e715) {
         C0114.bootstrap<"call",13,1>().schedule(() -> {
            if (!this.f_6d6feb33.m_4b9474ad()) {
               C0289.f_c22b8d7e.m_31a49508();
            }
         }, 30L, TimeUnit.SECONDS);
      }

      C0114.bootstrap<"call",7,1>(C0114.bootstrap<"call",6,1>()).filter(var0 -> !var0.getData().preRun()).forEach(Registry::run);
   }

   public static boolean m_c9dff46a() {
      return C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869219>());
   }

   private void m_d550f8fc() {
      MinecraftIdentifier var1 = new MinecraftIdentifier(C0252.bootstrap<"get",4294967424>(), C0252.bootstrap<"get",17179869220>());
      ModResourceManager var2 = C0114.bootstrap<"call",0,1>().getResourceManager();
      EntityShader.SHADERS.add(this.f_c919b03b = new EntityShader(var1, var2));
      EntityShader.SHADERS.add(this.f_3ec730b1 = new EntityShader(var1, var2));
      EntityShader.SHADERS.add(this.f_9d1af6bb = new EntityShader(var1, var2));
      this.f_31819e35 = new Shader(new MinecraftIdentifier(C0252.bootstrap<"get",4294967424>(), C0252.bootstrap<"get",17179869221>()), var2);
   }

   private void m_3fa9421c(GuiScreen var1, C0242.anonymousthis var2) {
      if (!C0114.bootstrap<"call",1,1>().hasKey(var2.toString())) {
         C0114.bootstrap<"call",1,1>().putPrimitive(var2.toString(), true);
         this.f_1fda51ee.add(var1);
      }
   }

   public void m_9a1c80f7() {
      this.m_3fa9421c(new C0191(), C0242.anonymousthis.f_c0b80100);
      this.m_3fa9421c(C0192.f_b6110a8d, C0242.anonymousthis.f_b610b11f);
      Settings var1 = C0114.bootstrap<"call",0,1>();
      int var2 = C0114.bootstrap<"call",1,1>().getMeta().getVersion();
      int var3 = var1.getPrimitive(C0242.anonymousthis.f_bd825dfe.toString(), -1);
      if (var3 < var2) {
         this.f_e8e8e498.info(C0252.bootstrap<"get",17179869222>(), new Object[]{C0114.bootstrap<"call",2,1>(var3), C0114.bootstrap<"call",2,1>(var2)});
         var1.putPrimitive(C0242.anonymousthis.f_bd825dfe.toString(), var2);
         if (!C0241.f_7826e715) {
            this.f_1fda51ee.add(C0192.f_d072ec73);
         }

         try {
            this.f_1fda51ee.add(C0114.bootstrap<"call",3,1>(null));
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      if (((C0296)C0114.bootstrap<"call",4,1>(C0296.class)).m_859a7265()) {
         this.f_1fda51ee.add(new C0193());
      }

      if (!this.f_1fda51ee.isEmpty()) {
         for (int var4 = 0; var4 < this.f_1fda51ee.size(); var4++) {
            GuiScreen var5 = this.f_1fda51ee.get(var4);
            if (var4 + 1 < this.f_1fda51ee.size()) {
               var5.parent = (GenericScreen)this.f_1fda51ee.get(var4 + 1);
            }
         }

         C0114.bootstrap<"call",5,1>().openScreen((GenericScreen)this.f_1fda51ee.get(0));
      }

      C0046.f_33e1045e.run();
   }

   public C0454 m_1ad98e94() {
      return this.f_fdb16dbc;
   }

   public C0136 m_ad827dd3() {
      return this.f_6d6feb33;
   }

   public C0089 m_15e74d28() {
      return this.f_dae56610;
   }

   public Logger m_fb88fdcf() {
      return this.f_e8e8e498;
   }

   public List<GuiScreen> m_7cb59ea8() {
      return this.f_1fda51ee;
   }

   public static C0242 m_8f1dc943() {
      return f_b8dc1cc6;
   }

   public void m_13d3e5fa(C0454 var1) {
      this.f_fdb16dbc = var1;
   }

   public EntityShader m_c347dc8a() {
      return this.f_c919b03b;
   }

   public EntityShader m_373a3102() {
      return this.f_3ec730b1;
   }

   public EntityShader m_c183731a() {
      return this.f_9d1af6bb;
   }

   public Shader m_26765a8c() {
      return this.f_31819e35;
   }

   public static enum anonymousthis {
      f_c0b80100(C0252.bootstrap<"get",17179869202>()),
      f_b610b11f(C0252.bootstrap<"get",17179869204>()),
      f_bd825dfe(C0252.bootstrap<"get",17179869206>());

      private final String f_5a444140;

      private anonymousthis(String var3) {
         this.f_5a444140 = var3;
      }

      @Override
      public String toString() {
         return this.f_5a444140;
      }
   }
}
