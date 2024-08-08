package com.prosettings.prosettings.repos;

import com.prosettings.prosettings.entities.Player;
import com.prosettings.prosettings.entities.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByPlayerName(String name);
    List<Player> findByPlayerNameContains(String name);

//    @Query("select p from Player p where p.dpi = ?1 and p.sens <= ?2")
//    List<Player> findByDPIAndSens(int dpi, Double sens);

    @Query("select p from Player p where p.dpi = :dpi and p.sens <= :sens")
    List<Player> findByDPIAndSens(@Param("dpi") int dpi, @Param("sens") Double sens);

    @Query("select p from Player p where p.tier = ?1")
    List<Player> findByTier(Tier tier);

    List<Player> findByTierTierId(Long id);

    @Query("select p from Player p order by p.playerName ASC, p.sens DESC")
    List<Player> sortPlayersNameSens();

}