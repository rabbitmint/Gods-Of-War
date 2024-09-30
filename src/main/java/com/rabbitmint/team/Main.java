package com.rabbitmint.team;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

public class Main {
    private Map<String, Team> teams;
    private Scoreboard scoreboard;

    public Main() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        if (manager != null) {
            scoreboard = manager.getMainScoreboard();
            teams = new HashMap<>();
            teams.put(Data.red_name, scoreboard.registerNewTeam(Data.red_name));
            teams.put(Data.blue_name, scoreboard.registerNewTeam(Data.blue_name));
        }
    }

    public void addPlayer(UUID playerId, String teamName) {
        Team team = teams.get(teamName);
        if (team != null) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(playerId);
            team.addEntry(player.getName());
        }
    }

    public void removePlayer(UUID playerId, String teamName) {
        Team team = teams.get(teamName);
        if (team != null) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(playerId);
            team.removeEntry(player.getName());
        }
    }

    public Team getTeam(String teamName) {
        return teams.get(teamName);
    }
}
