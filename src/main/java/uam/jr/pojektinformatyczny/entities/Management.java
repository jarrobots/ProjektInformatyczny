package uam.jr.pojektinformatyczny.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import uam.jr.pojektinformatyczny.entities.Admin;
import uam.jr.pojektinformatyczny.entities.Event;

@Entity
public class Management {
    @Id
    private int manId;
    private String name;
    private int solutionTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @OneToOne(mappedBy = "management")
    Event event;

    public Management() {}

    public Management(int manId, String name, int solutionTime, Admin admin, Event event) {
        this.manId = manId;
        this.name = name;
        this.solutionTime = solutionTime;
        this.admin = admin;
        this.event = event;
    }

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSolutionTime() {
        return this.solutionTime;
    }

    public void setSolutionTime(int solutionTime) {
        this.solutionTime = solutionTime;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String toString() {
        return "Management{man_id=" + this.manId + ", name='" + this.name + "', solutionTime=" + this.solutionTime + ", admin=" + this.admin + "}";
    }
}
