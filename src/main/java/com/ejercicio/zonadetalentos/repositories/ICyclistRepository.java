package com.ejercicio.zonadetalentos.repositories;

import com.ejercicio.zonadetalentos.collections.Cyclist;
import com.ejercicio.zonadetalentos.models.CyclistDTO;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ICyclistRepository extends ReactiveMongoRepository<Cyclist, String> {

    @Query("{'team.code': ?0}")
    Flux<Cyclist> findByCode(String teamCode);

    @Query("{'nationality': ?0}")
    Flux<Cyclist> findByNationality(String nationality);

}
