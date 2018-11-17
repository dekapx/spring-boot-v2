-----------------------------------------------------------------
$ ./confluent start
$ ./kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test-topic
$ ./kafka-topics --list --zookeeper localhost:2181
-----------------------------------------------------------------
- http://localhost:8080/api/ping
- http://localhost:8080/swagger-ui.html
-----------------------------------------------------------------
JSON POST Request
"Test Message"
