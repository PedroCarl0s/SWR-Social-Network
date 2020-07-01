package com.swr.social.network.swrsocialnetwork.rebels.services;


import com.swr.social.network.swrsocialnetwork.rebels.repositories.RebelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RebelService {

    @Autowired
    private RebelRepository rebelDAO;

}