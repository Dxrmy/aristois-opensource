package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.ArgumentType;
import java.util.function.Function;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.IRegistry;
import me.deftware.client.framework.render.gl.GLX;

public class C0196<T extends ListItem> extends C0188<T> {
   private final C0219<T> f_6983919f;
   private C0157 f_acd7d8c5;
   private ArgumentType<T> f_a545e2a1;

   public C0196(GenericScreen var1, C0219<T> var2, IRegistry<T, ?> var3, String var4, Function<T, String> var5) {
      this(var1, var2.m_5ce6615d(), var2, var3, var4, var5);
   }

   public C0196(GenericScreen var1, Class<T> var2, C0219<T> var3, IRegistry<T, ?> var4, String var5, Function<T, String> var6) {
      this(var1, var2, var3, new C0205<>(var2, var4, var6), var5);
   }

   public C0196(GenericScreen var1, Class<T> var2, C0219<T> var3, C0205<T> var4, String var5) {
      super(var1, var4);
      ((C0205)this.m_a2a4e197()).m_21736e90(this.f_6983919f = var3);
      this.f_a451d159 = this.f_6983919f != null;
      this.f_3dd96e1d = var5;
   }

   @Override
   protected void m_e02771ba() {
      ((C0205)this.m_a2a4e197()).m_d6ac7420(false);
      this.m_fcb36bc0();
   }

   public C0196<T> m_905d5fd2(ArgumentType<T> var1) {
      this.f_a545e2a1 = var1;
      return this;
   }

   protected C0219<T> m_6290fc66() {
      return this.f_6983919f;
   }

   @Override
   protected boolean onMouseClicked(int var1, int var2, int var3) {
      ListItem var4 = this.f_1d8ec2c9.getHoveredItem(var1, var2);
      if (var4 != null && var1 > this.getGuiScreenWidth() - 100) {
         if (this.f_6983919f.contains(var4)) {
            this.f_6983919f.remove(var4);
         } else {
            this.f_6983919f.add((T)var4);
         }
      }

      return super.onMouseClicked(var1, var2, var3);
   }

   @Override
   protected void m_9dfc6493(T var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {
      if (this.f_6983919f != null) {
         byte var10 = 20;
         int var11 = this.getGuiScreenWidth() - 100;
         int var12 = var4 + (this.f_751e4f27 / 2 - var10 / 2) - 2;
         boolean var13 = var7 > var11 && var7 < var11 + var10 && var8 > var12 && var8 < var12 + var10;
         GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
         C0228.f_7bf45835.bind().draw(var11, var12, var10, var10, var13 ? 20 : 0, this.f_6983919f.contains(var1) ? 20 : 0, 64, 64).unbind();
      }
   }

   @Override
   protected void m_1058ed9a() {
      super.m_1058ed9a();
      this.f_1d8ec2c9.setExtended(true);
      this.m_4f7d4126(new C0163[]{this.f_acd7d8c5 = (new C0164(40, 10, 120, 20, this.f_a545e2a1) {
         @Override
         protected void m_b728afce() {
            C0196.this.m_fcb36bc0();
         }
      }).m_407926d1(C0261.m_62895921())});
      if (this.f_a451d159) {
         C0154 var1 = this.m_79273652(
            getScaledWidth() - (this.f_6983919f != null && this.f_6983919f.m_a2a4e197().isEmpty() ? 55 : 80),
            10,
            20.0F,
            Message.of(C0261.m_ec4ef19a()),
            () -> {
               ((C0205)this.m_a2a4e197()).m_d6ac7420(!((C0205)this.m_a2a4e197()).m_5d86ac37());
               this.m_fcb36bc0();
            }
         );
         var1.m_c7a3618c(new C0153(var1, Message.of(C0261.m_83f6dd00())));
         this.m_4f7d4126(new C0163[]{var1});
      }

      this.m_fcb36bc0();
   }

   public void m_528060c0() {
      ((C0205)this.m_a2a4e197()).m_37118aff();
   }

   protected void m_fcb36bc0() {
      ((C0205)this.m_a2a4e197()).m_256015fc(this.f_acd7d8c5.m_e9914bd3());
      this.f_1d8ec2c9.setScrollbarPosition(0);
   }

   public C0219<T> m_8b1167e8() {
      return this.f_6983919f;
   }

   public C0157 m_5c944af5() {
      return this.f_acd7d8c5;
   }

   public ArgumentType<T> m_e0f61899() {
      return this.f_a545e2a1;
   }
}
