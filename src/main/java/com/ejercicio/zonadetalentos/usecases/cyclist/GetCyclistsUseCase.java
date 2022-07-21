package com.ejercicio.zonadetalentos.usecases.cyclist;

import com.ejercicio.zonadetalentos.mappers.CyclistMapper;
import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.repositories.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetCyclistsUseCase implements Supplier<Flux<CyclistDTO>> {

    private final ICyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    @Override
    public Flux<CyclistDTO> get() {
        log.info("\n***** Getting all cyclist *****\n");
        return cyclistRepository
                .findAll()
                .map(cyclist -> cyclistMapper
                        .convertEntityToDto()
                        .apply(cyclist));
    }
}
