package com.example.trainspottingjava.sighting;

public class PostBody {
    private final String trainId;
    private final String name;
    private final String colour;
    private final int trainNumber;
    private final String stationID;
    private final String stationName;
    private final String time;


    public PostBody(String trainId, String name, String colour, int trainNumber, String stationID, String stationName, String time) {
        this.trainId = trainId;
        this.name = name;
        this.colour = colour;
        this.trainNumber = trainNumber;
        this.stationID = stationID;
        this.stationName = stationName;
        this.time = time;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getStationID() {
        return stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public String getTime() {
        return time;
    }
}
