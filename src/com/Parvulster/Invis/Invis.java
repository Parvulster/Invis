package com.Parvulster.Invis;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Invis extends JavaPlugin{
	public void onEnable() {
		getLogger().info("Enabled");
	}
	public void onDisable() {
		getLogger().info("Disabled");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(label.equalsIgnoreCase("invis")) {
			if(player.isOp()) {
				if(!(player.hasPotionEffect(PotionEffectType.INVISIBILITY))) {
					player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 255, true));
					player.hidePlayer(player);
					player.sendMessage(ChatColor.GRAY + "You Are Now Invisible");
					return false;
				}
				if(player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
					player.removePotionEffect(PotionEffectType.INVISIBILITY);
					player.showPlayer(player);
					player.sendMessage(ChatColor.GRAY + "You are No Longer Invisible");
					return false;
				}
			}
		}
	return false;	
	}
}