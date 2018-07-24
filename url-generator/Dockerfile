# Base image containing Java runtime
FROM openjdk:10

# Application's jar to the container
ADD target/url-generator-0.0.1-SNAPSHOT.jar url-generator.jar

# Make port 8080 available to the world outside this container
EXPOSE 9090

# Run the jar file
ENTRYPOINT ["java", "-jar","/url-generator.jar"]