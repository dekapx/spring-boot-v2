## Spring Boot Docker Compose Example

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

--------------------------------------------------------------------------------------------
## setup postgres for dev environment
# Pull PostgreSQL latest image
$ docker pull postgres

# Setup and run PostgreSQL image in docker container
$ docker run -d --name pg-docker-dev -e POSTGRES_USER=dekapx -e POSTGRES_PASSWORD=passw0rd -e POSTGRES_DB=testdb -p 5432:5432 postgres:latest
--------------------------------------------------------------------------------------------
