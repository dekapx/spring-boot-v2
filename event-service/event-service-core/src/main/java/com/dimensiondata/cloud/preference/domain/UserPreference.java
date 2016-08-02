package com.dimensiondata.cloud.preference.domain;

import java.io.Serializable;

public class UserPreference implements Serializable
{
    private String organizationId;
    private String userName;
    private Geo geo;
    private Events events;
    private Ownership ownership;

    public String getOrganizationId()
    {
        return organizationId;
    }

    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
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
