package com.example.trainspottingjava.station.controller;

import com.example.trainspottingjava.station.model.CreateStationRequest;
import com.example.trainspottingjava.station.model.Station;
import com.example.trainspottingjava.station.repository.StationRepository;
import com.example.trainspottingjava.train.model.Train;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class StationController {

    private final StationRepository stationRepository;

    public StationController(StationRepository stationRepository){
        this.stationRepository = stationRepository;
    }

    @GetMapping("/Stations")
    public List<Station> getAllstations(){
        List<Station> stations = stationRepository.findAllByOrderByName().buffer().blockFirst();
        return stations;
    }

    //return station object with new id (201 status code = created)
    @PostMapping(value = "/Stations", consumes = {"application/json"})
    public ResponseEntity<Station> addStation(@RequestBody CreateStationRequest stationRequest){
        //java validation api

        List<Station> stations = stationRepository.findAllByOrderByName().buffer().blockFirst();
        String newStationName = stationRequest.getStationName();



        if (stations == null || stations.stream().noneMatch(s -> s.getName().equals(newStationName))) {
            Station newStation = stationRequest.makeNewStation();
            newStation.setName(newStationName);
            this.stationRepository.save(newStation).block();
            return new ResponseEntity<>(newStation, HttpStatus.CREATED);
        }
        //if a match was found:
        Station errorStation = new Station();
        errorStation.setName("Already Created");
        return new ResponseEntity<>(errorStation, HttpStatus.CONFLICT);

    }
}
