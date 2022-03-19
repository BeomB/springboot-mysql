package com.springbootmysql.controller;


import com.springbootmysql.entity.Player;
import com.springbootmysql.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PlayerController {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

//    @GetMapping("/get")
//    public List<Player> GetPlayer()
//    {
//        return (List<Player>) playerRepository.findAll();
//    }

    @GetMapping("/get")
    public Iterable<Player> GetPlayer() {
        return playerRepository.findAll();
    }

    @PostMapping("/add")
    public Player put(@RequestParam String name, @RequestParam Long goal, @RequestParam Long assist) {

        return playerRepository.save(new Player(name, goal, assist));
    }

    @PostMapping("/addd")
    public String ADD(@RequestBody Player player)
    {
        playerRepository.save(player);
        return "add";
    }


    @PutMapping(value = "/update/{number}")
    public Player Update(@PathVariable Long number,@RequestParam String name, @RequestParam Long goal, Long assist)
    {
        Optional<Player> player = playerRepository.findById(number);
        player.get().setName(name);
        player.get().setGoal(goal);
        player.get().setAssist(assist);
        return playerRepository.save(player.get());
    }

    @PutMapping(value = "/updated/{number}")
    public Player Updated(@RequestBody Player toplayer, @PathVariable long number)
    {
        Optional<Player> find_player = playerRepository.findById(number);
        find_player.get().setName(toplayer.getName());
        find_player.get().setGoal(toplayer.getGoal());
        find_player.get().setAssist(toplayer.getAssist());
        return playerRepository.save(find_player.get());
    }

    @DeleteMapping(value = "delete/{number}")
    public String Delete(@PathVariable long number)
    {
        playerRepository.deleteById(number);
        return "success";
    }







}







