package com.example.trainspottingjava.sighting;

<<<<<<< HEAD
import com.example.trainspottingjava.station.model.Station;
=======
import com.example.trainspottingjava.station.Station;
>>>>>>> main
import com.example.trainspottingjava.train.model.Train;

public class SightingPostBody {
    private Train train;
    private Station station;
    private String time;

    public SightingPostBody(Train train, Station station, String time) {
        this.train = train;
        this.station = station;
        this.time = time;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
