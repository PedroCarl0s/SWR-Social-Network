package com.swr.social.network.swrsocialnetwork.rebels.services;

import java.util.List;
import java.util.Optional;

import com.swr.social.network.swrsocialnetwork.rebels.repositories.RebelRepository;
import com.swr.social.network.swrsocialnetwork.rebels.models.Rebel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RebelService {

    @Autowired
    private RebelRepository rebelDAO;


    public List<Rebel> findAll() {
        return rebelDAO.findAll();
    }

    public Optional<Rebel> findById(Long id) {
        return rebelDAO.findById(id);
    }

    public Rebel save(Rebel rebel) {
        return rebelDAO.save(rebel);
    }

}