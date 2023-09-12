# Use an official Tomcat image as the base image
FROM tomcat:9.0

# Create a directory within the Tomcat container to store your web application
WORKDIR /usr/local/tomcat/webapps/your-web-app

# Copy your compiled WAR file to the Tomcat webapps directory (if applicable)
# COPY your-web-app.war .  # Uncomment and adjust this line if using a WAR file

# Copy your JSP files and other web application resources
COPY ./src/main/webapp/WEB-INF ./WEB-INF
COPY ./src/main/webapp/*.jsp ./
COPY ./src/main/webapp/css ./css  # Example: Copy CSS files
COPY ./src/main/webapp/js ./js    # Example: Copy JavaScript files
# Add any other resource directories as needed

# Optionally, you can copy configuration files or perform additional setup if needed
# COPY ./config-dir /usr/local/tomcat/conf/

# Expose the port that Tomcat will run on (default is 8080)
EXPOSE 8080

# Define the entry point to start Tomcat
CMD ["catalina.sh", "run"]


# Use the official Maven image as the build stage
FROM maven:3.8.3-openjdk-17-slim AS build

# Set the working directory inside the build stage
WORKDIR /app

# Copy only the POM file to the container
COPY pom.xml .

# Download project dependencies (if any)
RUN mvn dependency:go-offline -B

# Copy the rest of the source code to the container
COPY src ./src

# Build the application
RUN mvn package

# Start a new stage for the runtime image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the runtime stage
WORKDIR /app

# Copy the compiled JAR file from the build stage to the runtime stage
COPY --from=build /app/target/myFirst-WebApp-0.0.1-SNAPSHOT.war app.war

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Define the entry point for your application
ENTRYPOINT ["java", "-jar", "app.war"]
