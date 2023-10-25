package com.example.trainspottingjava.station.model;

public class CreateStationRequest {
    private String stationName;


    public String getStationName() {
        return stationName;
    }

    public Station makeNewStation(){
        Station newStation = new Station();
        newStation.setName(this.stationName);
        return newStation;
    }
}
