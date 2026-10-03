package me.deftware.aristois.recovered;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.RegistryMan;

public class C0164 extends C0157 {
   private final CommandDispatcher<Object> f_8a18a41a = new CommandDispatcher();
   private ParseResults<Object> f_f4f7a662;
   private Suggestions f_78fd71df;
   private ItemStack f_535c3b46;
   private final ArgumentType<?> f_181c8f78;
   private final String f_35a64156 = C0266.m_1d87ef21();
   private String f_9e2819d4 = "";
   private boolean f_9797eae4 = true;

   public C0164(int var1, int var2, int var3, int var4, ArgumentType<?> var5) {
      super(var1, var2, var3, var4);
      this.f_181c8f78 = var5;
      if (var5 != null) {
         this.f_8a18a41a
            .register(
               (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_1d87ef21())
                  .then(RequiredArgumentBuilder.argument(C0267.m_91e95cb4(), var5).executes(var0 -> 1))
            );
         this.m_a11708c5(this.m_e9914bd3());
      }

      this.m_efb6bb0d(Message.of(C0267.m_1616e137()).style(Appearance.of(DefaultColors.DARK_GRAY)));
      this.f_35a64156 = C0266.m_1d87ef21();
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_572d14e6(var1, var3, var5, var6);
      if (this.f_78fd71df != null) {
         Message var7 = Message.of(C0267.m_6dc2a812()).style(Appearance.of(DefaultColors.RED));
         int var8 = this.getPositionX() + 4 + FontRenderer.getStringWidth(this.m_e9914bd3());
         if (this.m_e9914bd3().isEmpty()) {
            var7 = C0197.f_9607505d.style(Appearance.of(DefaultColors.DARK_GRAY));
         } else if (!this.f_78fd71df.getList().isEmpty()) {
            Suggestion var9 = (Suggestion)this.f_78fd71df.getList().get(0);
            var7 = Message.of(var9.apply(C0267.m_e7934778() + this.m_e9914bd3()).substring(C0266.m_1d87ef21().length() + 1 + this.m_e9914bd3().length()))
               .style(Appearance.of(DefaultColors.DARK_GRAY));
         } else {
            var8 = (int)((double)this.getPositionX() + this.m_44bb072f().m_4388ac29() - (double)FontRenderer.getStringWidth(var7) - 5.0);
         }

         if (this.f_535c3b46 != null) {
            this.f_535c3b46.renderItemIntoGUI((int)((double)this.getPositionX() + this.m_44bb072f().m_4388ac29() - 20.0), this.getPositionY() + 2);
         } else {
            FontRenderer.drawStringWithShadow(var7, var8, (int)((double)this.getPositionY() + (this.m_44bb072f().m_d42f3372() - 8.0) / 2.0), 16777215);
         }
      }

      return var6;
   }

   @Override
   public void m_0e265701() {
      if (!this.f_9e2819d4.equalsIgnoreCase(this.m_e9914bd3())) {
         this.f_9e2819d4 = this.m_e9914bd3();
         this.m_a11708c5(this.m_e9914bd3());
      }

      super.m_0e265701();
   }

   public void m_a11708c5(String var1) {
      if (this.f_181c8f78 != null) {
         this.f_78fd71df = null;
         this.f_535c3b46 = null;
         StringReader var2 = new StringReader(C0267.m_e7934778() + var1);
         if (var2.canRead()) {
            this.f_f4f7a662 = this.f_8a18a41a.parse(var2, this);
            CompletableFuture var3 = this.f_8a18a41a.getCompletionSuggestions(this.f_f4f7a662);
            var3.thenRun(() -> {
               if (var3.isDone()) {
                  try {
                     this.f_8a18a41a.execute(C0267.m_e7934778() + this.m_e9914bd3(), this);
                     this.f_535c3b46 = new ItemStack(Objects.requireNonNull(RegistryMan.find(this.m_e9914bd3())), 1);
                  } catch (Exception var3x) {
                     this.f_535c3b46 = null;
                  }

                  this.f_78fd71df = (Suggestions)var3.join();
               }
            });
         }
      }
   }
}
