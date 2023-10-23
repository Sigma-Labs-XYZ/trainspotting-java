package com.example.trainspottingjava.train.repository;

import com.example.trainspottingjava.train.model.Train;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface TrainRepository extends FirestoreReactiveRepository<Train> {

    Flux<Train> findAllByOrderByName();
}
