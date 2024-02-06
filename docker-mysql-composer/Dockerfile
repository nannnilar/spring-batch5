# Start with a base image containing Java runtime
FROM openjdk
 # Add Maintainer Info
LABEL maintainer="Kyaw"
 # Make port 8080 available to the world outside this container
EXPOSE 8080
 # The application's jar file
ARG JAR_FILE=target/*.jar
 # Add the application's jar to the container
COPY ${JAR_FILE} docker-mysql-compose-0.0.1-SNAPSHOT.jar
 # Run the jar file
ENTRYPOINT ["java", "-jar", "/docker-mysql-compose-0.0.1-SNAPSHOT.jar"]