package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import uam.jr.pojektinformatyczny.entities.Team;
import uam.jr.pojektinformatyczny.services.TeamService;

import java.util.UUID;


@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    public TeamController() {
    }

    @GetMapping(value = "/list")
    public Iterable<Team> list(Model model) {
        return this.teamService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Team getByPublicId(@PathVariable("id") Integer publicId) {
        return this.teamService.findByID(publicId).get();
    }

    @GetMapping(value = "/count/{id}")
    public Integer getCountOfDetachedEvents(@PathVariable("id") Integer publicId){
        return this.teamService.countDetachedEvents(publicId);
    }


    @PostMapping(value = "/add")
    public ResponseEntity<Team> create(@RequestBody @Validated Team team) {
        team.setTeamId(Integer.parseInt(UUID.randomUUID().toString()));
        teamService.save(team);
        return ResponseEntity.ok().body(team);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Void> edit(@RequestBody Team team) {
        if (!teamService.checkIfExist(team.getTeamId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            teamService.save(team);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/team/{id}", produces = "application/json")
    public RedirectView delete(@PathVariable Integer id) {
        teamService.deleteById(id);
        return new RedirectView("/list", true);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(MethodArgumentNotValidException exception) {
        return exception.getFieldError().toString();
    }
}

