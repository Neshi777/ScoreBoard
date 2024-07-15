# Live Football World Cup Scoreboard

This Java library implements a simple scoreboard for tracking ongoing football matches. It allows starting new matches, updating scores, finishing matches, and retrieving a summary of matches sorted by score and start time.

## Overview
This library provides a simple in-memory solution to manage live football match scores for the World Cup. The scoreboard supports starting new games, updating scores, finishing games, and retrieving a summary of ongoing matches.

## Features
Start a New Game: Initializes a match with a score of 0-0.
Update Score: Updates the score of an ongoing match.
Finish Game: Removes a match from the scoreboard.
Get Summary: Retrieves a summary of all ongoing matches ordered by their total score and start time.

## Usage
This project is designed as a Java library and does not include a main class. It can be integrated into other applications where the functionality is needed.

Maven Dependency
To use this library in your project, add the following dependency to your pom.xml file:
```
<dependency>
    <groupId>com.example</groupId>
    <artifactId>live-football-scoreboard</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Project Structure

```
src/
|-- main/
|   |-- java/
|       |-- com/
|           |-- scoreboard/
|               |-- model/
|               |   |-- Match.java
|               |-- service/
|                   |-- FootballScoreService.java
|-- test/
|   |-- java/
|       |-- com/
|           |-- scoreboard/
|               |-- service/
|                   |-- FootballScoreServiceTest.java
|                   |-- FootballScoreIntegrationTest.java

```

## Building and Running Tests
To build the project and run the tests, use the following Maven commands:

```
# Compile the project
mvn compile

# Run the tests
mvn test
```

## Dependencies
This project uses the following dependencies:

`SLF4J API: 2.0.0`

`SLF4J Simple Logger: 2.0.0`

`JUnit 5: 5.8.1`

`JUnit 5 Parameterized Tests: 5.8.2`


## Assumptions
No Main Class: This project is a library and is not intended to be run as a standalone application. Therefore, it does not include a main class.

In-Memory Storage: The scoreboard is stored in memory using a list as specified in Requirements.

SLF4J for Logging: SLF4J is used for logging. The slf4j-simple implementation is used for simplicity, but it can be replaced with any other SLF4J-compatible logging framework if needed.

Test-Driven Development: JUnit 5 is used for testing, including parameterized tests to cover various scenarios and edge cases - as specified in requirements it has influence on the Git flow 
as means to show that specified parts of functionalities got their tests prepared before/in pair with logic development. Normally git history should be clean of artificial subdivision, 
focused on logical main parts and often flattened for clearness. The showed git history is mix of both - to keep commits clearly stated main parts and at the same time to show tests being specified as functionality and its scope descriptors.

Error Handling: The library includes basic error handling for invalid operations, such as starting a match with null or empty team names, updating scores for non-existent matches, and ensuring scores are non-negative.

Code Quality: The implementation follows SOLID principles, ensuring a clean and maintainable codebase. TDD has been applied to ensure the functionality meets the requirements and handles edge cases appropriately.

Logging: Comprehensive logging is included to track operations and errors, making it easier to debug and monitor the library's behavior.


## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contact
For questions or feedback, please contact [Marcin M] at [marcin.miechowiak@gmail.com].