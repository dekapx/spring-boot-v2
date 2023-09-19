```
- http://localhost:9090/api/batch/populateData
- http://localhost:9090/api/batch/invokeBatch
- http://localhost:9090/api/batch/cleanup
```

```bash
$ docker system prune --all
$ docker image ls
$ docker container ls -a
$ docker image pull postgres:12.1
$ docker container run \
    --name docker-postgres -p 5432:5432 \
    -e POSTGRES_USER=dekapx -e POSTGRES_PASSWORD=passw0rd \
    -e POSTGRES_DB=testdb  -d postgres:12.1
```