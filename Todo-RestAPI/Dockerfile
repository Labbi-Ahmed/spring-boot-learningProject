# Use the official OpenJDK 17 image as the base image
#FROM openjdk:17-jdk

# Set the working directory in the container
#WORKDIR /app

# Copy the Maven project files into the container
#COPY pom.xml .
#COPY src/ /app/src/

# Build the Spring Boot application using Maven
#RUN mvn clean package -DskipTests

# Expose the port your Spring Boot application will run on
#EXPOSE 8080

# Run the Spring Boot application when the container starts
#CMD ["java", "-jar", "target/Todo-RestAPI-0.0.1.jar"]


# Use an official OpenJDK runtime as a parent image
FROM maven:3.8.2-jdk-17 As build
COPY . .
RUN mvn clean package -Pprod -DskipTests


FROM openjdk:17-jdk-alpine


# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY target/Todo-RestAPI-0.0.1.jar /app/app.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
