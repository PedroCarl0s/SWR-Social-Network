package com.swr.social.network.swrsocialnetwork.rebels.repositories;


import com.swr.social.network.swrsocialnetwork.rebels.models.Rebel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RebelRepository extends JpaRepository<Rebel, Long> {

    @Query(value = "select count(id) as total_entities from rebels", nativeQuery = true)
    int totalEntities();

    @Query(value = "select count(id) as total_rebels from rebels where is_renegade = false", nativeQuery = true)
    int totalRebels();

    @Query(value = "select count(id) as total_rebels from rebels where is_renegade = true", nativeQuery = true)
    int totalRenegades();
    
    @Query(value = "select coalesce(avg(total_weapons),0) as avg_weapons from rebels", nativeQuery = true)
    double avgWeapons();
    
    @Query(value = "select coalesce(avg(total_weapons),0) as avg_weapons from rebels", nativeQuery = true)
    double avgAmmunition();

    @Query(value = "select coalesce(avg(total_weapons),0) as avg_weapons from rebels", nativeQuery = true)
    double avgWater();

    @Query(value = "select coalesce(avg(total_weapons),0) as avg_weapons from rebels", nativeQuery = true)
    double avgFood();
}