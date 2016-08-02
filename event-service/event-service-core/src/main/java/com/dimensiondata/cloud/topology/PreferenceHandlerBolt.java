package com.dimensiondata.cloud.topology;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import com.dimensiondata.cloud.monitoring.Event;
import com.dimensiondata.cloud.monitoring.PreferenceRestAdapter;
import com.dimensiondata.cloud.preference.domain.EventTypes;
import com.dimensiondata.cloud.preference.domain.UserPreference;

import java.util.Map;

public class PreferenceHandlerBolt extends BaseBasicBolt
{
    private PreferenceRestAdapter preferenceAdapter = null;

    @Override
    public void prepare(final Map stormConf, final TopologyContext context)
    {
        preferenceAdapter = new PreferenceRestAdapter();
    }

    @Override
    public void execute(final Tuple tuple, final BasicOutputCollector collector)
    {
        final Event event = (Event) tuple.getValueByField("event");
        final String id = String.valueOf(event.getEventId());
        UserPreference preference = preferenceAdapter.findPreferenceByUserId(id);
        if (preferenceMatched(event, preference)) {
            collector.emit(new Values(event));
        }
    }

    private boolean preferenceMatched(final Event event, final UserPreference preference) {
        final EventTypes eventTypes = EventTypes.valueOf(event.getEventType());
        return preference.getEvents().getEventTypes().contains(eventTypes);
    }

    @Override
    public void declareOutputFields(final OutputFieldsDeclarer declarer)
    {
        declarer.declare(new Fields("event"));
    }
}
