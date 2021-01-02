# Deployment using Docker Containers (User-service with mongoDB)

$ git clone https://github.com/Mallikarjun-V/spring-boot.git

$ cd microservices

Build the project
$ mvn -DskipTests package

$ docker build -t mallu33378/user-service:latest ./user-service/

$ docker build -t mallu33378/api-service:latest ./api-service/

##### create network called backend with driver bridge
$ docker network create backend

$ docker pull mongo:latest

$ docker run -d -p 27017:27017 --network backend -v ~/mongo/data:/data/db --name mongodb mongo:latest

##### evvironment variable MONGO_HOST property is the name of the mongo container, so that user-service can communicate to mongoDB container
$ docker run -d -p 8080:8080 --network backend -e MONGO_HOST=mongodb --name user-service mallu33378/user-service:latest

$ docker run -d -p 8081:8080 --network backend --name api-service mallu33378/api-service:latest

##### check logs of the container
$ docker logs api-service

##### to get into container
docker exec -it mongodb bash

###### execute mongo commands
$ mongo

$ show dbs

$ user demo

$ show collections
##### list all records in users collection
$ db.users.find()

##### to check the network/volume of the container
docker inspect container api-service

Test API

$ curl http://host:8081/api/users

Microservices can communicate through conatiner names if connected to the same bridge network.

##### to check memory and CPU usage for all the containers
$ docker stats

##### shows memory stats by conetainer name : api-service
$ docker stats api-service
