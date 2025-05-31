# PrioritiX
PrioritiX is a simple backend REST API built with Spring Boot that helps you prioritize your daily tasks using the Eisenhower Matrix method. Organize your tasks by urgency and importance to boost your productivity and focus on what truly matters.

<details>
    <summary>
        Phase 1 - Implementation Plan
    </summary>
    
    ## Overview
    Phase 1 focuses on building a simple, functional backend REST API to manage and prioritize tasks based on the Eisenhower Matrix framework. The goal is to create a solid foundation with clean architecture, core CRUD operations, and reliable unit tests.

    ---

    ## Features in Phase 1

    - **Task Management:**  
    - Create new tasks with fields:  
        - Title (String)  
        - Description (String)  
        - Due Date (Date)  
        - Urgent (Boolean)  
        - Important (Boolean)  
        - Done (Boolean)  
    - Retrieve all tasks  
    - Update tasks by ID  
    - Delete tasks by ID

    - **Eisenhower Matrix Classification:**  
    - Tasks automatically fall into one of the four quadrants based on their urgency and importance flags:  
        1. Urgent & Important  
        2. Not Urgent & Important  
        3. Urgent & Not Important  
        4. Not Urgent & Not Important

    - **RESTful API:**  
    - Well-defined endpoints under `/api/tasks`  
    - Use of HTTP status codes for appropriate responses  

    - **Clean Code & Structure:**  
    - Separation of concerns with Controller, Service, and Repository layers  
    - Use Lombok annotations to reduce boilerplate code  
    - Java 17+ features for modern syntax and immutability  

    - **Testing:**  
    - Unit tests using JUnit 5 and Mockito for service and controller layers  
    - Aim for good code coverage and test reliability  

    - **API Testing:**  
    - Postman collection provided for easy API endpoint testing  

    ---

    ## Tech Stack

    - Java 17+  
    - Spring Boot  
    - Gradle  
    - Lombok  
    - JUnit 5 & Mockito  

    ---

    ## How to Run Phase 1

    1. Clone the repository  
    2. Run `./gradlew bootRun` to start the Spring Boot app  
    3. Use Postman or any HTTP client to interact with the API at `http://localhost:8080/api/tasks`
    ---
</details>