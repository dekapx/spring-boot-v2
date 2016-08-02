package com.dimensiondata.cloud.preference.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the event types.
 * If events subscribed is TRUE and event type is not specified: All type of events are subscribed
 * If events subscribed is TRUE and event type is specified: Only selected events are subscribed
 * If events subscribed is FALSE: No events are subscribed
 */
public class Events implements Serializable
{
    private boolean subscribed;
    private List<EventTypes> eventTypes;

    public Events() {
        if (this.eventTypes == null) {
            this.eventTypes = new ArrayList<>();
        }
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public List<EventTypes> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventTypes> eventTypes) {
        this.eventTypes.addAll(eventTypes);
    }
}