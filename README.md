HMS-API (Hospital Management System) — README
=============================================

> Minimal Spring Boot REST backend for hospital patient management.**Status:** MVP — one working API: **Get all patients** (GET /api/patients).More CRUD endpoints (create/update/delete/search) are coming soon.

Quick summary (what we have so far)
-----------------------------------

*   Spring Boot 4.0.0 application

*   JPA (Hibernate) + PostgreSQL for persistence

*   Patient entity implemented (fields: id, firstName, middleName, lastName, dateOfBirth, gender, phonePrimary, email, addressLine1, nationalIdType, nationalId, emergencyContactName, emergencyContactPhone, createdAt, updatedAt, version)

*   One REST endpoint implemented:**GET /api/patients** — returns all patient records

*   Unit/integration tests run with Maven (mvn test) — tested and passing

*   Lombok used for boilerplate (@Getter, @Setter, @ToString, etc.)


Tech stack
----------

*   Java (configured java.version = 21 in pom.xml; project worked with JDK 23 in logs — JDK 21+ recommended)

*   Spring Boot 4.0.0

*   Spring Data JPA (Hibernate 7)

*   PostgreSQL

*   Maven

*   Lombok

*   JUnit 6 (via Spring Boot test starter)

*   Mockito / AssertJ (for tests bundled in spring-boot-starter-test)


Project structure (important files)
-----------------------------------

```bash   
src/    
main/      
java/com/hms/api/        
HospitalManagementApiApplication.java        
entities/Patient.java        <-- JPA entity (Lombok @ToString present)        
repository/PatientRepository.java        
controller/PatientController.java  <-- GET /api/patients    
resources/      
application.properties        <-- DB config  pom.xml   
```

Database (Postgres) — quick setup
---------------------------------

1.  Install PostgreSQL and create a database, e.g. hms.

2.  Create user / grant privileges or use existing DB user.


Example (psql):

```bash   
CREATE DATABASE hms;  
CREATE USER hms_user WITH PASSWORD 'hms_password';  
GRANT ALL PRIVILEGES ON DATABASE hms TO hms_user;   
```

1.  Configure src/main/resources/application.properties (example):


```bash   
spring.datasource.url=jdbc:postgresql://localhost:5432/hms  
spring.datasource.username=hms_user  
spring.datasource.password=hms_password   
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
spring.jpa.properties.hibernate.format_sql=true   
```