package pl.gametime.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player
{
    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long player_id;
    private String firstname;
    private String lastname;
    private String clubname;
    private long salary;

    public Player(String firstname, String lastname, String clubname, long salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.clubname = clubname;
        this.salary = salary;
    }



    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }





    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public Player() {
    }


}
