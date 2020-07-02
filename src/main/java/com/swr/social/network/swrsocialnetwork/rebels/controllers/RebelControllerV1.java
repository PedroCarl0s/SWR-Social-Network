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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/api/rebel")
@Api(value = "Rebel", tags = { "Rebel" })
public class RebelControllerV1 {

    @Autowired
    private RebelService rebelService;


    @ApiResponse(code = 200, message = "Returns all rebels")
    @ApiOperation(value = "List all rebels", produces = "application/json")
    @GetMapping
    public ResponseEntity<List<Rebel>> listAll() {
        return new ResponseEntity<List<Rebel>>(rebelService.findAll(), HttpStatus.OK);
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Rebel found"),
        @ApiResponse(code = 204, message = "Rebel not found")
    })
    @ApiOperation(value = "Find rebel by ID", produces = "application/json")
    @GetMapping("/{id}")
    public ResponseEntity<Rebel> findById(@PathVariable("id") Long id) {
        Rebel rebel = rebelService.findById(id).orElseThrow(() -> new RebelNotFoundException(id));

        return new ResponseEntity<Rebel>(rebel, HttpStatus.OK);
    }

    @ApiModelProperty(
        value = "A JSON value representing a transaction. An example of the expected schema can be found down here. The fields marked with an * means that they are required.",
        example = "{foo: whatever, bar: whatever2}")
    @ApiResponse(code = 201, message = "Rebel created")
    @ApiOperation(value = "Add new rebel", produces = "application/json")
    @PostMapping
    public ResponseEntity<Rebel> addRebel(@Valid @RequestBody Rebel rebel) {
        return new ResponseEntity<Rebel>(rebelService.save(rebel), HttpStatus.CREATED);
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Rebel found"),
        @ApiResponse(code = 204, message = "Rebel not found")
    })
    @ApiOperation(value = "Update rebel location by ID", produces = "application/json")
    @PatchMapping("/{id}")
    public ResponseEntity<Rebel> updateLocation(@PathVariable("id") Long id, @Valid @RequestBody Location newLocation) {
        Rebel rebel = rebelService.findById(id).orElseThrow(() -> new RebelNotFoundException(id));
        rebel.setLocation(newLocation);

        return new ResponseEntity<Rebel>(rebelService.save(rebel), HttpStatus.OK);
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Rebel found"),
        @ApiResponse(code = 204, message = "Rebel not found")
    })
    @ApiOperation(value = "Report rebel with accuser ID and accused ID ", produces = "application/json")
    @PatchMapping("/report/{accuserId}/{idAccused}")
    public ResponseEntity<Rebel> reportRebel (@PathVariable("accuserId") Long accuserId, @PathVariable("idAccused") Long idAccused) {
        Rebel accuserRebel = rebelService.findById(accuserId).orElseThrow(() -> new RebelNotFoundException(accuserId));
        Rebel accusedRebel = rebelService.findById(idAccused).orElseThrow(() -> new RebelNotFoundException(idAccused));

        if (!rebelService.isRenegade(accuserRebel)) {
            Rebel rebel = rebelService.incrementDenunciations(accusedRebel);
            return new ResponseEntity<Rebel>(rebelService.save(rebel), HttpStatus.OK);
        }

        throw new RenegadeReportException(accuserId);
    }

}