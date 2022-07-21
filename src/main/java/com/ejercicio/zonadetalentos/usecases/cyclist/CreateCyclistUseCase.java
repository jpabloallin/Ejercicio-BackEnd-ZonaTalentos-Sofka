package com.ejercicio.zonadetalentos.usecases.cyclist;

import com.ejercicio.zonadetalentos.mappers.CyclistMapper;
import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.repositories.ICyclistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateCyclistUseCase {

    private final ICyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Mono<CyclistDTO> apply(CyclistDTO cyclistDTO) {
        log.info("\n***** New cyclist created. Id: {} *****\n", cyclistDTO.getId());
        return  cyclistRepository
                .save(cyclistMapper
                        .convertDtoToEntity()
                        .apply(cyclistDTO)).map(cyclist -> cyclistMapper.convertEntityToDto()
                        .apply(cyclist));
    }
}
