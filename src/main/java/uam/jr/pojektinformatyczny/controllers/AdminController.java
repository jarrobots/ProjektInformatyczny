package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uam.jr.pojektinformatyczny.entities.Admin;
import uam.jr.pojektinformatyczny.services.AdminService;


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
}
