package uam.jr.pojektinformatyczny.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Admin {
    @Id
    private int adminId;
    private String name;
    private String lastName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;
    private String specials;

    public Admin() {}

    public Admin(int adminId, String name, String lastName, Team team, String specials) {
        this.adminId = adminId;
        this.name = name;
        this.lastName = lastName;
        this.team = team;
        this.specials = specials;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getSpecials() {
        return this.specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLatName(String latName) {
        this.lastName = latName;
    }

    public String toString() {
        return "Admin{adminId=" + this.adminId + ", name='" + this.name + "', latName='" + this.lastName + "', team=" + this.team + ", specials='" + this.specials + "'}";
    }
}
