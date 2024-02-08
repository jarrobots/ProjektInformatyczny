package uam.jr.pojektinformatyczny.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import uam.jr.pojektinformatyczny.entities.Team;
import uam.jr.pojektinformatyczny.repositories.TeamRepository;


@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository team) {
        this.teamRepository = team;
    }

    public Team save(Team team) {
        this.teamRepository.save(team);
        return team;
    }

    public Optional<Team> findByID(int id) {
        return this.teamRepository.findById(id);
    }

    public void deleteById(int id) {
        this.teamRepository.deleteById(id);
    }

    public Iterable<Team> findAll() {
        return this.teamRepository.findAll();
    }

    public boolean checkIfExist(int id){
        return (teamRepository.checkIfExist(id) > 0);
    }

    public Integer countDetachedEvents(int id){ return teamRepository.countEvents(id);}

}

