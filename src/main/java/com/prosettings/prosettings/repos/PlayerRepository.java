package com.prosettings.prosettings.repos;

import com.prosettings.prosettings.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByPlayerName(String name);
    List<Player> findByPlayerNameContains(String name);

//    @Query("select p from Player p where p.dpi = ?1 and p.sens <= ?2")
//    List<Player> findByDPIAndSens(int dpi, Double sens);

    @Query("select p from Player p where p.dpi = :dpi and p.sens <= :sens")
    List<Player> findByDPIAndSens(@Param("dpi") int dpi, @Param("sens") Double sens);
}

