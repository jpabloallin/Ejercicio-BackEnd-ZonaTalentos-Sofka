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
public class GetCyclistsByTeamCodeUseCase {

    private final ICyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Flux<CyclistDTO> get(String teamCode) {
        log.info("\n***** Getting cyclists by team code {} *****\n");
        return cyclistRepository
                .findByCode(teamCode)
                .filter(cyclist -> Objects.equals(cyclist.getTeam().getCode(), teamCode))
                .map(entity -> cyclistMapper.convertEntityToDto().apply(entity));
    }

}
