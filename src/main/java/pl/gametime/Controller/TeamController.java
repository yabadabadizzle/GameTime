package pl.gametime.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.gametime.Exception.ResourceNotFoundException;
import pl.gametime.Model.Team;
import pl.gametime.Repo.TeamRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @RequestMapping("/druzyna")
    public String wypisz()
    {
        return "tu druzyna";
    }

    @GetMapping("/getallTeams")
    public List<Team> getAll(){
        return teamRepository.findAll();

    }
    @RequestMapping("/findteambyid")
    public String findById(@RequestParam("id") long team_id)
    {
        String result= "";
        result = teamRepository.findById(team_id).toString();
        return result;
    }

    @RequestMapping("/deteleteambyid")

    public void deleteById(@RequestParam("id") long id)
    {
        teamRepository.deleteById(id);
    }
    @PutMapping("/teams/{team_id}")
    public Team updateTeam(@PathVariable Long team_id,
                               @Valid @RequestBody Team team) {
        return teamRepository.findById(team_id).map(editedTeam -> {
            team.setClubname(team.getClubname());
            team.setHometown(team.getHometown());
            team.setConference(team.getConference());
            return teamRepository.save(editedTeam);
        }).orElseThrow(() -> new ResourceNotFoundException("Team not found with id " + team_id));
    }

    @PostMapping("/addTeam")
    public Team createTeam(@RequestBody Team team)
    {
        return teamRepository.save(team);
    }

}
