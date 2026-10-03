package me.deftware.aristois.recovered;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.services.Registry;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.cosmetics.CosmeticProvider;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.helper.Logger;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.shader.EntityShader;
import me.deftware.client.framework.render.shader.Shader;
import me.deftware.client.framework.resource.ModResourceManager;
import me.deftware.client.framework.util.ResourceUtils;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public final class C0242 {
   private static C0242 f_50304eb6 = null;
   private C0454 f_ffc41f8c;
   private final C0136 f_bf6e587c = new C0136();
   private C0089 f_2c2513d2;
   private final Logger f_9c4c15a2 = new Logger(C0264.m_5fa6dd07());
   private EntityShader f_34bcf1fa;
   private EntityShader f_aeee01dd;
   private EntityShader f_341402a6;
   private Shader f_c46a85b7;
   public static final Runnable f_92499831 = () -> {
      if (C0289.m_c3a8b502(C0296.class).m_e0f7c666()) {
         Minecraft.getMinecraftGame().openScreen(new C0193());
      } else {
         ScreenRegistry.MainMenu.open(new Object[]{(GenericScreen)null});
      }
   };
   private final List<GuiScreen> f_80a41d3d = new LinkedList<>();

   public C0242() {
      f_50304eb6 = this;
      if (C0213.f_e71f2438.m_efa7610e()) {
         C0048 var1 = new C0048();

         try {
            var1.m_1058ed9a();
         } catch (Exception var10) {
            this.f_9c4c15a2.error(C0261.m_79bfaec2(), new Object[0]);
         }
      }

      ArrayList var12 = new ArrayList();
      var12.add(C0261.m_2e834348());
      var12.add(C0261.m_e07cee76());
      CosmeticProvider.PROVIDERS.add(new C0135());

      try {
         C0141 var2 = C0141.f_afca7f52;
         var2.m_1058ed9a();

         for (String var4 : var12) {
            InputStream var5 = ResourceUtils.getStreamFromModResources(Main.getInstance(), C0261.m_7b0db73e() + var4);
            if (var5 != null) {
               Certificate var6 = CertificateFactory.getInstance(C0261.m_056a389d()).generateCertificate(var5);
               var2.m_9ac856b9(var4, var6);
               this.f_9c4c15a2.debug(C0261.m_5fa6dd07(), new Object[]{var4});
               var5.close();
            } else {
               this.f_9c4c15a2.error(C0261.m_5f1ab561(), new Object[]{var4});
            }
         }

         var2.m_b728afce();
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      C0217.m_c162d659(C0143::m_1058ed9a);
      C0044.f_7b762377.run();

      try {
         this.f_2c2513d2 = new C0089();
      } catch (Exception var9) {
      }

      GameMap.INSTANCE.put(GameKeys.MARKETPLACE_ESC_BUTTON, false);
      C0243.m_1058ed9a();
      Arrays.stream(Registry.values()).filter(var0 -> var0.getData().preRun()).forEach(Registry::run);
      this.m_b728afce();

      try {
         Attributes var13 = new Manifest(((URLClassLoader)this.getClass().getClassLoader()).findResource(C0261.m_28b2c020()).openStream()).getMainAttributes();
         C0241.f_f6e3d33b = Boolean.parseBoolean(var13.getValue(C0261.m_45aaaba8()));
         C0241.f_152e7e4a = var13.getValue(C0261.m_88937f2b());
      } catch (IOException | ClassCastException var8) {
      }

      C0149.f_9e30b55f.run();
      C0248.f_2a1966bb.run();
      C0289.f_85a7343f.m_41c999d6(C0432.class, C0297.class, C0296.class, C0295.class);
      C0289.f_85a7343f.m_41c999d6(C0061.class);
      EventBus.registerClass(C0060.class, C0060.f_4818213b);
      if (C0241.f_f6e3d33b) {
         try {
            Main.class.getClassLoader().loadClass(C0261.m_396f9431()).getDeclaredConstructor().newInstance();
         } catch (Exception var7) {
            this.f_9c4c15a2.error(C0261.m_e9914bd3(), new Object[]{var7});
         }
      }

      Main.getConfig().getShutdownQueue().add(() -> C0289.f_85a7343f.m_918b7b9e().forEach(var0 -> {
            var0.save();
            var0.onShutdown();
         }));
      if (m_efa7610e()) {
         C0236 var14 = C0236.f_758a0b10;
      }

      C0014.f_def608a1.run();
      C0289.f_85a7343f.run();
      EventBus.registerClass(C0451.class, C0451.f_3c37bf88);
      C0074 var15 = C0074.f_d3f3801b;
      C0223.f_a04019fa.m_1058ed9a();
      CompletableFuture.runAsync(this.f_bf6e587c);
      if (C0241.f_f6e3d33b) {
         Executors.newSingleThreadScheduledExecutor().schedule(() -> {
            if (!this.f_bf6e587c.m_89e0519f()) {
               C0289.f_85a7343f.m_b728afce();
            }
         }, 30L, TimeUnit.SECONDS);
      }

      Arrays.stream(Registry.values()).filter(var0 -> !var0.getData().preRun()).forEach(Registry::run);
   }

   public static boolean m_efa7610e() {
      return C0217.m_b09e5caa(C0261.m_8631f87f());
   }

   private void m_b728afce() {
      MinecraftIdentifier var1 = new MinecraftIdentifier(C0264.m_65d43991(), C0261.m_818e6498());
      ModResourceManager var2 = Main.getInstance().getResourceManager();
      EntityShader.SHADERS.add(this.f_34bcf1fa = new EntityShader(var1, var2));
      EntityShader.SHADERS.add(this.f_aeee01dd = new EntityShader(var1, var2));
      EntityShader.SHADERS.add(this.f_341402a6 = new EntityShader(var1, var2));
      this.f_c46a85b7 = new Shader(new MinecraftIdentifier(C0264.m_65d43991(), C0261.m_56d4c1c7()), var2);
   }

   private void m_ebfce3d4(GuiScreen var1, C0242.anonymousthis var2) {
      if (!Main.getConfig().hasKey(var2.toString())) {
         Main.getConfig().putPrimitive(var2.toString(), true);
         this.f_80a41d3d.add(var1);
      }
   }

   public void m_0e265701() {
      this.m_ebfce3d4(new C0191(), C0242.anonymousthis.f_5710e889);
      this.m_ebfce3d4(C0192.f_5cc08e88, C0242.anonymousthis.f_72174552);
      Settings var1 = Main.getConfig();
      int var2 = Main.getInstance().getMeta().getVersion();
      int var3 = var1.getPrimitive(C0242.anonymousthis.f_3f4a7a8b.toString(), -1);
      if (var3 < var2) {
         this.f_9c4c15a2.info(C0261.m_d32ebe65(), new Object[]{var3, var2});
         var1.putPrimitive(C0242.anonymousthis.f_3f4a7a8b.toString(), var2);
         if (!C0241.f_f6e3d33b) {
            this.f_80a41d3d.add(C0192.f_43508b36);
         }

         try {
            this.f_80a41d3d.add(C0189.m_e842fe9d(null));
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      if (C0289.m_c3a8b502(C0296.class).m_e0f7c666()) {
         this.f_80a41d3d.add(new C0193());
      }

      if (!this.f_80a41d3d.isEmpty()) {
         for (int var4 = 0; var4 < this.f_80a41d3d.size(); var4++) {
            GuiScreen var5 = this.f_80a41d3d.get(var4);
            if (var4 + 1 < this.f_80a41d3d.size()) {
               var5.parent = (GenericScreen)this.f_80a41d3d.get(var4 + 1);
            }
         }

         Minecraft.getMinecraftGame().openScreen((GenericScreen)this.f_80a41d3d.get(0));
      }

      C0046.f_3cccbdf2.run();
   }

   public C0454 m_a88b18cc() {
      return this.f_ffc41f8c;
   }

   public C0136 m_dc6b6d48() {
      return this.f_bf6e587c;
   }

   public C0089 m_509e0ab7() {
      return this.f_2c2513d2;
   }

   public Logger m_7d0d42ce() {
      return this.f_9c4c15a2;
   }

   public List<GuiScreen> m_a2a4e197() {
      return this.f_80a41d3d;
   }

   public static C0242 m_fc1b642c() {
      return f_50304eb6;
   }

   public void m_6adf81f4(C0454 var1) {
      this.f_ffc41f8c = var1;
   }

   public EntityShader m_5100ce60() {
      return this.f_34bcf1fa;
   }

   public EntityShader m_b0a87172() {
      return this.f_aeee01dd;
   }

   public EntityShader m_644daa7e() {
      return this.f_341402a6;
   }

   public Shader m_e77ae4a1() {
      return this.f_c46a85b7;
   }

   public static enum anonymousthis {
      f_5710e889(C0261.m_cf4f91f1()),
      f_72174552(C0261.m_b48a8bc4()),
      f_3f4a7a8b(C0261.m_bec91365());

      private final String f_547f8be4;

      private anonymousthis(String var3) {
         this.f_547f8be4 = var3;
      }

      @Override
      public String toString() {
         return this.f_547f8be4;
      }
   }
}
