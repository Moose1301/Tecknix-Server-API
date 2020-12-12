package com.tecknix.api.commands;

import com.tecknix.api.TecknixAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    TecknixAPI plugin;

    public HelpCommand(TecknixAPI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String cmdName = cmd.getName().toLowerCase();
        if (!cmdName.equals("tchelp")) {
            return false;
        }
        Player p = (Player)sender;
        p.sendMessage("");
        p.sendMessage(ChatColor.STRIKETHROUGH + "----------------------------------------------------------");
        p.sendMessage("");
        p.sendMessage(ChatColor.AQUA + "    Commands:" + ChatColor.BOLD);
        p.sendMessage("");
        p.sendMessage(ChatColor.AQUA + "    /client (player) :" + ChatColor.DARK_AQUA + " Tells You If A Player IS Running TecknixClient!");
        p.sendMessage("");
        p.sendMessage(ChatColor.STRIKETHROUGH + "-----------------------------------------------------------");
        p.sendMessage("");
        return true;
    }
}

