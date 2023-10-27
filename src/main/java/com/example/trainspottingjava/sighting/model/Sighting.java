package com.example.trainspottingjava.sighting.model;

import com.example.trainspottingjava.station.model.Station;
import com.example.trainspottingjava.train.model.Train;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Document(collectionName = "JavaSighting")
public class Sighting {

    @DocumentId
    private String id;
    private Station station;
    private Train train;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm")
    private Date timestamp; //later this will be datetime object

    public Sighting() {

    }

    public Sighting(Station station, Train train, LocalDateTime timestamp) {
        this.station = station;
        this.train = train;
        this.timestamp = java.util.Date
                .from(timestamp.atZone(ZoneId.systemDefault())
                        .toInstant());

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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
