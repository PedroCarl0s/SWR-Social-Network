package com.swr.social.network.swrsocialnetwork.rebels.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Column(name = "total_weapons")
    private int totalWeapons;

    @Min(0)
    @Column(name = "total_ammunition")
    private int totalAmmunition;

    @Min(0)
    @Column(name = "total_water")
    private int totalWater;

    @Min(0)
    @Column(name = "total_food")
    private int totalFood;

    @JsonIgnore
    @OneToOne(mappedBy="inventory")
    private Rebel rebel;


    public Inventory() {}

    public Inventory(@Min(0) int totalWeapons, @Min(0) int totalAmmunition, @Min(0) int totalWater,
            @Min(0) int totalFood, Rebel rebel) {
        this.totalWeapons = totalWeapons;
        this.totalAmmunition = totalAmmunition;
        this.totalWater = totalWater;
        this.totalFood = totalFood;
        this.rebel = rebel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Rebel getRebel() {
        return rebel;
    }

    public void setRebel(Rebel rebel) {
        this.rebel = rebel;
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
        Inventory other = (Inventory) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}