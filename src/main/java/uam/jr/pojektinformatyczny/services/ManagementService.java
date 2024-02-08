package uam.jr.pojektinformatyczny.services;


import java.util.Optional;
import org.springframework.stereotype.Service;
import uam.jr.pojektinformatyczny.entities.Management;
import uam.jr.pojektinformatyczny.repositories.ManagementRepository;


@Service
public class ManagementService {
    private final ManagementRepository manRepository;

    public ManagementService(ManagementRepository manRepository) {
        this.manRepository = manRepository;
    }

    public Management save(Management man) {
        this.manRepository.save(man);
        return man;
    }

    public Optional<Management> findByID(int id) {
        return this.manRepository.findById(id);
    }

    public void deleteById(int id) {
        this.manRepository.deleteById(id);
    }

    public Iterable<Management> findAll() {
        return this.manRepository.findAll();
    }

    public boolean checkIfExist(int id){
        return (manRepository.checkIfExist(id) > 0);
    }
}
