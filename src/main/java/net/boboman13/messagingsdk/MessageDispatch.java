package net.boboman13.messagingsdk;

import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;

import java.io.UnsupportedEncodingException;

/**
 * Receives the messages from a Pigeon.
 *
 * @author boboman13
 */
public class MessageDispatch {

    private MessagingSDK plugin;

    public MessageDispatch(MessagingSDK plugin) {
        this.plugin = plugin;
    }

    @EventListener
    public void onMessageReceive(MessageEvent event) {
        // handle broadcast
        if (event.getChannel() == plugin.getPigeon().getBroadcastChannel()) {
            String message = null;

            try {
                message = event.getMessageAsString();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
                return;
            }

            plugin.getServer().broadcastMessage(message);
        } else if (event.getChannel() == plugin.getPigeon().getPrivateChannel()) {
            String message = null;

            try {
                message = event.getMessageAsString();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
                return;
            }

            String[] parts = message.split("\0");
            String playerName = parts[0];
            if (plugin.getServer().getPlayer(playerName).isOnline()) {
                plugin.getServer().getPlayer(playerName).sendMessage(parts[1]);
            }
        }
    }

}
