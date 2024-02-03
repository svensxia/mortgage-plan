#FROM ubuntu:20.04

#RUN apt update
#RUN apt install default-jdk -y
#COPY . .
#RUN javac App.java

#CMD ["java", "App"]

FROM openjdk:21-jdk

WORKDIR /app

COPY src/main/java/org/example/prospects.txt /app/prospects.txt

# Copy your JAR file into the container
ADD target/mortgagePlan-1.0-SNAPSHOT.jar mortgagePlan-1.0-SNAPSHOT.jar

# Define the command to run your Java application
ENTRYPOINT ["java", "-jar", "mortgagePlan-1.0-SNAPSHOT.jar"]

EXPOSE 8080