INSERT INTO java_db.public.team(team_id,team_name,des)
VALUES (1,'ZAS','zespół aplikacji serwerowych'),
       (2,'ZPM','zespół pamięci masowej'),
       (3,'ZSK','zespół sieci komputerowych');

INSERT INTO java_db.public.admin(admin_id, team_id, name, last_name, specials)
VALUES (1,1,'Janusz','Mekka','bankowość'),
       (2,1,'Jarosław','Kaczorowski','aplikacja główna'),
       (3,1,'Donald','Tuskowicz','serwery'),
       (4,2,'Michał','Nowak','Linux'),
       (5,2,'Marcin','Kowalski','Linux'),
       (6,2,'Jan', 'Abram','Windows'),
       (7,2,'Adam','Adamowicz','Windows'),
       (8,3,'Jan','Kowalski', 'sieci komputerowe'),
       (9,3,'Dominik','Szymański', 'sieci komputerowe'),
       (10,3,'Arkadiusz','Nowak','sieci komputerowe');

INSERT INTO java_db.public.event(event_id, name, team_id,des, realise_time)
VALUES (1,'konfiguracja',1, 'konfiguracja infrastruktury serwerowej', '2023-06-15 08:00'),
       (2,'konfiguracja',3, 'podłączenie serwera do sieci', '2023-06-15 08:00'),
       (3,'konfiguracja',2, 'uruchomienie aplikacji serwerowych', '2023-06-16 08:00');