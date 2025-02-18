# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy the source code
COPY src src

# Build the application
RUN ./mvnw clean package

# Expose the port the app runs on
EXPOSE 8089

# Run the application
CMD ["java", "-jar", "target/SpringMongoProject-0.0.1-SNAPSHOT.jar"]