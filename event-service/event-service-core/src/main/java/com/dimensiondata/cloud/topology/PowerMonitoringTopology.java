package com.dimensiondata.cloud.topology;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;
import com.dimensiondata.cloud.utils.EventScheme;
import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.ZkHosts;

public class PowerMonitoringTopology {
    private static final String BROKER_HOST_URL = "localhost:2181";
    private static final String KAFKA_TOPIC = "kafkatopic";
    private static final String KAFKA_SPOUT = "kafka-spout";
    private static final String TOPOLOGY_NAME = "power-monitoring-topology";
    private static final int SLEEP_TIME = 600000; // one minute

    public static void main(String args[]) {
        final TopologyBuilder builder = new TopologyBuilder();
        buildTopology(builder);
        final LocalCluster cluster = deployTopologyToLocalCluster(builder);

        Utils.sleep(SLEEP_TIME);
        cluster.killTopology(TOPOLOGY_NAME);
        cluster.shutdown();
    }

    private static void buildTopology(final TopologyBuilder builder) {
        buildKafkaSpout(builder);

        builder.setBolt("event-processor-bolt", new EventProcessorBolt()).shuffleGrouping(KAFKA_SPOUT);
        builder.setBolt("preference-handler-bolt", new PreferenceHandlerBolt()).shuffleGrouping("event-processor-bolt");
        builder.setBolt("event-sender-bolt", new EventSenderBolt()).shuffleGrouping("preference-handler-bolt");
    }

    private static void buildKafkaSpout(final TopologyBuilder builder) {
        final BrokerHosts brokerHosts = new ZkHosts(BROKER_HOST_URL);
        final SpoutConfig spoutConfig = new SpoutConfig(brokerHosts, KAFKA_TOPIC, "/event-service", "id");
        spoutConfig.scheme = new SchemeAsMultiScheme(new EventScheme());

        final KafkaSpout kafkaSpout = new KafkaSpout(spoutConfig);
        builder.setSpout(KAFKA_SPOUT, kafkaSpout, 1);
    }

    private static LocalCluster deployTopologyToLocalCluster(final TopologyBuilder builder) {
        final Config config = new Config();
        config.setDebug(true);

        final LocalCluster cluster = new LocalCluster();
        cluster.submitTopology(TOPOLOGY_NAME, config, builder.createTopology());
        return cluster;
    }
}
