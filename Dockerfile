FROM openjdk:17
LABEL authors="FAMILIA"
WORKDIR /app
COPY target/mensajeria-service-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-jar", "mensajeria-service-0.0.1-SNAPSHOT.jar"]
