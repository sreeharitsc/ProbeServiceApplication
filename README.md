# ProbeServiceApplication

# Sea Probe Control API

This is a Spring Boot REST API that simulates the movement of a sea probe on a 2D grid ocean floor. The probe can move forward, backward, turn left or right, avoid obstacles, and track the coordinates it visits.

## Features

- Initialize probe with a starting position and direction
- Move forward (`F`), backward (`B`), turn left (`L`), or right (`R`)
- Avoid going outside grid boundaries
- Track visited coordinates
- RESTful API design
- Test-Driven Development (TDD) with `JUnit 5`

## Technologies Used

- Java 1.8
- Maven 3.6
- Springboot 2.4.4

## Build
-- mvn clean install

## Run the application
-- mvn spring-boot:run

## App will start at
-- http://localhost:8080

## API Endpoints

### API 1: Initialize the probe

API POST /api/probe/init

Example JSON request body

```json
{
  "gridWidth": 5,
  "gridHeight": 5,
  "startX": 0,
  "startY": 0,
  "direction": "NORTH"
}
```

Example JSON response

```json
Probe initialized
```

### API 2: Send movement commands

API POST /api/probe/commands

Example JSON request body

```json
{
  "commands": "FFRFF"
}
```

Example JSON response

```json
Commands executed
```

### API 3: GET probe status

API GET /api/probe/status

Example JSON response

```json
{
  "currentPosition": {
    "x": 2,
    "y": 2
  },
  "direction": "EAST",
  "visitedPath": [
    { "x": 0, "y": 0 },
    { "x": 0, "y": 1 },
    { "x": 0, "y": 2 },
    { "x": 1, "y": 2 },
    { "x": 2, "y": 2 }
  ]
}
```


