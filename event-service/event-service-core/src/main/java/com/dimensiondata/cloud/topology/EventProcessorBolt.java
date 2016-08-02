package com.dimensiondata.cloud.topology;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import com.dimensiondata.cloud.monitoring.Event;

import java.util.List;

@SuppressWarnings("serial")
public class EventProcessorBolt extends BaseBasicBolt {

    @Override
    public void execute(final Tuple tuple, final BasicOutputCollector collector) {
        final List<Object> events = tuple.getValues();
        final Event event = (Event) events.iterator().next();
        collector.emit(new Values(event));
    }

    @Override
    public void declareOutputFields(final OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("event"));
    }

}
