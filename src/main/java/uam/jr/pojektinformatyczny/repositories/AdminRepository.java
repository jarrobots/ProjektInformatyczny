package uam.jr.pojektinformatyczny.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uam.jr.pojektinformatyczny.entities.Admin;


public interface AdminRepository extends CrudRepository<Admin, Integer>, PagingAndSortingRepository<Admin, Integer> {
}
