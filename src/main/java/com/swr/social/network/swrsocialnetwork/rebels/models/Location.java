package com.swr.social.network.swrsocialnetwork.rebels.models;

import javax.persistence.Embeddable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Location {

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotNull
    @Size(max = 80)
    private String galaxyName;

    @NotNull
    @Size(max = 80)
    private String baseName;

    
    public Location() {}

    public Location(@NotNull double latitude, @NotNull double longitude,
            @NotNull @Size(max = 80) String galaxyName, @NotNull @Size(max = 80) String baseName) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.galaxyName = galaxyName;
        this.baseName = baseName;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

}