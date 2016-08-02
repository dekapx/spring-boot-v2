package com.dimensiondata.cloud.preference.domain;

import java.io.Serializable;

/**
 * If ownership subscribed is TRUE - subscribed to events associated with user only.
 * If ownership subscribed is FALSE - subscribed to events associated with organization level.
 */
public class Ownership implements Serializable
{
    private boolean subscribed;

    public boolean isSubscribed()
    {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed)
    {
        this.subscribed = subscribed;
    }
}
