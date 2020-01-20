FROM openjdk:8
ADD target/spring-boot-actuator-0.0.1-SNAPSHOT.jar spring-boot-actuator.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-actuator.jar"]
EXPOSE 8080