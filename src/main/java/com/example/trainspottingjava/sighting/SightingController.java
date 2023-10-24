package com.example.trainspottingjava.sighting;

import com.example.trainspottingjava.station.Station;
import com.example.trainspottingjava.train.model.Train;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SightingController {




    @PostMapping("/sightings")
    public void saveSighting(@RequestBody PostBody postBody){
        Train train = new Train(postBody.getTrainId(), postBody.getName(), postBody.getColour(), postBody.getTrainNumber());
        Station station = new Station(postBody.getStationID(), postBody.getStationName());
        String time = postBody.getTime();

        System.out.println(train.getColour());
        System.out.println(station.getName());
    }
}
