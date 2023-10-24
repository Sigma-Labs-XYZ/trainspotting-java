package com.example.trainspottingjava.sighting;

import com.example.trainspottingjava.station.Station;
import com.example.trainspottingjava.train.model.Train;

public class Sighting {
    private Station station;
    private Train train;
    private String timestamp; //later this will be datetime object

    public Sighting(String trainId, String name, String colour, int trainNumber, String stationID, String stationName, String time) {

        this.station = new Station(stationID, stationName);
        this.train = new Train(trainId, name, colour, trainNumber);
        this.timestamp = time;
    }

    public Sighting(Station station, Train train, String timestamp) {
        this.station = station;
        this.train = train;
        this.timestamp = timestamp;
    }


    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
