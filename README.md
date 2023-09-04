# Project Title

Prime Number Generator

## Description

A Spring Boot service that provides a REST api which calculates and returns all the prime numbers up to and including a number provided.

## Getting Started

### Dependencies

* Java 20
* Gradle 8.2.1

### Building

* Download this repository. In the repository root directory run:
```
./gradlew clean build
```

### Executing program
* To run locally, in the repository root directory run:
```
./gradlew run
```
Verify by opening the openapi spec in the browser: http://localhost:8080/swagger-ui/index.html 

* To run on a different host, copy the executable jar file from build/lib/prime-number-service-0.0.1-SNAPSHOT.jar to the destination host and run:
```
java -jar prime-number-service-0.0.1-SNAPSHOT.jar
```

### API Documentation
* Access the Openapi spec of the api using http://<host domain>:8080/swagger-ui/index.html . You can test the apis using this interface as well.
* The api response has cache headers with max age of 1 year.


### Limitations, Known Issues and Roadmap
* The maximum limit upto which prime numbers can be generated is 10,000,000. 
* Add security - check for an apikey in the request
* Error messages can be improved
* Caching is handled in the default algorithm. A mechanism to handle caching across algorithms  can be built.
* Containerize using Docker
* Performance test. Max limit can be increased if the heap size is increased.
* Create a better Openapi spec 
* Add more algorithms
* Add features like give the last N prime numbers till the specified number.
* Handling numbers which are bigger than an integer

