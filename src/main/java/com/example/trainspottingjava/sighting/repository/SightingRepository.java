package com.example.trainspottingjava.sighting.repository;

import com.example.trainspottingjava.sighting.model.Sighting;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface SightingRepository extends FirestoreReactiveRepository<Sighting> {
    Flux<Sighting> findAllByOrderByStation();
    Flux<Sighting> findByTrain_NameAndTrain_Colour(String name, String colour);
}