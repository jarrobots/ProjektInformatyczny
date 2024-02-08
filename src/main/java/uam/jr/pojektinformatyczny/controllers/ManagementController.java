package uam.jr.pojektinformatyczny.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import uam.jr.pojektinformatyczny.entities.Management;
import uam.jr.pojektinformatyczny.services.ManagementService;

import java.util.UUID;


@RestController
@RequestMapping("/man")
public class ManagementController {
    @Autowired
    private ManagementService manService;

    public ManagementController() {
    }

    @GetMapping(value = "/list")
    public Iterable<Management> list(Model model) {
        return this.manService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Management getByPublicId(@PathVariable("id") Integer publicId) {
        return (Management)this.manService.findByID(publicId).get();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Management> create(@RequestBody @Validated Management man) {
        man.setManId(Integer.parseInt(UUID.randomUUID().toString()));
        manService.save(man);
        return ResponseEntity.ok().body(man);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Void> edit(@RequestBody Management man) {
        if (!manService.checkIfExist(man.getManId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            manService.save(man);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @ResponseBody
    @DeleteMapping(value = "/man/{id}" )
    public RedirectView delete(@PathVariable Integer id) {
        manService.deleteById(id);
        return new RedirectView("/api/productsList", true);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(MethodArgumentNotValidException exception) {
        return exception.getFieldError().toString();
    }
}
