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
Apache Kafka Setup
- /Users/dekapx/dev-tools/kafka/config/zookeeper.properties
    - dataDir=/Users/dekapx/dev-tools/kafka/zookeeper
- /Users/dekapx/dev-tools/kafka/config/server.properties
    - log.dirs=/Users/dekapx/dev-tools/kafka/kafka-logs
+---------------------------------------------------------------+
KAFKA HOME: /Users/dekapx/dev-tools/kafka/
## start zookeeper ##
$ bin/zookeeper-server-start.sh config/zookeeper.properties

## start kafka broker ##
$ bin/kafka-server-start.sh config/server.properties

## create a topic ##
$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka-request-topic


## list the topics ##
$ bin/kafka-topics.sh --list --zookeeper localhost:2181