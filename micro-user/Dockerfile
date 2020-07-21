# Need the Linux O/S in place
FROM openjdk:8-jdk-alpine

# COPY the app jar file in Container
# ADD <src> <dest>
ADD target/micro-user-0.0.1-SNAPSHOT.jar  /tmp/micro-user.jar

# EXPOSE 9090

# Command to run the jar file
# java -jar /tmp/micro-user.jar
CMD ["java", "-jar", "/tmp/micro-user.jar"]
 
