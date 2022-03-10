package com.august.pvpmanager;

import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent Event){
        Player player = Event.getPlayer();
        String playername = player.getName();
        PluginSupporter.Data playerpvp = PluginSupporter.getPvP(playername);
        if(playerpvp == null) {
            PluginSupporter.setPvP(playername, false);
        }
    }
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent Event){
        if(Event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE && Event.getEntity() instanceof Player){
            Arrow shooter = (Arrow) Event.getDamager();
            Player shoooter = (Player) shooter.getShooter();
            Player players = (Player) Event.getEntity();
            PluginSupporter.Data playerpvps = PluginSupporter.getPvP(players.getName());
            Boolean playerspvpbool = playerpvps.PvP;
            String shootername = shoooter.getName();
            PluginSupporter.Data shooterpvp = PluginSupporter.getPvP(shootername);
            Boolean shooterpvpbool = shooterpvp.PvP;
            if(shooterpvpbool == false || playerspvpbool  == false){
                Event.setCancelled(true);
                return;
            }
            return;
        }
        Player damager = (Player) Event.getDamager();
        String damagername = damager.getName();
        Player player = (Player) Event.getEntity();
        String playername = player.getName();
        if(!(damager instanceof Player) || !(player instanceof Player)) return;
        PluginSupporter.Data damagerpvp = PluginSupporter.getPvP(damagername);
        PluginSupporter.Data playerpvp = PluginSupporter.getPvP(playername);
        Boolean damagerpvpbool = damagerpvp.PvP;
        Boolean playerpvpbool = playerpvp.PvP;

        if(damagerpvpbool == false || playerpvpbool == false){
            Event.setCancelled(true);
        }
    }
}
