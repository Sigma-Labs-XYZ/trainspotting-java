package com.example.trainspottingjava.sighting.controller;

import com.example.trainspottingjava.sighting.model.Sighting;
import com.example.trainspottingjava.sighting.repository.SightingRepository;
import com.example.trainspottingjava.sighting.service.SightingService;
import com.example.trainspottingjava.station.model.Station;
import com.example.trainspottingjava.station.repository.StationRepository;
import com.example.trainspottingjava.train.model.Train;
import com.example.trainspottingjava.train.repository.TrainRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SightingController {

    private final SightingRepository sightingRepository;
    private final StationRepository stationRepository;
    private final TrainRepository trainRepository;

    public SightingController(SightingRepository sightingRepository, StationRepository stationRepository, TrainRepository trainRepository){
        this.sightingRepository = sightingRepository;
        this.stationRepository = stationRepository;
        this.trainRepository = trainRepository;
    }



    @PostMapping("/sightings")
    public ResponseEntity<Sighting> saveSighting(@RequestBody Sighting sighting){

        SightingService service = new SightingService();
        //1. If the train does not have an id, search the database for the train number. If the train does not exist, add it.
        service.confirmTrainID(sighting, trainRepository);


        //2. If the station does not exist, add it. (note: All UK stations have unique names)
        service.confirmStationID(sighting, stationRepository);

        // 3. Save the sighting
        this.sightingRepository.save(sighting).block();

        /*
        If there is a schema validation error we should return an error without saving anything.
        If there is an error in some of the records, we should save what we can and return a 500 error with a list of the errors
        */
        return new ResponseEntity<>(sighting, HttpStatus.CREATED);
    }
}
