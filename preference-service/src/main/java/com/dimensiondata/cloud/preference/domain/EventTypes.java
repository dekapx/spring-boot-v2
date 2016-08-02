package com.dimensiondata.cloud.preference.domain;


public enum EventTypes
{
    SERVER_EVENT ("ServerEvent"), C2B_FINISH("C2BFinish");

    private String eventType;
    private EventTypes(final String geoType) {
        this.eventType = eventType;
    }

    public String getEventType()
    {
        return eventType;
    }
}
