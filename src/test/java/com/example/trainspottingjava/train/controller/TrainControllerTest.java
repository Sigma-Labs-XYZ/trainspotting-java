package com.example.trainspottingjava.train.controller;

import static org.junit.jupiter.api.Assertions.*;
import com.example.trainspottingjava.train.model.Train;
import com.example.trainspottingjava.train.repository.TrainRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(TrainController.class)
@RunWith(SpringRunner.class)
public class TrainControllerTest {

    @MockBean
    private TrainRepository trainRepository;


    private TrainController trainController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        trainController = new TrainController(trainRepository);
    }

    @Test
    public void testGetAllTrains() {
        // Arrange
        List<Train> expectedTrains = new ArrayList<>();

        // Create mock Train objects with specific values
        Train train1 = new Train();
        train1.setId("BYU1");
        train1.setName("Train 1");
        train1.setColour("Red");
        train1.setTrainNumber(101);

        Train train2 = new Train();
        train2.setId("TUM2");
        train2.setName("Train 2");
        train2.setColour("Blue");
        train2.setTrainNumber(102);

        expectedTrains.add(train1);
        expectedTrains.add(train2);

        // Convert the List<Train> to a Flux<Train>
        Flux<Train> expectedTrainsFlux = Flux.fromIterable(expectedTrains);

        Mockito.when(trainRepository.findAllByOrderByName()).thenReturn(expectedTrainsFlux);

        // Actual
        List<Train> result = trainController.getAllTrains();

        assertEquals(expectedTrains.size(), result.size());

        for (int i = 0; i < expectedTrains.size(); i++) {
            assertEquals(expectedTrains.get(i).getTrainId(), result.get(i).getTrainId());
            assertEquals(expectedTrains.get(i).getName(), result.get(i).getName());
            assertEquals(expectedTrains.get(i).getColour(), result.get(i).getColour());
            assertEquals(expectedTrains.get(i).getTrainNumber(), result.get(i).getTrainNumber());
        }
    }
}