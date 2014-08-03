package net.boboman13.messagingsdk;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Facade for MessagingSDK
 *
 * @author boboman13
 */
public class MessagingSDK extends JavaPlugin {

    private static Pigeon pigeon;

    @Override
    public void onEnable() {
        this.pigeon = new Pigeon(this);
    }

    /**
     * Sends a message to a player on the network. If the player is not online, it won't send any message.
     * @param playername Player's username
     * @param message Message
     */
    public static void sendMessageToPlayer(String playername, String message) {
        String transport = playername + "\0" + message;
        pigeon.sendMessageToAllServers(pigeon.getPrivateChannel(), transport);
    }

    /**
     * Broadcasts a message globally across all servers.
     * @param message Message
     */
    public static void broadcastMessage(String message) {
        pigeon.sendMessageToAllServers(pigeon.getBroadcastChannel(), message);
    }

    /**
     * Broadcasts a message to a specific server.
     * @param message Message
     * @param server Server
     */
    public static void broadcastMessageToServer(String message, String server) {
        pigeon.sendMessageToServer(pigeon.getBroadcastChannel(), server, message);
    }

    /**
     * Gets the Pigeon.
     */
    public Pigeon getPigeon() {
        return this.pigeon;
    }

}
