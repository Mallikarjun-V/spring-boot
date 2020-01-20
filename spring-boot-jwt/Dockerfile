FROM openjdk:8
ADD target/spring-boot-jwt-0.0.1-SNAPSHOT.jar spring-boot-jwt.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-jwt.jar"]
EXPOSE 8080