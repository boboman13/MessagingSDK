package net.boboman13.messagingsdk;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.MessageRequest;
import lilypad.client.connect.api.result.FutureResult;
import lilypad.client.connect.api.result.impl.MessageResult;
import org.bukkit.Server;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

/**
 * Pigeon, the backend for the MessagingSDK Facade.
 */
public class Pigeon {

    private MessagingSDK plugin;
    private Server server;
    private Connect connect;

    private String broadcastChannel = "MessagingSDK-B";
    private String privateChannel = "MessagingSDK-P";
    private String metaChannel = "MessagingSDK-M";

    public Pigeon(MessagingSDK plugin) {
        this.plugin = plugin;
        this.server = plugin.getServer();
        connect = this.server.getServicesManager().getRegistration(Connect.class).getProvider();
    }

    public void sendMessageToServer(String channel, String server, String message) {
        MessageRequest req = null;

        try {
            req = new MessageRequest(server, channel, message);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return;
        }

        FutureResult<MessageResult> res = null;

        try {
            res = connect.request(req);
        } catch (RequestException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMessageToAllServers(String channel, String message) {
        MessageRequest req = null;

        try {
            req = new MessageRequest(Collections.EMPTY_LIST, channel, message);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return;
        }

        FutureResult<MessageResult> res = null;

        try {
            res = connect.request(req);
        } catch (RequestException ex) {
            ex.printStackTrace();
        }
    }

    public String getBroadcastChannel() {
        return broadcastChannel;
    }

    public String getPrivateChannel() {
        return privateChannel;
    }

    public String getMetaChannel() {
        return metaChannel;
    }
}
