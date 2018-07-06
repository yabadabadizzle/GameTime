package pl.gametime.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gametime.Repo.TeamRepository;

@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @RequestMapping("/druzyna")
    public String wypisz()
    {
        return "tu druzyna";
    }


}
