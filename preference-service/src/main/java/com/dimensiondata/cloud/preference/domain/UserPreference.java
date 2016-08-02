package com.dimensiondata.cloud.preference.domain;

import java.io.Serializable;

public class UserPreference implements Serializable
{// what about  the org id?
    private String id;
    private String userId;
    private Geo geo;
    private Events events;
    private Ownership ownership;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Geo getGeo()
    {
        return geo;
    }

    public void setGeo(Geo geo)
    {
        this.geo = geo;
    }

    public Events getEvents()
    {
        return events;
    }

    public void setEvents(Events events)
    {
        this.events = events;
    }

    public Ownership getOwnership()
    {
        return ownership;
    }

    public void setOwnership(Ownership ownership)
    {
        this.ownership = ownership;
    }
}
