# Base image containing Java runtime
FROM openjdk:10

# Application's jar to the container
ADD target/spring-boot-docker-0.0.1-SNAPSHOT.jar spring-boot-docker.jar

# Make port 8080 available to the world outside this container
EXPOSE 9090

# Run the jar file
ENTRYPOINT ["java", "-jar","/spring-boot-docker.jar"]