package com.prosettings.prosettings.repos;

import com.prosettings.prosettings.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
