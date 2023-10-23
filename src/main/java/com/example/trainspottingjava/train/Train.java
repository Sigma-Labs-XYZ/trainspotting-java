package com.example.trainspottingjava.train;

public class Train {
    private int trainId;
    private String name;
    private String colour;
    private int trainNumber;

    public Train(int trainId, String name, String colour, int trainNumber){
        this.trainId = trainId;
        this.name = name;
        this.colour = colour;
        this.trainNumber = trainNumber;
    }

    public int getTrainId(){
        return trainId;
    }

    public String getName(){
        return name;
    }

    public String getColour(){
        return colour;
    }

    public int getTrainNumber(){
        return trainNumber;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setName(int newTrainId){
        this.trainId = newTrainId;
    }

    public void setColour(String newColour){
        this.colour = newColour;
    }

    public void setTrainNumber(int newTrainNumber){
        this.trainNumber = newTrainNumber;
    }
}


