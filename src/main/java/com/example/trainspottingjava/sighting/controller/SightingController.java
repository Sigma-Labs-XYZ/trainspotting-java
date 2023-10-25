package com.example.trainspottingjava.sighting.controller;

import com.example.trainspottingjava.sighting.model.Sighting;
import com.example.trainspottingjava.sighting.repository.SightingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SightingController {

    private final SightingRepository sightingRepository;

    public SightingController(SightingRepository sightingRepository){
        this.sightingRepository = sightingRepository;
    }

    @PostMapping("/sightings")
    public ResponseEntity<Sighting> saveSighting(@RequestBody Sighting sighting){


        return new ResponseEntity<Sighting>(sighting, HttpStatus.CREATED);
    }
}
