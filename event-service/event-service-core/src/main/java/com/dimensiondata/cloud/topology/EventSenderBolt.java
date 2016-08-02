package com.dimensiondata.cloud.topology;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import com.dimensiondata.cloud.monitoring.Event;

@SuppressWarnings("serial")
public class EventSenderBolt extends BaseBasicBolt {

    @Override
    public void execute(final Tuple tuple, final BasicOutputCollector collector) {
        final Event event = (Event) tuple.getValueByField("event");
        System.out.println("EventSenderBolt - Sending event... : " + event.getEventType());
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }

}
