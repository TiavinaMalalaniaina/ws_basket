FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/WS-0.0.1-SNAPSHOT.jar /app/WS-0.0.1-SNAPSHOT.jar

COPY src/main/java/com/example/ws/Data/Data.sql /docker-entrypoint-initdb.d/init.sql

EXPOSE 8080

RUN apk --no-cache add postgresql

CMD ["java", "-jar", "/app/WS-0.0.1-SNAPSHOT.jar"]
