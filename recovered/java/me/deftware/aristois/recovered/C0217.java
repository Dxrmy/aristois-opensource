package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.entity.EntityCapsule;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.inventory.EntityInventory;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.types.FoodItem;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.registry.EntityRegistry;
import me.deftware.client.framework.registry.ItemRegistry;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.util.path.OSUtils;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.InteractableBlock;

public class C0217 {
   public static final String f_9644f226 = System.getProperty(C0258.m_b251ca51()).toLowerCase();
   public static final C0217.anonymousdefault f_99fecb28;
   public static final List<Item> f_e8d94395;
   public static final HashMap<Integer, Integer> f_c363c3c8;

   public C0217() {
   }

   public static boolean m_828a75ae(String var0) {
      return var0 == null || var0.isEmpty();
   }

   public static void m_124336d4(long var0, Runnable var2) {
      Executors.newSingleThreadScheduledExecutor().schedule(var2, var0, TimeUnit.MILLISECONDS);
   }

   public static <T> T m_924c66cb(Supplier<T> var0) {
      return (T)var0.get();
   }

   public static long m_46bbaa2a(long var0, long var2) {
      return ThreadLocalRandom.current().nextLong(var0, var2 + 1L);
   }

   public static Message m_f2d473b9(String var0, String var1, FormattingColor var2) {
      Builder var3 = new Builder();
      String[] var4 = Pattern.compile(var1, 2).split(var0);

      for (int var5 = 0; var5 < var4.length; var5++) {
         String var6 = var4[var5];
         var3.append(var6, Appearance.of(var2));
         int var7 = 0;

         for (int var8 = 0; var8 <= var5; var8++) {
            var7 += var4[var8].length();
            if (var8 >= 1) {
               var7 += var1.length();
            }
         }

         if (var7 == var0.length()) {
            if (!var0.endsWith(var1)) {
               break;
            }

            var7--;
         }

         var3.append(var0.substring(var7, var7 + var1.length()), Appearance.of(DefaultColors.YELLOW));
      }

      if (var0.equalsIgnoreCase(var1)) {
         var3.append(var0, Appearance.of(DefaultColors.YELLOW));
      }

      return var3.build();
   }

   public static boolean m_efa7610e() {
      String var0 = System.getProperty(C0258.m_813e3509());
      return OSUtils.isMac() ? var0.matches(C0258.m_3855be80()) : false;
   }

   public static String m_d46f830f(String var0) {
      if (var0.contains(C0257.m_593ecbab())) {
         StringBuilder var1 = new StringBuilder();

         for (String var5 : var0.split(C0257.m_593ecbab())) {
            var1.append(m_2beb0f7e(var5)).append(C0257.m_593ecbab());
         }

         var0 = var1.toString();
      } else {
         var0 = m_2beb0f7e(var0);
      }

      return var0;
   }

   private static String m_2beb0f7e(String var0) {
      return var0.substring(0, 1).toUpperCase() + var0.substring(1);
   }

   public static boolean m_9362a920() {
      return Minecraft.getMinecraftProtocolVersion() > 498;
   }

   public static UUID m_edf212e5(String var0) {
      return var0.contains(C0264.m_18204724()) ? UUID.fromString(var0) : UUID.fromString(var0.replaceFirst(C0264.m_68957b31(), C0264.m_4e02e7a9()));
   }

   public static boolean m_b09e5caa(String var0) {
      try {
         Class.forName(var0);
         return true;
      } catch (Throwable var2) {
         return false;
      }
   }

   public static void m_925db449(String var0, Runnable var1, Runnable var2) {
      Settings var3 = Main.getConfig();
      if (!var3.hasKey(var0)) {
         var3.putPrimitive(var0, true);
         var1.run();
      } else if (var2 != null) {
         var2.run();
      }
   }

   public static Color m_4771a9db(double var0, Color var2, Color var3) {
      int var4 = (int)Math.abs(var0 * (double)var2.getRed() + (1.0 - var0) * (double)var3.getRed());
      int var5 = (int)Math.abs(var0 * (double)var2.getGreen() + (1.0 - var0) * (double)var3.getGreen());
      int var6 = (int)Math.abs(var0 * (double)var2.getBlue() + (1.0 - var0) * (double)var3.getBlue());
      return new Color(var4, var5, var6);
   }

   public static List<Field> m_dff4e28f(Class<?> var0) {
      return Arrays.stream(var0.getDeclaredFields())
         .filter(var0x -> var0x.isAnnotationPresent(SerializedName.class))
         .peek(var0x -> var0x.setAccessible(true))
         .collect(Collectors.toList());
   }

   public static C0196<Block> m_20baf8c9(GenericScreen var0, C0219<Block> var1) {
      return new C0196(
         var0,
         Block.class,
         var1,
         BlockRegistry.INSTANCE,
         C0258.m_a9247108() + (var1 == null ? C0258.m_4626ac74() : C0266.m_7b0db73e()),
         var0x -> var0x.getName().string()
      );
   }

   public static C0196<Item> m_81b76da4(GenericScreen var0, C0219<Item> var1) {
      return new C0196(
         var0,
         Item.class,
         var1,
         ItemRegistry.INSTANCE,
         C0258.m_c688f8ca() + (var1 == null ? C0258.m_4626ac74() : C0266.m_7b0db73e()),
         var0x -> var0x.getName().string()
      );
   }

   public static C0196<EntityCapsule> m_c1fb6c03(GenericScreen var0, C0219<EntityCapsule> var1) {
      return new C0196(
         var0,
         EntityCapsule.class,
         var1,
         EntityRegistry.INSTANCE,
         C0258.m_35cdaa1a() + (var1 == null ? C0258.m_624b40d8() : C0258.m_8d7dbe31()),
         var0x -> var0x.getName().string()
      );
   }

   public static Predicate<Item> m_cba00437() {
      return var0 -> var0 instanceof FoodItem && !f_e8d94395.contains(var0);
   }

   public static EntityHand m_6094ce8a(EntityInventory var0, Item var1) {
      return m_cd81d441(var0, var1x -> var1x.equals(var1));
   }

   public static EntityHand m_cd81d441(EntityInventory var0, Predicate<Item> var1) {
      if (var1.test(var0.getHeldItem(false).getItem())) {
         return EntityHand.MainHand;
      } else {
         return var1.test(var0.getHeldItem(true).getItem()) ? EntityHand.OffHand : EntityHand.OffHand;
      }
   }

   public static int m_29c83797(Inventory var0, int var1, Predicate<Item> var2) {
      for (int var3 = 0; var3 < var1; var3++) {
         if (var2.test(var0.getStackInSlot(var3).getItem())) {
            return var3;
         }
      }

      return -1;
   }

   public static void m_c162d659(Runnable var0) {
      CompletableFuture.runAsync(var0);
   }

   public static void m_1d393e3f(Runnable var0, long var1) {
      Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(var0, 0L, var1, TimeUnit.MILLISECONDS);
   }

   public static <T> CompletableFuture<T> m_abf59b51(Supplier<T> var0) {
      return CompletableFuture.supplyAsync(var0);
   }

   public static <T> void m_35a6ad75(Supplier<T> var0, Consumer<T> var1) {
      m_abf59b51(var0).thenAccept(var1);
   }

   public static boolean m_51ce03a5() {
      BlockSwingResult var0 = Minecraft.getMinecraftGame().getHitBlock();
      return var0 != null && var0.getBlock() instanceof InteractableBlock;
   }

   @SafeVarargs
   public static <T> HashMap<T, T> m_5f8a4d99(T... var0) {
      HashMap var1 = new HashMap();

      for (int var2 = 1; var2 <= var0.length; var2++) {
         if (var2 % 2 == 0) {
            var1.put(var0[var2 - 2], var0[var2 - 1]);
         }
      }

      return var1;
   }

   public static <T, E> HashMap<T, E> m_aa59ab61(Object... var0) {
      HashMap var1 = new HashMap();

      for (int var2 = 1; var2 <= var0.length; var2++) {
         if (var2 % 2 == 0) {
            var1.put(var0[var2 - 2], var0[var2 - 1]);
         }
      }

      return var1;
   }

   public static String m_4d15c777(File var0) throws IOException {
      return String.join(C0258.m_1d87ef21(), Files.readAllLines(Paths.get(var0.getAbsolutePath()), StandardCharsets.UTF_8));
   }

   public static String m_d0cd04ec(int var0) {
      for (int var2 : f_c363c3c8.keySet()) {
         if (f_c363c3c8.get(var2) == var0) {
            return Keyboard.getKeyName(var2);
         }
      }

      return C0265.m_88937f2b();
   }

   public static Block[] m_1bf3a42e() {
      List var0 = C0207.m_2290cbf8(
         BlockRegistry.INSTANCE,
         C0265.m_cc27b633(),
         C0265.m_df6e621c(),
         C0264.m_d0e43f69(),
         C0265.m_23f794da(),
         C0265.m_56242a84(),
         C0264.m_e7934778(),
         C0265.m_af41331f(),
         C0265.m_9e27f038(),
         C0265.m_15737526(),
         C0258.m_c42f1c7e(),
         C0258.m_6f1f396d(),
         C0258.m_8ced16bd(),
         C0265.m_760db7bb(),
         C0265.m_68957b31(),
         C0258.m_15ef1a0d(),
         C0265.m_b89b7876(),
         C0258.m_9793dfe2(),
         C0258.m_1635bc47(),
         C0265.m_f257bcca()
      );
      if (C0213.f_17e12451.m_efa7610e()) {
         var0.addAll(C0207.m_ffe8ab8f(BlockRegistry.INSTANCE, var0x -> {
            String var1 = var0x.getName().toString().toLowerCase();
            return var1.contains(C0258.m_18204724()) && var1.contains(C0258.m_cf4f91f1());
         }));
      }

      return var0.toArray(new Block[0]);
   }

   public static int m_7a4f2a3d(Callable<Integer> var0) {
      return m_2cb9a1b2(var0, false);
   }

   public static int m_2cb9a1b2(Callable<Integer> var0, boolean var1) {
      try {
         return (Integer)var0.call();
      } catch (Exception var3) {
         var3.printStackTrace();
         if (var1) {
            C0064.m_b79f2e94().m_ecf8e7ae(C0258.m_d597c122(), var3.getMessage()).m_b728afce();
         }

         return -1;
      }
   }

   public static String m_8ced16bd() {
      return f_9644f226;
   }

   public static C0217.anonymousdefault m_0f84527e() {
      return f_99fecb28;
   }

   static {
      if (f_9644f226.contains(C0258.m_b48a8bc4()) || f_9644f226.contains(C0258.m_b886ae1c())) {
         f_99fecb28 = C0217.anonymousdefault.f_0edc9299;
      } else if (f_9644f226.contains(C0258.m_bec91365())) {
         f_99fecb28 = C0217.anonymousdefault.f_52ec5e75;
      } else {
         f_99fecb28 = C0217.anonymousdefault.f_b08bcbec;
      }

      f_e8d94395 = C0207.m_2290cbf8(ItemRegistry.INSTANCE, C0258.m_79bfaec2(), C0258.m_2e834348(), C0258.m_e07cee76(), C0258.m_7b0db73e(), C0258.m_056a389d());
      f_c363c3c8 = m_5f8a4d99(342, 4, 346, 4, 340, 1, 344, 1, 341, 2, 345, 2);
   }

   public static enum anonymousdefault {
      f_52ec5e75,
      f_b08bcbec,
      f_0edc9299,
      f_ca235988;

      private anonymousdefault() {
      }
   }

   public interface anonymousthis extends ListItem {
      String m_6f1f396d();

      default void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
         FontRenderer.drawString(Message.of(this.m_6f1f396d()), var2 + 28, var3 + (var5 / 2 - FontRenderer.getFontHeight() / 2) - 3, 16777215);
      }
   }
}
