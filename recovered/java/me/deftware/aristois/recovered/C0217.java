package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.entity.EntityCapsule;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.inventory.EntityInventory;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.types.FoodItem;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.registry.EntityRegistry;
import me.deftware.client.framework.registry.ItemRegistry;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.InteractableBlock;

public class C0217 {
   public static final String f_e097136a = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",60129542163>()).toLowerCase();
   public static final C0217.anonymousdefault f_24eccff2;
   public static final List<Item> f_596d6937;
   public static final HashMap<Integer, Integer> f_60f0f0a1;

   public C0217() {
   }

   public static boolean m_ecebbce6(String var0) {
      return var0 == null || var0.isEmpty();
   }

   public static void m_7cee49e1(long var0, Runnable var2) {
      C0114.bootstrap<"call",0,1>().schedule(var2, var0, TimeUnit.MILLISECONDS);
   }

   public static <T> T m_0a3c611b(Supplier<T> var0) {
      return (T)var0.get();
   }

   public static long m_18881c73(long var0, long var2) {
      return C0114.bootstrap<"call",1,1>().nextLong(var0, var2 + 1L);
   }

   public static Message m_f853330f(String var0, String var1, FormattingColor var2) {
      Builder var3 = new Builder();
      String[] var4 = C0114.bootstrap<"call",2,1>(var1, 2).split(var0);

      for (int var5 = 0; var5 < var4.length; var5++) {
         String var6 = var4[var5];
         var3.append(var6, C0114.bootstrap<"call",3,1>(var2));
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

         var3.append(var0.substring(var7, var7 + var1.length()), C0114.bootstrap<"call",3,1>(DefaultColors.YELLOW));
      }

      if (var0.equalsIgnoreCase(var1)) {
         var3.append(var0, C0114.bootstrap<"call",3,1>(DefaultColors.YELLOW));
      }

      return var3.build();
   }

   public static boolean m_5935dab6() {
      String var0 = C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",60129542145>());
      return C0114.bootstrap<"call",5,1>() ? var0.matches(C0252.bootstrap<"get",60129542146>()) : false;
   }

   public static String m_3b70c557(String var0) {
      if (var0.contains(C0252.bootstrap<"get",70>())) {
         StringBuilder var1 = new StringBuilder();

         for (String var5 : var0.split(C0252.bootstrap<"get",70>())) {
            var1.append(C0114.bootstrap<"call",0,1>(var5)).append(C0252.bootstrap<"get",70>());
         }

         var0 = var1.toString();
      } else {
         var0 = C0114.bootstrap<"call",0,1>(var0);
      }

      return var0;
   }

   private static String m_553dbff4(String var0) {
      return var0.substring(0, 1).toUpperCase() + var0.substring(1);
   }

   public static boolean m_06cd86f1() {
      return C0114.bootstrap<"call",1,1>() > 498;
   }

   public static UUID m_a0684c86(String var0) {
      return var0.contains(C0252.bootstrap<"get",4294967313>())
         ? C0114.bootstrap<"call",0,1>(var0)
         : C0114.bootstrap<"call",0,1>(var0.replaceFirst(C0252.bootstrap<"get",4294967342>(), C0252.bootstrap<"get",4294967343>()));
   }

   public static boolean m_0284a5de(String var0) {
      try {
         C0114.bootstrap<"call",0,1>(var0);
         return true;
      } catch (Throwable var2) {
         return false;
      }
   }

   public static void m_f21c33f5(String var0, Runnable var1, Runnable var2) {
      Settings var3 = C0114.bootstrap<"call",6,1>();
      if (!var3.hasKey(var0)) {
         var3.putPrimitive(var0, true);
         var1.run();
      } else if (var2 != null) {
         var2.run();
      }
   }

   public static Color m_746c8773(double var0, Color var2, Color var3) {
      int var4 = (int)C0114.bootstrap<"call",7,1>(var0 * (double)var2.getRed() + (1.0 - var0) * (double)var3.getRed());
      int var5 = (int)C0114.bootstrap<"call",7,1>(var0 * (double)var2.getGreen() + (1.0 - var0) * (double)var3.getGreen());
      int var6 = (int)C0114.bootstrap<"call",7,1>(var0 * (double)var2.getBlue() + (1.0 - var0) * (double)var3.getBlue());
      return new Color(var4, var5, var6);
   }

   public static List<Field> m_6d8c949b(Class<?> var0) {
      return C0114.bootstrap<"call",8,1>(var0.getDeclaredFields())
         .filter(var0x -> var0x.isAnnotationPresent(SerializedName.class))
         .peek(var0x -> var0x.setAccessible(true))
         .collect(C0114.bootstrap<"call",9,1>());
   }

   public static C0196<Block> m_40460c49(GenericScreen var0, C0219<Block> var1) {
      return new C0196(
         var0,
         Block.class,
         var1,
         BlockRegistry.INSTANCE,
         C0252.bootstrap<"get",60129542147>() + (var1 == null ? C0252.bootstrap<"get",60129542148>() : C0252.bootstrap<"get",12884901914>()),
         var0x -> var0x.getName().string()
      );
   }

   public static C0196<Item> m_849affbd(GenericScreen var0, C0219<Item> var1) {
      return new C0196(
         var0,
         Item.class,
         var1,
         ItemRegistry.INSTANCE,
         C0252.bootstrap<"get",60129542149>() + (var1 == null ? C0252.bootstrap<"get",60129542148>() : C0252.bootstrap<"get",12884901914>()),
         var0x -> var0x.getName().string()
      );
   }

   public static C0196<EntityCapsule> m_7d0b53a4(GenericScreen var0, C0219<EntityCapsule> var1) {
      return new C0196(
         var0,
         EntityCapsule.class,
         var1,
         EntityRegistry.INSTANCE,
         C0252.bootstrap<"get",60129542150>() + (var1 == null ? C0252.bootstrap<"get",60129542151>() : C0252.bootstrap<"get",60129542152>()),
         var0x -> var0x.getName().string()
      );
   }

   public static Predicate<Item> m_399fd29c() {
      return var0 -> var0 instanceof FoodItem && !f_596d6937.contains(var0);
   }

   public static EntityHand m_24ac7710(EntityInventory var0, Item var1) {
      return C0114.bootstrap<"call",10,1>(var0, var1x -> var1x.equals(var1));
   }

   public static EntityHand m_d871dd54(EntityInventory var0, Predicate<Item> var1) {
      if (var1.test(var0.getHeldItem(false).getItem())) {
         return EntityHand.MainHand;
      } else {
         return var1.test(var0.getHeldItem(true).getItem()) ? EntityHand.OffHand : EntityHand.OffHand;
      }
   }

   public static int m_b798500b(Inventory var0, int var1, Predicate<Item> var2) {
      for (int var3 = 0; var3 < var1; var3++) {
         if (var2.test(var0.getStackInSlot(var3).getItem())) {
            return var3;
         }
      }

      return -1;
   }

   public static void m_27b54f1e(Runnable var0) {
      C0114.bootstrap<"call",11,1>(var0);
   }

   public static void m_cf170b64(Runnable var0, long var1) {
      C0114.bootstrap<"call",0,1>().scheduleAtFixedRate(var0, 0L, var1, TimeUnit.MILLISECONDS);
   }

   public static <T> CompletableFuture<T> m_ac63600c(Supplier<T> var0) {
      return C0114.bootstrap<"call",2,1>(var0);
   }

   public static <T> void m_f2505352(Supplier<T> var0, Consumer<T> var1) {
      C0114.bootstrap<"call",12,1>(var0).thenAccept(var1);
   }

   public static boolean m_d4bf17ee() {
      BlockSwingResult var0 = C0114.bootstrap<"call",1,1>().getHitBlock();
      return var0 != null && var0.getBlock() instanceof InteractableBlock;
   }

   @SafeVarargs
   public static <T> HashMap<T, T> m_c7500b5e(T... var0) {
      HashMap var1 = new HashMap();

      for (int var2 = 1; var2 <= var0.length; var2++) {
         if (var2 % 2 == 0) {
            var1.put(var0[var2 - 2], var0[var2 - 1]);
         }
      }

      return var1;
   }

   public static <T, E> HashMap<T, E> m_8ffc2215(Object... var0) {
      HashMap var1 = new HashMap();

      for (int var2 = 1; var2 <= var0.length; var2++) {
         if (var2 % 2 == 0) {
            var1.put(var0[var2 - 2], var0[var2 - 1]);
         }
      }

      return var1;
   }

   public static String m_740ff607(File var0) throws IOException {
      return C0114.bootstrap<"call",15,1>(
         C0252.bootstrap<"get",60129542153>(),
         C0114.bootstrap<"call",14,1>(C0114.bootstrap<"call",13,1>(var0.getAbsolutePath(), new String[0]), StandardCharsets.UTF_8)
      );
   }

   public static String m_7b0eb3a5(int var0) {
      for (int var2 : f_60f0f0a1.keySet()) {
         if (f_60f0f0a1.get(C0114.bootstrap<"call",16,1>(var2)) == var0) {
            return C0114.bootstrap<"call",17,1>(var2);
         }
      }

      return C0252.bootstrap<"get",30064771104>();
   }

   public static Block[] m_99e8e90a() {
      List var0 = C0114.bootstrap<"call",1,1>(
         BlockRegistry.INSTANCE,
         new String[]{
            C0252.bootstrap<"get",30064771128>(),
            C0252.bootstrap<"get",30064771129>(),
            C0252.bootstrap<"get",4294967376>(),
            C0252.bootstrap<"get",30064771127>(),
            C0252.bootstrap<"get",30064771130>(),
            C0252.bootstrap<"get",4294967375>(),
            C0252.bootstrap<"get",30064771132>(),
            C0252.bootstrap<"get",30064771131>(),
            C0252.bootstrap<"get",30064771135>(),
            C0252.bootstrap<"get",60129542154>(),
            C0252.bootstrap<"get",60129542155>(),
            C0252.bootstrap<"get",60129542156>(),
            C0252.bootstrap<"get",30064771117>(),
            C0252.bootstrap<"get",30064771118>(),
            C0252.bootstrap<"get",60129542157>(),
            C0252.bootstrap<"get",30064771121>(),
            C0252.bootstrap<"get",60129542158>(),
            C0252.bootstrap<"get",60129542159>(),
            C0252.bootstrap<"get",30064771133>()
         }
      );
      if (C0213.f_57699eb8.m_093ae25a()) {
         var0.addAll(C0114.bootstrap<"call",2,1>(BlockRegistry.INSTANCE, var0x -> {
            String var1 = var0x.getName().toString().toLowerCase();
            return var1.contains(C0252.bootstrap<"get",60129542161>()) && var1.contains(C0252.bootstrap<"get",60129542162>());
         }));
      }

      return var0.toArray(new Block[0]);
   }

   public static int m_17a6d8d4(Callable<Integer> var0) {
      return C0114.bootstrap<"call",18,1>(var0, false);
   }

   public static int m_ebd9d74d(Callable<Integer> var0, boolean var1) {
      try {
         return (Integer)var0.call();
      } catch (Exception var3) {
         var3.printStackTrace();
         if (var1) {
            C0114.bootstrap<"call",19,1>().m_5de8d0b8(C0252.bootstrap<"get",60129542160>(), var3.getMessage()).m_9d59fbe9();
         }

         return -1;
      }
   }

   public static String m_aaccd313() {
      return f_e097136a;
   }

   public static C0217.anonymousdefault m_afa47898() {
      return f_24eccff2;
   }

   static {
      if (f_e097136a.contains(C0252.bootstrap<"get",60129542164>()) || f_e097136a.contains(C0252.bootstrap<"get",60129542165>())) {
         f_24eccff2 = C0217.anonymousdefault.f_49393542;
      } else if (f_e097136a.contains(C0252.bootstrap<"get",60129542166>())) {
         f_24eccff2 = C0217.anonymousdefault.f_abf55136;
      } else {
         f_24eccff2 = C0217.anonymousdefault.f_d5228704;
      }

      f_596d6937 = C0114.bootstrap<"call",1,1>(
         ItemRegistry.INSTANCE,
         new String[]{
            C0252.bootstrap<"get",60129542167>(),
            C0252.bootstrap<"get",60129542168>(),
            C0252.bootstrap<"get",60129542169>(),
            C0252.bootstrap<"get",60129542170>(),
            C0252.bootstrap<"get",60129542171>()
         }
      );
      f_60f0f0a1 = C0114.bootstrap<"call",3,1>(
         new Integer[]{
            C0114.bootstrap<"call",2,1>(342),
            C0114.bootstrap<"call",2,1>(4),
            C0114.bootstrap<"call",2,1>(346),
            C0114.bootstrap<"call",2,1>(4),
            C0114.bootstrap<"call",2,1>(340),
            C0114.bootstrap<"call",2,1>(1),
            C0114.bootstrap<"call",2,1>(344),
            C0114.bootstrap<"call",2,1>(1),
            C0114.bootstrap<"call",2,1>(341),
            C0114.bootstrap<"call",2,1>(2),
            C0114.bootstrap<"call",2,1>(345),
            C0114.bootstrap<"call",2,1>(2)
         }
      );
   }

   public static enum anonymousdefault {
      f_abf55136,
      f_d5228704,
      f_49393542,
      f_d756309c;

      private anonymousdefault() {
      }
   }

   public interface anonymousthis extends ListItem {
      String m_35ba7118();

      default void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
         C0114.bootstrap<"call",2,1>(
            C0114.bootstrap<"call",0,1>(this.m_35ba7118()), var2 + 28, var3 + (var5 / 2 - C0114.bootstrap<"call",1,1>() / 2) - 3, 16777215
         );
      }
   }
}
