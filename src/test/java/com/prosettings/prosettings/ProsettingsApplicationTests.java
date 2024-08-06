package com.prosettings.prosettings;

import com.prosettings.prosettings.entities.Player;
import com.prosettings.prosettings.entities.Tier;
import com.prosettings.prosettings.repos.PlayerRepository;
import com.prosettings.prosettings.repos.TierRepository;
import com.prosettings.prosettings.service.PlayerService;
import jdk.jfr.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProsettingsApplicationTests {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private TierRepository tierRepository;

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
	public void testFindByNamePlayerPerPage(){
		Page<Player> players = playerService.getAllPlayersPerPage(0, 5);
		System.out.println(players.getSize());
		System.out.println(players.getTotalElements());
		System.out.println(players.getTotalPages());
		players.getContent().forEach(p -> {System.out.println(p.toString());
		});
	}

	@Test
	public void testFindByName(){
		List<Player> players = playerRepository.findByPlayerName("Saad");
		for(Player p: players){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNameContains(){
		List<Player> players = playerRepository.findByPlayerNameContains("S");
		for(Player p: players){
			System.out.println(p.getPlayerName());
		}
	}

	@Test
	public void testFindByDPIAndSens(){
		List<Player> players = playerRepository.findByDPIAndSens(1600, 0.2);
		for(Player p: players){
			System.out.println(p.getPlayerName());
		}
	}


	@Test
	public void testInsertTiers(){
		List<Player> playerList = Arrays.asList(new Player(0.2, "Leviathan", "Brazil", "Aspas", 1600));
		Tier t = new Tier("Challengers", "Tier 2", playerList);
		tierRepository.save(t);
	}

	@Test
	public void setTier(){
		List<Player> vct = playerRepository.findByPlayerName("Demon1");
		Tier t1 = new Tier();
		t1.setTierId(2L);
		for (Player p : vct){
			p.setTier(t1);
			playerRepository.save(p);
		}
	}

	@Test
	public void testFindByCategory(){
		Tier t = new Tier();
		t.setTierId(1L);
		List<Player> players = playerRepository.findByTier(t);
		for (Player p: players){
			System.out.println(p.getPlayerName());
		}
	}

	@Test
	public void testFindByCategoryId(){
		List<Player> players = playerRepository.findByTierTierId(1L);
		for(Player p: players){
			System.out.println(p.getPlayerName());
		}
	}

	@Test
	public void testSortByNameSens(){
		List<Player> players = playerRepository.sortPlayersNameSens();
		for(Player p: players){
			System.out.println(p.getPlayerName());
		}
	}

}
