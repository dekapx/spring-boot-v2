------------------------------------------------------
- Application URLs -
------------------------------------------------------
- http://localhost:9090/api/ping
- http://localhost:9090/swagger-ui.html

------------------------------------------------------
- Application Docker Build, Deploy & Run -
------------------------------------------------------
# Build/rebuild an image from the project directory
$ docker build -f Dockerfile -t url-generator .

# Run the docker image
$ docker run -p 9090:9090 url-generator

------------------------------------------------------
- PostgreSQL Docker Setup -
------------------------------------------------------
# Pull PostgreSQL latest image
$ docker pull postgres

# Setup and run PostgreSQL image in docker container
$ docker run -d --name docker-postgres -e POSTGRES_USER=dekapx -e POSTGRES_PASSWORD=passw0rd -e POSTGRES_DB=testdb -p 5432:5432 postgres:latest
------------------------------------------------------------------------------------------------------------------------------------------------