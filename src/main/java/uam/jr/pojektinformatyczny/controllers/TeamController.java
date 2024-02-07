package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uam.jr.pojektinformatyczny.entities.Team;
import uam.jr.pojektinformatyczny.services.TeamService;

import java.util.UUID;


@RestController
@RequestMapping({"/team"})
public class TeamController {
    @Autowired
    private TeamService teamService;

    public TeamController() {
    }

    @GetMapping(value = "/")
    public Iterable<Team> list(Model model) {
        return this.teamService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Team getByPublicId(@PathVariable("id") Integer publicId) {
        return this.teamService.findByID(publicId).get();
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Team> create(@RequestBody @Validated Team team) {
        team.setTeamId(Integer.parseInt(UUID.randomUUID().toString()));
        teamService.save(team);
        return ResponseEntity.ok().body(team);
    }
}

