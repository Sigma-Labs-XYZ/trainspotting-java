package com.example.trainspottingjava.train.controller;

import com.example.trainspottingjava.train.model.Train;
import com.example.trainspottingjava.train.repository.TrainRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainController {

    private final TrainRepository trainRepository;

    public TrainController(TrainRepository trainRepository){
        this.trainRepository = trainRepository;

    }

    @GetMapping("/Trains")
    public List<Train> getAllTrains(){
        List<Train> trains = trainRepository.findAllByOrderByName().buffer().blockFirst();
        return trains;
    }
}
