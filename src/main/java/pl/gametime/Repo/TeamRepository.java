package pl.gametime.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gametime.Model.Team;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
