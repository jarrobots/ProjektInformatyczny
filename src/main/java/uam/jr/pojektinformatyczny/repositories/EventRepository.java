package uam.jr.pojektinformatyczny.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uam.jr.pojektinformatyczny.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer>, PagingAndSortingRepository<Event, Integer> {
    @Query("select count(e.eventId) from Event e where e.eventId = ?1")
    Integer checkIfExist(Integer id);
}
