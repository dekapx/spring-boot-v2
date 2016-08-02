package com.dimensiondata.cloud.preference.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Geo locations.
 * If Geo subscribed is true and Geo locations are not specified: All Geo events are subscribed.
 * If Geo subscribed is true and Geo locations are specified: Only selected Geo events are subscribed.
 * If Geo subscribed is FALSE: No Geo subscribed.
 */
public class Geo implements Serializable
{
    private boolean subscribed;
    private List<GeoTypes> geoTypes;

    public Geo()
    {
        if (this.geoTypes == null)
        {
            this.geoTypes = new ArrayList<>();
        }
    }

    public boolean isSubscribed()
    {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed)
    {
        this.subscribed = subscribed;
    }

    public List<GeoTypes> getGeoTypes()
    {
        return geoTypes;
    }

    public void setGeoTypes(List<GeoTypes> geoTypes)
    {
        this.geoTypes.addAll(geoTypes);
    }
}
