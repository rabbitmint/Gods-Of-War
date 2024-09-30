package com.rabbitmint.team;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Team {
    private String name;
    private Set<UUID> players;
    public Team(String name) {
        this.name = name;
        this.players = new HashSet<>();
    }
    public String getname() {
        return name;
    }

    public void addPlayer(UUID playerId) {
        players.add(playerId);
    }
    public void removePlayer(UUID playerId) {
        players.remove(playerId);
    }
    public Set<UUID> getPlayers() {
        return players;
    }
}
