package pl.gametime.Controller;

import org.springframework.web.bind.annotation.*;
import pl.gametime.Model.Player;
import pl.gametime.Repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping("/hello")
    public String wypisz()
    {
        return "siema";
    }

    @GetMapping("/getallplayers")
    public List<Player> getAll(){
        return playerRepository.findAll();

    }

    @PostMapping("/addplayer")
    public Player createCustomer(@RequestBody Player player)
    {
        return playerRepository.save(player);
    }
}
