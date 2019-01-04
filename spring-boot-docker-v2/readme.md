## Spring Boot Docker Compose Example

# Build the project
$ mvn clean install
$ mvn clean install -Dmaven.test.skip=true

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
$ docker run -d --name pg-docker-dev -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=testdb -p 5432:5432 postgres:latest
--------------------------------------------------------------------------------------------
# Application URLs -
- http://localhost:9090/api/ping
- http://localhost:9090/swagger-ui.html
--------------------------------------------------------------------------------------------
spring.datasource.url=jdbc:postgresql://pgdocker:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=create
