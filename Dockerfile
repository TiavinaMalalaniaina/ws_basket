FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/WS-0.0.1-SNAPSHOT.jar /app/WS-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/WS-0.0.1-SNAPSHOT.jar"]
