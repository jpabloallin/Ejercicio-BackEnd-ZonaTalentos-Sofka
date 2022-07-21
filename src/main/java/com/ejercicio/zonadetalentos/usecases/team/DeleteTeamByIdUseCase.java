package com.ejercicio.zonadetalentos.usecases.team;

import com.ejercicio.zonadetalentos.repositories.ITeamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteTeamByIdUseCase {
    private final ITeamRepository teamRepository;

    public Mono<Void> apply(String id) {
        log.info("\n***** Team deleted. Id: {} *****\n", id);
        return teamRepository.deleteById(id);
    }
}
