package uam.jr.pojektinformatyczny.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
public class Event {
    @Id
    private int eventId;
    private String name;
    private ZonedDateTime realiseTime;
    private String des;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;
    @OneToOne
    @JoinColumn(name = "man_id", unique = true)
    private Management management;

    public Event() {
    }

    public Event(int eventId, String name, String des, Team team, int y, int m, int d, int h, int min) {
        this.eventId = eventId;
        this.name = name;
        this.realiseTime = ZonedDateTime.of(LocalDateTime.of(y, m, d, h, min), ZoneId.of("UTC"));
        this.des = des;
        this.team = team;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getRealiseTime() {
        return this.realiseTime;
    }

    public void setRealiseTime(ZonedDateTime realiseTime) {
        this.realiseTime = realiseTime;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Management getManagement() {
        return this.management;
    }

    public void setManagement(Management management) {
        this.management = management;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String toString() {
        return "Event{event_id=" + this.eventId + ", name='" + this.name + "', realiseTime=" + this.realiseTime + ", des='" + this.des + "', team=" + this.team + ", management=" + this.management + "}";
    }
}
