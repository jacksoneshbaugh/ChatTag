package me.ITGuy12.ChatTag;

import org.bukkit.Bukkit; 
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			if(e.getMessage().contains(pl.getName())) {
				pl.playSound(pl.getLocation(), Sound.UI_BUTTON_CLICK, 10F, 10F);
				pl.sendMessage(ChatColor.GOLD + e.getPlayer().getName() + ChatColor.GREEN + " has mentioned you in chat!");
			}
		}
	}
}
