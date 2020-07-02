package com.swr.social.network.swrsocialnetwork.rebels.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "rebels")
public class Rebel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 60)
    private String name;

    @NotNull
    @Size(max = 15)
    private String gender;

    @JsonProperty(access = Access.READ_ONLY)
    private int totalDenunciations;

    @JsonProperty(access = Access.READ_ONLY)
    private boolean isRenegade;

    @NotNull
    @Embedded
    private Location location;

    @NotNull
    @Embedded
    private Inventory inventory;


    public Rebel() {}
    
    public Rebel(@NotNull @Size(max = 60) String name, @NotNull String gender, @NotNull Location location,
            @NotNull Inventory inventory) {
        this.name = name;
        this.gender = gender;
        this.totalDenunciations = 0;
        this.isRenegade = false;
        this.location = location;
        this.inventory = inventory;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDenunciations() {
        return this.totalDenunciations;
    }

    public void setTotalDenunciations() {
        this.totalDenunciations += 1;
    }

    public boolean getIsRenegade() {
        return this.isRenegade;
    }

    public void setAsRenegade() {
        this.isRenegade = true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rebel other = (Rebel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}