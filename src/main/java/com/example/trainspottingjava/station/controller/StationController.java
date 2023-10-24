package com.example.trainspottingjava.station.controller;

import com.example.trainspottingjava.station.model.Station;
import com.example.trainspottingjava.station.repository.StationRepository;
import com.example.trainspottingjava.train.model.Train;
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

    @PostMapping("/Stations")
    public void addStation(@RequestBody String stationName){
        //add logic to check if station is already there.

        //if not:
        Station newStation = new Station();
        newStation.setName(stationName);
        this.stationRepository.save(newStation).block();
    }
}
