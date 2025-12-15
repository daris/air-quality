# Air Quality

A Spring Boot application providing REST APIs for fetching air quality data from GIOŚ API.

---

## Tech Stack

- **Java** 17+
- **Spring Boot** 3.x
- **Maven**
- **Spring Web**
- **Spring Data JPA**
- **JUnit 5**
- **WireMock** (integration tests)

---

### Build the Project

```bash
mvn clean package
```

---

### Run the Application

```bash
docker compose up -d
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

API will be available at 
```
http://localhost:8080/swagger-ui/index.html
```

---

## Running Tests

```bash
mvn test
```

### Integration Tests

- Uses **WireMock** for external services
- Uses **MockMvc** for controller testing

