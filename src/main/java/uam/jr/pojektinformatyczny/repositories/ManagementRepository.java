package uam.jr.pojektinformatyczny.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uam.jr.pojektinformatyczny.entities.Management;


public interface ManagementRepository extends CrudRepository<Management, Integer>, PagingAndSortingRepository<Management, Integer> {
}
