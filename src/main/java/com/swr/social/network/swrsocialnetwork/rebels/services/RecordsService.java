package com.swr.social.network.swrsocialnetwork.rebels.services;

import com.swr.social.network.swrsocialnetwork.rebels.repositories.RebelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordsService {

    @Autowired
    private RebelRepository rebelDAO;

    
    public int totalEntities() {
        return rebelDAO.totalEntities();
    }

    public int totalRebels() {
        return rebelDAO.totalRebels();
    }

    public int totalRenegades() {
        return rebelDAO.totalRenegades();
    }

    public double avgWeapons() {
        return rebelDAO.avgWeapons();
    }

    public double avgAmmunitions() {
        return rebelDAO.avgAmmunition();
    }

    public double avgWaters() {
        return rebelDAO.avgWater();
    }

    public double avgFoods() {
        return rebelDAO.avgFood();
    }

    public boolean isZero(int value) {
        return value == 0;
    }

    public double rebelsPercentage(int totalRebels, int totalEntities) {
        if (isZero(totalEntities)) {
            return 0.0;
        }
        return ((totalRebels / totalEntities) * 100);
    }

    public double renegadesPercentage(int totalRenegades, int totalEntities) {
        if (isZero(totalEntities)) {
            return 0.0;
        }
        return ((totalRenegades / totalEntities) * 100);
    }

}