package uam.jr.pojektinformatyczny.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uam.jr.pojektinformatyczny.entities.Admin;


public interface AdminRepository extends CrudRepository<Admin, Integer>, PagingAndSortingRepository<Admin, Integer> {
    @Query("select count(a.adminId) from Admin a where a.adminId = ?1")
    Integer checkIfExist(Integer id);
}
