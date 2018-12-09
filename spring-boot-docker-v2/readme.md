# Spring Boot Docker Compose Example

# Build the project
$ mvn clean install

# Start the container
$ cd src/main/docker
$ docker-compose up

# Stop the running container
$ docker stop $(docker ps -a -q)

# Delete every Docker containers, must run first as images are attached to containers
$ docker rm -f $(docker ps -a -q)

# Delete every Docker image
$ docker rmi -f $(docker images -q)

# Delete all unused images and volumes
$ docker system prune --all

# How to run (Open browser and enter URL...)
http://localhost:9090/api/ping