# Utiliser une image de base avec Java 17
FROM openjdk:17-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR de votre projet dans le conteneur
COPY target/ws-0.0.1-SNAPSHOT.jar /app/ws-0.0.1-SNAPSHOT.jar

# Exposer le port sur lequel votre application Spring Boot écoute
EXPOSE 8080

# Commande pour exécuter votre application Spring Boot
CMD ["java", "-jar", "/app/ws-0.0.1-SNAPSHOT.jar"]
