package com.swr.social.network.swrsocialnetwork.rebels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "denunciations")
public class Denunciation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalDenunciations;

    private boolean isRenegade;

    @JsonIgnore
    @OneToOne(mappedBy="denunciation")
    private Rebel rebel;

    
    public Denunciation() {
        this.totalDenunciations = 0;
        this.isRenegade = false;
    }

    public Denunciation(Rebel rebel) {
        this.rebel = rebel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalDenunciations() {
        return totalDenunciations;
    }

    public void setTotalDenunciations(int totalDenunciations) {
        this.totalDenunciations = totalDenunciations;
    }

    public boolean isRenegade() {
        return this.isRenegade;
    }

    public void IsRenegade(boolean isRenegade) {
        this.isRenegade = isRenegade;
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
        Denunciation other = (Denunciation) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}