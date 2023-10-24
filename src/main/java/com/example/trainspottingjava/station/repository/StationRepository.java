package com.example.trainspottingjava.station.repository;

import com.example.trainspottingjava.station.model.Station;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface StationRepository extends FirestoreReactiveRepository<Station> {

    Flux<Station> findAllByOrderByName();
}
