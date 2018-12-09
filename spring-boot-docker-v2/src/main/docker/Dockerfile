FROM openjdk:8-jre
WORKDIR /spring-boot-docker-v2
VOLUME ["/spring-boot-docker-v2"]
COPY maven/spring-boot-docker-v2.jar spring-boot-docker-v2.jar
COPY maven/start.sh start.sh
RUN sh -c 'touch spring-boot-docker-v2.jar'
ENTRYPOINT ["./start.sh"]
