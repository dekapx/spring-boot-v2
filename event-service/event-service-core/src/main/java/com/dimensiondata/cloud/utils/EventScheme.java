package com.dimensiondata.cloud.utils;

import backtype.storm.spout.Scheme;
import backtype.storm.tuple.Fields;
import com.dimensiondata.cloud.monitoring.Event;

import java.util.Arrays;
import java.util.List;

public class EventScheme implements Scheme {
    @Override
    public List<Object> deserialize(byte[] bytes) {
        final Event event = new EventDeserializer().deserialize(null, bytes);
        return Arrays.asList(event);
    }

    @Override
    public Fields getOutputFields() {
        return new Fields("event");
    }
}
