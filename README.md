# Task Manager API

![CI](https://github.com/Emeric99/task-manager-api/actions/workflows/ci.yml/badge.svg)

Eine REST-API zur Verwaltung von Aufgaben (Tasks), entwickelt mit Spring Boot zur Vertiefung moderner Java-Backend-Technologien.

---

## Funktionen

- **Aufgaben erstellen** – Neue Tasks mit Titel, Beschreibung und Status anlegen
- **Aufgaben abrufen** – Alle Tasks oder eine einzelne Task per ID abfragen
- **Aufgaben aktualisieren** – Bestehende Tasks bearbeiten
- **Aufgaben löschen** – Tasks aus der Datenbank entfernen
- **Schichtenarchitektur** – Saubere Trennung zwischen Controller, Service, Repository und Model

---

## Tech-Stack

| Bereich            | Technologie                  |
| ------------------ | ----------------------------- |
| Backend            | Java 17, Spring Boot          |
| Persistenz         | Spring Data JPA, Hibernate    |
| Datenbank          | H2 (In-Memory) → PostgreSQL geplant |
| Build-Tool         | Maven                         |
| Boilerplate        | Lombok                        |
| API-Test           | Postman                       |

---

## Projektstruktur

task-manager-api/

├── src/main/java/com/emeric/taskmanager/

│   ├── controller/

│   │   └── TaskController.java     # REST-Endpunkte

│   ├── service/

│   │   └── TaskService.java        # Geschäftslogik

│   ├── repository/

│   │   └── TaskRepository.java     # Datenzugriff (Spring Data JPA)

│   ├── model/

│   │   └── Task.java               # Entität

│   └── TaskManagerApiApplication.java

├── src/main/resources/

│   └── application.properties      # Konfiguration

└── pom.xml

---

## API-Endpunkte

| Methode | Endpunkt           | Beschreibung              |
| ------- | ------------------- | -------------------------- |
| GET     | `/api/tasks`         | Alle Tasks abrufen         |
| GET     | `/api/tasks/{id}`     | Eine Task abrufen          |
| POST    | `/api/tasks`         | Neue Task erstellen        |
| PUT     | `/api/tasks/{id}`     | Task aktualisieren         |
| DELETE  | `/api/tasks/{id}`     | Task löschen                |

---

## Lokale Ausführung

### Voraussetzungen

- Java 17
- Maven

### Starten

```bash
git clone https://github.com/Emeric99/task-manager-api.git
cd task-manager-api
./mvnw spring-boot:run
```

Die API ist anschließend erreichbar unter:
**http://localhost:8080/api/tasks**

---

## Was ich dabei gelernt habe

- Aufbau einer REST-API mit Spring Boot und Spring Data JPA
- Schichtenarchitektur (Controller, Service, Repository, Model)
- Dependency Injection mit Spring (`@Autowired`)
- Automatische CRUD-Operationen über `JpaRepository`
- API-Tests mit Postman (GET, POST, PUT, DELETE)
- CI/CD-Pipeline mit GitHub Actions

---

*Privates Lernprojekt zur Vertiefung von Spring Boot · 2026*
