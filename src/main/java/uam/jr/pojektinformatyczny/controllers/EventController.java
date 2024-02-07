package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uam.jr.pojektinformatyczny.entities.Event;
import uam.jr.pojektinformatyczny.services.EventService;


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
        return this.eventService.findByID(publicId).get();
    }
}
