-----------
- URL -
-----------
- http://localhost:9090/hello/
- http://localhost:9090/servers/
- http://localhost:9090/swagger-ui.html

-----------
- Docker -
-----------
# Build/rebuild an image from the project directory
$ docker build -f Dockerfile -t spring-boot-docker .

# Run the docker image
$ docker run -p 9090:9090 spring-boot-docker

# Display all images from the respository
$ docker images -a

# Run the image
$ docker run spring-boot-docker

# List all running containers
$ docker ps -a

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
$ docker pull postgres

$ docker run -d --name docker-postgres -e POSTGRES_USER=dekapx -e POSTGRES_PASSWORD=passw0rd -e POSTGRES_DB=testdb -p 5432:5432 postgres:latest

--------------------------
- SQL Schema and Scripts -
--------------------------
CREATE SEQUENCE SERVERS_ID_SEQ;

CREATE TABLE SERVERS(
  ID INTEGER NOT NULL DEFAULT nextval('SERVERS_ID_SEQ'::regclass),
  NAME VARCHAR(255) not null,
  CONSTRAINT SERVER_PKEY PRIMARY KEY (ID)
);

ALTER SEQUENCE SERVERS_ID_SEQ OWNED BY SERVERS.id;

INSERT INTO SERVERS (NAME) VALUES('Dell PowerEdge T20');
INSERT INTO SERVERS (NAME) VALUES('Lenovo ThinkServer TS140');
INSERT INTO SERVERS (NAME) VALUES('Supermicro SuperWorkstation 5039A-IL');
INSERT INTO SERVERS (NAME) VALUES('Fujitsu Primergy TX1310 M1');
INSERT INTO SERVERS (NAME) VALUES('HP Proliant Microserver Gen8');
INSERT INTO SERVERS (NAME) VALUES('Lenovo ThinkServer TS440');
INSERT INTO SERVERS (NAME) VALUES('HP Proliant ML350 Gen 9');
INSERT INTO SERVERS (NAME) VALUES('Scan 3XS SER-T25');
INSERT INTO SERVERS (NAME) VALUES('Asus TS500');