package pl.gametime.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long team_id;

    private String clubname;

    private String hometown;

    private String conference;

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Team(String clubname, String hometown, String conference) {
        this.clubname = clubname;
        this.hometown = hometown;
        this.conference = conference;
    }


}
