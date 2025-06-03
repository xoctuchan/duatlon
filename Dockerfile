FROM eclipse-temurin:21-jdk-alpine
COPY target/tiempos-0.0.1-SNAPSHOT.jar /api-v1.jar
ENTRYPOINT ["java", "-jar", "/api-v1.jar"]