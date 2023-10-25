package com.example.trainspottingjava.sighting.controller;

import com.example.trainspottingjava.sighting.model.Sighting;
import com.example.trainspottingjava.sighting.repository.SightingRepository;
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

        String trainID = sighting.getTrain().getId();
        int trainNum = sighting.getTrain().getTrainNumber();
        List<Train> trains = trainRepository.findAllByOrderByName().buffer().blockFirst();


        if (trainID == null) { // If the train does not have an id:
            //search the database for the train number.
            Train matchingTrain = trains.stream()
                    .filter(train -> trainNum == (train.getTrainNumber()))
                    .findAny()
                    .orElse(null);

            //then set the ID   (for now I'm assuming the other data is correct, but some validation here would be good)

            if (matchingTrain == null) { // If the train does not exist, add it.
                String newId = this.trainRepository.save(sighting.getTrain()).block().getId();
                sighting.getTrain().setId(newId);
            } else {
                sighting.getTrain().setId(matchingTrain.getId());
            }
        } else { //if train does have id already
            //  TODO If I have time, we should check if that id exists in the db and if not reassign
            //for now I'm just going to assume that if the user enters a train ID, it's a real ID and they don't typo
            System.out.println("Post body gave train ID");
        }




        /*
        2. If the station does not exist, add it. (note: All UK stations have unique names)
        3. Save the sighting

        If there is a schema validation error we should return an error without saving anything.
        If there is an error in some of the records, we should save what we can and return a 500 error with a list of the errors
        */




        return new ResponseEntity<Sighting>(sighting, HttpStatus.CREATED);
    }
}
