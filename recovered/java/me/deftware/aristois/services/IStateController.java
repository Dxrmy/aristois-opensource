package me.deftware.aristois.services;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public interface IStateController {
   Set<IStateController> stateControllers = new HashSet<>();

   static IStateController getInstance() {
      return stateControllers.stream().filter(IStateController::isControlling).filter(IStateController::isControllable).findFirst().orElse(null);
   }

   default boolean isControllable() {
      return true;
   }

   boolean isPaused();

   boolean isControlling();

   void pause();

   void resume();

   String getId();

   default void interrupt() {
      this.interrupt(1500L);
   }

   void interrupt(long var1);

   void tick();

   EnumSet<IStateController.Capabilities> getCapabilities();

   public static enum Capabilities {
      Walking,
      SlotSwitching,
      Mining;

      private Capabilities() {
      }
   }
}
