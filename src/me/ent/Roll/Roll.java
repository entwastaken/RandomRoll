package me.ent.Roll;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Roll implements CommandExecutor  {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
			int rollResult, minval, maxval;
			
			if (label.equalsIgnoreCase("roll") || label.equalsIgnoreCase("randominteger") || label.equalsIgnoreCase("entsrandomroll:roll") || label.equalsIgnoreCase("entsrandomroll:randominteger")) {
				
				// Player rolling
				if (sender instanceof Player) {
					
					Player player = (Player) sender;
					
					// /roll (/randominteger) - Rolls from 1-100 by default.
					if (args.length == 0) {
						rollResult = 1 + (int) (Math.random() * 100);
						player.sendMessage(ChatColor.GOLD + "Rolled a " + Integer.toString(rollResult) + "!");
						return true;
					}
					
					// /roll (/randominteger) <number> - Rolls from 1 to a given value.
					if (args.length == 1) {
						if (isNum(args[0])) {
							rollResult = 1 + (int) (Math.random() * Integer.parseInt(args[0]));
							player.sendMessage(ChatColor.GOLD + "Rolled a " + Integer.toString(rollResult) + "!");
						}
						else
							player.sendMessage(ChatColor.DARK_RED + "Usage: /roll <max-value>");
						return true;
					}
					
					// /roll (/randominteger) <min> <max> - Rolls a random number between two given values.
					if (args.length == 2) {
						if (isNum(args[0]) && isNum(args[1])) {
							minval = Integer.parseInt(args[0]);
							maxval = Integer.parseInt(args[1]) - minval + 1;
							rollResult = minval + (int) (Math.random() * maxval);
							player.sendMessage(ChatColor.GOLD + "Rolled a " + Integer.toString(rollResult) + "!");
						}
						else
							player.sendMessage(ChatColor.DARK_RED + "Usage: /roll <min-value> <max-value>");
						return true;
					}
					player.sendMessage(ChatColor.RED + "Too many values introduced! Maximum number is two values.");
					return true;
				}
				
				// Rolling from console
				else {
					
					// /roll (/randominteger) - Rolls from 1-100 by default.
					if (args.length == 0) {
						rollResult = 1 + (int) (Math.random() * 100);
						sender.sendMessage(ChatColor.GOLD + "Rolled a " + Integer.toString(rollResult) + "!");
						return true;
					}
					
					// /roll (/randominteger) <number> - Rolls from 1 to a given value.
					if (args.length == 1) {
						if (isNum(args[0])) {
							rollResult = 1 + (int) (Math.random() * Integer.parseInt(args[0]));
							sender.sendMessage(ChatColor.GOLD + "Rolled a " + Integer.toString(rollResult) + "!");
						}
						else
							sender.sendMessage(ChatColor.DARK_RED + "Usage: /roll <max-value>");
						return true;
					}
					
					// /roll (/randominteger) <min> <max> - Rolls a random number between two given values.
					if (args.length == 2) {
						if (isNum(args[0]) && isNum(args[1])) {
							minval = Integer.parseInt(args[0]);
							maxval = Integer.parseInt(args[1]) - minval + 1;
							rollResult = minval + (int) (Math.random() * maxval);
							sender.sendMessage(ChatColor.GOLD + "Rolled a " + Integer.toString(rollResult) + "!");
						}
						else
							sender.sendMessage(ChatColor.DARK_RED + "Usage: /roll <min-value> <max-value>");
						return true;
					}
					sender.sendMessage(ChatColor.RED + "Too many values introduced! Maximum number is two values.");
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
