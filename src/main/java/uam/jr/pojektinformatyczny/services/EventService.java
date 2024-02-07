package uam.jr.pojektinformatyczny.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import uam.jr.pojektinformatyczny.entities.Event;
import uam.jr.pojektinformatyczny.repositories.EventRepository;


@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event save(Event event) {
        this.eventRepository.save(event);
        return event;
    }

    public Optional<Event> findByID(int id) {
        return this.eventRepository.findById(id);
    }

    public void deleteByID(int id) {
        this.eventRepository.deleteById(id);
    }

    public Iterable<Event> findAll() {
        return this.eventRepository.findAll();
    }
    public boolean checkIfExist(int id){
        return (eventRepository.checkIfExist(id) > 0);
    }
}

