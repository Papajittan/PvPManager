package com.august.pvpmanager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    private boolean isOnOff(String s){
        if(s.equalsIgnoreCase("on") || s.equalsIgnoreCase("off")){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        var player = (Player) commandSender;
        if(commandSender == null) return false;
        if(strings.length <= 0) {
                player.sendMessage(ChatColor.GOLD + "Please enter on or off to turn on or off pvp!");
                return true;
            }
            if(!isOnOff(strings[0])){
                player.sendMessage(ChatColor.RED + "Please enter on or off only!");
                return true;
            }
            PluginSupporter.Data playerpvp = PluginSupporter.getPvP(player.getName());
            Boolean playerpvpbool = playerpvp.PvP;
            if(strings[0].equalsIgnoreCase("on")){
                if(playerpvpbool == true){
                    player.sendMessage(ChatColor.RED + "Your pvp is already turned on!");
                    return true;
                }
                PluginSupporter.setPvP(player.getName(), true);
                player.sendMessage(ChatColor.GOLD + "Your pvp successfully turn on!");
                return true;
            }
            if(strings[0].equalsIgnoreCase("off")){
                if(playerpvpbool == false){
                    player.sendMessage(ChatColor.RED + "Your pvp is already turned off!");
                    return true;
                }
                PluginSupporter.setPvP(player.getName(), false);
                player.sendMessage(ChatColor.GOLD + "Your pvp successfully turn off!");
                return true;
            }
        return true;
    }
}
