---------------------------------------------------------------------------------------------------------
# Docker - 
---------------------------------------------------------------------------------------------------------
# Login Docker CLI
$ docker login
    - username & password
    
# Display all images from the repository
$ docker images -a

# Pull Hello World image
$ docker pull hello-world

# Run the image
$ docker run hello-world
        OR
$ docker run <image-id>

# List all running containers
$ docker ps -a

# Stop a running image
$ docker stop <image name>

# Build/rebuild an image from the project directory
$ docker build -f Dockerfile -t spring-boot-docker .

# Run the docker image
$ docker run -p 9090:9090 spring-boot-docker

# Stop the running container
$ docker stop $(docker ps -a -q)

# Delete every Docker containers, must run first as images are attached to containers
$ docker rm -f $(docker ps -a -q)

# Delete every Docker image
$ docker rmi -f $(docker images -q)

# Delete all unused images and volumes
$ docker system prune --all
---------------------------------------------------------------------------------------------------------
# Docker PostgreSQL 

# Display all images
$ docker images

# Display all containers (stop or running)
$ docker ps -a

# Pull PostgreSQL latest image
$ docker pull postgres

# Setup and run PostgreSQL image in docker container
$ docker run -d --name pg-docker-dev -e POSTGRES_USER=dekapx -e POSTGRES_PASSWORD=password -e POSTGRES_DB=testdb -p 5432:5432 postgres:latest

# Stop a running container (pg-docker-dev - name of the image)
$ docker stop pg-docker-dev 

# Stop the running containers
$ docker stop $(docker ps -a -q)

# Remove the container
$ docker rm pg-docker-dev

# Delete every Docker containers, must run first as images are attached to containers
$ docker rm -f $(docker ps -a -q)

# Remove the image (make sure container is not running)
$ docker rmi <IMAGE ID>

# Delete every Docker image
$ docker rmi -f $(docker images -q)

# Delete all unused images and volumes
$ docker system prune --all

# Execute command on running container (-U user, -W database)
$ docker exec -it pg-docker-dev psql -U postgres -W testdb


