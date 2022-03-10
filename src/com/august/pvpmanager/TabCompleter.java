package com.august.pvpmanager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> list = Arrays.asList("on", "off");
        List<String> completions = null;
        String input = strings[0].toLowerCase();
        for(String e : list){
            if(e.startsWith(input)){
                if(completions == null){
                    completions = new ArrayList();
                }
                completions.add(e);
            }
        }
        if(completions != null) Collections.sort(completions);
        return completions;
    }
}
