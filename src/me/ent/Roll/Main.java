package me.ent.Roll;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("roll").setExecutor(new Roll());
		this.getCommand("globalroll").setExecutor(new GlobalRoll());
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
