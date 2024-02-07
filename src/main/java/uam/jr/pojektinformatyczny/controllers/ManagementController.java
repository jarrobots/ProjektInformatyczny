package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uam.jr.pojektinformatyczny.entities.Management;
import uam.jr.pojektinformatyczny.services.ManagementService;


@RestController
@RequestMapping("/man")
public class ManagementController {
    @Autowired
    private ManagementService manService;

    public ManagementController() {
    }

    @GetMapping(value = "/")
    public Iterable<Management> list(Model model) {
        return this.manService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Management getByPublicId(@PathVariable("id") Integer publicId) {
        return (Management)this.manService.findByID(publicId).get();
    }
}
