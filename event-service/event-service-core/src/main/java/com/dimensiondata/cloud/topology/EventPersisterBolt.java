package com.dimensiondata.cloud.topology;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import com.dimensiondata.cloud.monitoring.Event;

import java.util.Map;

@SuppressWarnings("serial")
public class EventPersisterBolt extends BaseBasicBolt {

    @Override
    @SuppressWarnings("rawtypes")
    public void prepare(final Map stormConf, final TopologyContext context) {
    }

    @Override
    public void execute(final Tuple tuple, final BasicOutputCollector collector) {
        final Event event = (Event) tuple.getValueByField("event");
        System.out.println("Event Received: " + event.toString());
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }

}
