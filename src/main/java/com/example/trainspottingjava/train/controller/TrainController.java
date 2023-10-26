package com.example.trainspottingjava.train.controller;

import com.example.trainspottingjava.sighting.model.Sighting;
import com.example.trainspottingjava.sighting.model.SightingResponse;
import com.example.trainspottingjava.sighting.repository.SightingRepository;
import com.example.trainspottingjava.train.model.Train;
import com.example.trainspottingjava.train.repository.TrainRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    private final TrainRepository trainRepository;
    private final SightingRepository sightingRepository;

    public TrainController(TrainRepository trainRepository, SightingRepository sightingRepository) {
        this.trainRepository = trainRepository;
        this.sightingRepository = sightingRepository;

    }

    @GetMapping()
    public List<Train> getAllTrains() {
        List<Train> trains = trainRepository.findAllByOrderByName().buffer().blockFirst();
        return trains;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable("id") String id) {
        Train train = trainRepository.findAllById(List.of(id)).blockFirst();

        if (train != null) {
            return ResponseEntity.ok(train);
        } else {
            // Handle the case when the train with the specified ID is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/{id}/sightings")
    public ResponseEntity<SightingResponse> getTrainSightings(@PathVariable("id") String id) {
        //Lookup train with matching ID
        Train train = trainRepository.findAllById(List.of(id)).blockFirst();

        if (train != null) {
            String trainName = train.getName();
            String trainColor = train.getColour();

            // Look up sightings based on trainName and trainColor
            Flux<Sighting> sightings = sightingRepository.findByTrain_NameAndTrain_Colour(trainName, trainColor);

            // Convert Flux to a List
            List<Sighting> sightingList = sightings.collectList().block();

            return ResponseEntity.ok(new SightingResponse(sightingList, null));
        } else {
            String errorMessage = "Train with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new SightingResponse(null, errorMessage));
        }
    }

}