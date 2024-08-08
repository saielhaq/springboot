package com.prosettings.prosettings.controllers;

import com.prosettings.prosettings.entities.Player;
import com.prosettings.prosettings.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @RequestMapping("/ListPlayers")
    public String listPlayers(ModelMap modelMap, @RequestParam (name="page", defaultValue = "0") int page, @RequestParam (name = "size", defaultValue = "7") int size){
        Page<Player> players = playerService.getAllPlayersPerPage(page, size);
        modelMap.addAttribute("players", players);
        modelMap.addAttribute("pages", new int[players.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listPlayers";
    }

    @RequestMapping("/showCreate")
    public String showCreate(){
        return "createPlayer";
    }

    @RequestMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player") Player player, @RequestParam("sens") Double sens, ModelMap modelMap) throws ParseException {
        player.setSens(sens);
        Player savePlayer = playerService.savePlayer(player);
        String msg ="Player Saved with Id "+savePlayer.getPlayerId();
        modelMap.addAttribute("msg", msg);
        return "createPlayer";
    }

    @RequestMapping("/deletePlayer")
    public String deletePlayer(@RequestParam("id") Long id, ModelMap modelMap, @RequestParam (name="page", defaultValue = "0") int page, @RequestParam (name = "size", defaultValue = "7") int size)
    {
        playerService.deletePlayerById(id);
        Page<Player> players = playerService.getAllPlayersPerPage(page, size);
        modelMap.addAttribute("players", players);
        modelMap.addAttribute("pages", new int[players.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listPlayers";
    }

    @RequestMapping("/editPlayer")
    public String editerPlayer(@RequestParam("id") Long id, ModelMap modelMap)
    {
        Player p= playerService.getPlayer(id);
        modelMap.addAttribute("player", p);
        return "editerPlayer";
    }

    @RequestMapping("/updatePlayer")
    public String updatePlayer(@ModelAttribute("player") Player player, @RequestParam("sens") Double sens, ModelMap modelMap) throws ParseException {
        player.setSens(sens);
        playerService.updatePlayer(player);
        List<Player> prods = playerService.getAllPlayers();
        modelMap.addAttribute("players", prods);
        return "listPlayers";
    }
}



