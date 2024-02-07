package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uam.jr.pojektinformatyczny.entities.Team;
import uam.jr.pojektinformatyczny.services.TeamService;


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
}

