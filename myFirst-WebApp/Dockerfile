# Use an official OpenJDK runtime as a parent image
FROM maven:3.8.2-jdk-17 As build
COPY . .
RUN mvn clean package -Pprod -DskipTests


FROM openjdk:17-jdk-alpine


# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY target/*.jar /app/app.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]