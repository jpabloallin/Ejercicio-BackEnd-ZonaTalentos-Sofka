package com.ejercicio.zonadetalentos.usecases.cyclist;

import com.ejercicio.zonadetalentos.mappers.CyclistMapper;
import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.repositories.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class CreateCyclistUseCase {

    private final ICyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    @AssertTrue
    public Mono<CyclistDTO> apply(@Valid CyclistDTO cyclistDTO) {
        log.info("\n***** New cyclist created. *****\n");
        return  cyclistRepository
                .save(cyclistMapper
                        .convertDtoToEntity()
                        .apply(cyclistDTO)).map(cyclist -> cyclistMapper.convertEntityToDto()
                        .apply(cyclist));
    }
}
