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

        List<Station> stations = stationRepository.findAllByOrderByName().buffer().blockFirst();
        Station newStation = new Station();


        if (stations == null || stations.stream().noneMatch(s -> s.getName().equals(stationName))) {
            newStation.setName(stationName);
            this.stationRepository.save(newStation).block();
        }
        //maybe this should return some kind of message instead of silently doing nothing?

    }
}
