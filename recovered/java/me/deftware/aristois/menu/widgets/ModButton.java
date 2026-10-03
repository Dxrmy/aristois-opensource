package me.deftware.aristois.menu.widgets;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.aristois.recovered.C0441;
import me.deftware.client.framework.message.Message;

public abstract class ModButton extends ButtonWidget {
   private final AbstractMod mod;

   public ModButton(Message var1, C0441 var2, AbstractMod var3) {
      super(var1, var2);
      this.mod = var3;
   }

   public AbstractMod getMod() {
      return this.mod;
   }
}
