package me.deftware.aristois.recovered;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.item.IItem;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0164 extends C0157 {
   private final CommandDispatcher<Object> f_78901dc0 = new CommandDispatcher();
   private ParseResults<Object> f_86210596;
   private Suggestions f_9ca7b2bd;
   private ItemStack f_a2141a63;
   private final ArgumentType<?> f_2d2e20c0;
   private final String f_ed532e1a = C0252.bootstrap<"get",12884901897>();
   private String f_ddf5dd58 = "";
   private boolean f_418a1842 = true;

   public C0164(int var1, int var2, int var3, int var4, ArgumentType<?> var5) {
      super(var1, var2, var3, var4);
      this.f_2d2e20c0 = var5;
      if (var5 != null) {
         this.f_78901dc0
            .register(
               (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901897>())
                  .then(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",25769803852>(), var5).executes(var0 -> 1))
            );
         this.m_db7e2cbb(this.m_852a4be7());
      }

      this.m_0f07aaa2(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",25769803853>()).style(C0114.bootstrap<"call",3,1>(DefaultColors.DARK_GRAY)));
      this.f_ed532e1a = C0252.bootstrap<"get",12884901897>();
   }

   public boolean m_cdfe0a78(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_f4b6dd30(var1, var3, var5, var6);
      if (this.f_9ca7b2bd != null) {
         Message var7 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803854>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.RED));
         int var8 = this.getPositionX() + 4 + C0114.bootstrap<"call",2,1>(this.m_852a4be7());
         if (this.m_852a4be7().isEmpty()) {
            var7 = C0197.f_716a73fa.style(C0114.bootstrap<"call",1,1>(DefaultColors.DARK_GRAY));
         } else if (!this.f_9ca7b2bd.getList().isEmpty()) {
            Suggestion var9 = (Suggestion)this.f_9ca7b2bd.getList().get(0);
            var7 = C0114.bootstrap<"call",0,1>(
                  var9.apply(C0252.bootstrap<"get",25769803855>() + this.m_852a4be7())
                     .substring(C0252.bootstrap<"get",12884901897>().length() + 1 + this.m_852a4be7().length())
               )
               .style(C0114.bootstrap<"call",1,1>(DefaultColors.DARK_GRAY));
         } else {
            var8 = (int)((double)this.getPositionX() + this.m_2f9743b7().m_830cb294() - (double)C0114.bootstrap<"call",3,1>(var7) - 5.0);
         }

         if (this.f_a2141a63 != null) {
            this.f_a2141a63.renderItemIntoGUI((int)((double)this.getPositionX() + this.m_2f9743b7().m_830cb294() - 20.0), this.getPositionY() + 2);
         } else {
            C0114.bootstrap<"call",4,1>(var7, var8, (int)((double)this.getPositionY() + (this.m_2f9743b7().m_fc7f45bc() - 8.0) / 2.0), 16777215);
         }
      }

      return var6;
   }

   public void m_9cbf8678() {
      if (!this.f_ddf5dd58.equalsIgnoreCase(this.m_852a4be7())) {
         this.f_ddf5dd58 = this.m_852a4be7();
         this.m_db7e2cbb(this.m_852a4be7());
      }

      super.m_d3298760();
   }

   public void m_db7e2cbb(String var1) {
      if (this.f_2d2e20c0 != null) {
         this.f_9ca7b2bd = null;
         this.f_a2141a63 = null;
         StringReader var2 = new StringReader(C0252.bootstrap<"get",25769803855>() + var1);
         if (var2.canRead()) {
            this.f_86210596 = this.f_78901dc0.parse(var2, this);
            CompletableFuture var3 = this.f_78901dc0.getCompletionSuggestions(this.f_86210596);
            var3.thenRun(() -> {
               if (var3.isDone()) {
                  try {
                     this.f_78901dc0.execute(C0252.bootstrap<"get",25769803855>() + this.m_852a4be7(), this);
                     this.f_a2141a63 = new ItemStack((IItem)C0114.bootstrap<"call",6,1>(C0114.bootstrap<"call",5,1>(this.m_852a4be7())), 1);
                  } catch (Exception var3x) {
                     this.f_a2141a63 = null;
                  }

                  this.f_9ca7b2bd = (Suggestions)var3.join();
               }
            });
         }
      }
   }
}
