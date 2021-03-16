package me.ent.Roll;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GlobalRoll implements CommandExecutor  {


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		int rollResult, maxval, minval;
		
		if (label.equalsIgnoreCase("globalroll") || label.equalsIgnoreCase("entsrandomroll:globalroll")) {
			
			if(!(sender instanceof Player)) {
				
				if (args.length == 0) {
					rollResult = 1 + (int) (Math.random() * 100);
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Console rolled a " + Integer.toString(rollResult) + "! (1-100)");
					return true;
				}
				
				if (args.length == 1) {
					if (isNum(args[0])) {
						maxval = Integer.parseInt(args[0]);
						rollResult = 1 + (int) (Math.random() * maxval);
						Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Console rolled a " + Integer.toString(rollResult) + "! (1-" + maxval + ")");
					}
					else
						sender.sendMessage(ChatColor.DARK_RED + "Usage: /roll <max-value>");
					return true;
				}
				
				if (args.length == 2) {
					if (isNum(args[0]) && isNum(args[1])) {
						if (Integer.parseInt(args[0]) > Integer.parseInt(args[1])) {
							minval = Integer.parseInt(args[0]);
							maxval = Integer.parseInt(args[1]) - minval + 1;
							rollResult = minval + (int) (Math.random() * maxval);
							Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Console rolled a " + Integer.toString(rollResult) + "! (" + minval + "-" + Integer.toString(maxval+minval-1) + ")");
						}
						else {
							sender.sendMessage(ChatColor.DARK_RED + "Usage: /roll <min-value> <max-value>");
						}
					}
					else
						sender.sendMessage(ChatColor.DARK_RED + "Usage: /roll <min-value> <max-value>");
					return true;
				}
				sender.sendMessage(ChatColor.RED + "Too many values introduced! Maximum number is two values.");
				return true;
			}
			else {
				
				Player player = (Player) sender;
				
				if (player.hasPermission("randomroll.globalroll")) {
					
					if (args.length == 0) {
						rollResult = 1 + (int) (Math.random() * 100);
						Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player.getName() + " rolled a " + Integer.toString(rollResult) + "! (1-100)");
						return true;
					}
					
					if (args.length == 1) {
						if (isNum(args[0])) {
							maxval = Integer.parseInt(args[0]);
							rollResult = 1 + (int) (Math.random() * maxval);
							Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player.getName() + " rolled a " + Integer.toString(rollResult) + "! (1-" + maxval + ")");
						}
						else
							player.sendMessage(ChatColor.DARK_RED + "Usage: /roll <max-value>");
						return true;
					}
					
					if (args.length == 2) {
						if (isNum(args[0]) && isNum(args[1])) {
							if (Integer.parseInt(args[0]) > Integer.parseInt(args[1])) {
								minval = Integer.parseInt(args[0]);
								maxval = Integer.parseInt(args[1]) - minval + 1;
								rollResult = minval + (int) (Math.random() * maxval);
								Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player.getName() + " rolled a " + Integer.toString(rollResult) + "! (" + minval + "-" + Integer.toString(maxval+minval-1) + ")");
							}
							else {
								player.sendMessage(ChatColor.DARK_RED + "Usage: /roll <min-value> <max-value>");
							}
						}
						else
							player.sendMessage(ChatColor.DARK_RED + "Usage: /roll <min-value> <max-value>");
						return true;
					}
					player.sendMessage(ChatColor.RED + "Too many values introduced! Maximum number is two values.");
					return true;
				} 
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command. Please contact an administrator if you think this is a mistake.");
				return true;
			}
		}
		return false;
	}
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
