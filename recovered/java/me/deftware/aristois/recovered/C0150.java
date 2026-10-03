package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.ArgumentType;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;

public abstract class C0150 extends GuiScreen {
   protected Queue<Runnable> f_8e775fc5 = new ConcurrentLinkedQueue<>();
   protected Queue<Runnable> f_8da9ac7f = new ConcurrentLinkedQueue<>();
   protected List<C0163> f_28e409a6 = new CopyOnWriteArrayList<>();
   protected boolean f_b3be3666 = false;
   protected C0170 f_fc552245 = new C0170(C0170.anonymousthis.f_30166e29);
   private float f_9f22f031 = (float)C0114.bootstrap<"call",0,1>();
   private float f_e502bfdf = (float)C0114.bootstrap<"call",1,1>();

   public C0150(GenericScreen var1) {
      super(var1);
   }

   protected abstract void m_83a81c97();

   protected void onInitGui() {
      this.getMinecraftScreen()._clearChildren();
      this.f_28e409a6.clear();
      this.m_83a81c97();
      this.f_28e409a6.forEach(C0163::m_6b155392);
   }

   protected void onDraw(int var1, int var2, float var3) {
      boolean var4 = false;

      for (C0163 var6 : this.f_28e409a6) {
         var4 = var6.m_2f338522(this.m_9cbbf5a4((double)var1), this.m_95c2b8b3((double)var2), var3, var4);
      }
   }

   protected void onPostDraw(int var1, int var2, float var3) {
      this.f_28e409a6
         .stream()
         .filter(var0 -> var0.m_bb20fb08() != null)
         .forEach(var4x -> var4x.m_bb20fb08().m_92696976(this.m_9cbbf5a4((double)var1), this.m_95c2b8b3((double)var2), var3, false));
      Runnable var4 = this.f_8da9ac7f.poll();
      if (var4 != null) {
         var4.run();
      }
   }

   protected void onUpdate() {
      this.f_28e409a6.forEach(C0163::m_e103589e);
      if (this.f_b3be3666 && (this.f_9f22f031 != (float)C0114.bootstrap<"call",0,1>() || this.f_e502bfdf != (float)C0114.bootstrap<"call",1,1>())) {
         this.f_9f22f031 = (float)C0114.bootstrap<"call",0,1>();
         this.f_e502bfdf = (float)C0114.bootstrap<"call",1,1>();
         this.onInitGui();
      }

      Runnable var1 = this.f_8e775fc5.poll();
      if (var1 != null) {
         var1.run();
      }
   }

   protected boolean onKeyPressed(int var1, int var2, int var3) {
      for (C0163 var5 : this.f_28e409a6) {
         if (var5.m_fd40ceb2(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   protected boolean onKeyReleased(int var1, int var2, int var3) {
      for (C0163 var5 : this.f_28e409a6) {
         if (var5.m_80d40b65(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   protected boolean onMouseReleased(int var1, int var2, int var3) {
      for (C0163 var5 : this.f_28e409a6) {
         if (var5.m_73c37f1a(this.m_9cbbf5a4((double)var1), this.m_95c2b8b3((double)var2), var3)) {
            return true;
         }
      }

      return false;
   }

   protected boolean onMouseClicked(int var1, int var2, int var3) {
      for (C0163 var5 : this.f_28e409a6) {
         if (var5.m_7e41b969(this.m_9cbbf5a4((double)var1), this.m_95c2b8b3((double)var2), var3)) {
            return true;
         }
      }

      return false;
   }

   protected double m_9cbbf5a4(double var1) {
      if (this.f_fc552245.m_f29c6a39() != C0170.anonymousthis.f_30166e29) {
         var1 = C0114.bootstrap<"call",0,1>();
      }

      if (this.f_fc552245.m_f29c6a39() == C0170.anonymousthis.f_4b51c068) {
         var1 *= (double)C0114.bootstrap<"call",1,1>();
      }

      return var1;
   }

   protected double m_95c2b8b3(double var1) {
      if (this.f_fc552245.m_f29c6a39() != C0170.anonymousthis.f_30166e29) {
         var1 = C0114.bootstrap<"call",0,1>();
      }

      if (this.f_fc552245.m_f29c6a39() == C0170.anonymousthis.f_4b51c068) {
         var1 *= (double)C0114.bootstrap<"call",1,1>();
      }

      return var1;
   }

   protected C0150 m_85ec1792(int var1, int var2, Message... var3) {
      for (Message var7 : var3) {
         this.addCenteredText(var1, var2, var7);
         var2 += 15;
      }

      return this;
   }

   public C0164 m_96a83982(int var1, int var2, int var3, Message var4, ArgumentType<?> var5) {
      C0164 var6 = new C0164(var1, var2 + C0114.bootstrap<"call",2,1>() + 5, var3, 20, var5);
      var6.m_1764a806(var4);
      return var6;
   }

   protected C0157 m_135bf7e8(int var1, int var2, int var3, Message var4) {
      C0157 var5 = new C0157(var1, var2 + C0114.bootstrap<"call",2,1>() + 5, var3, 20);
      var5.m_f260ed14(var4);
      return var5;
   }

   protected C0154 m_652e51a7(int var1, int var2, float var3, Message var4, Supplier<GuiScreen> var5) {
      return this.m_8803dae3(var1, var2, var3, var4, () -> C0114.bootstrap<"call",3,1>().openScreen((GenericScreen)var5.get()));
   }

   protected C0154 m_8803dae3(int var1, int var2, float var3, Message var4, Runnable var5) {
      return this.m_0447bd6d(var1, var2, var3, var4, var1x -> var5.run());
   }

   protected C0154 m_0447bd6d(int var1, int var2, float var3, Message var4, final Consumer<C0154> var5) {
      return new C0154(var1, var2, (int)var3, 20, var4) {
         public boolean m_f2e616af(int var1) {
            var5.accept(this);
            return true;
         }
      };
   }

   public GuiScreen m_8d846d1c(GenericScreen var1) {
      this.parent = var1;
      return this;
   }

   protected void m_a415c4df() {
      short var1 = 180;
      this.m_ef389a68(
         this.m_8803dae3(
            C0114.bootstrap<"call",0,1>() / 2 - var1 / 2,
            C0114.bootstrap<"call",1,1>() - 50,
            (float)var1,
            C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",10>()),
            this::goBack
         )
      );
   }

   protected boolean m_e8141714(C0157... var1) {
      for (C0157 var5 : var1) {
         if (!var5.m_e439f254()) {
            return false;
         }
      }

      return true;
   }

   public C0150 m_ef389a68(C0163... var1) {
      for (C0163 var5 : var1) {
         this.f_28e409a6.add(var5);
         if (var5 instanceof C0154) {
            this.addComponent((C0154)var5);
         } else if (var5 instanceof C0157) {
            this.addComponent((C0157)var5);
         } else if (var5 instanceof C0161) {
            this.addComponent((C0161)var5);
         }

         if (var5 instanceof C0428) {
            ((C0428)var5).m_efd468d7(this.f_fc552245.m_879f24b8());
         }
      }

      return this;
   }

   public List<C0163> m_dcccdb46() {
      return this.f_28e409a6;
   }

   public void m_c742a154(boolean var1) {
      this.f_b3be3666 = var1;
   }

   public void m_5df4a615(C0170 var1) {
      this.f_fc552245 = var1;
   }
}
