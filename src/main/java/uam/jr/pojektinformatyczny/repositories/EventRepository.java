package uam.jr.pojektinformatyczny.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uam.jr.pojektinformatyczny.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer>, PagingAndSortingRepository<Event, Integer> {
}
