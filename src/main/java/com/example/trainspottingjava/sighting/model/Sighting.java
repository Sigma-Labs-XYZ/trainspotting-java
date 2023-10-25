package com.example.trainspottingjava.sighting.model;

import com.example.trainspottingjava.station.model.Station;
import com.example.trainspottingjava.train.model.Train;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

@Document(collectionName = "JavaSighting")
public class Sighting {

    @DocumentId
    private String id;
    private Station station;
    private Train train;
    private String timestamp; //later this will be datetime object

    public Sighting(Station station, Train train, String timestamp) {
        this.station = station;
        this.train = train;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
