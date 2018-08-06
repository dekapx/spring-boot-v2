Mandatory Requirements
Design and implement an API for short URL creation
Implement forwarding of short URLs to the original ones
There should be some form of persistent storage
The application should be distributed as one or more Docker images

Additional Requirements
Design and implement an API for gathering different statistics

Assessment
Treat this as a real project. It should be readable, maintainable, and extensible where appropriate.
The implementation should preferably be in Java, however any language can be used.
If you will transfer it to another team - it should be clear how to work with it and what is going on.
You should send us a link to a Git repository that we will be able to clone.
------------------------------------------------------------------------------------------------------------------------------------------------
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