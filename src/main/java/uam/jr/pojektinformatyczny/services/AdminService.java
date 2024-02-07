package uam.jr.pojektinformatyczny.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import uam.jr.pojektinformatyczny.entities.Admin;
import uam.jr.pojektinformatyczny.repositories.AdminRepository;


@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin add(Admin admin) {
        this.adminRepository.save(admin);
        return admin;
    }

    public Optional<Admin> findById(int id) {
        return this.adminRepository.findById(id);
    }

    public void delete(int id) {
        this.adminRepository.deleteById(id);
    }

    public Iterable<Admin> findAll() {
        return this.adminRepository.findAll();
    }
}

