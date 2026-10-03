package me.deftware.aristois.recovered;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.inventory.EntityInventory;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0035 extends C0001 {
   private final Queue<Integer> f_84866344 = new ArrayDeque<>(36);
   private long f_6e5470dd = System.currentTimeMillis();
   private long f_9ac57fc6 = 260L;

   public C0035() {
      EventBus.registerClass(this.getClass(), this);
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().addCommand(C0266.m_760db7bb(), var1 -> {
         MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
         if (this.f_84866344.isEmpty()) {
            EntityInventory var3 = var2.getInventory();

            for (int var4 = 0; var4 < var3.getSize(); var4++) {
               ItemStack var5 = var3.getStackInSlot(var4);
               if (!var5.isEmpty()) {
                  this.f_84866344.add(C0073.m_a73ee2be(var4));
               }
            }

            C0064.m_13c9ffeb().m_ecf8e7ae(C0266.m_68957b31(), this.f_84866344.size()).m_1058ed9a();
         } else {
            C0064.m_b79f2e94().m_ecf8e7ae(C0266.m_4e02e7a9()).m_1058ed9a();
         }
      });
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
      if (var2 != null && System.currentTimeMillis() > this.f_6e5470dd + this.f_9ac57fc6 && !this.f_84866344.isEmpty()) {
         var2.windowClick(this.f_84866344.poll(), 1, WindowClickAction.THROW);
         this.f_6e5470dd = System.currentTimeMillis();
      }
   }
}
