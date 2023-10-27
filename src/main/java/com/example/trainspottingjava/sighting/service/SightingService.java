package com.example.trainspottingjava.sighting.service;

import com.example.trainspottingjava.sighting.model.Sighting;
import com.example.trainspottingjava.station.model.Station;
import com.example.trainspottingjava.station.repository.StationRepository;
import com.example.trainspottingjava.train.model.Train;
import com.example.trainspottingjava.train.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightingService {

    public void confirmTrainID(Sighting sighting, TrainRepository trainRepository){

        String trainID = sighting.getTrain().getTrainId();
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
                String newId = trainRepository.save(sighting.getTrain()).block().getTrainId();
                sighting.getTrain().setId(newId);
            } else {
                sighting.getTrain().setId(matchingTrain.getTrainId());
            }
        } else { //if train does have id already
            //  TODO If I have time, we should check if that id exists in the db and if not reassign
            //for now I'm just going to assume that if the user enters a train ID, it's a real ID and they don't typo
            System.out.println("Post body gave train ID");
        }
    }

    public void confirmStationID(Sighting sighting, StationRepository stationRepository){

        String stationID = sighting.getStation().getId();
        String stationName = sighting.getStation().getName();
        List<Station> stations = stationRepository.findAllByOrderByName().buffer().blockFirst();


        if (stationID == null) { // If the station does not have an id:
            //search the database for the station name.
            Station matchingStation = stations.stream()
                    .filter(station -> stationName.equals(station.getName()))
                    .findAny()
                    .orElse(null);

            //then set the ID   (for now I'm assuming the other data is correct, but some validation here would be good)

            if (matchingStation == null) { // If the station does not exist, add it.
                String newId = stationRepository.save(sighting.getStation()).block().getId();
                sighting.getStation().setId(newId);
            } else {
                sighting.getStation().setId(matchingStation.getId());
            }
        } else { //if station does have id already
            //  TODO If I have time, we should check if that id exists in the db and if not reassign
            //for now I'm just going to assume that if the user enters a station ID, it's a real ID and they don't typo
            System.out.println("Post body gave station ID");
        }

    }


}
