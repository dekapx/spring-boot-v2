----------
- Docker - 
----------
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

# Remove the container
$ docker rm -vf $(docker ps -aq)

# Delete every Docker image
$ docker rmi -f $(docker images -q)

# Delete all unused images and volumes
$ docker system prune --all

---------------------
- Docker PostgreSQL - 
---------------------




