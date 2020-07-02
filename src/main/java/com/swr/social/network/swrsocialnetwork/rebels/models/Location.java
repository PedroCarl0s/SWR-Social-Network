package com.swr.social.network.swrsocialnetwork.rebels.models;

import javax.persistence.Embeddable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class Location {

    @ApiModelProperty(notes = "Latitude of the rebel's location", name = "latitude", required = true, example = "123.99789")
    @NotNull
    private double latitude;

    @ApiModelProperty(notes = "Longitude of the rebel's location", name = "longitude", required = true, example = "456.12345")
    @NotNull
    private double longitude;

    @ApiModelProperty(notes = "Galaxy name of the rebel's", name = "galaxyName", required = true, example = "Milky Way")
    @NotNull
    @Size(max = 80)
    private String galaxyName;

    @ApiModelProperty(notes = "Base name of the rebel's", name = "baseName", required = true, example = "Way")
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