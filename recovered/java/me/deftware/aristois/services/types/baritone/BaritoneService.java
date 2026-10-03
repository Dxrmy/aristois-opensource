package me.deftware.aristois.services.types.baritone;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.IBaritoneProvider;
import java.util.EnumSet;
import me.deftware.aristois.recovered.C0014;
import me.deftware.aristois.recovered.C0098;
import me.deftware.aristois.recovered.C0289;
import me.deftware.aristois.recovered.C0393;
import me.deftware.aristois.recovered.C0395;
import me.deftware.aristois.services.IStateController;
import me.deftware.aristois.services.Service;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

@Service(
   value = {"baritone.api.BaritoneAPI"},
   name = "Baritone",
   description = {"Baritone integration"},
   module = true,
   source = {"https://github.com/cabaletta/baritone"},
   preRun = true
)
public class BaritoneService implements Runnable {
   private final BaritoneService.BaritoneStateController stateController = new BaritoneService.BaritoneStateController(this);
   @C0098(
      value = "Interrupt",
      description = {"Allow Aristois to pause Baritone"}
   )
   private boolean interrupt = true;

   public BaritoneService() {
   }

   public IBaritoneProvider getService() {
      return BaritoneAPI.getProvider();
   }

   @Override
   public void run() {
      C0014.f_70e27a90.m_e04d25fd(BaritoneCommand.class).m_e04d25fd(BaritoneGotoCommand.class);
      String prefix = (String)BaritoneAPI.getSettings().prefix.value;
      if (prefix.equalsIgnoreCase("#") || prefix.equalsIgnoreCase(CommandRegister.getCommandTrigger())) {
         BaritoneAPI.getSettings().prefix.value = "@";
      }

      EventBus.registerClass(this.getClass(), this);
      IStateController.stateControllers.add(this.stateController);
   }

   @EventHandler
   private void onUpdate(EventUpdate event) {
      boolean jesus = C0289.m_c716a1b3(C0395.class);
      BaritoneAPI.getSettings().assumeWalkOnLava.value = jesus;
      BaritoneAPI.getSettings().assumeWalkOnWater.value = jesus;
      BaritoneAPI.getSettings().assumeSafeWalk.value = C0289.m_c716a1b3(C0393.class);
      this.stateController.tick();
   }

   public boolean sendCommand(String command) {
      return this.getService().getPrimaryBaritone().getCommandManager().execute(command);
   }

   public boolean isActive() {
      IBaritone baritone = this.getService().getPrimaryBaritone();
      return baritone.getMineProcess().isActive()
         || baritone.getCustomGoalProcess().isActive()
         || baritone.getBuilderProcess().isActive()
         || baritone.getFarmProcess().isActive()
         || baritone.getFollowProcess().isActive()
         || baritone.getExploreProcess().isActive();
   }

   public BaritoneService.BaritoneStateController getStateController() {
      return this.stateController;
   }

   public boolean isInterrupt() {
      return this.interrupt;
   }

   public static class BaritoneStateController implements IStateController {
      private final BaritoneService service;
      private boolean taskStored = false;
      private long interruption = -1L;

      @Override
      public boolean isControllable() {
         return this.service.isInterrupt();
      }

      @Override
      public void resume() {
         if (this.taskStored && this.service.isActive()) {
            this.taskStored = false;
            this.service.sendCommand("resume");
         }
      }

      @Override
      public String getId() {
         return "Baritone";
      }

      @Override
      public void interrupt(long ms) {
         this.interruption = System.currentTimeMillis() + ms;
         this.pause();
      }

      @Override
      public void tick() {
         if (this.isPaused() && this.interruption != -1L && this.interruption < System.currentTimeMillis()) {
            this.resume();
            this.interruption = -1L;
         }
      }

      @Override
      public EnumSet<IStateController.Capabilities> getCapabilities() {
         EnumSet<IStateController.Capabilities> enumSet = EnumSet.of(
            IStateController.Capabilities.Walking, IStateController.Capabilities.SlotSwitching, IStateController.Capabilities.Mining
         );
         if ((Boolean)BaritoneAPI.getSettings().disableAutoTool.value) {
            enumSet.remove(IStateController.Capabilities.SlotSwitching);
         }

         return enumSet;
      }

      @Override
      public boolean isPaused() {
         return this.taskStored;
      }

      @Override
      public boolean isControlling() {
         return this.service.isActive();
      }

      @Override
      public void pause() {
         if (!this.taskStored && this.service.isActive()) {
            this.service.sendCommand("pause");
            this.taskStored = true;
         }
      }

      public BaritoneStateController(BaritoneService service) {
         this.service = service;
      }
   }
}
