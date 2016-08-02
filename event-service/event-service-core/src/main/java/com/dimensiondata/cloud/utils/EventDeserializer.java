package com.dimensiondata.cloud.utils;

import com.dimensiondata.cloud.monitoring.Event;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class EventDeserializer implements Deserializer<Event> {
    @Override
    public void configure(Map configs, boolean isKey) {
    }

    @Override
    public Event deserialize(String topic, byte[] data) {
        try {
            if (data == null)
                return null;

            if (data.length < 8)
                throw new SerializationException("Size of data received by IntegerDeserializer is shorter than expected");

            final ByteBuffer buffer = ByteBuffer.wrap(data);
            final int id = buffer.getInt();
            int nameSize = buffer.getInt();
            byte[] nameBytes = new byte[nameSize];
            buffer.get(nameBytes);
            final String name = new String(nameBytes, "UTF-8");
            return new Event(id, name);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing Event to byte[] " + e);
        }
    }

    @Override
    public void close() {
    }
}
