package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uam.jr.pojektinformatyczny.entities.Admin;
import uam.jr.pojektinformatyczny.services.AdminService;

import java.util.UUID;


@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminService adminService;

    public AdminController() {
    }

    @GetMapping(value = "/")
    public Iterable<Admin> list(Model model) {
        return this.adminService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Admin getByPublicId(@PathVariable("id") Integer publicId) {
        return this.adminService.findById(publicId).get();
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Admin> create(@RequestBody @Validated Admin admin) {
        admin.setAdminId(Integer.parseInt(UUID.randomUUID().toString()));
        adminService.save(admin);
        return ResponseEntity.ok().body(admin);
    }
}
