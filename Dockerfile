FROM ubuntu:latest

RUN apt-get update && \
    apt-get install -y postgresql && \
    apt-get install -y openjdk-17-jdk

EXPOSE 5432

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=malalaniaina
ENV POSTGRES_DB=basket

COPY src/main/java/com/example/ws/Data/Data.sql /docker-entrypoint-initdb.d/

EXPOSE 8080

COPY target/ws-0.0.1-SNAPSHOT.jar /app/ws-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/app/ws-0.0.1-SNAPSHOT.jar"]
