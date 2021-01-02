$ git clone https://github.com/Mallikarjun-V/spring-boot.git

$ cd microservices

Build the project
$ mvn -DskipTests package

$ docker build -t db-service:latest ./db-service/
$ docker build -t db-service:latest ./api-service/

#create network called backend with driver bridge
$ docker network create backend

$ docker pull mongo:latest
$ docker run -d -p 27017:27017 --network backend -v ~/mongo/data:/data/db --name mongodb mongo:latest

$ docker run -d -p 8080:8080 --network backend --name db-service db-service:latest

$ docker run -d -p 8081:8080 --network backend --name api-service api-service:latest

# check logs of the container
$ docker logs api-service

#to get into container
docker exec -it mongodb bash

#execute mongo commands
$ mongo
$ show dbs
$ user demo
$ show collections
#list all records in users collection
$ db.users.find()

#to check the network/volume of the container
docker inspect container api-service

Test API
curl http://host:8081/api/users

Microservices can communicate through conatiner names if connected to the same bridge network.

#to check memory and CPU usage 
$ docker stats
# shows stats for all the containers

$ docker stats api-service
#shows memory stats by conetainer name : api-service
