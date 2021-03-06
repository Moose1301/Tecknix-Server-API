package com.tecknix.api;

import com.tecknix.api.commands.ClientCommand;
import com.tecknix.api.commands.HelpCommand;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;

import java.util.ArrayList;
import java.util.UUID;


public class TecknixAPI extends JavaPlugin {
    private static TecknixAPI instance;
    public ArrayList<UUID> tecknixClientUsers = new ArrayList<>();
    @Override
    public void onEnable() {
        // Check Client Brand
        Messenger messenger = Bukkit.getMessenger();
        messenger.registerIncomingPluginChannel(this, "MC|Brand", new CheckBrand());

        System.out.println("Tecknix Client API Has Been Loaded!");

        // Register Commands!
        getCommand("tchelp").setExecutor(new HelpCommand(this));
        getCommand("client").setExecutor(new ClientCommand(this));
    }


    @Override
    public void onDisable() {
        System.out.println("Tecknix Client API Has Been Disabled!");
    }

    public static TecknixAPI getInstance() {
        return instance;
    }
}
