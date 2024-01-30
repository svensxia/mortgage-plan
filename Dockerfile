FROM openjdk:8

# Copy your JAR file into the container
ADD target/project-0.0.1-SNAPSHOT.jar project-0.0.1-SNAPSHOT.jar

# Define the command to run your Java application
ENTRYPOINT ["java", "-jar", "project-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080