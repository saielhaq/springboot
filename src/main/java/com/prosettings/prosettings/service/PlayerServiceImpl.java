package com.prosettings.prosettings.service;


import com.prosettings.prosettings.entities.Player;
import com.prosettings.prosettings.entities.Tier;
import com.prosettings.prosettings.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player savePlayer(Player p) {
        return playerRepository.save(p);
    }

    @Override
    public Player updatePlayer(Player p) {
        return playerRepository.save(p);
    }

    @Override
    public void deletePlayer(Player p) {
        playerRepository.delete(p);
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player getPlayer(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        return playerOptional.orElse(null);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Page<Player> getAllPlayersPerPage(int page, int size) {
        return playerRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Player> findByNamePlayer(String name) {
        return playerRepository.findByPlayerName(name);
    }

    @Override
    public List<Player> findByNamePlayerContains(String name) {
        return playerRepository.findByPlayerNameContains(name);
    }

    @Override
    public List<Player> findByDPIAndSens(int dpi, Double sens) {
        return playerRepository.findByDPIAndSens(dpi, sens);
    }

    @Override
    public List<Player> findByTier(Tier tier) {
        return playerRepository.findByTier(tier);
    }

    @Override
    public List<Player> findByTierTierId(Long id) {
        return playerRepository.findByTierTierId(id);
    }

    @Override
    public List<Player> sortPlayersNameSens() {
        return playerRepository.sortPlayersNameSens();
    }
}
