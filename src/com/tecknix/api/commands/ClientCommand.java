package com.tecknix.api.commands;

import com.tecknix.api.TecknixAPI;
import org.bukkit.Bukkit;
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
        if(args.length != 1) {
            p.sendMessage(ChatColor.RED + "Usage: /client <player>");
            return false;
        }
        if(Bukkit.getPlayer(args[0]) == null) {
            p.sendMessage(ChatColor.RED + "Unknown player");
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        p.sendMessage("");
        p.sendMessage(ChatColor.STRIKETHROUGH + "----------------------------------------------------------");
        p.sendMessage("");
        p.sendMessage(ChatColor.AQUA + target.getName() + ChatColor.DARK_AQUA +
                String.valueOf(TecknixAPI.getInstance().tecknixClientUsers.contains(target.getUniqueId()) ? " Is Running TecknixClient!" :
                        " Is not Running TecknixClient!"));
        p.sendMessage("");
        p.sendMessage(ChatColor.STRIKETHROUGH + "-----------------------------------------------------------");
        p.sendMessage("");
        return true;

    }
}