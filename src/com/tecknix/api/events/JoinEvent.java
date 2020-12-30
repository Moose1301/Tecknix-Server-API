package com.tecknix.api.events;

import com.tecknix.api.TecknixAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.lang.reflect.InvocationTargetException;

public class JoinEvent implements Listener {


    private static void addChannel(Player p, String channel) {
        try {
            p.getClass().getMethod("addChannel", String.class).invoke(p, channel);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        addChannel(evt.getPlayer(), "MC|BRAND");
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if(!TecknixAPI.getInstance().tecknixClientUsers.isEmpty()) {
            TecknixAPI.getInstance().tecknixClientUsers.remove(event.getPlayer().getUniqueId());
        }
    }
}

