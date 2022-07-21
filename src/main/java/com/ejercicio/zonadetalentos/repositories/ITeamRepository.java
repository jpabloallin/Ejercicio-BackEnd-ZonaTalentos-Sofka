package com.ejercicio.zonadetalentos.repositories;

import com.ejercicio.zonadetalentos.collections.Cyclist;
import com.ejercicio.zonadetalentos.collections.Team;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITeamRepository extends ReactiveMongoRepository<Team, String> {
    @Query("{'country': ?0}")
    Flux<Team> findByCountry(String country);
}
