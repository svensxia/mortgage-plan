FROM openjdk:8

# Copy your JAR file into the container
ADD target/mortgagePlan-1.0-SNAPSHOT.jar mortgagePlan-1.0-SNAPSHOT.jar

# Define the command to run your Java application
ENTRYPOINT ["java", "-jar", "mortgagePlan-1.0-SNAPSHOT.jar"]

EXPOSE 8080