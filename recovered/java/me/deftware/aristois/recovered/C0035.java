package me.deftware.aristois.recovered;

import java.util.ArrayDeque;
import java.util.Queue;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.inventory.EntityInventory;
import me.deftware.client.framework.item.ItemStack;

public class C0035 extends C0001 {
   private final Queue<Integer> f_7b1097f4 = new ArrayDeque<>(36);
   private long f_3aaf9940 = C0114.bootstrap<"call",0,1>();
   private long f_44082683 = 260L;

   public C0035() {
      C0114.bootstrap<"call",1,1>(this.getClass(), this);
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().addCommand(C0252.bootstrap<"get",12884901933>(), var1 -> {
         MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
         if (this.f_7b1097f4.isEmpty()) {
            EntityInventory var3 = var2.getInventory();

            for (int var4 = 0; var4 < var3.getSize(); var4++) {
               ItemStack var5 = var3.getStackInSlot(var4);
               if (!var5.isEmpty()) {
                  this.f_7b1097f4.add(C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var4)));
               }
            }

            C0114.bootstrap<"call",5,1>().m_5de8d0b8(C0252.bootstrap<"get",12884901934>(), C0114.bootstrap<"call",4,1>(this.f_7b1097f4.size())).m_66e721c0();
         } else {
            C0114.bootstrap<"call",6,1>().m_5de8d0b8(C0252.bootstrap<"get",12884901935>()).m_66e721c0();
         }
      });
   }

   @EventHandler
   private void m_6484bcaa(EventUpdate var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var2 != null && C0114.bootstrap<"call",1,1>() > this.f_3aaf9940 + this.f_44082683 && !this.f_7b1097f4.isEmpty()) {
         var2.windowClick(this.f_7b1097f4.poll(), 1, WindowClickAction.THROW);
         this.f_3aaf9940 = C0114.bootstrap<"call",1,1>();
      }
   }
}
