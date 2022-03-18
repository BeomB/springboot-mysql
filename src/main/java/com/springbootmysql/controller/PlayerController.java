package com.springbootmysql.controller;


import com.springbootmysql.entity.Player;
import com.springbootmysql.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/player")
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


}







