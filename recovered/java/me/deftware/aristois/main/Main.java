package me.deftware.aristois.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;
import me.deftware.aristois.recovered.C0047;
import me.deftware.aristois.recovered.C0150;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0213;
import me.deftware.aristois.recovered.C0231;
import me.deftware.aristois.recovered.C0242;
import me.deftware.aristois.recovered.C0438;
import me.deftware.aristois.recovered.C0454;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.minecraft.Minecraft;
import org.apache.commons.io.IOUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;

public class Main extends EMCMod {
   private static Main instance;

   public Main() {
   }

   public static Settings getConfig() {
      return instance.getSettings();
   }

   public void setup() {
      GLFW.glfwSetCharCallback(WindowHelper.getWindowHandle(), new GLFWCharCallback() {
         public void invoke(long window, int codepoint) {
            try {
               MinecraftScreen screen = Minecraft.getMinecraftGame().getScreen();
               if (screen instanceof C0150) {
                  C0150 builder = (C0150)screen;

                  for (C0163 widget : builder.m_dcccdb46()) {
                     if (widget instanceof C0438) {
                        C0438 consumer = (C0438)widget;
                        consumer.m_1f87a876(codepoint);
                     }
                  }
               }
            } catch (Throwable var9) {
            }
         }
      });
      if (!C0213.f_57699eb8.m_093ae25a()) {
         this.getResourceManager().setTransformer(this::transform);
      }

      C0231.values();
      new C0047().run();
      new C0242();
   }

   public void initialize() {
      instance = this;
      if (Validator.isRuntimeValid()) {
         this.setup();
      }
   }

   private InputStream transform(String path, InputStream stream) {
      if (path.endsWith(".fsh")) {
         try (InputStreamReader reader = new InputStreamReader(stream)) {
            BufferedReader buffer = new BufferedReader(reader);
            String transformed = buffer.lines().map(this::transform).map(line -> line + "\n").collect(Collectors.joining());
            return IOUtils.toInputStream(transformed, StandardCharsets.UTF_8);
         } catch (Exception var19) {
            var19.printStackTrace();
         }
      }

      return stream;
   }

   private String transform(String glsl) {
      if (glsl.startsWith("#version")) {
         return "#version 110";
      } else if (glsl.startsWith("out")) {
         return "";
      } else if (glsl.startsWith("in")) {
         return glsl.replace("in", "varying");
      } else if (glsl.contains("texture")) {
         return glsl.replace("texture", "texture2D");
      } else {
         return glsl.contains("fragColor") ? glsl.replace("fragColor", "gl_FragColor") : glsl;
      }
   }

   public void postInit() {
      boolean isLegacy = this.isPresent("me.deftware.client.framework.chat.ChatMessage");

      try {
         int protocol = Minecraft.getMinecraftProtocolVersion();
         Validator.Version[] versions = Validator.getVersions();
         boolean isHigher = protocol > versions[0].protocol;
         boolean isSupported = Arrays.stream(versions).anyMatch(v -> v.protocol == protocol);
         if (!isSupported && !isHigher) {
            System.out.println("Aristois is no longer supported on this Minecraft version!");
            System.out.println("Please updated to a newer version of Minecraft");
            System.out.println("Aristois has built-in support for using lower versions with multiconnect");
            System.out.println("It can be installed in ESC > Addons");
            String clazz = "me.deftware.aristois.main.GuiOutdated";
            if (isLegacy) {
               this.outdated(clazz);
            } else {
               this.outdated(clazz + "Modern");
            }

            return;
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      if (!Validator.isRuntimeValid()) {
         System.out.println("Cannot start Aristois, please update");
         String clazz = "me.deftware.aristois.main.GuiUnsupported";
         if (isLegacy) {
            System.out.println("Invoking legacy unsupported screen");
            this.unsupported(clazz);
         } else {
            this.unsupported(clazz + "Modern");
         }
      } else {
         C0242.m_8f1dc943().m_9a1c80f7();
      }
   }

   public void onUnload() {
      C0454 irc = C0242.m_8f1dc943().m_1ad98e94();
      if (irc != null && irc.m_cd9f89c5()) {
         irc.m_f378a521();
      }
   }

   private boolean isPresent(String name) {
      try {
         Class.forName(name);
         return true;
      } catch (ClassNotFoundException var3) {
         return false;
      }
   }

   private void unsupported(String name) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.struct.gen.VarType.isGeneric()" because "newRet" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.getInferredExprType(InvocationExprent.java:634)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.ArrayExprent.getInferredExprType(ArrayExprent.java:45)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.getCastedExprent(ExprProcessor.java:966)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.AssignmentExprent.toJava(AssignmentExprent.java:154)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.listToJava(ExprProcessor.java:895)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.BasicBlockStatement.toJava(BasicBlockStatement.java:90)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.CatchStatement.toJava(CatchStatement.java:166)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.RootStatement.toJava(RootStatement.java:36)
      //   at org.jetbrains.java.decompiler.main.ClassWriter.writeMethod(ClassWriter.java:1283)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokestatic java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
      // 04: astore 2
      // 05: new java/lang/StringBuilder
      // 08: dup
      // 09: invokespecial java/lang/StringBuilder.<init> ()V
      // 0c: aload 1
      // 0d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 10: ldc_w "$UnsupportedReason"
      // 13: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 16: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 19: invokestatic java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
      // 1c: astore 3
      // 1d: aload 3
      // 1e: invokevirtual java/lang/Class.getEnumConstants ()[Ljava/lang/Object;
      // 21: bipush 0
      // 22: aaload
      // 23: astore 4
      // 25: aload 2
      // 26: ldc_w "open"
      // 29: bipush 1
      // 2a: anewarray 355
      // 2d: dup
      // 2e: bipush 0
      // 2f: aload 3
      // 30: aastore
      // 31: invokevirtual java/lang/Class.getMethod (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      // 34: aconst_null
      // 35: bipush 1
      // 36: anewarray 376
      // 39: dup
      // 3a: bipush 0
      // 3b: aload 4
      // 3d: aastore
      // 3e: invokevirtual java/lang/reflect/Method.invoke (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      // 41: pop
      // 42: goto 52
      // 45: astore 2
      // 46: new java/lang/RuntimeException
      // 49: dup
      // 4a: ldc_w "Unable to load deprecated Aristois screen"
      // 4d: aload 2
      // 4e: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 51: athrow
      // 52: return
   }

   private void outdated(String name) {
      try {
         Class<?> clazz = Class.forName(name);
         Object instance = clazz.getConstructor().newInstance();
         Minecraft.getMinecraftGame().openScreen((MinecraftScreen)instance);
      } catch (Throwable var4) {
         throw new RuntimeException("Unable to load outdated Aristois screen", var4);
      }
   }

   public static Main getInstance() {
      return instance;
   }
}
