package com.ejercicio.zonadetalentos.usecases.cyclist;

import com.ejercicio.zonadetalentos.repositories.ICyclistRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteCyclistByIdUseCase {

    private final ICyclistRepository cyclistRepository;

    public Mono<Void> apply(String id) {
        log.info("\n***** cyclist deleted. Id: {} *****\n", id);
        return cyclistRepository.deleteById(id);
    }
}
