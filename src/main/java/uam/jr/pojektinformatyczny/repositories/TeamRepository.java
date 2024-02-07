package uam.jr.pojektinformatyczny.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uam.jr.pojektinformatyczny.entities.Team;


public interface TeamRepository extends CrudRepository<Team, Integer>, PagingAndSortingRepository<Team, Integer> {
}