package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import uam.jr.pojektinformatyczny.entities.Admin;
import uam.jr.pojektinformatyczny.services.AdminService;

import java.util.UUID;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    public AdminController() {
    }

    @GetMapping(value = "/list")
    public Iterable<Admin> list(Model model) {
        return this.adminService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Admin getByPublicId(@PathVariable("id") Integer publicId) {
        return this.adminService.findById(publicId).get();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Admin> create(@RequestBody @Validated Admin admin) {
        admin.setAdminId(Integer.parseInt(UUID.randomUUID().toString()));
        adminService.save(admin);
        return ResponseEntity.ok().body(admin);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Void> edit(@RequestBody Admin admin) {
        if (!adminService.checkIfExist(admin.getAdminId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            adminService.save(admin);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/admin/{id}", produces = "application/json")
    public RedirectView delete(@PathVariable Integer id) {
        adminService.deleteById(id);
        return new RedirectView("/admin/list", true);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(MethodArgumentNotValidException exception) {
        return exception.getFieldError().toString();
    }
}
