package com.swr.social.network.swrsocialnetwork.rebels.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

@Embeddable
public class Inventory {

    @Column(name = "total_weapons")
    private int totalWeapons;

    @Column(name = "total_ammunition")
    private int totalAmmunition;

    @Column(name = "total_water")
    private int totalWater;

    @Column(name = "total_food")
    private int totalFood;
    

    public Inventory() {}

    public Inventory(@Min(0) int totalWeapons, @Min(0) int totalAmmunition, @Min(0) int totalWater,
            @Min(0) int totalFood) {
        this.totalWeapons = totalWeapons;
        this.totalAmmunition = totalAmmunition;
        this.totalWater = totalWater;
        this.totalFood = totalFood;
    }

    public int getTotalWeapons() {
        return totalWeapons;
    }

    public void setTotalWeapons(int totalWeapons) {
        this.totalWeapons = totalWeapons;
    }

    public int getTotalAmmunition() {
        return totalAmmunition;
    }

    public void setTotalAmmunition(int totalAmmunition) {
        this.totalAmmunition = totalAmmunition;
    }

    public int getTotalWater() {
        return totalWater;
    }

    public void setTotalWater(int totalWater) {
        this.totalWater = totalWater;
    }

    public int getTotalFood() {
        return totalFood;
    }

    public void setTotalFood(int totalFood) {
        this.totalFood = totalFood;
    }
    
}