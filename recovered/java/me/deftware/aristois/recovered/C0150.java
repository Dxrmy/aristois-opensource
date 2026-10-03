package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.ArgumentType;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.input.Mouse;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;

public abstract class C0150 extends GuiScreen {
   protected Queue<Runnable> f_37f92d3c = new ConcurrentLinkedQueue<>();
   protected Queue<Runnable> f_fc732e17 = new ConcurrentLinkedQueue<>();
   protected List<C0163> f_3a3757f5 = new CopyOnWriteArrayList<>();
   protected boolean f_9fef701d = false;
   protected C0170 f_1676ce40 = new C0170(C0170.anonymousthis.f_d3168abd);
   private float f_3dcdccbc = (float)getDisplayWidth();
   private float f_efafb8a0 = (float)getDisplayHeight();

   public C0150(GenericScreen var1) {
      super(var1);
   }

   protected abstract void m_1058ed9a();

   protected void onInitGui() {
      this.getMinecraftScreen()._clearChildren();
      this.f_3a3757f5.clear();
      this.m_1058ed9a();
      this.f_3a3757f5.forEach(C0163::m_1058ed9a);
   }

   protected void onDraw(int var1, int var2, float var3) {
      boolean var4 = false;

      for (C0163 var6 : this.f_3a3757f5) {
         var4 = var6.m_572d14e6(this.m_d945de47((double)var1), this.m_461db524((double)var2), var3, var4);
      }
   }

   protected void onPostDraw(int var1, int var2, float var3) {
      this.f_3a3757f5
         .stream()
         .filter(var0 -> var0.m_75885561() != null)
         .forEach(var4x -> var4x.m_75885561().m_572d14e6(this.m_d945de47((double)var1), this.m_461db524((double)var2), var3, false));
      Runnable var4 = this.f_fc732e17.poll();
      if (var4 != null) {
         var4.run();
      }
   }

   protected void onUpdate() {
      this.f_3a3757f5.forEach(C0163::m_0e265701);
      if (this.f_9fef701d && (this.f_3dcdccbc != (float)GuiScreen.getDisplayWidth() || this.f_efafb8a0 != (float)GuiScreen.getDisplayHeight())) {
         this.f_3dcdccbc = (float)GuiScreen.getDisplayWidth();
         this.f_efafb8a0 = (float)GuiScreen.getDisplayHeight();
         this.onInitGui();
      }

      Runnable var1 = this.f_37f92d3c.poll();
      if (var1 != null) {
         var1.run();
      }
   }

   protected boolean onKeyPressed(int var1, int var2, int var3) {
      for (C0163 var5 : this.f_3a3757f5) {
         if (var5.m_82e0832a(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   protected boolean onKeyReleased(int var1, int var2, int var3) {
      for (C0163 var5 : this.f_3a3757f5) {
         if (var5.m_81405691(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   protected boolean onMouseReleased(int var1, int var2, int var3) {
      for (C0163 var5 : this.f_3a3757f5) {
         if (var5.m_a2722fba(this.m_d945de47((double)var1), this.m_461db524((double)var2), var3)) {
            return true;
         }
      }

      return false;
   }

   protected boolean onMouseClicked(int var1, int var2, int var3) {
      for (C0163 var5 : this.f_3a3757f5) {
         if (var5.m_8407b1bf(this.m_d945de47((double)var1), this.m_461db524((double)var2), var3)) {
            return true;
         }
      }

      return false;
   }

   protected double m_d945de47(double var1) {
      if (this.f_1676ce40.m_d8379fac() != C0170.anonymousthis.f_d3168abd) {
         var1 = Mouse.getMouseX();
      }

      if (this.f_1676ce40.m_d8379fac() == C0170.anonymousthis.f_f2dd6320) {
         var1 *= (double)RenderStack.getScale();
      }

      return var1;
   }

   protected double m_461db524(double var1) {
      if (this.f_1676ce40.m_d8379fac() != C0170.anonymousthis.f_d3168abd) {
         var1 = Mouse.getMouseY();
      }

      if (this.f_1676ce40.m_d8379fac() == C0170.anonymousthis.f_f2dd6320) {
         var1 *= (double)RenderStack.getScale();
      }

      return var1;
   }

   protected C0150 m_ba846326(int var1, int var2, Message... var3) {
      for (Message var7 : var3) {
         this.addCenteredText(var1, var2, var7);
         var2 += 15;
      }

      return this;
   }

   public C0164 m_79f4267e(int var1, int var2, int var3, Message var4, ArgumentType<?> var5) {
      C0164 var6 = new C0164(var1, var2 + FontRenderer.getFontHeight() + 5, var3, 20, var5);
      var6.m_8d564dc2(var4);
      return var6;
   }

   protected C0157 m_c1f9f0d3(int var1, int var2, int var3, Message var4) {
      C0157 var5 = new C0157(var1, var2 + FontRenderer.getFontHeight() + 5, var3, 20);
      var5.m_8d564dc2(var4);
      return var5;
   }

   protected C0154 m_7b83f958(int var1, int var2, float var3, Message var4, Supplier<GuiScreen> var5) {
      return this.m_79273652(var1, var2, var3, var4, () -> Minecraft.getMinecraftGame().openScreen((GenericScreen)var5.get()));
   }

   protected C0154 m_79273652(int var1, int var2, float var3, Message var4, Runnable var5) {
      return this.m_5a1fbc03(var1, var2, var3, var4, var1x -> var5.run());
   }

   protected C0154 m_5a1fbc03(int var1, int var2, float var3, Message var4, final Consumer<C0154> var5) {
      return new C0154(var1, var2, (int)var3, 20, var4) {
         @Override
         public boolean m_1521b1fa(int var1) {
            var5.accept(this);
            return true;
         }
      };
   }

   public GuiScreen m_772dbb91(GenericScreen var1) {
      this.parent = var1;
      return this;
   }

   protected void m_fd4438d8() {
      short var1 = 180;
      this.m_4f7d4126(this.m_79273652(getScaledWidth() / 2 - var1 / 2, getScaledHeight() - 50, (float)var1, Message.of(C0257.m_c42f1c7e()), this::goBack));
   }

   protected boolean m_8407423a(C0157... var1) {
      for (C0157 var5 : var1) {
         if (!var5.m_f21a055b()) {
            return false;
         }
      }

      return true;
   }

   public C0150 m_4f7d4126(C0163... var1) {
      for (C0163 var5 : var1) {
         this.f_3a3757f5.add(var5);
         if (var5 instanceof C0154) {
            this.addComponent((C0154)var5);
         } else if (var5 instanceof C0157) {
            this.addComponent((C0157)var5);
         } else if (var5 instanceof C0161) {
            this.addComponent((C0161)var5);
         }

         if (var5 instanceof C0428) {
            ((C0428)var5).m_394ecb95(this.f_1676ce40.m_89e0519f());
         }
      }

      return this;
   }

   public List<C0163> m_ed46fa58() {
      return this.f_3a3757f5;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_9fef701d = var1;
   }

   public void m_c037c5e2(C0170 var1) {
      this.f_1676ce40 = var1;
   }
}
