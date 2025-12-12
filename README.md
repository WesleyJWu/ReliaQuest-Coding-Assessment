# ReliaQuest-Coding-Assessment

This repository contains the solution for the ReliaQuest entry-level Java challenge. It implements a foundational Spring Boot web application that provides a RESTful API for managing employee records.

## Key Features & Design Highlights

* **Layered Architecture:** Follows the standard **Controller → Service → Repository** pattern for clear separation of concerns, making the application modular and highly testable. 

* **RESTful Endpoints:** Exposes all required CRUD (Create, Read, Delete) functionality for managing `Employee` resources:
    * `GET /api/v1/employee`: Retrieves a list of all current employees (Read All).
    * `POST /api/v1/employee`: Creates a new employee record and returns status `201 CREATED` (Create).
    * `GET /api/v1/employee/{uuid}`: Retrieves a single employee by UUID (Read One).

* **Clean Error Handling:** Uses Java's `Optional` type and Spring's `ResponseStatusException` to handle missing resources, ensuring all invalid lookups correctly return status `404 NOT FOUND`.

* **Build Integrity:** The project is configured with Gradle **8.8** and explicitly targets **Java 17** toolchains, ensuring a stable and consistent build environment.
