package com.swr.social.network.swrsocialnetwork.rebels.controllers;

import java.util.HashMap;
import java.util.Map;

import com.swr.social.network.swrsocialnetwork.rebels.services.RecordsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/v1/api/records/")
@Api(value = "Records", tags = { "Records" })
public class RecordsControllerV1 {

    @Autowired
    private RecordsService recordsService;

    @ApiResponse(code = 200, message = "Return all averages of inventory items")
    @ApiOperation(value = "Returns all weapons, ammunition, water and food averages per rebel", produces = "application/json")
    @GetMapping("/avg")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> averages() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("avgWeapons", recordsService.avgWeapons());
        map.put("avgAmmunitions", recordsService.avgAmmunitions());
        map.put("avgWaters", recordsService.avgWaters());
        map.put("avgFoods", recordsService.avgFoods());

        return map;
    }

    @ApiResponse(code = 200, message = "Returns average of weapons")
    @ApiOperation(value = "Returns average of weapons per rebel", produces = "application/json")
    @GetMapping("/avg/weapons")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> avgWeapons() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("avgWeapons", recordsService.avgWeapons());

        return map;
    }

    @ApiResponse(code = 200, message = "Returns average of ammunition")
    @ApiOperation(value = "Returns average of ammunition per rebel", produces = "application/json")
    @GetMapping("/avg/ammunitions")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> avgAmmunitions() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("avgAmmunitions", recordsService.avgAmmunitions());

        return map;
    }

    @ApiResponse(code = 200, message = "Returns average of waters")
    @ApiOperation(value = "Returns average of waters per rebel", produces = "application/json")
    @GetMapping("/avg/waters")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> avgWaters() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("avgWaters", recordsService.avgWaters());

        return map;
    }

    @ApiResponse(code = 200, message = "Returns average of foods")
    @ApiOperation(value = "Returns average of foods per rebel", produces = "application/json")
    @GetMapping("/avg/foods")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> avgFoods() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("avgFoods", recordsService.avgFoods());

        return map;
    }

    // WIP
    // @GetMapping("/percentage")
    // @ResponseStatus(HttpStatus.OK)
    // public Map<String, Double> percentageRebels() {
    //     HashMap<String, Double> map = new HashMap<>();
    //     Double rebelsPercentage = recordsService.rebelsPercentage(recordsService.totalRebels(), recordsService.totalEntities());

    //     Double renegadesPercentage = recordsService.renegadesPercentage(
    //         recordsService.totalRenegades(),
    //         recordsService.totalEntities());

    //     map.put("totalRebels", Double.valueOf(recordsService.totalRebels()));
    //     map.put("totalRenegades", Double.valueOf(recordsService.totalRenegades()));
    //     map.put("percentageRebels", Double.valueOf(rebelsPercentage));
    //     map.put("percentageRenegades", Double.valueOf(renegadesPercentage));

    //     return map;
    // }

}