package com.swr.social.network.swrsocialnetwork.rebels.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class Inventory {

    @ApiModelProperty(notes = "Weapons total of the rebel", name = "total_weapons", required = true, example = "3")
    @Column(name = "total_weapons")
    private int totalWeapons;

    @ApiModelProperty(notes = "Ammunition total of the rebel", name = "total_ammunition", required = true, example = "6")
    @Column(name = "total_ammunition")
    private int totalAmmunition;

    @ApiModelProperty(notes = "Water total of the rebel", name = "total_water", required = true, example = "2")
    @Column(name = "total_water")
    private int totalWater;

    @ApiModelProperty(notes = "Food total of the rebel", name = "total_food", required = true, example = "5")
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