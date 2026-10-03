package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.widgets.Component;
import me.deftware.client.framework.gui.widgets.NativeComponent;

public abstract class C0168<T extends Component> implements NativeComponent<T>, Component {
   public C0168() {
   }

   public int getPositionX() {
      return this.getComponent().getPositionX();
   }

   public int getPositionY() {
      return this.getComponent().getPositionY();
   }

   public int getComponentWidth() {
      return this.getComponent().getComponentWidth();
   }

   public int getComponentHeight() {
      return this.getComponent().getComponentHeight();
   }

   public boolean isActive() {
      return this.getComponent().isActive();
   }

   public void setPositionX(int var1) {
      this.getComponent().setPositionX(var1);
   }

   public void setPositionY(int var1) {
      this.getComponent().setPositionY(var1);
   }

   public void setComponentWidth(int var1) {
      this.getComponent().setComponentWidth(var1);
   }

   public void setComponentHeight(int var1) {
      this.getComponent().setComponentHeight(var1);
   }

   public void setActive(boolean var1) {
      this.getComponent().setActive(var1);
   }
}
