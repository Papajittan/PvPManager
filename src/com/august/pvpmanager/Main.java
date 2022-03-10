package com.august.pvpmanager;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;
    @Override
    public void onEnable(){
        instance = this;
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + this.getName() +" is enabling!");
        getServer().getPluginManager().registerEvents(new Event(), this);
        getCommand("pvp").setExecutor(new Command());
        getCommand("pvp").setTabCompleter(new TabCompleter());
    }
}
