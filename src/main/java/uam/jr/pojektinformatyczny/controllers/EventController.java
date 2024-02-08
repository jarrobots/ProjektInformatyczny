package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import uam.jr.pojektinformatyczny.entities.Event;
import uam.jr.pojektinformatyczny.entities.Team;
import uam.jr.pojektinformatyczny.services.EventService;

import java.util.UUID;


@RestController
@RequestMapping("/api")
public class EventController {
    @Autowired
    private EventService eventService;

    public EventController() {
    }

    @GetMapping(value = "/list")
    public Iterable<Event> list(Model model) {
        return this.eventService.findAll();
    }

    @GetMapping(value = "/event/{id}")
    public Event getByPublicId(@PathVariable("id") Integer publicId) {
        return this.eventService.findById(publicId).get();
    }
    @PostMapping(value = "/event/add")
    public ResponseEntity<Event> create(@RequestBody @Validated Event event) {
        event.setEventId(Integer.parseInt(UUID.randomUUID().toString()));
        eventService.save(event);
        return ResponseEntity.ok().body(event);
    }

    @PutMapping(value = "/event/put")
    public ResponseEntity<Void> edit(@RequestBody Event event) {
        if (!eventService.checkIfExist(event.getEventId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            eventService.save(event);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/event/{id}", produces = "application/json")
    public RedirectView delete(@PathVariable Integer id) {
        eventService.deleteById(id);
        return new RedirectView("/api/list", true);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(MethodArgumentNotValidException exception) {
        return exception.getFieldError().toString();
    }
}
