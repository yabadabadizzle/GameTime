package pl.gametime.Controller;

import org.springframework.web.bind.annotation.*;
import pl.gametime.Exception.ResourceNotFoundException;
import pl.gametime.Model.Player;
import pl.gametime.Repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
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
    @RequestMapping("/findplayerbyid")
    public String findById(@RequestParam("id") long id)
    {
        String result= "";
        result = playerRepository.findById(id).toString();
        return result;
    }

    @RequestMapping("/deleteplayerbyid")

    public void deleteById(@RequestParam("id") long id)
    {
        playerRepository.deleteById(id);
    }
    @PutMapping("/players/{player_id}")
    public Player updatePlayer(@PathVariable Long player_id,
                                   @Valid @RequestBody Player player) {
        return playerRepository.findById(player_id).map(editedPlayer -> {
                    player.setFirstname(player.getFirstname());
                    player.setLastname(player.getLastname());
                    player.setClubname(player.getClubname());
                    player.setSalary(player.getSalary());
                    return playerRepository.save(editedPlayer);
                }).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + player_id));
    }

    @PostMapping("/addplayer")
    public Player createCustomer(@RequestBody Player player)
    {
        return playerRepository.save(player);
    }
}
