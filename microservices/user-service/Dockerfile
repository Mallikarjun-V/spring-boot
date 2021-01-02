FROM openjdk:8
ADD target/db-service-0.0.1-SNAPSHOT.jar db-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/db-service.jar"]
EXPOSE 8080