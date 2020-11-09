package com.airline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.exception.AirlineNotFoundException;
import com.airline.model.Airline;
import com.airline.service.AirlineService;


@RestController
@RequestMapping("/airline-api")
public class AirlineResponseController {
	@Autowired
	AirlineService airlineService;
	@PostMapping("/airlines")
    ResponseEntity<Airline> addAirline(@RequestBody Airline airline) {
        Airline nairline = airlineService.addAirline(airline);
        return ResponseEntity.ok(nairline);
    }
    @GetMapping("/airlines/get-one/{airlineId}")
    ResponseEntity<Airline> getAirlineById(@PathVariable("airlineId")Integer airlineid) throws AirlineNotFoundException{
    	Airline nairline = airlineService.getAirlineById(airlineid);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Getting airline by Id");
        header.add("title", "One Airline");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(header).body(nairline);
    }
    @GetMapping("/airlines")
    ResponseEntity<List<Airline>> getAllAirlines(){
        List<Airline> airlineList =  airlineService.getAllAirlines();
        return ResponseEntity.ok(airlineList);
    }
    @GetMapping("/airlines/name/{name}")
    ResponseEntity<List<Airline>> getAirlineByName(@PathVariable("name")String name) throws AirlineNotFoundException{
        List<Airline> airlineList =  airlineService.getAirlineByName(name);
        return ResponseEntity.ok(airlineList);
    }
}

