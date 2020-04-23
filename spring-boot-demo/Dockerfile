FROM openjdk:8
ADD target/spring-boot-demo-0.0.1-SNAPSHOT.jar spring-boot-demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-demo.jar"]
EXPOSE 8080