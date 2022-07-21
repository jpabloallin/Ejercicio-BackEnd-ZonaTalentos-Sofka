package com.ejercicio.zonadetalentos.usecases.cyclist;

import com.ejercicio.zonadetalentos.mappers.CyclistMapper;
import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.repositories.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetCyclistsByNationalityUseCase {
    private final ICyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Flux<CyclistDTO> get(String nationality) {
        log.info("\n***** Getting cyclists by nationality {} *****\n");
        return cyclistRepository
                .findByNationality(nationality)
                .filter(cyclist -> Objects.equals(cyclist.getNationality(), nationality))
                .map(entity -> cyclistMapper.convertEntityToDto().apply(entity));
    }
}
