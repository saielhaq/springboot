package com.prosettings.prosettings.service;

import com.prosettings.prosettings.entities.Player;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlayerService {
    Player savePlayer(Player p);
    Player updatePlayer(Player p);
    void deletePlayer(Player p);
    void deletePlayerById(Long id);
    Player getPlayer(Long id);
    List<Player> getAllPlayers();

    Page<Player> getAllPlayersPerPage(int page, int size);
}
