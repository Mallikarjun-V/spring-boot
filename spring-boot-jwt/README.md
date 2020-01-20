1. Create Docker Image

Build the maven project to generate JAR
>> mvn clean package

Build a docker image from the specified Dockerfile
>> docker build -t spring-boot-jwt .

List all the docker images
>> docker image ls

2. Run docker image, use the -d option in docker run command to run the container in the background, -p is used to Publish a container’s port(s) to the host

>> docker run -d -p 8080:8080 spring-boot-jwt


OTHER DOCKER COMMANDS

List all the containers running
>> docker container ls

or
>> docker ps

List all containers
>> docker container ls -a

or 
>> docker ps -a

To stop the container gracefully
>> docker stop <container_id>

To kill the container immediately
>> docker kill <container_id>

To remove the container
>> docker rm <container_id>

To remove the image
>> docker rmi <image_id>

For Windows machine access the application via docker-machine ip
>> docker-machine ip

Access below URL in the browser
http://<docker-machine-ip>:8080/test