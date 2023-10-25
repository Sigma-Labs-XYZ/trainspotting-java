package com.example.trainspottingjava.sighting.controller;

import com.example.trainspottingjava.sighting.model.CreateSightingRequest;
import com.example.trainspottingjava.station.model.Station;
import com.example.trainspottingjava.train.model.Train;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SightingController {




    @PostMapping("/sightings")
    public void saveSighting(@RequestBody CreateSightingRequest postBody){
        Train train = new Train();
        Station station = new Station();
        String time = postBody.getTime();

        System.out.println(train.getColour());
        System.out.println(station.getName());
    }
}
