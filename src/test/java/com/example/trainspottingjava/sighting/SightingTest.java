package com.example.trainspottingjava.sighting;

import com.example.trainspottingjava.station.Station;
import com.example.trainspottingjava.train.model.Train;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SightingTest {

    @Mock
    private Sighting mockSighting;
    private Sighting sighting = new Sighting();


    private Station station = new Station("1", "King's Cross");
    private Train train =  new Train("1", "Thomas", "Blue", 1);
    private String timestamp = "00:00:00";

    @Test
    void getBeforeAssign() {
        assertNull(mockSighting.getStation());
        //This causes NPE without the mock annotation on sighting -> maybe I should be using optionals?
    }

    @Test
    void setThenGet(){
        sighting.setStation(station);
        sighting.setTrain(train);
        sighting.setTimestamp(timestamp);

        assertEquals(sighting.getStation(), station);
        assertEquals(sighting.getTrain(), train);
        assertEquals(sighting.getTimestamp(), timestamp);
    }
}