# JavaPort

Landing planes with a Java built air traffic control system

## Getting started

This project uses Java 11, and Gradle 6.9

Clone this repository and navigate to the project root

```shell
git clone git@github.com:AJ8GH/java-port.git
cd java-port
```

Build the project by running the gradle wrapper:

### On Mac / Unix

```shell
./gradlew build
```

### On Windows

```shell
./gradlew.bat build
```

## Running Tests

Project uses `JUnit` for testing, with class dependencies mocked with `Mockito`. 

To run all unit tests, ensure you are in the root folder and run:

```shell
gradle test
```

Add the `--info` flag to see more detailed output.

## Design

Airport class:
* Knows its capacity and if it contains a specific plane

Plane:
* Knows if it is grounded or airborne

Weather:
* Knows if it is stormy or sunny

Edge cases:
* Custom exceptions thrown when:
    * Taking off or landing in stormy weather
    * Landing at an airport at max capacity
    * Taking off from the wrong airport
    * Taking off when airborne or landing when grounded

## Dependencies

### Build tool

`Gradle`

### Modules

* `testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'`
* `testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'`
* `implementation 'org.junit.jupiter:junit-jupiter:5.7.2'`
* `implementation 'org.mockito:mockito-inline:3.11.1'`
* `implementation 'org.mockito:mockito-junit-jupiter:3.11.1'`
* `testCompile 'org.mockito:mockito-core:3.11.1'`
