# TakeMe - Travel Planning Application (Frontend)

A modern travel planning application frontend built with Java and Vaadin framework. This application allows users to search for flights and hotels, manage travelers, and create comprehensive travel plans.

## Technologies

- Java 11+
- Spring Boot
- Vaadin (UI Framework)
- Gradle (Build Tool)
- RESTful API integration

## Features

- **Flight Search**: Search and compare flight offers from various destinations
- **Hotel Search**: Find and book hotels at your destination
- **Traveler Management**: Add and manage travelers for your trips
- **Travel Planning**: Create and save complete travel plans
- **User Authentication**: Register and login to manage your trips

## Project Structure

The project follows a standard Spring Boot application structure:

```
src/main/java/com/kodilla/tripplannerfront/
├── component/       # Reusable UI components
├── config/          # Application configuration
├── dto/             # Data Transfer Objects
├── mapper/          # Object mappers
├── service/         # Business logic services
├── session/         # Session management
├── tripplanerback/  # Backend integration
│   ├── client/      # API clients
│   ├── config/      # Backend configuration
│   └── dto/         # Backend DTOs
└── view/            # Vaadin UI views
```

## Setup and Installation

### Prerequisites

- Java 11 or higher
- Gradle
- Backend service running on port 8083 (see application.properties)

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run the application using Gradle:

```bash
./gradlew bootRun
```

4. Open your browser and navigate to `http://localhost:8084`

## Configuration

The application is configured to connect to a backend service running on `http://localhost:8083/api/v1`. You can modify this in the `application.properties` file:

```properties
vaadin.launch-browser=true
spring.application.name=take-me-front
server.port=8084
backend.api.endpoint.test=http://localhost:8083/api/v1
```

## Usage

1. **Plan a Trip**: Start by searching for flights and hotels using the search form
2. **Manage Travelers**: Add travelers to your trip with their details
3. **Review and Book**: Review your travel plan and save it
4. **View Saved Trips**: Access your saved trips from the "Your trips" section

## Development

### Building the Project

```bash
./gradlew build
```

### Running Tests

```bash
./gradlew test
```
