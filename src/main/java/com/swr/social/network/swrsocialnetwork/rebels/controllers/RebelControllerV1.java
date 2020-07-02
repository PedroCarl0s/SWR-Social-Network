package com.swr.social.network.swrsocialnetwork.rebels.controllers;

import java.util.List;

import javax.validation.Valid;

import com.swr.social.network.swrsocialnetwork.rebels.exceptions.RebelNotFoundException;
import com.swr.social.network.swrsocialnetwork.rebels.exceptions.RenegadeReportException;
import com.swr.social.network.swrsocialnetwork.rebels.models.Location;
import com.swr.social.network.swrsocialnetwork.rebels.models.Rebel;
import com.swr.social.network.swrsocialnetwork.rebels.services.RebelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/rebel")
public class RebelControllerV1 {

    @Autowired
    private RebelService rebelService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Rebel>> listAll() {
        return new ResponseEntity<List<Rebel>>(rebelService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rebel> findById(@PathVariable("id") Long id) {
        Rebel rebel = rebelService.findById(id).orElseThrow(RebelNotFoundException::new);

        return new ResponseEntity<Rebel>(rebel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rebel> addRebel(@Valid @RequestBody Rebel rebel) {
        return new ResponseEntity<Rebel>(rebelService.save(rebel), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Rebel> updateLocation(@PathVariable("id") Long id, @Valid @RequestBody Location newLocation) {
        Rebel rebel = rebelService.findById(id).orElseThrow(RebelNotFoundException::new);
        rebel.setLocation(newLocation);

        return new ResponseEntity<Rebel>(rebelService.save(rebel), HttpStatus.OK);
    }

    @PatchMapping("/report/{accuserId}/{idAccused}")
    public ResponseEntity<Rebel> reportRebel (@PathVariable("accuserId") Long accuserId, @PathVariable("idAccused") Long idAccused) {
        Rebel accuserRebel = rebelService.findById(accuserId).orElseThrow(RebelNotFoundException::new);

        Rebel accusedRebel = rebelService.findById(idAccused).orElseThrow(RebelNotFoundException::new);

        if (rebelService.validateDenunciation(accuserRebel)) {
            Rebel rebel = rebelService.incrementDenunciations(accusedRebel);
            return new ResponseEntity<Rebel>(rebelService.save(rebel), HttpStatus.OK);
        }

        throw new RenegadeReportException();
    }

}