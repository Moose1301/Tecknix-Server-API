package com.tecknix.api;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.UnsupportedEncodingException;

@SuppressWarnings("all")
public class CheckBrand implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player p, byte[] msg) {
        try {
            String brand = new String(msg, "UTF-8").substring(1);
            if (brand.equals("Tecknix-Client")) {
                p.sendMessage(ChatColor.AQUA + "Thankyou For Using TecknixClient!");
                TecknixAPI.getInstance().tecknixClientUsers.add(p.getUniqueId());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

