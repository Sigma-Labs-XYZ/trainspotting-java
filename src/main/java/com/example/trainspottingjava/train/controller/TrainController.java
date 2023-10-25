package com.example.trainspottingjava.train.controller;

import com.example.trainspottingjava.train.model.Train;
import com.example.trainspottingjava.train.repository.TrainRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private final TrainRepository trainRepository;

    public TrainController(TrainRepository trainRepository){
        this.trainRepository = trainRepository;

    }

    @GetMapping()
    public List<Train> getAllTrains(){
        List<Train> trains = trainRepository.findAllByOrderByName().buffer().blockFirst();
        return trains;
    }

    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable("id") String id){
        return trainRepository.findAllById(List.of(id)).blockFirst();
    }
}