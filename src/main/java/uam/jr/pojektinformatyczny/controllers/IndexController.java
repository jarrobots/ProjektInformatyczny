package uam.jr.pojektinformatyczny.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uam.jr.pojektinformatyczny.entities.Admin;
import uam.jr.pojektinformatyczny.entities.Event;
import uam.jr.pojektinformatyczny.entities.Management;
import uam.jr.pojektinformatyczny.entities.Team;
import uam.jr.pojektinformatyczny.services.AdminService;
import uam.jr.pojektinformatyczny.services.EventService;
import uam.jr.pojektinformatyczny.services.ManagementService;
import uam.jr.pojektinformatyczny.services.TeamService;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ManagementService manService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TeamService teamService;



    @PostMapping(value = "/generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {
        Team team1 = teamService.save(new Team(1,"ZAS", "zespół aplikacji serwerowych"));
        Team team2 = teamService.save(new Team(2,"ZPM", "Zespół pamięci masowej"));
        Team team3 = teamService.save(new Team(3, "ZSK", "Zespół sieci komputerowych"));

        Admin admin1 = adminService.save(new Admin(1,"Janusz", "Mekka", team1, "bankowość"));
        Admin admin2 = adminService.save(new Admin(2,"Jarosław","Kaczorowski",team1,"aplikacja główna"));
        Admin admin3 = adminService.save(new Admin(3,"Donald","Tuskowicz",team1,"serwery"));
        Admin admin4 = adminService.save(new Admin(4,"Michał","Nowak",team2,"Linux"));
        Admin admin5 = adminService.save(new Admin(5,"Marcin","Kowalski",team2, "Linux"));
        Admin admin6 = adminService.save(new Admin(6,"Jan","Abram",team2,"Windows"));
        Admin admin7 = adminService.save(new Admin(7,"Adam","Adamowicz",team2, "Windows"));
        Admin admin8 = adminService.save(new Admin(8, "Jan","Kowalski",team3,"sieci komputerowe"));
        Admin admin9 = adminService.save(new Admin(9,"Dominik","Szymański",team3, "sieci komputerowe"));
        Admin admin10 = adminService.save(new Admin(10,"Arkadiusz","Nowak",team3,"sieci komputerowe"));

        Event event1 = eventService.save(new Event(1,"konfiguracja","konfiguracja infrastruktury serwerowej",team2,2024,2,10,8,0));
        Event event2 = eventService.save(new Event(1,"konfiguracja","konfiguracja sieci komputerowych",team2,2024,2,10,14,0));
        Event event3 = eventService.save(new Event(1,"konfiguracja","konfiguracja aplikacji serwerowych",team2,2024,2,11,8,0));

        Management man1 = manService.save(new Management(1,"start",1,admin2,event3));
        Management man2 = manService.save(new Management(2,"dostarczenie osprzętu",3,admin4,event1));
        return "Done";
    }
}
