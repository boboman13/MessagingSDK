MessagingSDK
-----

> In order to use the MessagingSDK, please download it and add it as a dependency for your build. At the moment, there is no Maven repository to automatically download it from.

### Example Usage
```java
import net.boboman13.messagingsdk.MessagingSDK;

public class MyPlugin extends BukkitPlugin {

    @Override
    public void onEnable() {
        MessagingSDK.sendMessageToPlayer("boboman13", "This is a private message");
        MessagingSDK.broadcastMessage("This message is broadcasted to all servers");
        MessagingSDK.broadcastMessageToServer("This message is broadcasted to one server", "myServer");
    }

}
```

### Documentation
All methods come through the `MessagingSDK` facade. If you want to access the backend, use:
```java
Pigeon pigeon = MessagingSDK.getPigeon();
```

This will give you the `Pigeon` singleton that the MessagingSDK uses to send messages.

#### Send a private message
```java
public static void sendMessageToPlayer(String playername, String message);
```

It takes the first argument as the playername, and the second as the message. This will send a private message to the player (no matter where he/she is on the network; no server must be specified).

#### Broadcast a global message
```java
public static void broadcastMessage(String message);
```

This broadcasts a message across all servers on the LilyPad network. No servers must be specified. The message is a `String`.

#### Broadcast a specific-server message
```java
public static void broadcastMessageToServer(String message, String server);
```

This broadcasts a message to an entire server, but not all servers on the network. It must be specified as the second argument (taken as a `String`).

### License
[MIT License](./LICENSE)
