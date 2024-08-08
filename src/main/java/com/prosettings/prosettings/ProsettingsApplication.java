package com.prosettings.prosettings;

import com.prosettings.prosettings.entities.Player;
import com.prosettings.prosettings.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
public class ProsettingsApplication implements CommandLineRunner {

	@Autowired
	PlayerService playerService;

	@Autowired
	private RepositoryRestConfiguration repositoryRestconfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProsettingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestconfiguration.exposeIdsFor(Player.class);
		System.out.println("[SERVER] Server started.");
//		playerService.savePlayer(new Player(0.184, "None", "Morocco", "Saad", 1600));
//		playerService.savePlayer(new Player(0.16, "None", "Morocco", "Ghostdead", 800));
//		playerService.savePlayer(new Player(0.5, "None", "Portugal", "purin", 1600));
//		playerService.savePlayer(new Player(0.7, "None", "Morocco / Belgium", "ScreaM", 400));
//		playerService.savePlayer(new Player(0.2, "Sentinels", "Morocco", "Johnqt", 1600));
//		playerService.savePlayer(new Player(0.2, "Leviathan", "Brazil", "Aspas", 1600));
//		playerService.savePlayer(new Player(0.1, "NRG", "USA", "Demon1", 1600));

	}

}
