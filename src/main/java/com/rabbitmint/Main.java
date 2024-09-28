package com.rabbitmint;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private Startup startup;

    @Override
    public void onEnable() {
        startup = new Startup();
        startup.onStartup();
    }

    @Override
    public void onDisable() {
        startup.onShutdown();
    }
}
