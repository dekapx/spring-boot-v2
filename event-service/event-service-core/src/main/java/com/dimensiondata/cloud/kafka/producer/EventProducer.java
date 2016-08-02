package com.dimensiondata.cloud.kafka.producer;

import com.dimensiondata.cloud.preference.domain.EventTypes;
import com.dimensiondata.cloud.utils.EventSerializer;
import com.dimensiondata.cloud.monitoring.Event;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EventProducer {
    private static final String KAFKA_TOPIC = "kafkatopic";

    public static void main(String args[]) throws Exception {
        final EventProducer kafkaProducer = new EventProducer();
        kafkaProducer.publishMessages();
    }

    public void publishMessages() throws Exception {
        final Properties props = defineBrokerProperties();
        final KafkaProducer<String, Event> producer = new KafkaProducer<String, Event>(props);

        for (int i = 1; i <= 15; i++) {
            final Event event = new Event(i, EventTypes.SERVER_EVENT.name());
            final ProducerRecord<String, Event> producerRecord = new ProducerRecord<String, Event>(KAFKA_TOPIC, "" + i, event);
            producer.send(producerRecord);
            final String msg = String.format("Sending %s event to Kafka", EventTypes.SERVER_EVENT.name());
            System.out.println(msg);
            TimeUnit.SECONDS.sleep(1);
        }

        producer.close();
    }

    private Properties defineBrokerProperties() throws Exception {
        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EventSerializer.class.getName());
        return props;
    }

}
