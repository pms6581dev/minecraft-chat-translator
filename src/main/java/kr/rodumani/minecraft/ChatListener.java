package kr.rodumani.minecraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final static EnglishToKorean englishToKorean = new EnglishToKorean();

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        String message = asyncPlayerChatEvent.getMessage();
        if (message.startsWith("-")) {
            message = message + "\n--> " + englishToKorean.engToKor(message.substring(1));
            asyncPlayerChatEvent.setMessage(message);
        }
        else {
            asyncPlayerChatEvent.setMessage(message);
        }
    }
}
