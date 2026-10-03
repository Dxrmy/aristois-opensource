# Aristois Community client (clean-room)

This is an **original, MIT-licensed** client built on the MIT-licensed EMC
framework. It shares no source code with the proprietary Aristois client under
`recovered/` — that is kept only as reference.

## Why clean-room

The original client is `Copyright (C) Aristois 2018–2023, All Rights Reserved`
and is still served from `maven.aristois.net`. Redistributing decompiled client
code as open source would infringe. Writing our own modules against the public
EMC API is the only way the client itself can be MIT.

## Layout

```
src/main/java/org/aristois/client/
├── AristoisClient.java          # EMCMod entry point
├── module/
│   ├── Module.java              # base feature (enable/disable, settings, keybind)
│   ├── Category.java
│   ├── ModuleManager.java       # registry + key dispatch
│   └── modules/
│       ├── SprintModule.java
│       ├── FastUseModule.java
│       └── CoordinatesModule.java
└── setting/
    ├── Setting.java
    ├── BooleanSetting.java
    └── NumberSetting.java
```

Enabling a module calls `EventBus.INSTANCE.registerClass(this)`; any method
annotated with `@EventHandler` then receives EMC events. Disabling unsubscribes.

## How it loads

The EMC framework's `DirectoryModDiscovery` scans
`<game>/libraries/EMC/<mc-version>/` for jars containing a `client.json`:

```json
{
  "name": "Aristois Community",
  "main": "org.aristois.client.AristoisClient",
  "minVersion": "16.0.0",
  "scheme": 4
}
```

EMC reads `main`, loads the class, and calls `initialize()`.

## Build

```bash
./gradlew emcClientJar
# -> build/emc/aristois-community-client.jar
# copy to <game>/libraries/EMC/1.21.4/
```

(`./gradlew build` also compiles the client alongside the framework.)

> The Gradle/Loom build is **not yet verified on the author's machine**
> (Loom decompiles Minecraft and needs ~8 GB RAM). The Java sources are syntax
> checked, and the EMC API calls used here exist in the EMC 17.0.0 framework.

## Adding a module

```java
public final class MyModule extends Module {
    private final BooleanSetting option = add(new BooleanSetting("Option", "what it does", true));

    public MyModule() {
        super("MyModule", "Does a thing", Category.PLAYER);
        setKeyBind(GLFW.GLFW_KEY_K);
    }

    @EventHandler
    public void onUpdate(EventUpdate event) {
        if (option.isEnabled() && Minecraft.getMinecraftGame()._getPlayer() != null) {
            // ...
        }
    }
}
```

Register it in `AristoisClient.initialize()`:

```java
moduleManager.register(new MyModule());
```
