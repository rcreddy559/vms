# Use Eclipse Temurin OpenJDK 21 LTS as the base image
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR from the target folder to the container
COPY target/*.jar app.jar

# Expose the application port (default 8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
