package com.dimensiondata.cloud.preference.domain;

public enum GeoTypes
{
    NA ("NorthAmerica"), EU ("Europe"), CA("Canada");

    private String geoType;
    private GeoTypes(final String geoType) {
        this.geoType = geoType;
    }

    public String getGeoType() {
        return geoType;
    }
}
