-----------------------------------------------------------------
$ ./confluent start
$ ./confluent stop

$ ./kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test-topic-v2
$ ./kafka-topics --list --zookeeper localhost:2181
$ ./kafka-topics --delete --zookeeper localhost:2181 --topic test-topic-v2
-----------------------------------------------------------------
- http://localhost:8080/api/ping
- http://localhost:8080/swagger-ui.html
-----------------------------------------------------------------