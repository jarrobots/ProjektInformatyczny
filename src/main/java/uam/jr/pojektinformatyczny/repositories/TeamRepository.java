package uam.jr.pojektinformatyczny.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uam.jr.pojektinformatyczny.entities.Team;


public interface TeamRepository extends CrudRepository<Team, Integer>, PagingAndSortingRepository<Team, Integer> {
    @Query("select count(t.teamId) from Team t where t.teamId = ?1")
    Integer checkIfExist(Integer id);


    @Query("select count(e.eventId) from Team t Left join Event e on e.eventId = t.teamId WHERE t.teamId = ?1 group by t.teamId")
    Integer countEvents(Integer id);

}