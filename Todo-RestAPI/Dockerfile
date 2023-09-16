# Use the official AdoptOpenJDK 17 as the base image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file (pom.xml) into the container
COPY pom.xml .

# Download and install Maven dependencies (this step is cached if the pom.xml file hasn't changed)
RUN mvn dependency:go-offline

# Copy the application source code into the container
COPY src/ /app/src/

# Build the application using Maven
RUN mvn package -DskipTests

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "target/Todo-RestAPI-0.0.1.jar"]
