package com.example.trainspottingjava.sighting;

import com.example.trainspottingjava.station.Station;
import com.example.trainspottingjava.train.Train;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;

@RestController
public class SightingController {


    @PostMapping("/sightings")
    public void saveSighting(@RequestBody Train train, Station station, String time){ // maybe should return something (the train object?)
        System.out.println(train.getTrainId());
        System.out.println(train.getName());
        System.out.println(train.getColour());
        System.out.println(train.getTrainNumber());

        System.out.println(station.getName());
        System.out.println(time);

        System.out.println(train.getClass());
        System.out.println(station.getClass());
    }
}
