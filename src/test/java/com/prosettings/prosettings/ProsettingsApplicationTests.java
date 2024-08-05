package com.prosettings.prosettings;

import com.prosettings.prosettings.entities.Player;
import com.prosettings.prosettings.repos.PlayerRepository;
import com.prosettings.prosettings.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProsettingsApplicationTests {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerService playerService;

	@Test
	public void testCreatePlayer(){
		Player p = new Player(0.5, "None", "Portugal", "purin", 1600);
		playerRepository.save(p);
	}

	@Test
	public void testFindPlayer() {
		Optional<Player> playerOptional = playerRepository.findById(9L);
		if(playerOptional.isPresent()){
			Player p = playerOptional.get();
			System.out.println(p);
		}else{
			System.out.println("Player not found");
		}
	}

	@Test
	public void testUpdatePlayer(){
		Optional<Player> playerOptional = playerRepository.findById(9L);
		if(playerOptional.isPresent()){
		Player p = playerOptional.get();
		p.setSens(0.184);
		playerRepository.save(p);
		}
	}

	@Test
	public void testDeletePlayer(){
		playerRepository.deleteById(13L);
	}

	@Test
	public void testListPlayers(){
		List<Player> players = playerRepository.findAll();
		for (Player p : players){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNamePlayerContains(){
		Page<Player> players = playerService.getAllPlayersPerPage(0, 5);
		System.out.println(players.getSize());
		System.out.println(players.getTotalElements());
		System.out.println(players.getTotalPages());
		players.getContent().forEach(p -> {System.out.println(p.toString());
		});
	}
}
