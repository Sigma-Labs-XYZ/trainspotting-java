package com.example.trainspottingjava.train.model;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

@Document(collectionName = "Train")
public class Train {

    @DocumentId
    private String id;
    private String name;
    private String colour;
    private int trainNumber;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getColour(){
        return colour;
    }

    public void setColour(String newColour){
        this.colour = newColour;
    }


    public int getTrainNumber(){
        return trainNumber;
    }

    public void setTrainNumber(int newTrainNumber){
        this.trainNumber = newTrainNumber;
    }
}


