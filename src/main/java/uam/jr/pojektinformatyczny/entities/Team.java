package uam.jr.pojektinformatyczny.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import uam.jr.pojektinformatyczny.entities.Admin;

@Entity
public class Team {
    @Id
    private int teamId;
    private String teamName;
    @OneToOne
    @JoinColumn(name = "admin_id", unique = true)
    private Admin leader;
    private String des;

    public Team() {}

    public Team(int teamId, String teamName, String des) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.des = des;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Admin getLeader() {
        return this.leader;
    }

    public void setLeader(Admin leader) {
        this.leader = leader;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String toString() {
        int var10000 = this.teamId;
        return "Team{teamId=" + var10000 + ", teamName='" + this.teamName + "', leader=" + this.leader.getLastName() + ", des='" + this.des + "'}";
    }
}

