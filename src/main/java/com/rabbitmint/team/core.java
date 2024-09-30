package com.rabbitmint.team;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.command.ConsoleCommandSender;

public class core implements Listener {

    private Plugin plugin;
    private Location redCoreLocation;
    private Location blueCoreLocation;

    public core(Plugin plugin) {
        this.plugin = plugin;
    }

    public void loadCoreLocations() {
        FileConfiguration config = plugin.getConfig();

        String redWorldName = config.getString("cores.red.world");
        World redWorld = Bukkit.getWorld(redWorldName);
        double redX = config.getDouble("cores.red.x");
        double redY = config.getDouble("cores.red.y");
        double redZ = config.getDouble("cores.red.z");
        redCoreLocation = new Location(redWorld, redX, redY, redZ);

        String blueWorldName = config.getString("cores.blue.world");
        World blueWorld = Bukkit.getWorld(blueWorldName);
        double blueX = config.getDouble("cores.blue.x");
        double blueY = config.getDouble("cores.blue.y");
        double blueZ = config.getDouble("cores.blue.z");
        blueCoreLocation = new Location(blueWorld, blueX, blueY, blueZ);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        Location blockLocation = block.getLocation();

        if (block.getType() == Material.DIAMOND_BLOCK) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            String playerName = player.getName();
            String titleMessage;
            String subtitleMessage;

            if (blockLocation.equals(redCoreLocation)) {
                titleMessage = "레드 코어가 파괴되었습니다!";
                subtitleMessage = "블루팀 승리!";
                Bukkit.broadcastMessage(playerName + "가 레드 코어를 파괴했습니다!");
            } else if (blockLocation.equals(blueCoreLocation)) {
                titleMessage = "블루 코어가 파괴되었습니다!";
                subtitleMessage = "레드팀 승리!";
                Bukkit.broadcastMessage(playerName + "가 블루 코어를 파괴했습니다!");
            } else {
                return;
            }

            if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
                String command = String.format("title @a title [{\"text\":\"%s\",\"color\":\"gold\"}]", titleMessage);
                Bukkit.dispatchCommand(console, command);
                command = String.format("title @a subtitle [{\"text\":\"%s\",\"color\":\"dark_red\"}]", subtitleMessage);
                Bukkit.dispatchCommand(console, command);
            } else {
                event.setCancelled(true);
                block.setType(Material.DIAMOND_BLOCK);
                player.sendMessage("다이아몬드 블럭은 맨손으로만 부술 수 있습니다!");
            }
        }
    }
}
