FROM openjdk:8
ADD target/api-service-0.0.1-SNAPSHOT.jar api-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api-service.jar"]
EXPOSE 8080