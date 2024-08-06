package com.prosettings.prosettings.service;

import com.prosettings.prosettings.entities.Player;
import com.prosettings.prosettings.entities.Tier;
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

    List<Player> findByNamePlayer(String name);
    List<Player> findByNamePlayerContains(String name);
    List<Player> findByDPIAndSens(int dpi, Double sens);
    List<Player> findByTier (Tier tier);
    List<Player> findByTierTierId(Long id);
    List<Player> sortPlayersNameSens();
}
