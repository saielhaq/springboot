package com.prosettings.prosettings.restcontrollers;

import com.prosettings.prosettings.entities.Player;
import com.prosettings.prosettings.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PlayerRESTController {

    @Autowired
    PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Player getPlayerById(@PathVariable("id") Long id){
        return playerService.getPlayer(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Player createPlayer(@RequestBody Player player){
        return playerService.savePlayer(player);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Player updatePlayer(@RequestBody Player player){
        return playerService.updatePlayer(player);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePlayer(@PathVariable("id") Long id){
        playerService.deletePlayerById(id);
    }

    @RequestMapping(value = "/playerstier/{tierId}", method = RequestMethod.GET)
    public List<Player> getPlayerByTierId(@PathVariable("tierId") Long tierId){
        return playerService.findByTierTierId(tierId);
    }
}
