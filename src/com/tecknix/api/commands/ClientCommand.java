package com.tecknix.api.commands;

import com.tecknix.api.TecknixAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class ClientCommand implements CommandExecutor {

    TecknixAPI plugin;

    public ClientCommand(TecknixAPI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String cmdName = cmd.getName().toLowerCase();
        if (!cmdName.equals("client")) {
            return false;
        }
        Player p = (Player) sender;
        p.sendMessage("");
        p.sendMessage(ChatColor.STRIKETHROUGH + "----------------------------------------------------------");
        p.sendMessage("");
        p.sendMessage(ChatColor.AQUA + "    AHAHAHAH L THIS COMMAND DOESNT WORK " + ":" + ChatColor.DARK_AQUA + " IS Running TecknixClient!");
        p.sendMessage("");
        p.sendMessage(ChatColor.STRIKETHROUGH + "-----------------------------------------------------------");
        p.sendMessage("");
        return true;

    }
}